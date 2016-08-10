package ua.service;

import java.util.List;

import ua.entity.Ingredient;

public interface IngredientService {

	void save(String name);
	
	List<Ingredient> findAll();
	
	Ingredient findByName(String name);
	
}
