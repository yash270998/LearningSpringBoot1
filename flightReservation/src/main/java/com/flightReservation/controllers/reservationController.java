package com.flightReservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightReservation.entities.Flight;
import com.flightReservation.repos.flightRepository;

@Controller
public class reservationController {
	
	@Autowired
	flightRepository repo;
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") int flightId,ModelMap modelmap) {
		Flight flight = repo.findById(flightId).get();
		modelmap.addAttribute("flight",flight);
		return "completeReservation";
	}
}
