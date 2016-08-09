package ua.service;

import java.util.List;

import ua.entity.AmountAndIngredient;

public interface IngredientAmountService {

	List<AmountAndIngredient> findAll();

	void delete(int id);

	void save(int amount, int ingredientId, int msId);

}
