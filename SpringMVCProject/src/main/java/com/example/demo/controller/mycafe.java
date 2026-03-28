package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class mycafe {

	@RequestMapping("/cafe")
	public String showWelPage(Model model) {
		String name = "Priyanka";
		model.addAttribute("myname", name);
		return "welcome";
	}

	@RequestMapping("/processOrder")
	public String processOrder(HttpServletRequest request,Model model) {
		
		String userEnteredValue = request.getParameter("foodType");
		
		model.addAttribute("userInput", userEnteredValue);
		
		return "processOrder";
	}
}
