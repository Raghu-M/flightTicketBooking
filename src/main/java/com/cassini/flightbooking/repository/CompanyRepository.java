package com.cassini.flightbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cassini.flightbooking.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{

}
