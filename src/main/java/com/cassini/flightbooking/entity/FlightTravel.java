package com.cassini.flightbooking.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FlightTravel {
	
	@Id
	private Integer flightTravelId;
	
	@ManyToOne
	@JoinColumn(name = "flight_id")
	private Flight flight;
	
	@ManyToOne
	@JoinColumn(name = "from_location")
	private Location fromLocation;
	
	@ManyToOne
	@JoinColumn(name = "to_location")
	private Location toLocation;
	
	private Double economyPrice;
	
	private Double businessPrice;
	
	private Integer economySeatAvailable;
	
	private Integer businessSeatAvailable;
	
	private LocalDate date;
	
	private LocalTime departureTime;
	
	private LocalTime arrivalTime;

}
