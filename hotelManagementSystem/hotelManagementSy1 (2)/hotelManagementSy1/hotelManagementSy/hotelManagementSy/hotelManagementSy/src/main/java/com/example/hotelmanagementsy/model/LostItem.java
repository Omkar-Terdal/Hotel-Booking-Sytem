package com.example.hotelmanagementsy.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lostfound")
public class LostItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;


    // Constructors
    public LostItem() {
    }

    public LostItem(String description, String location, Date dateLost, String claimedBy) {
        this.description = description;
        this.location = location;

    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    // toString() method for debugging
    @Override
    public String toString() {
        return "LostAndFoundItem{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +

                '}';
    }
}
