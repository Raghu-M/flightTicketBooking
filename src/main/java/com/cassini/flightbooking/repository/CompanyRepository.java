package com.cassini.flightbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cassini.flightbooking.entity.Company;

@Repository
@Transactional
public interface CompanyRepository extends JpaRepository<Company, Integer>{
	
	
}
