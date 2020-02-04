package com.cassini.flightbooking.service;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cassini.flightbooking.dto.FlightRequestDto;
import com.cassini.flightbooking.entity.Company;
import com.cassini.flightbooking.entity.Flight;
import com.cassini.flightbooking.entity.FlightTravel;
import com.cassini.flightbooking.entity.Location;
import com.cassini.flightbooking.repository.FlightTravelRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class FlightServiceTest {

	@InjectMocks
	FlightServiceImpl flightServiceImpl;

	@Mock
	FlightTravelRepository flightTravelRepository;

	List<FlightTravel> flights = new ArrayList<FlightTravel>();
	FlightRequestDto flightRequestDto = new FlightRequestDto();

	@Before
	public void setup() {
		flightRequestDto.setDate(LocalDate.now());
		flightRequestDto.setFlightClass("economy");
		flightRequestDto.setFromLocationId(1);
		flightRequestDto.setNumberOfSeats(5);
		flightRequestDto.setToLocationId(2);

		Company company = new Company();
		company.setCompanyName("test");

		Flight flight = new Flight();
		flight.setCompany(company);

		Location location = new Location();
		location.setLocationName("test");

		FlightTravel flightTravel = new FlightTravel();
		flightTravel.setFlight(flight);
		flightTravel.setArrivalTime(LocalTime.now());
		flightTravel.setDepartureTime(LocalTime.now());
		flightTravel.setEconomySeatAvailable(10);
		flightTravel.setBusinessSeatAvailable(10);
		flightTravel.setEconomyPrice(123.0);
		flightTravel.setBusinessPrice(123.0);
		flightTravel.setFromLocation(location);
		flightTravel.setToLocation(location);
		flightTravel.setDate(LocalDate.now());
		flights.add(flightTravel);
		
		FlightTravel flightTravel1 = new FlightTravel();
		flightTravel1.setFlight(flight);
		flightTravel1.setArrivalTime(LocalTime.now());
		flightTravel1.setDepartureTime(LocalTime.now());
		flightTravel1.setEconomySeatAvailable(2);
		flightTravel1.setBusinessSeatAvailable(2);
		flightTravel1.setEconomyPrice(123.0);
		flightTravel1.setBusinessPrice(123.0);
		flightTravel1.setFromLocation(location);
		flightTravel1.setToLocation(location);
		flightTravel1.setDate(LocalDate.now());
		flights.add(flightTravel1);

	}

	@Test
	public void testGetFlightsSuccessEconomy() {

		Mockito.when(flightTravelRepository.findByFromLocationAndToLocationAndDate(Mockito.any(), Mockito.any(),
				Mockito.any())).thenReturn(flights);
		assertNotNull(flightServiceImpl.getFlights(flightRequestDto));

	}
	
	@Test
	public void testGetFlightsSuccessBusiness() {
		flightRequestDto.setFlightClass("business");
		Mockito.when(flightTravelRepository.findByFromLocationAndToLocationAndDate(Mockito.any(), Mockito.any(),
				Mockito.any())).thenReturn(flights);
		assertNotNull(flightServiceImpl.getFlights(flightRequestDto));

	}
	
	@Test
	public void testGetFlightsNoClass() {
		flightRequestDto.setFlightClass("null");
		Mockito.when(flightTravelRepository.findByFromLocationAndToLocationAndDate(Mockito.any(), Mockito.any(),
				Mockito.any())).thenReturn(flights);
		assertNotNull(flightServiceImpl.getFlights(flightRequestDto));

	}

}
