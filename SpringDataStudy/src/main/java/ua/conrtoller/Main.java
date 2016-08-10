package ua.conrtoller;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.entity.Ingredient;
import ua.repository.IngredientRepository;

public class Main {

	static final ConfigurableApplicationContext context = 
			new ClassPathXmlApplicationContext
			("/META-INF/applicationContext.xml");
	static final IngredientRepository repository = 
			context.getBean(IngredientRepository.class);
	
	public static void main(String[] args) {
		List<Ingredient> ingredients = repository.findAll();
		for (Ingredient ingredient : ingredients) {
			System.out.println(ingredient.getName());
		}
		context.close();
	}

}
