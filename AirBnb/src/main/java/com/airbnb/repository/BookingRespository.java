
package com.airbnb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbnb.model.Booking;

public interface BookingRespository extends JpaRepository<Booking, Long> {

}
