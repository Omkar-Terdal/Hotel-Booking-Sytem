package com.example.hotelmanagementsy.service;

import com.example.hotelmanagementsy.model.Payment;
import com.example.hotelmanagementsy.model.PaymentStatus;

import java.math.BigDecimal;

public class OnlinePaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment(Payment payment) {
        // Simulate online payment processing
        BigDecimal zero = new BigDecimal(0);
        if (payment.getAmount().compareTo(zero) > 0) {
            // Payment successful
            payment.setPaymentStatus(PaymentStatus.PAID);
            System.out.println("Online payment processed successfully.");
        } else {
            // Payment failed
            payment.setPaymentStatus(PaymentStatus.FAILED);
            System.out.println("Online payment failed. Please try again.");
        }
        // Save payment details or perform any necessary actions
    }
}
