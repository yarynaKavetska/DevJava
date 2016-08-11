package ua.service.implementation;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.AmountAndIngredient;
import ua.entity.Recipe;
import ua.form.RecipeForm;
import ua.repository.AmountAndIngredientRepository;
import ua.repository.CountryRepository;
import ua.repository.RecipeRepository;
import ua.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private AmountAndIngredientRepository amountAndIngredientRepository;
	
	@Override
	public List<Recipe> findAll() {
		return recipeRepository.findAll();
	}

	@Override
	public void delete(int id) {
		recipeRepository.delete(id);
	}

	@Override
	public void save(RecipeForm form) {
		Recipe recipe = new Recipe();
		recipe.setId(form.getId());
		recipe.setCountry(form.getCountry());
		recipe.setName(form.getName());
		recipe.setTime(LocalTime.parse(form.getTime()));
		recipeRepository.save(recipe);
	}

	@Override
	public RecipeForm findOneCountryInited(int id) {
		Recipe recipe = recipeRepository.findOneCountryInited(id);
		RecipeForm form = new RecipeForm();
		form.setCountry(recipe.getCountry());
		form.setId(recipe.getId());
		form.setName(recipe.getName());
		form.setTime(recipe.getTime().toString());
		return form;
	}

	@Override
	public Recipe findOne(int id) {
		return recipeRepository.findOne(id);
	}

	@Override
	@Transactional
	public void addIngredient(int id, int ingredId) {
		Recipe recipe = recipeRepository.findOne(id);
		AmountAndIngredient ingredient = amountAndIngredientRepository.findOne(ingredId);
		recipe.getAmountAndIngredients().add(ingredient);
	}

	@Override
	public Recipe findOneAmountInited(int id) {
		return recipeRepository.findOneAmountInited(id);
	}

	@Override
	@Transactional
	public void delIngredient(int id, int ingredId) {
		Recipe recipe = recipeRepository.findOne(id);
		recipe.getAmountAndIngredients().removeIf((i)->i.getId()==ingredId);
	}
}
