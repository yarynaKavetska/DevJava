package ua.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.dao.CategoryDao;
import ua.dao.implementation.CategoryDaoImpl;
import ua.untity.shop.Category;

public class Main {

	private static final EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("primary");
	private static final EntityManager em = factory.createEntityManager();
	
	private static final CategoryDao CATEGORY_DAO = new CategoryDaoImpl(em);
	
	public static void main(String[] args) {
		Category category = CATEGORY_DAO.findOne(1);
		em.close();
		factory.close();
	}
}
