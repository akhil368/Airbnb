package com.airbnb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.airbnb.model.Host;
import com.airbnb.service.HostService;

@RestController
public class HostController {

	@Autowired
	private HostService hostService;
	
	@PostMapping("/hosts")
	public ResponseEntity<Host> addHost(@RequestBody Host host)
	{
		return new ResponseEntity<Host>(hostService.addHost(host),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/hosts/{id}")
	public ResponseEntity<Host> deleteHost(@PathVariable Long id)
	{
		return new ResponseEntity<Host>(hostService.deleteHost(id),HttpStatus.OK);
	}
	@GetMapping("/hosts")
	public ResponseEntity<List<Host>> getAllHosts()
	{
		return new ResponseEntity<List<Host>>(hostService.hostList(),HttpStatus.OK);
	}
	@GetMapping("/hosts/{id}")
	public ResponseEntity<Host> getById(@PathVariable Long id)
	{
		return new ResponseEntity<Host>(hostService.hostById(id),HttpStatus.OK);
	}
	@PutMapping("/hosts")
	public ResponseEntity<Host> updateHost(@RequestBody Host host)
	{
		return new ResponseEntity<Host>(hostService.updateHost(host),HttpStatus.OK);
	}
	
	
}
