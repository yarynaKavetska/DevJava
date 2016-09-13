package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.Ingredient;
import ua.form.filter.IngredientFilterForm;
import ua.service.IngredientService;

@Controller
public class IngredientController {

	@Autowired
	private IngredientService ingredientService;
	
	@ModelAttribute("ingredient")
	public Ingredient getForm(){
		return new Ingredient();
	}
	
	@ModelAttribute("filter")
	public IngredientFilterForm getFilter(){
		return new IngredientFilterForm();
	}
	
	@RequestMapping("/admin/ingredient")
	public String show(Model model,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") IngredientFilterForm form){
		model.addAttribute("page", ingredientService.findAll(pageable, form));
		return "adminIngredient";
	}
	
	@RequestMapping(value="/admin/ingredient", method=RequestMethod.POST)
	public String save(@ModelAttribute("ingredient") Ingredient ingredient,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") IngredientFilterForm form){
		ingredientService.save(ingredient);
		return "redirect:/admin/ingredient"+getParams(pageable, form);
	}
	
	@RequestMapping("/admin/ingredient/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") IngredientFilterForm form){
		ingredientService.delete(id);
		return "redirect:/admin/ingredient"+getParams(pageable, form);
	}
	
	@RequestMapping("/admin/ingredient/update/{id}")
	public String update(Model model, @PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") IngredientFilterForm form){
		model.addAttribute("ingredient", ingredientService.findOne(id));
		model.addAttribute("ingredients", ingredientService.findAll(pageable, form));
		return "adminIngredient";
	}
	
	private String getParams(Pageable pageable, IngredientFilterForm form){
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
		buffer.append("&search=");
		buffer.append(form.getSearch());
		return buffer.toString();
	}
}
