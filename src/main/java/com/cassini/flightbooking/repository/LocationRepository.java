package com.cassini.flightbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cassini.flightbooking.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{

}