package com.example.hotelmanagementsy.repository;

import com.example.hotelmanagementsy.model.LostItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LostItemRepository extends JpaRepository<LostItem, Long> {
}
