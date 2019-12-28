package com.example.ayoteralab.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ayoteralab.main.dto.UserDTO;
import com.example.ayoteralab.main.service.MyUserDetailsService;

@Controller
public class ViewController {

	final Logger L = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@GetMapping("/signup")
	public String goSignup() {
		return "/signup";
	}
	
	@PostMapping("/signup")
	public String signupUser(UserDTO user) throws Exception {
		L.info("[POST] /usersignup :: Insert User in user_info table - {}", user);
		System.out.println(user);
		
		myUserDetailsService.signupUser(user);
		
		return "redirect:/home";
	}
	
}
