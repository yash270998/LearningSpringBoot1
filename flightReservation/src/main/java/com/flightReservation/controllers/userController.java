package com.flightReservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flightReservation.entities.User;
import com.flightReservation.repos.userRepository;

@Controller
public class userController {
	
	@Autowired
	private userRepository userrepo;
	
	
	@RequestMapping("/showReg")
	public String  showRegistrationPage() {
		return "login/registerUser";
	}
	@RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		userrepo.save(user);
		return "login/login";
		
	}
}
