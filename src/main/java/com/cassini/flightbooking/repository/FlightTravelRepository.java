package com.cassini.flightbooking.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cassini.flightbooking.entity.FlightTravel;
import com.cassini.flightbooking.entity.Location;

@Repository
public interface FlightTravelRepository extends JpaRepository<FlightTravel, Integer> {

	List<FlightTravel> findByFromLocationAndToLocationAndDate(Location fromLocation, Location toLocation,
			LocalDate date);

}
