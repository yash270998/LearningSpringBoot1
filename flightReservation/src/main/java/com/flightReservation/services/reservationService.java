package com.flightReservation.services;

import com.flightReservation.dto.ReservationRequest;
import com.flightReservation.entities.Reservation;

public interface reservationService {
	public Reservation bookFlight(ReservationRequest request);
}
