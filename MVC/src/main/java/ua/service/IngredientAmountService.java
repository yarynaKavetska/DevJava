package ua.service;

import java.util.List;

import ua.entity.AmountAndIngredient;
import ua.form.AmountForm;

public interface IngredientAmountService {

	List<AmountAndIngredient> findAll();

	void delete(int id);

	void save(AmountForm form);

	AmountForm findOneForm(int id);

}
