package com.flightReservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		userrepo.save(user);
		return "login/login";
		
	}
	@RequestMapping("/showLogin")

	public String ShowLoginPage() {
	return "login/login";

	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelmap) {
		User user = userrepo.findByEmail(email);
		if (user.getPassword().equals(password)) {
			return "findFlights";
		}
		else {
			modelmap.addAttribute("msg","Invalid Credentials! Try Again!");
		}
		return "login/login";
	}
}
