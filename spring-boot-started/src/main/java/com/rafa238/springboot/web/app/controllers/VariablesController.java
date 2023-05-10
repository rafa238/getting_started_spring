package com.rafa238.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/variable")
public class VariablesController {
	
	@RequestMapping("/string/{text}")
	public String pathVariable(Model model, @PathVariable(name="text") String variable) {
		model.addAttribute("title", "Variables path");
		model.addAttribute("result", variable);
		return "variables/watch";
	}
	
	@RequestMapping("/mix-variables/{text}/{number}")
	public String pathVariables(Model model, @PathVariable(name="text") String variable,  @PathVariable(name="number") Integer num) {
		model.addAttribute("title", "Variables path");
		model.addAttribute("result", variable);
		model.addAttribute("number", num);
		return "variables/watch";
	}
}
