package com.main.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController { 
	
	@RequestMapping("/signin")
	public String getLoginPage() {
		return "login";
	}
	
	@GetMapping("/")
	public String getHome() {
		return "Home";
	}

}
