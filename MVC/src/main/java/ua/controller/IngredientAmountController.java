package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.Ingredient;
import ua.entity.MeasuringSystem;
import ua.form.IngredientAmountForm;
import ua.form.filter.IngredientAmountFilterForm;
import ua.service.IngredientAmountService;
import ua.service.IngredientService;
import ua.service.MeasuringSystemService;
import ua.service.implementation.editor.IngredientEditor;
import ua.service.implementation.editor.MeasuringSystemEditor;

@Controller
public class IngredientAmountController {

	@Autowired
	private IngredientAmountService ingredientAmountService;
	
	@Autowired
	private IngredientService ingredientService;
	
	@Autowired
	private MeasuringSystemService measuringSystemService;
	
	@ModelAttribute("form")
	public IngredientAmountForm getForm(){
		return new IngredientAmountForm();
	}
	
	@ModelAttribute("filter")
	public IngredientAmountFilterForm getFilter(){
		return new IngredientAmountFilterForm();
	}
	
	@InitBinder("form")
	protected void initBinder(WebDataBinder binder){
	   binder.registerCustomEditor(Ingredient.class, new IngredientEditor(ingredientService));
	   binder.registerCustomEditor(MeasuringSystem.class, new MeasuringSystemEditor(measuringSystemService));
	}
	
	@RequestMapping("/admin/ingredientAmount")
	public String show(Model model,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") IngredientAmountFilterForm filter){
		model.addAttribute("measuringSystems", measuringSystemService.findAll())
		.addAttribute("ingredients", ingredientService.findAll())
		.addAttribute("page", ingredientAmountService.findAll(pageable, filter));
		return "ingredientAmountAdmin";
	}
	
	@RequestMapping(value = "/admin/ingredientAmount", method=RequestMethod.POST)
	public String save(@ModelAttribute("form") IngredientAmountForm form,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") IngredientAmountFilterForm filter){
		ingredientAmountService.save(form);
		return "redirect:/admin/ingredientAmount"+getParams(pageable, filter);
	}
	
	@RequestMapping("/admin/ingredientAmount/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") IngredientAmountFilterForm filter){
		ingredientAmountService.delete(id);
		return "redirect:/admin/ingredientAmount"+getParams(pageable, filter);
	}
	
	@RequestMapping("/admin/ingredientAmount/update/{id}")
	public String update(@PathVariable int id, Model model,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") IngredientAmountFilterForm filter){
		model.addAttribute("measuringSystems", measuringSystemService.findAll())
		.addAttribute("ingredients", ingredientService.findAll())
		.addAttribute("page", ingredientAmountService.findAll(pageable, filter));
		model.addAttribute("form", ingredientAmountService.findOneForForm(id));
		return "ingredientAmountAdmin";
	}
	
	private String getParams(Pageable pageable, IngredientAmountFilterForm form){
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
		buffer.append("&min=");
		buffer.append(form.getMin());
		buffer.append("&max=");
		buffer.append(form.getMax());
		for(Integer i : form.getIngredientIds()){
			buffer.append("&ingredientIds=");
			buffer.append(i.toString());
		}
		for(Integer i : form.getMsIds()){
			buffer.append("&msIds=");
			buffer.append(i.toString());
		}
		return buffer.toString();
	}
}
