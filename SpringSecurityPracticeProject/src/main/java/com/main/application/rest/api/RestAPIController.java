package com.main.application.rest.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.application.service.UserService;

@RestController
public class RestAPIController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping("/list")
	public List<String> getList(){
		List<String> list = new ArrayList<>();
		list.add("Priya");
		list.add("Namdev");
 		list.add("Rambhade");
		return list;
	}
	
	@GetMapping("/isUserExits")
	public boolean isUserExits(HttpServletRequest request,HttpServletResponse response) {
		boolean isValid = false;
		String email = (String)request.getAttribute("email");
		String mobileNumber = (String)request.getAttribute("mobileNumber");
		
		long id = (Long)request.getAttribute("id");
		
		if(email != null && !email.isEmpty()) {
			isValid = service.checkUserExistByEmail(email, id);
		}else if(mobileNumber != null && !mobileNumber.isEmpty()) {
			isValid = service.checkUserExistByMobileNumber(mobileNumber, id);
		} 
		return isValid;
	}
	

}
