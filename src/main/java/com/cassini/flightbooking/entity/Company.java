package com.cassini.flightbooking.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Company {
	
	@Id
	private Integer companyId;
	private String companyName;

}
