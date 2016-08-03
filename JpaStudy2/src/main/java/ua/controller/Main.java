package ua.controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ua.entity.Country;

public class Main {

	static EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("primary");
	static EntityManager em = factory.createEntityManager();

	public static void main(String[] args) {
		if(!em.getTransaction().isActive())em.getTransaction().begin();
//		List<Country> countries = em.createQuery("SELECT c FROM "
//				+ "Country c WHERE c.id in (:ids)", 
//				Country.class)
//				.setParameter("ids", Arrays.asList(1,2,3,4,5))
//				.getResultList();
//		for (Country country : countries) {
//			System.out.println(country.getId()+" "+country.getName());
//		}
//		List<Country> countries2 = em.createQuery("SELECT c FROM "
//				+ "Country c WHERE c.name like :like", 
//				Country.class)
//				.setParameter("like", "U%")
//				.getResultList();
//		for (Country country : countries2) {
//			System.out.println(country.getId()+" "+country.getName());
//		}
		long count = em.createQuery("SELECT count(c) FROM "
				+ "Country c ", 
				Long.class).getSingleResult();
		System.out.println(count);
		double avg = em.createQuery("SELECT avg(c) FROM "
				+ "Country c ", 
				Double.class).getSingleResult();
		System.out.println(avg);
		List<Country> countries = em.createQuery("SELECT c FROM "
				+ "Country c order by c.name asc", //desc
				Country.class).setFirstResult(4).setMaxResults(2)
				.getResultList();
		for (Country country : countries) {
			System.out.println(country.getId()+" "+country.getName());
		}
		//SELECT r FROM Recipe r WHERE r.country.name like :like гавнокод
		//SELECT r FROM Recipe r JOIN r.country c WHERE c.name like :like гуд код
		if(em.getTransaction().isActive())em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
