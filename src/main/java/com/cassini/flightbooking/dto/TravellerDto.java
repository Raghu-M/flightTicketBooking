package com.cassini.flightbooking.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class TravellerDto {
	
	private String travellerName;
	private String email;
	private LocalDate dateOfBirth;
	private Long phoneNumber;

}
