package com.cassini.flightbooking.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TravellerRequestDto {
	
	private String travellerName;
	private String email;
	private LocalDate dateOfBirth;
	private Long phoneNumber;

}
