package com.airbnb.model;

import java.time.LocalDate;
import java.time.LocalDateTime;


import javax.print.attribute.standard.DateTimeAtCompleted;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Booking {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   
    private LocalDate startDate;

    
    private LocalDate endDate;

    @ManyToOne
//    @JsonIgnore
    @JoinColumn(name="property_id")
    private Property property;

    @ManyToOne
//    @JsonIgnore
    @JoinColumn(name="guest_id")
    private Guest guest;


	public Booking(LocalDate startDate, LocalDate endDate, Property property, Guest guest) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.property = property;
		this.guest = guest;
	}

	
	
	
}
