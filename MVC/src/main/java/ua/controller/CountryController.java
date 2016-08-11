package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.Country;
import ua.service.CountryService;

@Controller
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@ModelAttribute("country")
	public Country getCountry(){
		return new Country();
	}

	@RequestMapping("/admin/country")
	public String showCountry(Model model){
		model.addAttribute("countries", countryService.findAll());
		return "adminCountry";
	}
	
	@RequestMapping("/admin/country/delete/{id}")
	public String deleteCountry(@PathVariable int id){
		countryService.delete(id);
		return "redirect:/admin/country";
	}
	
	@RequestMapping("/admin/country/update/{id}")
	public String updateCountry(@PathVariable int id, Model model){
		model.addAttribute("country", countryService.findOne(id));
		model.addAttribute("countries", countryService.findAll());
		return "adminCountry";
	}
	
	@RequestMapping(value= "/admin/country", method=RequestMethod.POST)
	public String showCountry(@ModelAttribute("country") Country country){
		countryService.save(country);
		return "redirect:/admin/country";
	}
}
