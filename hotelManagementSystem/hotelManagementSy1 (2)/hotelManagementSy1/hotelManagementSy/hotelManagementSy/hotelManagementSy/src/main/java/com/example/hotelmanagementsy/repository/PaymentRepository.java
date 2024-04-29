package com.example.hotelmanagementsy.repository;

import com.example.hotelmanagementsy.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // You can define custom methods here if needed
}
