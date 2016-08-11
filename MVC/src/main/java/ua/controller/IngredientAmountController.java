package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import ua.form.AmountForm;
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
	
	@InitBinder("amount")
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(MeasuringSystem.class, new MeasuringSystemEditor(measuringSystemService));
		binder.registerCustomEditor(Ingredient.class, new IngredientEditor(ingredientService));
	}
	
	@ModelAttribute("amount")
	public AmountForm getAmount(){
		return new AmountForm();
	}
	
	@RequestMapping("/admin/ingredientAmount")
	public String show(Model model){
		model.addAttribute("measuringSystems", measuringSystemService.findAll())
		.addAttribute("ingredients", ingredientService.findAll())
		.addAttribute("ingredientAmounts", ingredientAmountService.findAll());
		return "ingredientAmountAdmin";
	}
	
	@RequestMapping(value = "/admin/ingredientAmount", method=RequestMethod.POST)
	public String save(@ModelAttribute("amount") AmountForm form){
		ingredientAmountService.save(form);
		return "redirect:/admin/ingredientAmount";
	}
	
	@RequestMapping("/admin/ingredientAmount/delete/{id}")
	public String delete(@PathVariable int id){
		ingredientAmountService.delete(id);
		return "ingredientAmountAdmin";
	}
	
	@RequestMapping("/admin/ingredientAmount/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("measuringSystems", measuringSystemService.findAll())
		.addAttribute("ingredients", ingredientService.findAll())
		.addAttribute("ingredientAmounts", ingredientAmountService.findAll())
		.addAttribute("amount", ingredientAmountService.findOneForm(id));
		return "ingredientAmountAdmin";
	}
}
