package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Ingredient;
import ua.repository.IngredientRepository;
import ua.service.IngredientService;

@Service
public class IngredientServiceImpl implements IngredientService{

	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Override
	public List<Ingredient> findAll() {
		return ingredientRepository.findAll();
	}

	@Override
	public void save(String name) {
		Ingredient ingredient = new Ingredient();
		ingredient.setName(name);
		ingredientRepository.save(ingredient);
	}

	@Override
	public void delete(int id) {
		ingredientRepository.delete(id);
	}

}
