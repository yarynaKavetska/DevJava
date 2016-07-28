package ua.conrtoller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.service.CountryService;

public class Main {

	static ConfigurableApplicationContext context = 
			new ClassPathXmlApplicationContext
			("/META-INF/applicationContext.xml");
	static CountryService countryService = context.getBean(CountryService.class);
	
	
	public static void main(String[] args) {
		
		context.close();
	}

}
