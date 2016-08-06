package ua.entity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private LocalTime time;
	
	private String name;
	@ManyToOne(fetch=FetchType.LAZY)
	private Country country;
	
	private int quantity;
	
	@ManyToMany
	@JoinTable(name = "AmountAndIngredient_Recipe", joinColumns = 
	@JoinColumn(name = "recipe_id"), inverseJoinColumns = 
	@JoinColumn(name = "amountAndIngredient_id"))
	private List<AmountAndIngredient> amountAndIngredients= new ArrayList<>();
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<AmountAndIngredient> getAmountAndIngredients() {
		return amountAndIngredients;
	}

	public void setAmountAndIngredients(
			List<AmountAndIngredient> amountAndIngredients) {
		this.amountAndIngredients = amountAndIngredients;
	}
}
