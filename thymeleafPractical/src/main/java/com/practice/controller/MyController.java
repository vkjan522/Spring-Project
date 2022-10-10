package com.practice.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model model) {
		// putting data in model....
		model.addAttribute("name", "vikash");
		model.addAttribute("currentDate", new Date().toLocaleString());

		return "about";
		// about.html
	}
	// Handling iteration

	@GetMapping("/example-loop")
	public String iterateHandler(Model m) {
		// Creating list, set, collection
		List<String> names = List.of("vikash", "deepak", "chhotu", "vivek");
		m.addAttribute("names", names);

		return "iterate";
	}

	// Handler for conditional statement
	@GetMapping("/example-condition")
	public String conditionalStatement(Model m) {
		m.addAttribute("isActive", true);
		m.addAttribute("gender", "f");
		List<Integer> list = List.of(899, 876, 90, 4567, 1235);
		m.addAttribute("myList", list);
		return "conditional";
	}

	// handler for including fragments
	@GetMapping("/service")
	public String servicesHandler(Model m) {
		// processing logic
		m.addAttribute("title", "I like to eat Samosa");
		m.addAttribute("subtitle", LocalDateTime.now().toString());
		return "services";
	}

}
