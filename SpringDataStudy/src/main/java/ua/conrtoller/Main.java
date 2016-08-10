package ua.conrtoller;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.entity.Country;
import ua.service.CountryService;

public class Main {

	static final ConfigurableApplicationContext context = 
			new ClassPathXmlApplicationContext
			("/META-INF/applicationContext.xml");
	static final CountryService service = 
			context.getBean(CountryService.class);
	
	public static void main(String[] args) {
		List<Country> ingredients = service.findAll();
		for (Country ingredient : ingredients) {
			System.out.println(ingredient.getName());
		}
		
		context.close();
	}
}
