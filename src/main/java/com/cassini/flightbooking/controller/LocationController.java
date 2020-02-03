package com.cassini.flightbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassini.flightbooking.entity.Location;
import com.cassini.flightbooking.service.LocationService;

import lombok.extern.slf4j.Slf4j;

/**
 * The LocationController program implements an application flightbooking
 * 
 * @author Amala
 * @version 1.0
 * @since 2020-02-03
 *
 */

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
@RequestMapping("/locations")
@Slf4j
public class LocationController {
	@Autowired
	LocationService locationService;

	/**
	 * This method is used to get Locations list
	 * 
	 * @return list This returns list of Locations
	 */
	@GetMapping
	public List<Location> getAllLocations() {
		log.info("starting getAllLocations method , inside LocationController");
		return (List<Location>) locationService.getAllLocations();

	}

}
