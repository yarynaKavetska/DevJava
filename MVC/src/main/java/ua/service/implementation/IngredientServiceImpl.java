package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Ingredient;
import ua.form.filter.IngredientFilterForm;
import ua.repository.IngredientRepository;
import ua.service.IngredientService;
import ua.service.implementation.specification.IngredientFilterAdapter;

@Service
public class IngredientServiceImpl implements IngredientService{

	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Override
	public List<Ingredient> findAll() {
		return ingredientRepository.findAll();
	}

	@Override
	public void save(Ingredient ingredient) {
		ingredientRepository.save(ingredient);
	}

	@Override
	public void delete(int id) {
		ingredientRepository.delete(id);
	}

	@Override
	public Ingredient findOne(int id) {
		return ingredientRepository.findOne(id);
	}

	@Override
	public Page<Ingredient> findAll(Pageable pageable) {
		return ingredientRepository.findAll(pageable);
	}

	@Override
	public Page<Ingredient> findAll(Pageable pageable, IngredientFilterForm form) {
		return ingredientRepository.findAll(new IngredientFilterAdapter(form), pageable);
	}

}
