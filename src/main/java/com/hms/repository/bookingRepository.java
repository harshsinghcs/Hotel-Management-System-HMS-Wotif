package com.hms.repository;

import com.hms.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface bookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByCustomerId(Long CustomerId);
}