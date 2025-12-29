package com.examly.springapp.service;

import com.examly.springapp.model.Guest;
import java.util.List;

public interface GuestService {

    Guest addGuest(Guest guest);

    List<Guest> getAllGuests();

    Guest getGuestById(Long id);

    Guest updateGuest(Guest guest);
}
