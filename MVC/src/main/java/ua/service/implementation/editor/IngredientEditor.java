package ua.service.implementation.editor;

import java.beans.PropertyEditorSupport;

import ua.service.IngredientService;

public class IngredientEditor extends PropertyEditorSupport{

	private final IngredientService ingredientService;

	public IngredientEditor(IngredientService ingredientService) {
		this.ingredientService = ingredientService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(ingredientService.findOne(Integer.valueOf(text)));
	}
	
	
}
