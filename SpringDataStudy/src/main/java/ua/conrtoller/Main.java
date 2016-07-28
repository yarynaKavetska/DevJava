package ua.conrtoller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.entity.Country;
import ua.entity.Recipe;
import ua.repository.CountryRepository;
import ua.repository.RecipeRepository;
import ua.service.CountryService;

public class Main {

	static ConfigurableApplicationContext context = 
			new ClassPathXmlApplicationContext
			("/META-INF/applicationContext.xml");
	static RecipeRepository recipeRepository = context.getBean(RecipeRepository.class);
	
	
	public static void main(String[] args) {
		Recipe recipe = new Recipe();
		recipe.setName("Borsch");
		recipeRepository.save(recipe);
		
		context.close();
	}

}
