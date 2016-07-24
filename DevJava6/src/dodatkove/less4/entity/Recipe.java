package dodatkove.less4.entity;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

	private int id;
	
	private String title;
	
	private Country country;
	
	private List<Collector> collectors = new ArrayList<>();

	public Recipe(String title, Country country, List<Collector> collectors) {
		this.title = title;
		this.country = country;
		this.collectors = collectors;
	}
	
	public List<Collector> getCollectors() {
		return collectors;
	}

	public void setCollectors(List<Collector> collectors) {
		this.collectors = collectors;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", title=" + title + ", country=" + country
				+ "]";
	}
}
