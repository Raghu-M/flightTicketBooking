package com.cassini.flightbooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "bookingId", initialValue = 50000, allocationSize = 1)
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookingId")
	private Long bookingId;
	
	@ManyToOne
	@JoinColumn(name  = "flight_travel_id")
	private FlightTravel flightTravel;

}
