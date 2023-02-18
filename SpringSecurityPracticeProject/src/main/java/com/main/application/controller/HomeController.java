package com.main.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.main.application.entity.User;
import com.main.application.service.UserService;

@Controller
@RequestMapping("/home") 
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String getLoginPage() {
		System.out.println("Login Url Called");
		return "login";
	}
	
	@GetMapping("/home")
	public ModelAndView getHomePage() {
		ModelAndView view = new ModelAndView("Home");
		view.addObject("name", "Priya Rambhade");
		return view;
	}
 
	@GetMapping("/getUserRegistrationpage")
	public ModelAndView getUserRegistrationpage() {
		System.out.println("User registration");
		ModelAndView view = new ModelAndView("UserRegistrationPage");
		return view;
	}
	
}
