package com.cassini.flightbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cassini.flightbooking.entity.Company;
import com.cassini.flightbooking.service.CompanyService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
@RequestMapping("/companies")
@Slf4j
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	@GetMapping
	public ResponseEntity<List<Company>> getCompanies()
	{
		log.info("Calling getAllCompanies() method from CompanyController");
	    return ResponseEntity.ok().body( companyService.getAllCompanies());
 	
	}

}
