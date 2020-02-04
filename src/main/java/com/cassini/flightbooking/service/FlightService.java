package com.cassini.flightbooking.service;

import java.util.List;

import com.cassini.flightbooking.dto.FlightRequestDto;
import com.cassini.flightbooking.dto.FlightResponseDto;

public interface FlightService {
	
	List<FlightResponseDto> getFlights(FlightRequestDto flightRequestDto);

}
