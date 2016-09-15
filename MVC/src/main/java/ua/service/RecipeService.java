package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Recipe;
import ua.form.RecipeForm;
import ua.form.filter.RecipeFilterForm;

public interface RecipeService {

	List<Recipe> findAll();

	void delete(int id);
	
	void save(RecipeForm form);

	RecipeForm findForForm(int id);

	Recipe findByName(String name);

	Page<Recipe> findAll(RecipeFilterForm form, Pageable pageable);

}
