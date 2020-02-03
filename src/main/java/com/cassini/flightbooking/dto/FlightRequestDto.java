package com.cassini.flightbooking.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightRequestDto {
	
	private Integer fromLocationId;
	private Integer toLocationId;
	private LocalDate date;
	private String flightClass;
	private Integer numberOfSeats;

}
