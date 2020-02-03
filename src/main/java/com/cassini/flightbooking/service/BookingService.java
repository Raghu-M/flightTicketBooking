package com.cassini.flightbooking.service;

import com.cassini.flightbooking.dto.BookingRequestDto;

public interface BookingService {
	
	public Long saveBookingDetails(BookingRequestDto bookingRequestDto);

}
