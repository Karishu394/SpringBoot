package com.examly.springapp.controller;

import com.examly.springapp.model.Room;
import com.examly.springapp.service.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomServiceImpl roomService;

    @PostMapping
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
        Room saved = roomService.addRoom(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable Long id) {
        Room room = roomService.getRoomById(id);
        if (room == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(room);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody Room room) {
        room.setRoomId(id.intValue());
        Room updated = roomService.updateRoom(room);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<Room>> getRoomsByCategoryName(@PathVariable String categoryName) {
        List<Room> rooms = roomService.getRoomsByCategoryName(categoryName);
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/number/{roomNumber}")
    public ResponseEntity<?> getRoomByNumber(@PathVariable String roomNumber) {
        List<Room> rooms = roomService.getRoomsByNumber(roomNumber);
        if (rooms.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No room found with number: " + roomNumber);
        }
        return ResponseEntity.ok(rooms);
    }
}
