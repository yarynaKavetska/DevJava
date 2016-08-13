package ua.service;

import java.util.List;

import ua.entity.Category;

public interface CategoryService {

	void save(String categoryName, int parentId);
	
	List<Category> findAll();
	
	void changeParent(int catId, int newParentId);
	
	Category findOne(int id);
}
