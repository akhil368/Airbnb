package com.airbnb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbnb.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
