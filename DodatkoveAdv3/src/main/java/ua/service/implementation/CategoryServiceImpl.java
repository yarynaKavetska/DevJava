package ua.service.implementation;

import java.util.List;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Fetch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Category;
import ua.repository.CategoryRepository;
import ua.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	@Transactional
	public void save(String categoryName, int parentId) {
		Category category = new Category();
		category.setName(categoryName);
		category.setParent(categoryRepository.findOne(parentId));
		categoryRepository.save(category);
	}

	@Override
	@Transactional
	public List<Category> findAll() {
		List<Category> parents = categoryRepository.findByParentIsNull();
		initChilds(parents);
		return parents;
	}
	
	private void initChilds(List<Category> categories){
		for (Category category : categories) {
			List<Category> childs = categoryRepository.findByParentId(category.getId());
			category.setChilds(childs);
			initChilds(childs);
		}
	}

	@Override
	@Transactional
	public void changeParent(int catId, int newParentId) {
		Category category = categoryRepository.findOne(catId);
		//перевірку на те що ми не додаємо батька нижче дітей
		if(category.getParent()!=null){
			category.getParent().getChilds().removeIf(c->c.getId()==catId);
		}
		category.setParent(categoryRepository.findOne(newParentId));
		changeChildsLevel(category.getChilds(), category.getLevel());
	}
	
	private void changeChildsLevel(List<Category> childs, int parentLevel){
		for (Category category : childs) {
			category.setLevel(parentLevel+1);
			changeChildsLevel(categoryRepository
					.findByParentId(category.getId()), category.getLevel());
		}
	}

	@Override
	public Category findOne(int id) {
		Category category = categoryRepository.findOne(id);
		category = categoryRepository.findOne(findParent(id, category.getLevel()));
		return category;
	}
	
	private Specification<Category> findParent(int id, int level){
		return (root, query, cb)-> {
			Expression<Integer> exp = root.get("id");
			Fetch<Category, Category> fetch = root.fetch("parent");
			for(int i = 0; i < level-1; i++){
				fetch = getFetch(fetch);
			}
			return cb.equal(exp, id);
		};
	}
	
	private Fetch<Category, Category> getFetch(Fetch<Category, Category> fetch){
		return fetch.fetch("parent");
	}
}
