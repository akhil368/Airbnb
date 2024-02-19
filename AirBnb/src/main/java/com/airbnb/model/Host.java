package com.airbnb.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
public class Host {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private boolean active;
	
	private String location;
	
	@Enumerated(EnumType.STRING)
	private PropertyType propertyType;
	
	@Column(length=1000)
	private String about;
	
	private LocalDate date;
	
	@OneToMany(mappedBy="host")
	private List<Property> properties;

	public Host(String name, boolean isActive, String location, PropertyType propertyType, String about, LocalDate  date,
			List<Property> properties) {
		super();
		this.name = name;
		this.active = isActive;
		this.location = location;
		this.propertyType = propertyType;
		this.about = about;
		this.date = date;
		this.properties = properties;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	
	
	
	
	
}
