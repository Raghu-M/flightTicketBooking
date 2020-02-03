package com.cassini.flightbooking.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponseDto {
	
	private List<TravellerDto> travellers;
	private String companyName;
	private String toLocation;
	private String fromLocation;
	private LocalDate date;
	private Integer numberOfSeats;
	private String flightClass;
	

}
