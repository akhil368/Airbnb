package com.airbnb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbnb.exceptions.NotFoundException;
import com.airbnb.exceptions.NullException;
import com.airbnb.model.Host;
import com.airbnb.repository.HostRepositroy;

@Service
public class HostServiceImpl implements HostService{

	@Autowired
	private HostRepositroy hostRepo;
	@Override
	public Host addHost(Host sot) {
		if(sot==null)
		{
			throw new NullException("Data Entered is Null");
		}
		return hostRepo.save(sot);
	}

	@Override
	public List<Host> hostList() {
		List<Host> list =hostRepo.findAll();
		if(list.size()==0)
		 throw new NotFoundException("Host List is Emty");
		return list;
	}

	@Override
	public Host hostById(Long id) {
		Optional<Host>  optHost=hostRepo.findById(id);
		if(optHost.isPresent())
		{
			Host host=optHost.get();
			return host;
		}
		throw new NotFoundException("No Host Found with given Id");
	}

	@Override
	public Host updateHost(Host host) {
		Optional<Host>  optHost=hostRepo.findById(host.getId());
		if(optHost.isPresent())
		{
			hostRepo.save(host);
			
			return host;
		}
		throw new NotFoundException("No Host Found to update");
		}

	@Override
	public Host deleteHost(Long id) {
		Optional<Host>  optHost=hostRepo.findById(id);
		if(!optHost.isPresent())
		{
			throw new NotFoundException("No Host Found to Delete");
		}
		Host host=optHost.get();
		hostRepo.delete(host);
		return host;
	}

}
