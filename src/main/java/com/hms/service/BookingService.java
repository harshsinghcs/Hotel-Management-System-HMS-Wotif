package com.hms.service;

import com.hms.entity.Booking;
import com.hms.entity.Room;
import com.hms.repository.bookingRepository;
import com.hms.repository.roomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookingService {
    @Autowired
    private com.hms.repository.bookingRepository bookingRepository;
    @Autowired
    private com.hms.repository.roomRepository roomRepository;

    public Booking createBooking(Booking booking){
        Room room = roomRepository.findById(booking.getRoomId()).orElseThrow(()-> new RuntimeException("Room not found"));
        if(!room.getAvailable()){
            throw new RuntimeException("Room is not available");
        }
        room.setAvailable(false);
        roomRepository.save(room);
        return bookingRepository.save(booking);
    }
}
