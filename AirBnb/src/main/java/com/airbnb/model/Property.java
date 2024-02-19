package com.airbnb.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="host_id")
	private Host host;
	
	@OneToMany(mappedBy="property")
	private List<Booking> bookings;

	public Property(String name, Host host, List<Booking> bookings) {
		super();
		this.name = name;
		this.host = host;
		this.bookings = bookings;
	}
	
	
}
