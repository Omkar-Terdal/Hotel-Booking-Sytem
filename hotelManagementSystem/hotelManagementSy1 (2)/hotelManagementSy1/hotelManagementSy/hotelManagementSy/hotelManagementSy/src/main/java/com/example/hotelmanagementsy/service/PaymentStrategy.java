package com.example.hotelmanagementsy.service;

import com.example.hotelmanagementsy.model.Payment;

public interface PaymentStrategy {
    void processPayment(Payment payment);
}
