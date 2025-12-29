package com.examly.springapp.service;

import com.examly.springapp.model.Room;
import com.examly.springapp.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepo roomRepo;

    @Override
    public Room addRoom(Room room) {
        return roomRepo.save(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    @Override
    public Room getRoomById(Long id) {
        return roomRepo.findById(id).orElse(null);
    }

    @Override
    public Room updateRoom(Room room) {
        return roomRepo.save(room);
    }

    public List<Room> getRoomsByCategoryName(String categoryName) {
        return roomRepo.findByRoomCategoryCategoryName(categoryName);
    }

    public List<Room> getRoomsByNumber(String roomNumber) {
        return roomRepo.findByRoomNumber(roomNumber);
    }
}