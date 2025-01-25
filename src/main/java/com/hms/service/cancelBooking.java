package com.hms.service;

import com.hms.entity.Booking;
import com.hms.entity.Room;
import com.hms.repository.bookingRepository;
import com.hms.repository.roomRepository;
import lombok.Builder;

public void cancelBooking(Long bookingId){
    Booking booking = bookingRepository.findById(bookingId)
            .orElseThrow(()-> new RuntimeException("Booking not found"));
    Room room = roomRepository.findById(booking.getRoomId())
            .orElseThrow(()-> new RuntimeException("Room not found"));

    room.setAvailable(true);
    roomRepository.save(room);
    booking.setStatus("Cancelled");
    bookingRepository.save(booking);
}