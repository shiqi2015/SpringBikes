package com.SpingMVC.Bikes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpingMVC.Bikes.models.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long> {
	
	
}
