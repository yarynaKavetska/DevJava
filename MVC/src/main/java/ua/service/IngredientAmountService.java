package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.AmountAndIngredient;
import ua.form.IngredientAmountForm;
import ua.form.filter.IngredientAmountFilterForm;

public interface IngredientAmountService {

	List<AmountAndIngredient> findAll();

	void delete(int id);

	void save(IngredientAmountForm form);
	
	Page<AmountAndIngredient> findAll(Pageable pageable);
	
	Page<AmountAndIngredient> findAll(Pageable pageable, IngredientAmountFilterForm form);

	IngredientAmountForm findOneForForm(int id);
}
