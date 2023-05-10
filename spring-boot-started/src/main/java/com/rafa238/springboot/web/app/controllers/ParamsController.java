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
	 * @RequestParam can especifying if the current param is required, or default Value
	 */
	@GetMapping("/string")
	public String param(Model model, @RequestParam(name = "param") String parameter) {
		model.addAttribute("result", "The string sent is " + parameter );
		return "params/watch";
	}
}
