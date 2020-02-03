package com.cassini.flightbooking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cassini.flightbooking.dto.FlightRequestDto;
import com.cassini.flightbooking.dto.FlightResponseDto;
import com.cassini.flightbooking.entity.FlightTravel;
import com.cassini.flightbooking.entity.Location;
import com.cassini.flightbooking.repository.FlightTravelRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Raghu
 * 
 *         flight service class has the implementations of all the flight
 *         related apis.
 *
 */

@Service
@Slf4j
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightTravelRepository flightTravelRepository;

	/**
	 * @author Raghu
	 * 
	 *         this API is used to get the flights using from location, to location
	 *         and date.
	 * 
	 * @param from location, to location, date.
	 * @return list of flights.
	 * 
	 */

	@Override
	public List<FlightResponseDto> getFlights(FlightRequestDto flightRequestDto) {
		log.info("getFlights controller ---> getting flights... ");
		Location fromLocation = new Location();
		Location toLocation = new Location();
		fromLocation.setLocationId(flightRequestDto.getFromLocationId());
		toLocation.setLocationId(flightRequestDto.getToLocationId());
		List<FlightTravel> flights = flightTravelRepository.findByFromLocationAndToLocationAndDate(fromLocation,
				toLocation, flightRequestDto.getDate());
		if (flightRequestDto.getFlightClass().equals("economy")) {
			flights = flights.stream()
					.filter(flight -> flight.getEconomySeatAvailable() >= flightRequestDto.getNumberOfSeats())
					.collect(Collectors.toList());
		} else if (flightRequestDto.getFlightClass().equals("business")) {
			flights = flights.stream()
					.filter(flight -> flight.getBusinessSeatAvailable() >= flightRequestDto.getNumberOfSeats())
					.collect(Collectors.toList());
		}
		List<FlightResponseDto> flightResponseDtos = new ArrayList<>();
		flights.forEach(flight -> {
			FlightResponseDto flightResponseDto = new FlightResponseDto();
			flightResponseDto.setCompanyName(flight.getFlight().getCompany().getCompanyName());
			BeanUtils.copyProperties(flight, flightResponseDto);
			flightResponseDto.setFromLocation(flight.getFromLocation().getLocationName());
			flightResponseDto.setToLocation(flight.getToLocation().getLocationName());
			flightResponseDtos.add(flightResponseDto);
		});

		return flightResponseDtos;
	}

}
