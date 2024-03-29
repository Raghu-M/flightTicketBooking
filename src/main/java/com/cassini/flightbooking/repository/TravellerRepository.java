package com.cassini.flightbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cassini.flightbooking.entity.Booking;
import com.cassini.flightbooking.entity.Traveller;

@Repository
public interface TravellerRepository extends JpaRepository<Traveller, Integer>{
	
	List<Traveller> findByBooking(Booking booking);

}
