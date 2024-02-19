package com.airbnb.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Guest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String gender;
	
	private LocalDate dateOfBirth;
	
	
	private String bio;
	
	@OneToMany(mappedBy = "guest")
	private List<Booking> bookings;

	public Guest(String name, String gender, LocalDate  dateOfBirth, String bio, List<Booking> bookings) {
		super();
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.bio = bio;
		this.bookings = bookings;
	}
	
	
}
