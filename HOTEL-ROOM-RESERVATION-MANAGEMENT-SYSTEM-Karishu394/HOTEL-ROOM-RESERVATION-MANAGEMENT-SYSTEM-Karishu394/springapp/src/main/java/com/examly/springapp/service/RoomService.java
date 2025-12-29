package com.examly.springapp.service;

import com.examly.springapp.model.Room;
import java.util.List;

public interface RoomService {

    Room addRoom(Room room);

    List<Room> getAllRooms();

    Room getRoomById(Long id);

    Room updateRoom(Room room);
}
