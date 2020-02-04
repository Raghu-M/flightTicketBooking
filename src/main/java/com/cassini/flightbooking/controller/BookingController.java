package com.cassini.flightbooking.controller;

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
	BookingServiceImpl bookingServiceImpl;

	/**
	 * 
	 * @param bookingId is the parameter for getBookingDetailsById() method
	 * @return booking details
	 * @throws RecordNotFoundException 
	 */
	@GetMapping("/{bookingId}")
	public ResponseEntity<BookingResponseDto> getBookingDetailsById(@PathVariable("bookingId") Long bookingId) throws RecordNotFoundException {
		log.info("starting getBookingDetailsById method , inside BookingController");
		if (bookingId == null) {
			throw new NullPointerException("Booking Id missing");
		}else {
			return ResponseEntity.ok().body(bookingServiceImpl.getBookingDetailsById(bookingId));
		}
		
		

	}

}
