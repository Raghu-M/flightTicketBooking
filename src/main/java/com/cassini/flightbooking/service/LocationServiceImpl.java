package com.cassini.flightbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cassini.flightbooking.entity.Location;
import com.cassini.flightbooking.repository.LocationRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LocationServiceImpl implements LocationService {
	@Autowired
	LocationRepository locationRepository;
	/**
	 * This method is used to get Locations list
	 * 
	 */
	@Override
	public List<Location> getAllLocations() {
		log.info("starting  getAllLocations method , inside LocationServiceImpl");
		return locationRepository.findAll();
	}

}
