package com.flightReservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightReservation.dto.ReservationRequest;
import com.flightReservation.entities.Flight;
import com.flightReservation.entities.Reservation;
import com.flightReservation.repos.flightRepository;
import com.flightReservation.services.reservationService;

@Controller
public class reservationController {
	Logger LOGGER = LoggerFactory.getLogger(reservationController.class);
	@Autowired
	flightRepository repo;
	@Autowired
	reservationService reserService;
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") int flightId,ModelMap modelmap) {
		LOGGER.info("Inside ShowComplete Reservation() with FlightID : "+flightId);
		Flight flight = repo.findById(flightId).get();
		modelmap.addAttribute("flight",flight);
		LOGGER.info("Flight is :"+flight);
		return "completeReservation";
	}
	@RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelmap) {
		LOGGER.info("Inside completeReservation()"+request) ;
		Reservation reservation = reserService.bookFlight(request);
		modelmap.addAttribute("msg","Reservation created successfully! Id : " + reservation.getId());
		return "reservationConfirmation";
	}
}
