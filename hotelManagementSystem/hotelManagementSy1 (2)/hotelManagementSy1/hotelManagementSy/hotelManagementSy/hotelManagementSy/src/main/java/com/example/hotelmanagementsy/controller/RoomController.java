package com.example.hotelmanagementsy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.hotelmanagementsy.model.Room;
import com.example.hotelmanagementsy.repository.RoomRepository;

@Controller
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @PostMapping("/add-room")
    public String addRoom(@RequestParam String roomId, @RequestParam String roomType) {
        Room room = new Room();
        room.setRoomId(roomId);
        roomRepository.save(room);
        return "redirect:/dashboard";
    }
}
