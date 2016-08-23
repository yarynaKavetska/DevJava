package ua.service.implementation;

import java.io.File;
import java.io.IOException;
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
	@Transactional
	public void save(RecipeForm form) {
		Recipe recipe = new Recipe();
		recipe.setId(form.getId());
		recipe.setCountry(form.getCountry());
		recipe.setName(form.getName());
		recipe.setTime(LocalTime.parse(form.getTime()));
		recipe.setPath(form.getPath());
		recipe.setVersion(form.getVersion());
		recipeRepository.saveAndFlush(recipe);
		if(form.getFile()!=null&&!form.getFile().isEmpty()){
			int index = form.getFile().getOriginalFilename().lastIndexOf(".");
			String extension = form.getFile().getOriginalFilename()
					.substring(index);
			String path = System.getProperty("catalina.home")+"/images/recipe/";
			File file = new File(path);
			if(!file.exists())file.mkdirs();
			file = new File(file, recipe.getId()+extension);
			try {
				form.getFile().transferTo(file);
				recipe.setPath(extension);
				recipe.setVersion(form.getVersion()+1);
			} catch (IllegalStateException | IOException e) {
			}
			recipeRepository.save(recipe);
		}
	}

	@Override
	public RecipeForm findOneCountryInited(int id) {
		Recipe recipe = recipeRepository.findOneCountryInited(id);
		RecipeForm form = new RecipeForm();
		form.setCountry(recipe.getCountry());
		form.setId(recipe.getId());
		form.setName(recipe.getName());
		form.setTime(recipe.getTime().toString());
		form.setPath(recipe.getPath());
		form.setVersion(recipe.getVersion());
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
