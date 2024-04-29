package com.example.hotelmanagementsy.service;

import com.example.hotelmanagementsy.model.Payment;
import com.example.hotelmanagementsy.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    private PaymentStrategy paymentStrategy;
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(Payment payment) {
        paymentStrategy.processPayment(payment);
    }

    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    // Method to retrieve all payment statuses
    public List<String> getAllPaymentStatus() {
        List<Payment> payments = paymentRepository.findAll();
        return payments.stream()
                .map(payment -> payment.getPaymentStatus().toString()) // Convert enum to string
                .collect(Collectors.toList());
    }
}