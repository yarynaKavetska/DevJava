package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Ingredient;
import ua.form.filter.IngredientFilterForm;

public interface IngredientService {

	List<Ingredient> findAll();

	void save(Ingredient ingredient);

	void delete(int id);
	
	Ingredient findOne(int id);
	
	Page<Ingredient> findAll(Pageable pageable);

	Page<Ingredient> findAll(Pageable pageable, IngredientFilterForm form);

}
