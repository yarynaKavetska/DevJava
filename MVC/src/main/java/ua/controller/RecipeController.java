package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.CountryService;
import ua.service.RecipeService;

@Controller
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping("/admin/recipe")
	public String showRecipes(Model model){
		model.addAttribute("recipes", recipeService.findAll());
		model.addAttribute("countries", countryService.findAll());
		return "adminRecipe";
	}
	
	@RequestMapping(value="/admin/recipe", method=RequestMethod.POST)
	public String save(@RequestParam String name, 
			@RequestParam String time, 
			@RequestParam int countryId){
		recipeService.save(name, time, countryId);
		return "redirect:/admin/recipe";
	}
	
	@RequestMapping(value="/admin/recipe/delete/{id}")
	public String delete(@PathVariable int id){
		recipeService.delete(id);
		return "redirect:/admin/recipe";
	}
	
}
