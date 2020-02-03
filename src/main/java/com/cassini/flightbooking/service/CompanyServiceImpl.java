package com.cassini.flightbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cassini.flightbooking.controller.CompanyController;
import com.cassini.flightbooking.entity.Company;
import com.cassini.flightbooking.repository.CompanyRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	@Override
	public List<Company> getAllCompanies() {
		
		log.info("Fetching All Company records from companyRepository");
		return companyRepository.findAll();
	}

}
