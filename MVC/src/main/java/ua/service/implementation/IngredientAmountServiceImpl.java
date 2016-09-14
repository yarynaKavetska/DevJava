package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.AmountAndIngredient;
import ua.entity.Ingredient;
import ua.entity.MeasuringSystem;
import ua.form.IngredientAmountForm;
import ua.form.filter.IngredientAmountFilterForm;
import ua.repository.AmountAndIngredientRepository;
import ua.repository.IngredientRepository;
import ua.repository.MeasuringSystemRepository;
import ua.service.IngredientAmountService;
import ua.service.implementation.specification.IngredientAmountFilterAdapter;

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
	public void save(IngredientAmountForm form) {
		MeasuringSystem system = form.getSystem();
		Ingredient ingredient = form.getIngredient();
		AmountAndIngredient amountAndIngredient = new AmountAndIngredient();
		amountAndIngredient.setAmount(Integer.valueOf(form.getAmount()));
		amountAndIngredient.setIngredient(ingredient);
		amountAndIngredient.setMeasuringSystem(system);
		amountAndIngredientRepository.save(amountAndIngredient);
	}

	@Override
	public Page<AmountAndIngredient> findAll(Pageable pageable) {
		return amountAndIngredientRepository.findAll(pageable);
	}

	@Override
	public Page<AmountAndIngredient> findAll(Pageable pageable, IngredientAmountFilterForm form) {
		return amountAndIngredientRepository.findAll(new IngredientAmountFilterAdapter(form), pageable);
	}

	@Override
	public IngredientAmountForm findOneForForm(int id) {
		AmountAndIngredient ai = amountAndIngredientRepository.findForForm(id);
		IngredientAmountForm form = new IngredientAmountForm();
		form.setId(id);
		form.setAmount(String.valueOf(ai.getAmount()));
		form.setIngredient(ai.getIngredient());
		form.setSystem(ai.getMeasuringSystem());
		return form;
	}
}
