package com.airbnb.service;

import java.util.List;

import com.airbnb.model.Guest;


public interface GuestService {

public Guest addGuest(Guest guest) ;
	
	public List<Guest> guestList();
	
	public Guest guestById(Long id);
	
	public  Guest updateguest(Guest guest);
	
	public Guest deleteGuest(Long id);
	
	
}
