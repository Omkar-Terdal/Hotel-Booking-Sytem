package com.example.hotelmanagementsy.model;

public interface BookingService {
    void createBooking(Booking booking);
    void cancelBooking(Booking booking);
    Booking getBookingById(Long bookingId);
}
