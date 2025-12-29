package com.examly.springapp.controller;

import com.examly.springapp.model.Guest;
import com.examly.springapp.service.GuestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestController {

    @Autowired
    private GuestServiceImpl guestService;

    @PostMapping
    public ResponseEntity<Guest> addGuest(@RequestBody Guest guest) {
        Guest saved = guestService.addGuest(guest);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Guest>> getAllGuests() {
        List<Guest> guests = guestService.getAllGuests();
        return ResponseEntity.ok(guests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable Long id) {
        Guest guest = guestService.getGuestById(id);
        if (guest == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(guest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable Long id, @RequestBody Guest guest) {
        guest.setGuestId(id.intValue());
        Guest updated = guestService.updateGuest(guest);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<?> getGuestByPhone(@PathVariable String phone) {
        List<Guest> guests = guestService.getGuestsByPhone(phone);
        if (guests.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("No guest found with phone: " + phone);
        }
        return ResponseEntity.ok(guests);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<Guest>> getGuestByEmail(@PathVariable String email) {
        List<Guest> guests = guestService.getGuestsByEmail(email);
        return ResponseEntity.ok(guests);
    }
}

