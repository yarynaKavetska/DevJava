package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.Ingredient;
import ua.service.IngredientService;

@Controller
public class IngredientController {

	@Autowired
	private IngredientService ingredientService;
	
	@ModelAttribute("ingredient")
	public Ingredient getIngredient(){
		return new Ingredient();
	}
	
	@RequestMapping("/admin/ingredient")
	public String show(Model model){
		model.addAttribute("ingredients", ingredientService.findAll());
		return "adminIngredient";
	}
	
	@RequestMapping(value="/admin/ingredient", method=RequestMethod.POST)
	public String save(@ModelAttribute("ingredient") Ingredient ingredient){
		ingredientService.save(ingredient);
		return "redirect:/admin/ingredient";
	}
	
	@RequestMapping("/admin/ingredient/delete/{id}")
	public String delete(@PathVariable int id){
		ingredientService.delete(id);
		return "redirect:/admin/ingredient";
	}
	
	@RequestMapping("/admin/ingredient/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("ingredient", ingredientService.findOne(id));
		model.addAttribute("ingredients", ingredientService.findAll());
		return "adminIngredient";
	}
}
