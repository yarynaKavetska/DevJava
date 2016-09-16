package ua.service.implementation;

import java.time.LocalTime;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Recipe;
import ua.form.RecipeForm;
import ua.form.filter.RecipeFilterForm;
import ua.repository.CountryRepository;
import ua.repository.RecipeRepository;
import ua.service.FileWriter;
import ua.service.FileWriter.Folder;
import ua.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService{

	@Resource
	private RecipeRepository recipeRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private FileWriter fileWriter;
	
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
		recipe.setPath(form.getPath());
		recipe.setVersion(form.getVersion());
		recipeRepository.saveAndFlush(recipe);
		String extension = fileWriter.write(Folder.RECIPE, form.getFile(), recipe.getId());
		if(extension!=null){
			recipe.setVersion(form.getVersion()+1);
			recipe.setPath(extension);
			recipeRepository.save(recipe);
		}
	}

	@Override
	public RecipeForm findForForm(int id) {
		Recipe recipe = recipeRepository.findOneCountryInited(id);
		RecipeForm form = new RecipeForm();
		form.setId(recipe.getId());
		form.setCountry(recipe.getCountry());
		form.setName(recipe.getName());
		form.setTime(recipe.getTime().toString());
		form.setPath(recipe.getPath());
		form.setVersion(recipe.getVersion());
		return form;
	}

	@Override
	public Recipe findByName(String name) {
		return recipeRepository.findByName(name);
	}

	@Override
	public Page<Recipe> findAll(RecipeFilterForm form, Pageable pageable) {
		return recipeRepository.findAll(pageable);
	}
}