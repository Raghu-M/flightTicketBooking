package com.cassini.flightbooking.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cassini.flightbooking.entity.Location;
import com.cassini.flightbooking.service.LocationService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LocationControllerTest {

	@InjectMocks
	LocationController locationController;
	@Mock
	LocationService locationService;

	@Test
	public void getAllLocations() {

		List<Location> list = new ArrayList<Location>();
		Location location1 = new Location();
		location1.setLocationId(1);
		location1.setLocationName("BANGALORE");
		Location location2 = new Location();
		location2.setLocationId(2);
		location2.setLocationName("BANGALORE");
		Location location3 = new Location();
		location3.setLocationId(3);
		location3.setLocationName("CHENNAI");
		list.add(location1);
		list.add(location2);
		list.add(location3);

		Mockito.when(locationService.getAllLocations()).thenReturn(list);
		List<Location> allLocations = locationService.getAllLocations();

		assertEquals(3, allLocations.size());
	
	
	}

}
