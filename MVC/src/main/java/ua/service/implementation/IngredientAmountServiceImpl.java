package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.AmountAndIngredient;
import ua.form.AmountFilter;
import ua.form.AmountForm;
import ua.repository.AmountAndIngredientRepository;
import ua.repository.IngredientRepository;
import ua.repository.MeasuringSystemRepository;
import ua.service.IngredientAmountService;
import ua.specification.AmountFilterAdapter;

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
	public void save(AmountForm form) {
		AmountAndIngredient amountAndIngredient = new AmountAndIngredient();
		amountAndIngredient.setId(form.getId());
		amountAndIngredient.setAmount(Integer.valueOf(form.getAmount()));
		amountAndIngredient.setIngredient(form.getIngredient());
		amountAndIngredient.setMeasuringSystem(form.getMs());
		amountAndIngredientRepository.save(amountAndIngredient);
	}

	@Override
	public AmountForm findOneForm(int id) {
		AmountAndIngredient amountAndIngredient = amountAndIngredientRepository.findOneIngredientMsInited(id);
		AmountForm form = new AmountForm();
		form.setAmount(String.valueOf(amountAndIngredient.getAmount()));
		form.setId(amountAndIngredient.getId());
		form.setIngredient(amountAndIngredient.getIngredient());
		form.setMs(amountAndIngredient.getMeasuringSystem());
		return form;
	}

	@Override
	public List<AmountAndIngredient> findAll(AmountFilter amountFilter) {
		return amountAndIngredientRepository.findAll(new AmountFilterAdapter(amountFilter));
	}
}
