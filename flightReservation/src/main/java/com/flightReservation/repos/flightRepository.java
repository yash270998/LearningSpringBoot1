package com.flightReservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightReservation.entities.Flight;

public interface flightRepository extends JpaRepository<Flight, Integer> {

}
