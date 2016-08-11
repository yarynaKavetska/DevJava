package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.IngredientAmountService;
import ua.service.RecipeService;

@Controller
public class RecipeIngredientController {
	
	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private IngredientAmountService ingredientAmountService;
	
	@RequestMapping("/admin/recipe/{id}")
	public String showAddToRecipe(@PathVariable int id, Model model){
		model.addAttribute("recipe", recipeService.findOneAmountInited(id));
		model.addAttribute("ingredients", ingredientAmountService.findAll());
		return "adminRecipeIngredient";
	}
	
	@RequestMapping("/admin/recipe/{id}/{ingredId}")
	public String addToRecipe(@PathVariable int id, @PathVariable int ingredId){
		recipeService.addIngredient(id, ingredId);
		return "redirect:/admin/recipe/"+id;
	}
	
	@RequestMapping("/admin/recipe/delete/{id}/{ingredId}")
	public String removeFromRecipe(@PathVariable int id, @PathVariable int ingredId){
		recipeService.delIngredient(id, ingredId);
		return "redirect:/admin/recipe/"+id;
	}
}
