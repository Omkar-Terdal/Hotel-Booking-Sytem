package com.example.hotelmanagementsy.service;

import com.example.hotelmanagementsy.model.LostItem;
import com.example.hotelmanagementsy.repository.LostItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LostAndFoundService {

    private final LostItemRepository lostItemRepository;

    @Autowired
    public LostAndFoundService(LostItemRepository lostItemRepository) {
        this.lostItemRepository = lostItemRepository;
    }

    public void logLostItem(LostItem lostItem) {
        lostItemRepository.save(lostItem);
    }

    public void saveLostItem(LostItem lostItem) {
        lostItemRepository.save(lostItem);
    }
}
