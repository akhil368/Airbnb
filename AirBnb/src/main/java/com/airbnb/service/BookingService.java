package com.airbnb.service;

import java.util.List;

import com.airbnb.model.Booking;
import com.airbnb.model.Property;

public interface BookingService {

	public Booking addBooking(Booking booking);
	
	public List<Booking> bookingList(Long id);
	
	public List<Property> propertList();
}
