package ua.conrtoller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.repository.RecipeRepository;

public class Main {

	static ConfigurableApplicationContext context = 
			new ClassPathXmlApplicationContext
			("/META-INF/applicationContext.xml");
	static RecipeRepository recipeRepository = context.getBean(RecipeRepository.class);
	
	
	public static void main(String[] args) {
		
		context.close();
	}

}
