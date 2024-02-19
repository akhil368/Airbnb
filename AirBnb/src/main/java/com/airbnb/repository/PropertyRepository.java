package com.airbnb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbnb.model.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {

	
}
