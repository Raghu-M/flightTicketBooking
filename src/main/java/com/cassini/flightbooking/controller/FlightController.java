package com.cassini.flightbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassini.flightbooking.dto.FlightRequestDto;
import com.cassini.flightbooking.dto.FlightResponseDto;
import com.cassini.flightbooking.exception.DateNotFoundException;
import com.cassini.flightbooking.exception.LocationNotFoundException;
import com.cassini.flightbooking.service.FlightService;
import com.cassini.flightbooking.util.ApplicationConstant;

import lombok.extern.slf4j.Slf4j;

/**
 * This Controller is having the flight related functionalities. This
 * Controller will call the flightService in which the implementations are
 * done.
 * 
 * @API It has a method which will get the flights.
 * @author Raghu 
 */

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
@RequestMapping("/flights")
@Slf4j
public class FlightController {
	
	/**
	 * This will inject all the implementations in the flightService.
	 */
	@Autowired
	FlightService flightService;

	/**
	 * @author Raghu
	 * 
	 *         this API is used to get the flights using from location, to location
	 *         and date.
	 * 
	 * @param from location, to location, date.
	 * @return list of flights.
	 * @throws LocationNotFoundException
	 * @throws DateNotFoundException
	 * 
	 */
	@PostMapping
	public ResponseEntity<List<FlightResponseDto>> getFlights(@RequestBody FlightRequestDto flightRequestDto)
			throws LocationNotFoundException, DateNotFoundException {
		log.info("getFlights controller ---> getting flights... ");
		if (flightRequestDto.getFromLocationId() == null) {
			log.error("getFlights controller ---> LocationNotFoundException occured");
			throw new LocationNotFoundException(ApplicationConstant.FROM_LOCATION_NOT_FOUND);
		} else if (flightRequestDto.getToLocationId() == null) {
			log.error("getFlights controller ---> LocationNotFoundException occured");
			throw new LocationNotFoundException(ApplicationConstant.TO_LOCATION_NOT_FOUND);

		} else if (flightRequestDto.getDate() == null) {
			log.error("getFlights controller ---> DateNotFoundException occured");
			throw new DateNotFoundException(ApplicationConstant.DATE_NOT_FOUND);

		} else {
			return ResponseEntity.ok().body(flightService.getFlights(flightRequestDto));
		}

	}

}
