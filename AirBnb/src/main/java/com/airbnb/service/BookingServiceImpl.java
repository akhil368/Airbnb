package com.airbnb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbnb.exceptions.AirBnbException;
import com.airbnb.exceptions.NullException;
import com.airbnb.model.Booking;
import com.airbnb.model.Property;
import com.airbnb.repository.BookingRespository;
import com.airbnb.repository.PropertyRepository;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired 
	private PropertyRepository propertyRepo;
	@Autowired
	private BookingRespository bookingRepo;
	@Override
	public Booking addBooking(Booking booking) {
		if(booking==null)
		{
			throw new NullException("Booking Data is null");
			
		}
		return bookingRepo.save(booking);
	}

	@Override
	public List<Booking> bookingList(Long id) {
		List<Booking> booking=bookingRepo.findAll();
		List<Booking> guestBooking = null;
		for(Booking b:booking )
		{
			if(b.getGuest().getId()==id)
			{
				guestBooking.add(b);
			}
		}
		
		if(guestBooking.size()==0)
		{
			throw new AirBnbException("Not Past Booking Found of Guest with id : "+ id);
		}
		
		return guestBooking;
	}

	@Override
	public List<Property> propertList() {
		List<Property> propertyList=propertyRepo.findAll();
		List<Property> list=null;
		for(Property p:propertyList)
		{
			if(p.getBookings().size()>0)
			{
				list.add(p);
			}
		}
		if(list.size()==0)
		{
			throw new NullException("Not Booking Found ");
		}
		return list;
	}

	
}
