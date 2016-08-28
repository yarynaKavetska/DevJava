package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.CountryService;

@Controller
public class CountryController {
	
	@Autowired
	private CountryService countryService;

	@RequestMapping("/admin/country")
	public String show(Model model){
		model.addAttribute("countries", countryService.findAll());
		return "adminCountry";
	}
	
	@RequestMapping("/admin/country/delete/{id}")
	public String delete(@PathVariable int id){
		countryService.delete(id);
		return "redirect:/admin/country";
	}
	
	@RequestMapping(value= "/admin/country", method=RequestMethod.POST)
	public String save(@RequestParam String name){
		countryService.save(name);
		return "redirect:/admin/country";
	}
	
	@RequestMapping("/admin/country/recipe")
	public String showCountry(Model model){
		model.addAttribute("countries", countryService.findWithRecipes());
		return "adminCountryRecipe";
	}
}
