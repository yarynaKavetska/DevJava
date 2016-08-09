package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.IngredientAmountService;
import ua.service.IngredientService;
import ua.service.MeasuringSystemService;

@Controller
public class IngredientAmountController {

	@Autowired
	private IngredientAmountService ingredientAmountService;
	
	@Autowired
	private IngredientService ingredientService;
	
	@Autowired
	private MeasuringSystemService measuringSystemService;
	
	@RequestMapping("/admin/ingredientAmount")
	public String show(Model model){
		model.addAttribute("measuringSystems", measuringSystemService.findAll())
		.addAttribute("ingredients", ingredientService.findAll())
		.addAttribute("ingredientAmounts", ingredientAmountService.findAll());
		return "ingredientAmountAdmin";
	}
	
	@RequestMapping(value = "/admin/ingredientAmount", method=RequestMethod.POST)
	public String save(@RequestParam int amount, 
			@RequestParam int ingredientId,
			@RequestParam int msId){
		ingredientAmountService.save(amount, ingredientId, msId);
		return "redirect:/admin/ingredientAmount";
	}
	
	@RequestMapping("/admin/ingredientAmount/delete/{id}")
	public String delete(@PathVariable int id){
		ingredientAmountService.delete(id);
		return "ingredientAmountAdmin";
	}
}
