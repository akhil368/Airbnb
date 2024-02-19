package com.airbnb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airbnb.model.Booking;
import com.airbnb.model.Property;
import com.airbnb.service.BookingService;

@RestController

public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/bookings")
	public ResponseEntity<List<Booking>> getAllBooking(@PathVariable Long id)
	{
		return new ResponseEntity<List<Booking>>(bookingService.bookingList(id),HttpStatus.OK);
	}
	
	@GetMapping("/propertyBookings")
	public ResponseEntity<List<Property>> getAllBookingofProperty()
	{
		return new ResponseEntity<List<Property>>(bookingService.propertList(),HttpStatus.OK);
	}
	
	@PostMapping("/bookings")
	public ResponseEntity<Booking> makeBooking(@RequestBody Booking B)
	{
		return new ResponseEntity<Booking>(bookingService.addBooking(B),HttpStatus.OK);
	}
}
