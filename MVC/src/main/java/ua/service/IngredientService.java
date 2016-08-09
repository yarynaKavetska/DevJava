package ua.service;

import java.util.List;

import ua.entity.Ingredient;

public interface IngredientService {

	List<Ingredient> findAll();

	void save(String name);

	void delete(int id);

}
