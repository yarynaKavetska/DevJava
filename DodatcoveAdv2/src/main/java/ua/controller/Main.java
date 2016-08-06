package ua.controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
import ua.filter.RecipeFilter;

public class Main {

	static EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("primary");
	static EntityManager em = factory.createEntityManager();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		if(!em.getTransaction().isActive())em.getTransaction().begin();
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to add recipe");
			System.out.println("Enter 2 to filter recipes");
			switch (scanner.next()) {
			case "1":
				addRecipe();
				break;
			case "2":
				filter();
				break;
			default:
				isRun = false;
				break;
			}
		}
		if(em.getTransaction().isActive())em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	private static void filter(){
		List<RecipeFilter.Value> values = new ArrayList<>();
		List<String> countries = new ArrayList<>();
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to add ingred to filter");
			System.out.println("Enter 2 to add country to filter");
			System.out.println("Enter 3 to show finded recipes");
			switch (scanner.next()) {
			case "1":
				System.out.println("Enter ingredient");
				String ingredient = scanner.next();
				System.out.println("Enter ms");
				String ms = scanner.next();
				System.out.println("Enter amount");
				int amount = scanner.nextInt();
				values.add(new RecipeFilter.Value(ingredient, ms, amount));
				break;
			case "2":
				System.out.println("Enter country");
				countries.add(scanner.next());
				break;
			default:
				RecipeFilter filter = new RecipeFilter(em);
				filter.setCountries(countries);
				filter.setValues(values);
				List<Recipe> recipes = em.createQuery(filter.getCq()).getResultList();
				for (Recipe recipe : recipes) {
					System.out.println(recipe.getName());
				}
				isRun = false;
				break;
			}
		}
	}
	
	private static Country getCountry(){
		System.out.println("Enter country name");
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Country> cq = cb.createQuery(Country.class);
		Root<Country> root = cq.from(Country.class);
		cq.select(root);
		String countryName = scanner.next();
		Predicate predicate = cb.equal(root.get("name"), countryName);
		cq.where(predicate);
		Country country = null;
		try{
			country = em.createQuery(cq).getSingleResult();
		}catch(NoResultException e){
			country = new Country();
			country.setName(countryName);
			em.persist(country);
		}
		return country;
	}
	
	private static AmountAndIngredient getAi(String ingredientName,
			String ms, int amount){
		AmountAndIngredient amountAndIngredient = null;
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AmountAndIngredient> cq = cb.createQuery(AmountAndIngredient.class);
		Root<AmountAndIngredient> root = cq.from(AmountAndIngredient.class);
		cq.select(root);
		Expression<Integer> exp1 = root.get("amount");
		Predicate amPred = cb.equal(exp1, amount);
		Join<AmountAndIngredient, Ingredient> ingJoin = root
				.join("ingredient");
		Predicate ingPred = cb.equal(ingJoin.get("name"), ingredientName);
		Join<AmountAndIngredient, MeasuringSystem> msJoin = root
				.join("measuringSystem");
		Predicate msPred = cb.equal(msJoin.get("name"), ms);
		cq.where(amPred, ingPred, msPred);
		try{
			amountAndIngredient = em.createQuery(cq).getSingleResult();
		}catch(NoResultException e){
		}
		return amountAndIngredient;
	}
	
	private static Ingredient getIngredient(String ingredientName){
		Ingredient ingredient = null;
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Ingredient> cq = cb.createQuery(Ingredient.class);
		Root<Ingredient> root = cq.from(Ingredient.class);
		cq.select(root);
		Predicate predicate = cb.equal(root.get("name"), ingredientName);
		cq.where(predicate);
		try{
			ingredient = em.createQuery(cq).getSingleResult();
		}catch(NoResultException e){
			ingredient = new Ingredient();
			ingredient.setName(ingredientName);
			em.persist(ingredient);
		}
		return ingredient;
	}
	
	private static MeasuringSystem getMeasuringSystem(String ms){
		MeasuringSystem measuringSystem = null;
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MeasuringSystem> cq = cb.createQuery(MeasuringSystem.class);
		Root<MeasuringSystem> root = cq.from(MeasuringSystem.class);
		cq.select(root);
		Predicate predicate = cb.equal(root.get("name"), ms);
		cq.where(predicate);
		try{
			measuringSystem = em.createQuery(cq).getSingleResult();
		}catch(NoResultException e){
			measuringSystem = new MeasuringSystem();
			measuringSystem.setName(ms);
			em.persist(measuringSystem);
		}
		return measuringSystem;
	}
	
	private static void addRecipe(){
		Country country = getCountry();
		Recipe recipe = new Recipe();
		System.out.println("Enter recipe title");
		String title = scanner.next();
		recipe.setName(title);
		System.out.println("Enter hour");
		int hour = scanner.nextInt();
		System.out.println("Enter min");
		int min = scanner.nextInt();
		recipe.setCountry(country);
		recipe.setTime(LocalTime.of(hour, min));
		System.out.println("Enter quantity");
		int quantity = scanner.nextInt();
		recipe.setQuantity(quantity);
		em.persist(recipe);
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to add ingredient");
			System.out.println("Enter 2 to add exit");
			switch (scanner.next()) {
			case "1":
				System.out.println("Enter ingredient name");
				String ingredientName = scanner.next();
				System.out.println("Enter ms name");
				String ms = scanner.next();
				System.out.println("Enter amount");
				int amount = scanner.nextInt();
				AmountAndIngredient amountAndIngredient = getAi(ingredientName, ms, amount);
				if(amountAndIngredient==null){
					Ingredient ingredient = getIngredient(ingredientName);
					MeasuringSystem system = getMeasuringSystem(ms);
					amountAndIngredient = new AmountAndIngredient();
					amountAndIngredient.setIngredient(ingredient);
					amountAndIngredient.setMeasuringSystem(system);
					amountAndIngredient.setAmount(amount);
					em.persist(amountAndIngredient);
				}
				recipe.getAmountAndIngredients().add(amountAndIngredient);
				em.persist(amountAndIngredient);
				break;
			default:
				isRun = false;
				break;
			}
		}
	}
}
