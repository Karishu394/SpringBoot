package com.examly.springapp.service;

import com.examly.springapp.model.Guest;
import com.examly.springapp.repository.GuestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepo guestRepo;

    @Override
    public Guest addGuest(Guest guest) {
        return guestRepo.save(guest);
    }

    @Override
    public List<Guest> getAllGuests() {
        return guestRepo.findAll();
    }

    @Override
    public Guest getGuestById(Long id) {
        return guestRepo.findById(id).orElse(null);
    }

    @Override
    public Guest updateGuest(Guest guest) {
        return guestRepo.save(guest);
    }

    public List<Guest> getGuestsByPhone(String phone) {
        return guestRepo.findByPhone(phone);
    }

    public List<Guest> getGuestsByEmail(String email) {
        return guestRepo.findByEmail(email);
    }
}