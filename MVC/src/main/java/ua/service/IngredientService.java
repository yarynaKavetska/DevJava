package ua.service;

import java.util.List;

import ua.entity.Ingredient;

public interface IngredientService {

	List<Ingredient> findAll();

	void save(Ingredient ingredient);

	void delete(int id);

	Ingredient findOne(int id);

	Ingredient findByName(String name);

}
