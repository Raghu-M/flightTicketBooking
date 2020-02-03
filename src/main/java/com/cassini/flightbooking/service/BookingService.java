package com.cassini.flightbooking.service;

import com.cassini.flightbooking.dto.BookingResponseDto;
import com.cassini.flightbooking.exception.RecordNotFoundException;

public interface BookingService {
	
	public BookingResponseDto getBookingDetailsById(Long bookingId) throws RecordNotFoundException;

}
