package com.hms.service;

import com.hms.entity.Room;
import com.hms.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAvailableRooms(){
        return roomRepository.findByAvailableTure();
    }
}
