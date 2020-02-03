package com.cassini.flightbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cassini.flightbooking.entity.FlightTravel;

@Repository
public interface FlightTravelRepository extends JpaRepository<FlightTravel, Integer>{

}
