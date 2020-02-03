package com.cassini.flightbooking.controller;

<<<<<<< HEAD
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
=======
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassini.flightbooking.dto.BookingResponseDto;
import com.cassini.flightbooking.exception.RecordNotFoundException;
import com.cassini.flightbooking.service.BookingServiceImpl;
>>>>>>> 441b865a3f997b7f11e5cd75fe1f525007e8855f

import lombok.extern.slf4j.Slf4j;

/**
 * The BookingController program implements an application flightbooking
 * 
 * @author Amala
 * @version 1.0
 * @since 2020-02-03
 *
 */
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
	
	

	/**
	 * 
	 * @param bookingId is the parameter for getBookingDetailsById() method
	 * @return booking details
	 * @throws RecordNotFoundException 
	 */
	@GetMapping("/{bookingId}")
	public ResponseEntity<BookingResponseDto> getBookingDetailsById(@PathVariable("bookingId") Long bookingId) throws RecordNotFoundException {
		log.info("starting getBookingDetailsById method , inside LocationController");
		if (bookingId == null) {
			throw new NullPointerException("Booking Id missing");
		}else {
			return ResponseEntity.ok().body(bookingService.getBookingDetailsById(bookingId));
		}
		
		

	}

}
