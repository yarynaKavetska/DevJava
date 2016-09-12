package ua.service.implementation.validator;

import java.util.regex.Matcher;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Country;
import ua.form.RecipeForm;
import ua.service.CountryService;

public class CountryValidator implements Validator {

	private final CountryService countryService;

	public CountryValidator(CountryService countryService) {
		this.countryService = countryService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Country.class.equals(clazz);
	}
	
	

	@Override
	public void validate(Object target, Errors errors) {
		Country form = (Country) target;
		if(form.getId()==0)if(countryService.findByName(form.getName())!=null){
			errors.rejectValue("name", "", "Country already exists");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
	}
}
