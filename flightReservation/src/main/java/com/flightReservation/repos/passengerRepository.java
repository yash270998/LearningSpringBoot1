package com.flightReservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightReservation.entities.Passenger;

public interface passengerRepository extends JpaRepository<Passenger, Integer> {

}
