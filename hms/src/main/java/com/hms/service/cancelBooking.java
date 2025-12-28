package com.hms.service;

import com.hms.entity.Booking;
import com.hms.entity.Room;
import com.hms.repository.BookingRepository;
import com.hms.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class cancelBooking {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;

    public void cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found" + bookingId));
        Room room = roomRepository.findById(booking.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found" + booking.getRoomId()));

        room.setAvailable(true);
        roomRepository.save(room);

        booking.setStatus("Cancelled");
        bookingRepository.save(booking);
    }
}