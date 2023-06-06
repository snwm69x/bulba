package com.sneg.likevavo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sneg.likevavo.entities.Booking;


public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);  
}
