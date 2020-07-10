package com.flightReservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightReservation.entities.User;
import com.flightReservation.repos.userRepository;
import com.flightReservation.services.SecurityService;

@Controller
public class userController {
	
	@Autowired
	private userRepository userrepo;
	@Autowired
	SecurityService securityService;
	private static final Logger LOGGER = LoggerFactory.getLogger(userController.class);
	@Autowired
	private BCryptPasswordEncoder encoder;
	@RequestMapping("/showReg")
	public String  showRegistrationPage() {
		LOGGER.info("Inside ShowRegistration Page");
		return "login/registerUser";
	}
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		LOGGER.info("Inside Register()" + user);
		user.setPassword(encoder.encode(user.getPassword()));
		userrepo.save(user);
		return "login/login";
		
	}
	@RequestMapping("/showLogin")

	public String ShowLoginPage() {
		LOGGER.info("Inside ShowLoginPage()");
	return "login/login";

	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelmap) {
		LOGGER.info("Inside Login()" + email);
		
//		User user = userrepo.findByEmail(email);
		boolean loginresponse = securityService.login(email, password);
		if (loginresponse) {
			return "findFlights";
		}
		else {
			modelmap.addAttribute("msg","Invalid Credentials! Try Again!");
		}
		return "login/login";
	}
}
