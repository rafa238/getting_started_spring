package com.rafa238.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {
	
	/*
	 * We can receive parameters in a url way (?example=example+String)
	 * @RequestParam can specifying if the current param is required, or default Value
	 */
	@GetMapping("/string")
	public String param(Model model, @RequestParam(name = "param") String parameter) {
		model.addAttribute("result", "The string sent is " + parameter );
		return "params/watch";
	}
	
	/*
	 * This is an example how we can get multiple parameters
	 * If we omit the @RequesParam name, we consider variable's name as parameter name
	 */
	@GetMapping("/mix-params")
	public String mixParams(Model model, @RequestParam String greeting, @RequestParam Integer num) {
		model.addAttribute("result", "The greetiong sent is: " + greeting + ", and number: " + num );
		return "params/watch";
	}
	
}
