package com.airbnb.service;

import java.util.List;



import org.springframework.stereotype.Service;

import com.airbnb.model.Host;


@Service
public interface HostService {

	public Host addHost(Host sot) ;
	
	public List<Host> hostList();
	
	public Host hostById(Long id);
	
	public Host updateHost(Host host);
	
	public Host deleteHost(Long id);
	
}
