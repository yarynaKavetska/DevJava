package ua.service;

import java.util.List;

import ua.entity.Recipe;
import ua.form.RecipeForm;

public interface RecipeService {

	List<Recipe> findAll();

	void delete(int id);
	
	void save(RecipeForm form);

	RecipeForm findOneCountryInited(int id);

	Recipe findOne(int id);

	void addIngredient(int id, int ingredId);

	Recipe findOneAmountInited(int id);

	void delIngredient(int id, int ingredId);
}
