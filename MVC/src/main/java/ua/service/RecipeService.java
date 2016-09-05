package ua.service;

import java.util.List;

import ua.entity.Recipe;
import ua.form.RecipeForm;

public interface RecipeService {

	List<Recipe> findAll();

	void delete(int id);
	
	void save(RecipeForm form);

	RecipeForm findForForm(int id);

	Recipe findByName(String name);

}
