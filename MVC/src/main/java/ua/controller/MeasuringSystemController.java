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

import ua.entity.MeasuringSystem;
import ua.form.filter.MeasuringSystemFilterForm;
import ua.service.MeasuringSystemService;

@Controller
public class MeasuringSystemController {

	@Autowired
	private MeasuringSystemService measuringSystemService;
	
	@ModelAttribute("measuringSystem")
	public MeasuringSystem getForm(){
		return new MeasuringSystem();
	}
	
	@ModelAttribute("filter")
	public MeasuringSystemFilterForm getFilter(){
		return new MeasuringSystemFilterForm();
	}
	
	@RequestMapping("/admin/measuringSystem")
	public String show(Model model,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") MeasuringSystemFilterForm form){
		model.addAttribute("page", measuringSystemService.findAll(pageable, form));
		return "measuringSystemIngredient";
	}
	
	@RequestMapping(value="/admin/measuringSystem", method=RequestMethod.POST)
	public String save(@ModelAttribute("measuringSystem") MeasuringSystem measuringSystem,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") MeasuringSystemFilterForm form){
		measuringSystemService.save(measuringSystem);
		return "redirect:/admin/measuringSystem"+getParams(pageable, form);
	}
	
	@RequestMapping("/admin/measuringSystem/delete/{id}")
	public String delete(@PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") MeasuringSystemFilterForm form){
		measuringSystemService.delete(id);
		return "redirect:/admin/measuringSystem"+getParams(pageable, form);
	}
	
	@RequestMapping("/admin/measuringSystem/update/{id}")
	public String update(Model model, @PathVariable int id,
			@PageableDefault(5) Pageable pageable,
			@ModelAttribute(value="filter") MeasuringSystemFilterForm form){
		model.addAttribute("measuringSystem", measuringSystemService.findOne(id));
		model.addAttribute("measuringSystems", measuringSystemService.findAll(pageable, form));
		return "redirect:/admin/measuringSystem"+getParams(pageable, form);
	}
	
	private String getParams(Pageable pageable, MeasuringSystemFilterForm form){
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
