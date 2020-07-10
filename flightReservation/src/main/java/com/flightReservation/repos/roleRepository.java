package com.flightReservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightReservation.entities.Role;

public interface roleRepository extends JpaRepository<Role, Integer> {

}
