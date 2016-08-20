package ua.controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ua.entity.AmountAndIngredient;
import ua.entity.Ingredient;
import ua.entity.MeasuringSystem;
import ua.entity.Recipe;

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
//		long count = em.createQuery("SELECT count(c) FROM "
//				+ "Country c ", 
//				Long.class).getSingleResult();
//		System.out.println(count);
//		double avg = em.createQuery("SELECT avg(c) FROM "
//				+ "Country c ", 
//				Double.class).getSingleResult();
//		System.out.println(avg);
//		List<Country> countries = em.createQuery("SELECT c FROM "
//				+ "Country c order by c.name asc", //desc
//				Country.class).setFirstResult(4).setMaxResults(2)
//				.getResultList();
//		for (Country country : countries) {
//			System.out.println(country.getId()+" "+country.getName());
//		}
		//SELECT r FROM Recipe r WHERE r.country.name like :like гавнокод
		//SELECT r FROM Recipe r JOIN r.country c WHERE c.name like :like гуд код
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Recipe> cq = cb.createQuery(Recipe.class);
//		Root<Recipe> root = cq.from(Recipe.class);
//		cq.select(root);
//		Predicate eq = cb.equal(root.get("name"), "Borsch");
//		Predicate in = root.get("id").in(Arrays.asList(1,2));
//		Expression<Integer> exp = root.get("id");
//		Predicate be = cb.between(exp, 1, 10);
//		Join<Recipe, AmountAndIngredient> aiJoin = 
//				root.join("amountAndIngredients");
//		Expression<Integer> exp2 = aiJoin.get("amount");
//		Predicate gt = cb.greaterThan(exp2, 120);
//		Join<AmountAndIngredient, Ingredient> ingJoin = 
//				aiJoin.join("ingredient");
//		Predicate eqIng = cb.equal(ingJoin.get("name"), "Potato");
//		
//		Predicate or = cb.or(eq, in, be);
//		Predicate and = cb.and(gt, eqIng);
//		or = cb.or(or, and);
//		cq.where(or);
//		List<Recipe> recipes = em.createQuery(cq).getResultList();
//		System.out.println(recipes);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Recipe> cq = cb.createQuery(Recipe.class);
		Root<Recipe> root = cq.from(Recipe.class);
		cq.select(root);
		Predicate eq = cb.equal(root.get("name"), "Borsch");
		Predicate in = root.get("id").in(Arrays.asList(1,2,3,4,5));
		Expression<Integer> exp = root.get("id");
		Predicate be = cb.between(exp, 1, 10);
		Join<Recipe, AmountAndIngredient> iaJoin = root.join(
				"amountAndIngredients");
		Expression<Integer> exp1 = iaJoin.get("amount");
		Predicate amPred = cb.equal(exp1, 500);
		Join<AmountAndIngredient, MeasuringSystem> msJoin = iaJoin.join(
				"measuringSystem");
		Predicate msPred = cb.equal(msJoin.get("name"), "g");
		Join<AmountAndIngredient, Ingredient> ingJoin = iaJoin.join(
				"ingredient");
		Predicate ingrPred = cb.equal(ingJoin.get("name"), "Potato");
		Predicate all = eq;
		if(in!=null)
		all = cb.or(all, in);
		all = cb.or(all, be);
		Predicate and = cb.and(amPred, msPred, ingrPred);
		all = cb.or(all, and);
		cq.where(all);
		List<Recipe> recipes = em.createQuery(cq).getResultList();
		System.out.println(recipes);
		if(em.getTransaction().isActive())em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
