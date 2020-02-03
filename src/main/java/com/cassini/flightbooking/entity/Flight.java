package com.cassini.flightbooking.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Flight {
	
	@Id
	private Integer flightId;
	private String flightName;
	private Integer totalEconomySeats;
	private Integer totalBusinessSeats;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

}
