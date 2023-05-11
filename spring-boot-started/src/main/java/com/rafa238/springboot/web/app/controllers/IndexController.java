package com.rafa238.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rafa238.springboot.web.app.models.User;

@Controller
@RequestMapping(value="/app")
public class IndexController {
	/*
	 * Value notation is used for inject the current value with any value from properties file
	 */
	@Value("${text.indexcontroller.index}")
	private String indexTitle;
	
	@Value("${text.indexcontroller.profile}")
	private String profileTitle;
	
	@Value("${text.indexcontroller.list}")
	private String listTitle;
	
	
	
	//this is the first way to make any request (GET, POST, PUT...), specifying values and method.
	/*
	*	@RequestMapping(value="/index", method = RequestMethod.GET)
	*	public String index() {
	*		return "index";
	*	}
	*/
	
	//this is the second way, making directly GetMapping or PostMapping, using '{}' for all possible routes
	@GetMapping({"/index", "/home", "/", ""})
	public String index(Model model) {
		
		/*
		 * There are three different ways to pass parameters
		 * 1st, 2nd: Using Model(Interface) and ModelMap(Class), both use a HashMap.
		 * 3rd: Model and View, set parameters and also the specific a view to return
		 */
		model.addAttribute("title", this.indexTitle);
		return "index";
	}
	
	@GetMapping("/profile")
	public String profile(Model model) {
		/*
		 * This is a more complete example how to use model (is the most used way to pass parameters)
		 */
		User user = new User();
		user.setName("Bob");
		user.setSurname("William");
		model.addAttribute("title", this.profileTitle);
		model.addAttribute("user", user);
		return "profile";
	}
	
	
	/*
	 * Another way pass parameters using model, is ModelAttribute.
	 * This notation help to make a model that is share along controller routes.
	 */
	@ModelAttribute("users")
	public List<User> fillUsers(){
		List<User> users = Arrays.asList(
				new User("Rafael", "Juarez", "rafa@gmail.com"),
				new User("Samuel", "Juarez", "sasmy@gmail.com"),
				new User("Chiwis", "Juarez", "chiwis@gmail.com"));
		
		return users;
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		/*
		 * This Route will use Model Attribute users
		 */
		model.addAttribute("title", this.listTitle);
		return "list";
	}
}
