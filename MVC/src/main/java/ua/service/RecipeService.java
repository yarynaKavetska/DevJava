package ua.service;

import java.util.List;

import ua.entity.Recipe;

public interface RecipeService {

	List<Recipe> findAll();

	void delete(int id);
	
	void save(String name, String time, int countryId);

}
