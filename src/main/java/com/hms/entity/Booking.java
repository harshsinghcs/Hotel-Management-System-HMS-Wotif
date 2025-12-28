package com.hms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Booking {
    @Id
    @GeneratzedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long roomId;
    private Long customerId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Double totalAmount;
    private String status; // Confirmed, Cancelled

    public Long getRoomId() {
        return null;
    }

    public void setStatus(String cancelled) {
    }


    // Getters and Setters
}

