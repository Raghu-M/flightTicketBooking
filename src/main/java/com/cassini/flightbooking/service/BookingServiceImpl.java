package com.cassini.flightbooking.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cassini.flightbooking.dto.BookingRequestDto;
import com.cassini.flightbooking.dto.BookingResponseDto;
import com.cassini.flightbooking.dto.TravellerDto;
import com.cassini.flightbooking.entity.Booking;
import com.cassini.flightbooking.entity.FlightTravel;
import com.cassini.flightbooking.entity.Traveller;
import com.cassini.flightbooking.exception.RecordNotFoundException;
import com.cassini.flightbooking.repository.BookingRepository;
import com.cassini.flightbooking.repository.FlightTravelRepository;
import com.cassini.flightbooking.repository.TravellerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	TravellerRepository travellerRepository;
	
	@Autowired
	FlightTravelRepository flightTravelRepository;

	/**
	 * 
	 * @param bookingId is the parameter for getBookingDetailsById() method
	 * @return booking details
	 * @throws RecordNotFoundException 
	 */
	public BookingResponseDto getBookingDetailsById(Long bookingId) throws RecordNotFoundException {
		log.info("starting getBookingDetailsById method , inside BookingServiceImpl");
		 Optional<Booking> bookingdetails = bookingRepository.findById(bookingId);
		 if (!bookingdetails.isPresent()) {
				throw new RecordNotFoundException("Invalid BookingDetails id : " + bookingId);
			}
		 BookingResponseDto bookingResponseDto = new BookingResponseDto();
		 bookingResponseDto.setCompanyName(bookingdetails.get().getFlightTravel().getFlight().getCompany().getCompanyName());
		 bookingResponseDto.setDate(bookingdetails.get().getFlightTravel().getDate());
		 bookingResponseDto.setFromLocation(bookingdetails.get().getFlightTravel().getFromLocation().getLocationName());
		 bookingResponseDto.setToLocation(bookingdetails.get().getFlightTravel().getToLocation().getLocationName());
		 bookingResponseDto.setFlightClass(bookingdetails.get().getFlightClass());
		 List<Traveller> travellers = travellerRepository.findByBooking(bookingdetails.get());
		 List<TravellerDto> travellerDtos = new ArrayList<TravellerDto>();
		 travellers.forEach(traveller -> {
			 TravellerDto travellerDto = new TravellerDto();
			 BeanUtils.copyProperties(traveller, travellerDto);
			 travellerDtos.add(travellerDto);
		 });
		 bookingResponseDto.setTravellers(travellerDtos);
		return bookingResponseDto;
	}


	@Override
	@Transactional
	public Long saveBookingDetails(BookingRequestDto bookingRequestDto) {

		Optional<FlightTravel> fligtTravel = flightTravelRepository.findById(bookingRequestDto.getFlightTravelId());

		if (bookingRequestDto.getFlightClass().equals("economy")) {

			fligtTravel.get().setEconomySeatAvailable(
					fligtTravel.get().getEconomySeatAvailable() - bookingRequestDto.getNumberOfSeats());

		} else if (bookingRequestDto.getFlightClass().equals("business")) {

			fligtTravel.get().setBusinessSeatAvailable(
					fligtTravel.get().getBusinessSeatAvailable() - bookingRequestDto.getNumberOfSeats());

		}
		flightTravelRepository.save(fligtTravel.get());
		Booking booking = new Booking();
		booking.setFlightClass(bookingRequestDto.getFlightClass());
		FlightTravel flightTravel = new FlightTravel();
		flightTravel.setFlightTravelId(bookingRequestDto.getFlightTravelId());
		booking.setFlightTravel(flightTravel);
		bookingRepository.save(booking);
		bookingRequestDto.getTraveller().forEach(t -> {
			Traveller traveller = new Traveller();
			traveller.setBooking(booking);
			BeanUtils.copyProperties(t, traveller);
			travellerRepository.save(traveller);
		});
		
		return booking.getBookingId();

	}

}
