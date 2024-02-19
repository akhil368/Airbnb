
package com.airbnb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbnb.exceptions.NotFoundException;
import com.airbnb.exceptions.NullException;
import com.airbnb.model.Guest;
import com.airbnb.repository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService {

	@Autowired
	private GuestRepository guestRepo;
	@Override
	public Guest addGuest(Guest guest) {
		// TODO Auto-generated method stub
		if(guest==null)
		{
			throw new NullException("Guest is Null");
		}
		return guestRepo.save(guest);
	}

	@Override
	public List<Guest> guestList() {
		List<Guest> list=guestRepo.findAll();
		if(list.size()==0)
		{
			throw new NotFoundException("List is Empty");
		}
		return list;
	}

	@Override
	public Guest guestById(Long id) {
		Optional<Guest> optGuest=	guestRepo.findById(id);
		if(optGuest.isPresent())
		{
			return optGuest.get();
		}
		throw new NotFoundException("No Guest is found wwith give Id : " + id);
	}

	@Override
	public Guest updateguest(Guest guest) {
		
		Optional<Guest> optGuest=	guestRepo.findById(guest.getId());
		if(optGuest.isPresent())
		{
			
			return guestRepo.save(guest);
		}
		throw new NotFoundException("No Guest is find to update");
	}

	@Override
	public Guest deleteGuest(Long id) {
		Optional<Guest> optGuest=	guestRepo.findById(id);
		if(optGuest.isPresent())
		{
			Guest guest=optGuest.get();
			guestRepo.delete(guest);
		}
		throw new NotFoundException("No Guest found with give Id :" + id);
	}

}
