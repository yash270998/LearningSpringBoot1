package com.flightcheckin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightcheckin.integration.ReservationRestClient;
import com.flightcheckin.integration.dto.Reservation;
import com.flightcheckin.integration.dto.ReservationUpdateRequest;

@Controller
public class CheckInController {
	@Autowired
	ReservationRestClient restClient;
	
	@RequestMapping("/showStartCheckIn")
	public String showStartCheckIn() {
		
		return "startCheckIn";
		
	}
	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId") int reservationId,ModelMap modelmap) {
		Reservation reservation = restClient.findReservation(reservationId);
		modelmap.addAttribute("reservation",reservation);
		return "displayReservationDetails";
	}
	@RequestMapping("/completeCheckIn")
	public String completeCheckIn(@RequestParam("reservationId") int reservationId,@RequestParam("numberOfBags")int numberOfBags) {
		ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
		reservationUpdateRequest.setId(reservationId);
		reservationUpdateRequest.setCheckedIn(true);
		reservationUpdateRequest.setNumberOfBags(numberOfBags);
		restClient.updateReservation(reservationUpdateRequest);
		return "checkInConfirmation";
	}
}
