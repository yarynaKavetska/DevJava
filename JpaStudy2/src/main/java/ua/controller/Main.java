package ua.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.entity.Country;

public class Main {

	static EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("primary");
	static EntityManager em = factory.createEntityManager();

	public static void main(String[] args) {
		if(!em.getTransaction().isActive())em.getTransaction().begin();
		Country country = em.createQuery("SELECT distinct c FROM Country c JOIN "
				+ " FETCH c.recipes r WHERE r.name=:name", Country.class)
				.setParameter("name", "Borsch")
				.getSingleResult();
		if(em.getTransaction().isActive())em.getTransaction().commit();
		em.close();
		factory.close();
		System.out.println(country.getName()+" "+country.getRecipes());
	}
}
