package ua.conrtoller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.entity.Country;
import ua.repository.CountryRepository;
import ua.service.CountryService;

public class Main {

	static ConfigurableApplicationContext context = 
			new ClassPathXmlApplicationContext
			("/META-INF/applicationContext.xml");
	static CountryService service = context.getBean(CountryService.class);
	
	
	public static void main(String[] args) {
		service.delete("Ukraine");
		context.close();
	}

}
