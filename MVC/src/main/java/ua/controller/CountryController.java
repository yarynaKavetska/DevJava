package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.entity.Country;
import ua.service.CountryService;

@Controller
@SessionAttributes("country")
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@ModelAttribute("country")
	public Country getForm(){
		return new Country();
	}

	@RequestMapping("/admin/country")
	public String show(Model model, @PageableDefault(5) Pageable pageable){
		model.addAttribute("countries", countryService.findAllPageable(pageable));
		return "adminCountry";
	}
	
	@RequestMapping("/admin/country/delete/{id}")
	public String delete(@PathVariable int id){
		countryService.delete(id);
		return "redirect:/admin/country";
	}
	
	@RequestMapping(value= "/admin/country", method=RequestMethod.POST)
	public String save(@ModelAttribute("country") Country country){
		countryService.save(country);
		return "redirect:/admin/country";
	}
	
	@RequestMapping("/admin/country/recipe")
	public String showCountry(Model model){
		model.addAttribute("countries", countryService.findWithRecipes());
		return "adminCountryRecipe";
	}
}
