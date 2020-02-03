package com.cassini.flightbooking.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Location {
	
	@Id
	private Integer locationId;
	private String locationName;

}
