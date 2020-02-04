package com.cassini.flightbooking.service;

import com.cassini.flightbooking.dto.BookResponseDto;
import com.cassini.flightbooking.dto.BookingRequestDto;
import com.cassini.flightbooking.dto.BookingResponseDto;
import com.cassini.flightbooking.exception.RecordNotFoundException;

public interface BookingService {
	
	public BookResponseDto saveBookingDetails(BookingRequestDto bookingRequestDto);
	
	public BookingResponseDto getBookingDetailsById(Long bookingId) throws RecordNotFoundException;

}
