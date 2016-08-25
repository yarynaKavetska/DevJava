package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.entity.MyUser;
import ua.service.MyUserService;

@Controller
public class IndexController {

	@Autowired
	private MyUserService service;
	
	@RequestMapping("/")
	public String showIndex(MyUser user, Model model){
		model.addAttribute("user", user);
		return "index";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String showIndex(@ModelAttribute MyUser user){
		service.save(user);
		return "redirect:/";
	}
	
	@RequestMapping("/admin")
	public String showAdmin() {
		return "adminPanel";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
}
