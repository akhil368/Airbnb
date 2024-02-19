package com.airbnb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.airbnb.model.Guest;
import com.airbnb.service.GuestService;

@RestController
public class GuestController {

	@Autowired
	private GuestService guestService;
	
	@PostMapping("/guests")
	public ResponseEntity<Guest> addGuest(@RequestBody Guest guest)
	{
		return new ResponseEntity<Guest>(guestService.addGuest(guest),HttpStatus.CREATED);
	}
	
	@GetMapping("/guests")
	public ResponseEntity<List<Guest>> getAllGuests()
	{
		return new ResponseEntity<List<Guest>>(guestService.guestList(),HttpStatus.OK);
	}
	
	@DeleteMapping("/guests/{id}")
	public ResponseEntity<Guest> deleteGuest(@PathVariable Long id)
	{
		return new ResponseEntity<Guest>(guestService.deleteGuest(id),HttpStatus.OK);
	}
	@GetMapping("/guests/{id}")
	public ResponseEntity<Guest> findGuestById(@PathVariable Long id)
	{
		return new ResponseEntity<Guest>(guestService.guestById(id),HttpStatus.OK);
	}
	@PutMapping("/guests")
	public ResponseEntity<Guest> updateGuest(@RequestBody Guest guest)
	{
		return new ResponseEntity<Guest>(guestService.updateguest(guest),HttpStatus.CREATED);
	}
}
