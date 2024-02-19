package com.airbnb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbnb.model.Host;
import com.airbnb.model.PropertyType;

public interface HostRepositroy extends JpaRepository<Host, Long> {

	public List<Host> findByLocation(String location);
	public List<Host> findByPropertyType(PropertyType propertyType);

}

