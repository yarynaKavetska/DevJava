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
		em.getTransaction().begin();
		Country country = em.createQuery("SELECT distinct c FROM Country c "
				+ "JOIN fetch c.recipes r WHERE r.name=:name", Country.class)
				.setParameter("name", "Borsch")
				.getSingleResult();
		em.getTransaction().commit();
		em.close();
		factory.close();
		System.out.println(country.getId()+" "+country.getName()+" "
				+country.getRecipes());
	}
}
