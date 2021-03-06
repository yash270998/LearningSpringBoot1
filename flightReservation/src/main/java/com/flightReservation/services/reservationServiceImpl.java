package com.flightReservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flightReservation.dto.ReservationRequest;
import com.flightReservation.entities.Flight;
import com.flightReservation.entities.Passenger;
import com.flightReservation.entities.Reservation;
import com.flightReservation.repos.flightRepository;
import com.flightReservation.repos.passengerRepository;
import com.flightReservation.repos.reservationRepository;
import com.flightReservation.util.EmailUtil;
import com.flightReservation.util.PDFGenerator;

@Service
public class reservationServiceImpl implements reservationService {
	Logger LOGGER = LoggerFactory.getLogger(reservationServiceImpl.class);
	@Autowired
	flightRepository flightrepo;
	@Autowired
	passengerRepository passengerrepo;
	@Autowired
	reservationRepository reservationrepo;
	@Autowired
	PDFGenerator pdfgenerator;
	@Autowired
	EmailUtil emailutil;

	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {
		LOGGER.info("Inside bookFlight()");
		// TODO Auto-generated method stub
		// Make Payment logic. not implemented here.
		int flightId = request.getFlightId();
		LOGGER.info("Flight fetched : " + flightId);
		Flight flight = flightrepo.findById(flightId).get();
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		Passenger savedPassenger = passengerrepo.save(passenger);
		LOGGER.info("saved Passenger : " + savedPassenger);
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);

		Reservation savedReservation = reservationrepo.save(reservation);
		String pathString = "/" + savedReservation.getId() + ".pdf";
		pdfgenerator.generateItinerary(savedReservation, pathString);
		LOGGER.info("Generating Itinerary and EMAIL");
		emailutil.sendItinerary(passenger.getEmail(), pathString);
		return savedReservation;
	}

}
