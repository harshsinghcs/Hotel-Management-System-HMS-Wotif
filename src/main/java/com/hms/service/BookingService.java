package com.hms.service;

import com.hms.entity.Booking;
import com.hms.entity.Room;
import com.hms.repository.BookingRepository;
import com.hms.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RoomRepository roomRepository;

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
