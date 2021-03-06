package com.flightReservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightReservation.dto.ReservationUpdateRequest;
import com.flightReservation.entities.Reservation;
import com.flightReservation.repos.reservationRepository;

@RestController
@CrossOrigin
public class ReservationRESTController {
	@Autowired
	reservationRepository reservationrepo;
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRESTController.class);
	
	@RequestMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable("id") int id) {
		LOGGER.info("Inside findReservation for ID: "+id);
		Reservation reservation = reservationrepo.findById(id).get();
		return reservation;
	}
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
LOGGER.info("inside Update Reservation for : "+request);
		Reservation reservation = reservationrepo.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		return reservationrepo.save(reservation);
	}
}
