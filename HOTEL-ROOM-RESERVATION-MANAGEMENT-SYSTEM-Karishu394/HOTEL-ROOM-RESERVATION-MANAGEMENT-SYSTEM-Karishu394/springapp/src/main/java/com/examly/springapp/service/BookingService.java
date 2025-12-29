package com.examly.springapp.service;

import com.examly.springapp.model.Booking;
import java.util.List;

public interface BookingService {

    Booking addBooking(Booking booking);

    List<Booking> getAllBookings();

    Booking getBookingById(Long id);

    Booking updateBooking(Booking booking);
}
