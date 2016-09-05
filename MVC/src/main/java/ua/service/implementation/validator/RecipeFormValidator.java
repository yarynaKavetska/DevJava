package ua.service.implementation.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.form.RecipeForm;
import ua.service.RecipeService;

public class RecipeFormValidator implements Validator{
	
	private final RecipeService recipeService;
	
	public RecipeFormValidator(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return RecipeForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RecipeForm form = (RecipeForm) target;
		if(form.getId()!=0)if(recipeService.findByName(form.getName())!=null){
			errors.rejectValue("name", "", "Recipe already exists");
		}
		Pattern p = Pattern.compile("^[0-9]{2,2}:[0-9]{2,2}:[0-9]{2,2}$");
		Matcher m = p.matcher(form.getTime());
		if(!m.matches()){
			errors.rejectValue("time", "", "Time format is hh:mm:ss");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
	}
}
