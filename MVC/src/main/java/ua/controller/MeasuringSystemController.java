package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.service.MeasuringSystemService;

@Controller
public class MeasuringSystemController {

	@Autowired
	private MeasuringSystemService measuringSystemService;
	
	@RequestMapping("/admin/measuringSystem")
	public String show(Model model){
		model.addAttribute("measuringSystems", measuringSystemService.findAll());
		return "measuringSystemIngredient";
	}
	
	@RequestMapping(value="/admin/measuringSystem", method=RequestMethod.POST)
	public String save(@RequestParam String name){
		measuringSystemService.save(name);
		return "redirect:/admin/measuringSystem";
	}
	
	@RequestMapping("/admin/measuringSystem/delete/{id}")
	public String delete(@PathVariable int id){
		measuringSystemService.delete(id);
		return "redirect:/admin/measuringSystem";
	}
}
