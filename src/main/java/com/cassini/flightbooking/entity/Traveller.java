package com.cassini.flightbooking.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Traveller {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer travellerId;
	private String travellerName;
	private String email;
	private LocalDate dateOfBirth;
	private Long phoneNumber;
	
	@ManyToOne
	@JoinColumn(name = "booking_id")
	private Booking booking;

}
