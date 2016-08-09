package ua.service.implementation;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Country;
import ua.entity.Recipe;
import ua.repository.CountryRepository;
import ua.repository.RecipeRepository;
import ua.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService{

	@Autowired
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
	public void save(String name, String time, int countryId) {
		Recipe recipe = new Recipe();
		Country country = countryRepository.findOne(countryId);
		recipe.setCountry(country);
		recipe.setName(name);
		recipe.setTime(LocalTime.parse(time));
		recipeRepository.save(recipe);
	}

	
}
