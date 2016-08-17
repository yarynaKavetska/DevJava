package ua.service.implementation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Ingredient;
import ua.service.IngredientService;

public class IngredientValidator implements Validator{
	
	private final IngredientService ingredientService;
	
	public IngredientValidator(IngredientService ingredientService) {
		this.ingredientService = ingredientService;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return Ingredient.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Ingredient ingredient = (Ingredient) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Ingredient name can't be empty");
		if(ingredientService.findByName(ingredient.getName())!=null){
			errors.rejectValue("name", "", "Ingredient with this name alredy exists");
		}
	}

}
