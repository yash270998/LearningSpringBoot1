package com.flightReservation.controllers;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightReservation.entities.Flight;
import com.flightReservation.repos.flightRepository;

@Controller
public class flightController {
	@Autowired
	private flightRepository flightrepo;
	
	Logger LOGGER = LoggerFactory.getLogger(flightController.class);
	@RequestMapping("findFlights")
	public String findFlights(@RequestParam("from") String from,@RequestParam("to") String to,
			@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate, ModelMap modelmap) {
		LOGGER.info("Inside findFlights() From : " +from + " To : "+to);
		List<Flight> flights = flightrepo.findFlights(from,to,departureDate);
		
		modelmap.addAttribute("flights",flights);
		LOGGER.info("Flights Found are : "+flights);
		return "displayFlights";
	}
}
