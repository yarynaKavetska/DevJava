package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.AmountAndIngredient;
import ua.entity.Ingredient;
import ua.entity.MeasuringSystem;
import ua.repository.AmountAndIngredientRepository;
import ua.repository.IngredientRepository;
import ua.repository.MeasuringSystemRepository;
import ua.service.IngredientAmountService;

@Service
public class IngredientAmountServiceImpl implements IngredientAmountService{

	@Autowired
	private AmountAndIngredientRepository amountAndIngredientRepository;
	
	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Autowired
	private MeasuringSystemRepository measuringSystemRepository;
	
	@Override
	public List<AmountAndIngredient> findAll() {
		return amountAndIngredientRepository.findAll();
	}

	@Override
	public void delete(int id) {
		amountAndIngredientRepository.delete(id);
	}

	@Override
	public void save(int amount, int ingredientId, int msId) {
		MeasuringSystem system = measuringSystemRepository.findOne(msId);
		Ingredient ingredient = ingredientRepository.findOne(ingredientId);
		AmountAndIngredient amountAndIngredient = new AmountAndIngredient();
		amountAndIngredient.setAmount(amount);
		amountAndIngredient.setIngredient(ingredient);
		amountAndIngredient.setMeasuringSystem(system);
		amountAndIngredientRepository.save(amountAndIngredient);
	}
}
