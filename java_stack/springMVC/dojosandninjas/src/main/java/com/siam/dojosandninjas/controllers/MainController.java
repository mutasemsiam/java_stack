package com.siam.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.siam.dojosandninjas.models.Dojo;
import com.siam.dojosandninjas.models.Ninja;
import com.siam.dojosandninjas.services.DojoService;
import com.siam.dojosandninjas.services.NinjaService;

@Controller
public class MainController {
	@Autowired
	DojoService dojoService;
	
	@Autowired
	NinjaService ninjaService;
	
	@GetMapping("/")
	public String main() {
		
	return "redirect:/dojos/new";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return"adddojo.jsp";
		
	}
	
	@PostMapping("/dojos/new")
	public String createNewDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
            return "adddojo.jsp";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/ninjas/new";
        }
		
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.findDojo(id));
		return "showdojo.jsp";
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "addninja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String createNewNinja(Model model,
			@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result) {
		if (result.hasErrors()) {
            return "addninja.jsp";
        } else {
            ninjaService.createNinja(ninja);
            Dojo dojo = ninja.getDojo();
            Long Id = dojo.getId();
            return "redirect:/dojos/" + Id;
            //or we can redirect with parameter by using redirectAttributes like this:
            //public String createNewNinja(RedirectAttributes redirectAttributes)
            //..
            //Long Id = dojo.getId();
            //redirectAttributes.addAttribute("id", Id);
            //
            //return "redirect:/dojos/{id}";
            
        }
		
	}
	
	
}
