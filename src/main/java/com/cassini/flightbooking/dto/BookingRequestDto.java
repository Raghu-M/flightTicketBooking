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
	private String paymentMode;
	private Double totalAmount;
	List<TravellerRequestDto> traveller;
	

}
