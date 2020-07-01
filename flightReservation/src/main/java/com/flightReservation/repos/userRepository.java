package com.flightReservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightReservation.entities.User;

public interface userRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);

}
