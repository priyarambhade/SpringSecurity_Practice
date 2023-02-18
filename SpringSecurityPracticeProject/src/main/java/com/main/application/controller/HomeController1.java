package com.main.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.main.application.entity.User;
import com.main.application.service.UserService;

@Controller
public class HomeController1 {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getSideBar")
	public ModelAndView getSideBar() {
		ModelAndView view = new ModelAndView("app_side_bar");
		return view;
	}
	
	@RequestMapping("/registerUser")
	public ModelAndView registerUser() {
		ModelAndView view = new ModelAndView("UserRegistrationPage");
		return view;
	}
	
	@RequestMapping(value="/saveUser", method = RequestMethod.POST)
	public Object saveUser(HttpServletRequest request,HttpServletResponse  response,User user) {
		if(user != null) {
			userService.saveUser(user);
		}
		ModelAndView view = new ModelAndView("redirect:/getUserRegistrationpage");
		return view;
	}

}
