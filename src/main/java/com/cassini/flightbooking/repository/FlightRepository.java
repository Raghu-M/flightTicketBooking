package com.cassini.flightbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cassini.flightbooking.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>{

}
