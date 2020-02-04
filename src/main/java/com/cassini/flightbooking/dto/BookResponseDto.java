package com.cassini.flightbooking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponseDto {
	
	private String paymentMode;
	private Long bookingId;

}
