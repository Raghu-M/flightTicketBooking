package com.cassini.flightbooking.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequestDto {
	
	private Integer flightTravelId;
	private Integer numberOfSeats;
	private String flightClass;
	List<TravellerRequestDto> traveller;
	

}
