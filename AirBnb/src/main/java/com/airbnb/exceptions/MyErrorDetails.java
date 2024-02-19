package com.airbnb.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyErrorDetails {

	private String message;
	
	private String description;
	
	private LocalDateTime date;
	
}
