package ua.dao.implementation;

import javax.persistence.EntityManager;

import ua.dao.CategoryDao;
import ua.untity.shop.Category;

public class CategoryDaoImpl extends GenericDaoImpl<Category, Integer> implements CategoryDao{

	public CategoryDaoImpl(EntityManager em) {
		super(Category.class, em);
	}
}
