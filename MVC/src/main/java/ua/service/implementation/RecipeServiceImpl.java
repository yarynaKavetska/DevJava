package ua.service.implementation;

import java.time.LocalTime;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Recipe;
import ua.form.RecipeForm;
import ua.repository.CountryRepository;
import ua.repository.RecipeRepository;
import ua.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService{

	@Resource
	private RecipeRepository recipeRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
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
		recipe.setCountry(form.getCountry());
		recipe.setName(form.getName());
		recipe.setTime(LocalTime.parse(form.getTime()));
		recipe.setId(form.getId());
		recipeRepository.save(recipe);
	}

	@Override
	public RecipeForm findForForm(int id) {
		Recipe recipe = recipeRepository.findOneCountryInited(id);
		RecipeForm form = new RecipeForm();
		form.setId(recipe.getId());
		form.setCountry(recipe.getCountry());
		form.setName(recipe.getName());
		form.setTime(recipe.getTime().toString());
		return form;
	}
}