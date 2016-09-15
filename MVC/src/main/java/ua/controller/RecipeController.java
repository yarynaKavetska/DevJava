package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
import ua.form.RecipeForm;
import ua.form.filter.RecipeFilterForm;
import ua.service.CountryService;
import ua.service.RecipeService;
import ua.service.implementation.editor.CountryEditor;
import ua.service.implementation.validator.RecipeFormValidator;

@Controller
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private CountryService countryService;
	
	@InitBinder("form")
	protected void initBinder(WebDataBinder binder){
	   binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
	   binder.setValidator(new RecipeFormValidator(recipeService));
	}
	
	@ModelAttribute("form")
	public RecipeForm getForm(){
		return new RecipeForm();
	}
	
	@ModelAttribute("filter")
	public RecipeFilterForm getFilter(){
		return new RecipeFilterForm();
	}
	
	@RequestMapping("/admin/recipe")
	public String showRecipes(Model model,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") RecipeFilterForm form){
		model.addAttribute("page", recipeService.findAll(form, pageable));
		model.addAttribute("countries", countryService.findAll());
		return "adminRecipe";
	}
	
	@RequestMapping(value="/admin/recipe", method=RequestMethod.POST)
	public String save(@ModelAttribute("form") @Valid RecipeForm form,
			BindingResult br, Model model,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") RecipeFilterForm filter){
		if(br.hasErrors()){
			model.addAttribute("page", recipeService.findAll(filter, pageable));
			model.addAttribute("countries", countryService.findAll());
			return "adminRecipe";
		}
		recipeService.save(form);
		return "redirect:/admin/recipe"+getParams(pageable, filter);
	}
	
	@RequestMapping(value="/admin/recipe/update/{id}")
	public String update(Model model, @PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") RecipeFilterForm form){
		model.addAttribute("form", recipeService.findForForm(id));
		model.addAttribute("page", recipeService.findAll(form, pageable));
		model.addAttribute("countries", countryService.findAll());
		return "adminRecipe";
	}
	
	@RequestMapping(value="/admin/recipe/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") RecipeFilterForm form){
		recipeService.delete(id);
		return "redirect:/admin/recipe"+getParams(pageable, form);
	}
	
	private String getParams(Pageable pageable, RecipeFilterForm form){
		StringBuilder buffer = new StringBuilder();
		buffer.append("?page=");
		buffer.append(String.valueOf(pageable.getPageNumber()+1));
		buffer.append("&size=");
		buffer.append(String.valueOf(pageable.getPageSize()));
		if(pageable.getSort()!=null){
			buffer.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order)->{
				buffer.append(order.getProperty());
				if(order.getDirection()!=Direction.ASC)
				buffer.append(",desc");
			});
		}
		return buffer.toString();
	}
	
}
