package com.cassini.flightbooking.controller;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cassini.flightbooking.dto.FlightRequestDto;
import com.cassini.flightbooking.exception.DateNotFoundException;
import com.cassini.flightbooking.exception.LocationNotFoundException;
import com.cassini.flightbooking.service.FlightService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class FlightControllerTest {
	
	@InjectMocks
	FlightController flightController;
	
	@Mock
	FlightService flightService;
	
	@Test(expected = LocationNotFoundException.class)
	public void testGetFlightsToLocationMissing() throws LocationNotFoundException, DateNotFoundException {
		FlightRequestDto flightRequestDto = new FlightRequestDto();
		flightController.getFlights(flightRequestDto);
	}
	
	@Test(expected = LocationNotFoundException.class)
	public void testGetFlightsDateMissing() throws LocationNotFoundException, DateNotFoundException {
		FlightRequestDto flightRequestDto = new FlightRequestDto();
		flightRequestDto.setFromLocationId(1);
		flightController.getFlights(flightRequestDto);
	}
	
	@Test(expected = DateNotFoundException.class)
	public void testGetFlightsFromLocationMissing() throws LocationNotFoundException, DateNotFoundException {
		FlightRequestDto flightRequestDto = new FlightRequestDto();
		flightRequestDto.setFromLocationId(1);
		flightRequestDto.setToLocationId(2);
		flightController.getFlights(flightRequestDto);
	}
	
	@Test
	public void testGetFlightsSuccess() throws LocationNotFoundException, DateNotFoundException {
		FlightRequestDto flightRequestDto = new FlightRequestDto();
		flightRequestDto.setFromLocationId(1);
		flightRequestDto.setToLocationId(2);
		flightRequestDto.setDate(LocalDate.now());
		Mockito.when(flightService.getFlights(flightRequestDto)).thenReturn(new ArrayList<>());
		assertNotNull(flightController.getFlights(flightRequestDto));
	}
	
	
	
}
