package ua.filter;

import java.util.List;

import javax.persistence.EntityManager;
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

public class RecipeFilter {

	private final CriteriaBuilder cb;
	private final CriteriaQuery<Recipe> cq;
	private final Root<Recipe> root;
	private Predicate predicate;
	
	private List<Value> values;
	
	private List<String> countries;
	
	public RecipeFilter(EntityManager em) {
		cb = em.getCriteriaBuilder();
		cq = cb.createQuery(Recipe.class);
		root = cq.from(Recipe.class);
	}
	
	public static class Value{
		
		private String ingredient;
		
		private String ms;
		
		private int amount;
		
		public Value(String ingredient, String ms, int amount) {
			this.ingredient = ingredient;
			this.ms = ms;
			this.amount = amount;
		}

		public String getIngredient() {
			return ingredient;
		}

		public void setIngredient(String ingredient) {
			this.ingredient = ingredient;
		}

		public String getMs() {
			return ms;
		}

		public void setMs(String ms) {
			this.ms = ms;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}
	}

	public List<Value> getValues() {
		return values;
	}

	public void setValues(List<Value> values) {
		Join<Recipe, AmountAndIngredient> aiJoin = 
				root.join("amountAndIngredients");
		Join<AmountAndIngredient, Ingredient> ingJoin =
				aiJoin.join("ingredient");
		Join<AmountAndIngredient, MeasuringSystem> msJoin = 
				aiJoin.join("measuringSystem");
		for (Value value : values) {
			Expression<Integer> exp = aiJoin.get("amount");
			Predicate am = cb.equal(exp, value.amount);
			Predicate ing = cb.equal(ingJoin.get("name"),
					value.ingredient);
			Predicate ms = cb.equal(msJoin.get("name"), value.ms);
			if(predicate==null){
				predicate = cb.and(am, ing, ms);
			}else{
				predicate = cb.and(predicate, am, ing, ms);
			}
		}
		this.values = values;
	}

	public List<String> getCountries() {
		return countries;
	}

	public void setCountries(List<String> countries) {
		Join<Recipe, Country> join = 
				root.join("country");
		for (String string : countries) {
			Predicate country = cb.equal(join.get("name"), string);
			if(predicate==null){
				predicate = country;
			}else{
				predicate = cb.and(predicate, country);
			}
		}
		this.countries = countries;
	}

	public CriteriaQuery<Recipe> getCq() {
		cq.where(predicate);
		return cq;
	}
}
