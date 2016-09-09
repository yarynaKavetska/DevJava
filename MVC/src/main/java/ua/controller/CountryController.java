package ua.controller;

import javax.servlet.http.HttpSession;

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
		model.addAttribute("page", countryService.findAll(pageable));
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
	public String save(@ModelAttribute("country") Country country, HttpSession session){
		countryService.save(country);
		session.removeAttribute("country");
		return "redirect:/admin/country";
	}
	
	@RequestMapping("/admin/country/recipe")
	public String showCountry(Model model){
		model.addAttribute("countries", countryService.findWithRecipes());
		return "adminCountryRecipe";
	}
}
