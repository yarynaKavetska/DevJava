package ua.controller;

import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.WeakHashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ua.entity.AmountAndIngredient;
import ua.entity.Country;
import ua.entity.Ingredient;
import ua.entity.MeasuringSystem;
import ua.entity.Recipe;

public class Main {

	private static final EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("primary");
	private static final EntityManager em = factory.createEntityManager();
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// Country country = em.find(Country.class, 1);
		// country.setName("Ukraine");
		// Country country = em
		// .createQuery("select c from Country c where c.id=:id", Country.class)
		// .setParameter("id", 1).getSingleResult();
		// System.out.println(country.getName());
		// List<Country> countries =
		// em.createQuery("from Country").getResultList();
		// System.out.println(countries);
		// em.getTransaction().commit();
		
//		List<Recipe> recipe = em.createQuery("select r "
//				+ "from Recipe r "
//				+ "join r.country c "
//				+ "where c.name=:name", Recipe.class)
//				.setParameter("name", "Ukraine").getResultList();
//		
//		boolean isRun = true;
//		while (isRun) {
//			System.out.println("Enter 1 to add recipe");
//			System.out.println("Enter 2 to add country");
//			System.out.println("Enter 0 to add exit");
//			switch (sc.next()) {
//			case "1": {
//				addIngredients();
//				break;
//			}
//			case "2": {
//				addCountry();
//				break;
//			}
//			default :{
//				isRun = false;
//			}
//			}
		
	
		


		// Country country = em
		// .createQuery(
		// "SELECT c " + "FROM Country c " + "WHERE c.name=:name",
		// Country.class)
		// // select * from Country where name='Ukraine'
		// .setParameter("name", "Ukraine").getSingleResult();
		// System.out.println(country.getName());
		em.getTransaction().begin();
//		LocalDate date = LocalDate.of(2016, 07, 25);
//		date.minusDays(1);
//		List<Country> country = em.createQuery("SELECT distinct c "
//				+"FROM Country c "
//				+"JOIN fetch c.recipes "
//				+"WHERE c.name=:name", Country.class)
//				.setParameter("name", "Ukraine")
//				.getResultList();
		Map<String, byte[]> map = new WeakHashMap<>();
		SoftReference<Map<String, byte[]>> mapdel = new SoftReference<Map<String,byte[]>>(map);
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Recipe> cq = cb.createQuery(Recipe.class);
		Root<Recipe> root = cq.from(Recipe.class);
		Predicate findByRecipeName = cb.equal(root.get("name"),
				"Borscht");
		Join<Recipe, Country> countryJoin = root.join("country");
		root.fetch("country");
		cq.distinct(true);
		Predicate findByCountryName = cb.equal(
				countryJoin.get("name"), "Ukraine");
		Predicate all = cb.and(findByRecipeName, findByCountryName);
		Join<Recipe, AmountAndIngredient> amountAndIngredientJoin = 
				root.join("amountAndIngredients");
		Expression<Integer> ex = amountAndIngredientJoin.get("amount");
		Predicate findByAmount = cb.greaterThan(
				ex, 100);
		all = cb.and(all, findByAmount);
		Join<AmountAndIngredient, Ingredient> ingredientJoin = 
				amountAndIngredientJoin.join("ingredient");
		Predicate findByIngredientIds = ingredientJoin
				.get("id").in(Arrays.asList(1,2,5,10));
		all = cb.and(all,findByIngredientIds);
		cq.where(all);
		List<Recipe> recipes = em.createQuery(cq).getResultList();
		System.out.println(recipes.get(0).getCountry());
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	static void addCountry() {
		Country country = new Country();
		System.out.println("Enter country name");
		country.setName(sc.next());
		em.getTransaction().begin();
		em.persist(country);
		em.getTransaction().commit();
	}

	static Recipe addRecipe() {
		System.out.println("Enter country name");
		em.getTransaction().begin();
		Country country = em
				.createQuery("select c from Country c where c.name=:name",
						Country.class).setParameter("name", sc.next())
				.getSingleResult();
		Recipe recipe = new Recipe();
		recipe.setCountry(country);
		System.out.println("Enter recipe name");
		recipe.setName(sc.next());
		em.persist(recipe);
		em.getTransaction().commit();
		return recipe;
	}

	static Ingredient addIngredient(String ingredientName) {
		Ingredient ingredient = null;
		try {
			ingredient = em
					.createQuery(
							"select i from Ingredient i where i.name=:name",
							Ingredient.class)
					.setParameter("name", ingredientName).getSingleResult();
		} catch (NoResultException e) {
			ingredient = new Ingredient();
			ingredient.setName(ingredientName);
			em.persist(ingredient);
		}
		return ingredient;
	}

	static MeasuringSystem addMS(String measuringSystemName) {
		MeasuringSystem measuringSystem = null;
		try {
			measuringSystem = em
					.createQuery(
							"select i from MeasuringSystem i where i.name=:name",
							MeasuringSystem.class)
					.setParameter("name", measuringSystemName)
					.getSingleResult();
		} catch (NoResultException e) {
			measuringSystem = new MeasuringSystem();
			measuringSystem.setName(measuringSystemName);
			em.persist(measuringSystem);
		}
		return measuringSystem;
	}

	static void addIngredients() {
		Recipe recipe = addRecipe();
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to add ingredient");
			System.out.println("Enter 0 to add exit");
			switch (sc.next()) {
			case "1": {
				em.getTransaction().begin();
				System.out.println("Enter ingredient name");
				String ingredientName = sc.next();
				Ingredient ingredient = addIngredient(ingredientName);
				System.out.println("Enter ms name");
				String measuringSystemName = sc.next();
				MeasuringSystem measuringSystem = addMS(measuringSystemName);
				System.out.println("Enter amount");
				int amount = sc.nextInt();
				AmountAndIngredient amountAndIngredient = null;
				try {
					// select r from Recipe r join r.country c where
					// c.name=:name
					// select r from Country c join c.recipes r where
					// c.name=:name
					amountAndIngredient = em
							.createQuery(
									"SELECT ai "
											+ "FROM AmountAndIngredient ai "
											+ "JOIN ai.ingredient i "
											+ "JOIN ai.measuringSystem ms "
											// ON ai.id = i.id
											// AND ai.id = ms.id
											+ "WHERE i.name=:ingName "
											+ "AND ms.name=:msName "
											+ "AND ai.amount=:amount",
									AmountAndIngredient.class)
							.setParameter("ingName", ingredientName)
							.setParameter("msName", measuringSystemName)
							.setParameter("amount", amount).getSingleResult();
				} catch (NoResultException e) {
					amountAndIngredient = new AmountAndIngredient();
					amountAndIngredient.setMeasuringSystem(measuringSystem);
					amountAndIngredient.setIngredient(ingredient);
					amountAndIngredient.setAmount(amount);
					em.persist(amountAndIngredient);
				}
				recipe.getAmountAndIngredients().add(amountAndIngredient);
				em.getTransaction().commit();
				break;
			}
			default: {
				isRun = false;
			}
			}
		}
	}
}
