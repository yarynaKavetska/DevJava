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
import org.springframework.web.bind.annotation.RequestParam;

import ua.entity.Country;
import ua.form.CountryFilterForm;
import ua.service.CountryService;

@Controller
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@ModelAttribute(value="country")
	public Country getForm(){
		return new Country();
	}
	
	@ModelAttribute(value="filter")
	public CountryFilterForm getFilter(){
		return new CountryFilterForm();
	}

	@RequestMapping("/admin/country")
	public String show(Model model, @PageableDefault(5) Pageable pageable, @ModelAttribute(value="filter") CountryFilterForm form){
		model.addAttribute("page", countryService.findAll(pageable, form));
		return "adminCountry";
	}
	
	@RequestMapping("/admin/country/delete/{id}")
	public String delete(@PathVariable int id, 
			@RequestParam(value="page", required=false, defaultValue="1") int page, 
			@RequestParam(value="size", required=false, defaultValue="5") int size,
			@RequestParam(value="sort", required=false, defaultValue="") String sort){
		countryService.delete(id);
		return "redirect:/admin/country?page="+page+"&size="+size+"&sort="+sort;
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
