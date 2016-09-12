package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

@Entity
public class Country {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private long population;
	
	private String name;
	@OneToMany(mappedBy="country")
	private List<Recipe> recipes = new ArrayList<>();
	
	@PreRemove
	public void removeAllChilds(){
		for (Recipe recipe : recipes) {
			recipe.setCountry(null);
		}
	}
	
	public long getPopulation() {
		return population;
	}
	
	public void setPopulation(long population) {
		this.population = population;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Country))
			return false;
		Country other = (Country) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
