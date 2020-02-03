package com.cassini.flightbooking.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cassini.flightbooking.dto.BookingRequestDto;
import com.cassini.flightbooking.entity.Booking;
import com.cassini.flightbooking.entity.FlightTravel;
import com.cassini.flightbooking.entity.Traveller;
import com.cassini.flightbooking.repository.BookingRepository;
import com.cassini.flightbooking.repository.FlightTravelRepository;
import com.cassini.flightbooking.repository.TravellerRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	TravellerRepository travellerRepository;
	@Autowired
	FlightTravelRepository flightTravelRepository;

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
