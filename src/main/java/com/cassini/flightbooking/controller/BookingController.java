package com.cassini.flightbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassini.flightbooking.dto.BookingRequestDto;
import com.cassini.flightbooking.exception.FlightTravelIdException;
import com.cassini.flightbooking.service.BookingService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
@RequestMapping("/bookings")
@Slf4j
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping
	public ResponseEntity<Long> saveBookingDetails(@RequestBody BookingRequestDto bookingRequestDto) throws FlightTravelIdException
	{
		log.info("Inside saveBookingDetails method in BookingController Class");
		if(bookingRequestDto.getFlightTravelId() == 0 || bookingRequestDto.getFlightTravelId().equals(null) )
		{
			log.error("FlightTravelId not found");
			throw new FlightTravelIdException("");
		}
		return ResponseEntity.ok().body(bookingService.saveBookingDetails(bookingRequestDto));
	}
	
	

}
