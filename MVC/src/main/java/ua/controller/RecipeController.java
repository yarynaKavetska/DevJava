package ua.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.Country;
import ua.form.RecipeForm;
import ua.service.CountryService;
import ua.service.RecipeService;
import ua.service.implementation.editor.CountryEditor;

@Controller
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private CountryService countryService;
	
	@InitBinder("recipe")
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
		binder.registerCustomEditor(List.class, "countries", new CustomCollectionEditor(List.class){
			@Override
            protected Object convertElement(Object element){
                Integer id = (Integer) element;
                return id != null ? countryService.findOne(id) : null;
            }
		});
	}
	
	@ModelAttribute("recipe")
	public RecipeForm getForm(){
		return new RecipeForm();
	}
	
	@RequestMapping("/admin/recipe")
	public String showRecipes(Model model){
		model.addAttribute("recipes", recipeService.findAll());
		model.addAttribute("countries", countryService.findAll());
		return "adminRecipe";
	}
	
	@RequestMapping(value="/admin/recipe", method=RequestMethod.POST)
	public String save(@ModelAttribute("recipe") RecipeForm form){
		recipeService.save(form);
		return "redirect:/admin/recipe";
	}
	
	@RequestMapping(value="/admin/recipe/delete/{id}")
	public String delete(@PathVariable int id){
		recipeService.delete(id);
		return "redirect:/admin/recipe";
	}
	
	@RequestMapping(value="/admin/recipe/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("recipe", recipeService.findOneCountryInited(id));
		model.addAttribute("recipes", recipeService.findAll());
		model.addAttribute("countries", countryService.findAll());
		return "adminRecipe";
	}
	
}
