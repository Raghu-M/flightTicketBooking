package com.cassini.flightbooking.dto;

import java.time.LocalTime;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightResponseDto {
	
	private String companyName;
	private LocalTime arrivalTime;
	private LocalTime departureTime;
	private Double economyPrice;
	private Double businessPrice;
	private String fromLocation;
	private String toLocation;
	private LocalDate date;
	private Integer flightTravelId;

}
