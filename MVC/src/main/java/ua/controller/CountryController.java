package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.Country;
import ua.service.CountryService;
import ua.service.implementation.validator.CountryValidator;

@Controller
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@ModelAttribute("country")
	public Country getCountry(){
		return new Country();
	}
	
	@InitBinder("country")
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(new CountryValidator(countryService));
	}

	@RequestMapping("/admin/country")
	public String showCountry(Model model, @PageableDefault(size=5,sort="name") Pageable pageable){
		model.addAttribute("countries", countryService.findAll(pageable));
		return "adminCountry";
	}
	
	@RequestMapping("/admin/country/delete/{id}")
	public String deleteCountry(@PathVariable int id){
		countryService.delete(id);
		return "redirect:/admin/country";
	}
	
	@RequestMapping("/admin/country/update/{id}")
	public String updateCountry(@PathVariable int id, Model model, @PageableDefault(size=5) Pageable pageable){
		model.addAttribute("country", countryService.findOne(id));
		model.addAttribute("countries", countryService.findAll(pageable));
		return "adminCountry";
	}
	
	@RequestMapping(value= "/admin/country", method=RequestMethod.POST)
	public String showCountry(@ModelAttribute("country") @Valid Country country, BindingResult br, Model model, @PageableDefault(size=5) Pageable pageable){
		if(br.hasErrors()){
			model.addAttribute("countries", countryService.findAll(pageable));
			return "adminCountry";
		}
		countryService.save(country);
		return "redirect:/admin/country";
	}
}
