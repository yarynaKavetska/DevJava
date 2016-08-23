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
	
	private String path;
	
	private int version;
	
	private String name;
	@ManyToOne(fetch=FetchType.LAZY)
	private Country country;
	@ManyToMany
	@JoinTable(name = "AmountAndIngredient_Recipe", joinColumns = 
	@JoinColumn(name = "recipe_id"), inverseJoinColumns = 
	@JoinColumn(name = "amountAndIngredient_id"))
	private List<AmountAndIngredient> amountAndIngredients= new ArrayList<>();
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
