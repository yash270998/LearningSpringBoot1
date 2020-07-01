package com.flightReservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightReservation.entities.Reservation;

public interface reservationRepository extends JpaRepository<Reservation, Integer> {

}
