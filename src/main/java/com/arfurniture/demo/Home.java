package com.arfurniture.demo;

import java.sql.Timestamp;
import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Home {
    @Id
    @Column(name="home_id")
    private String id;

    public Home() {
        // Get current timestamp
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        // Get random integer between 10000 and 99999
        int randomInt = new Random().nextInt(90000) + 10000;

        // Combine timestamp and random number as string
        String combinedString = timestamp.toString() + String.valueOf(randomInt);
        id = combinedString;
    }

    //set id
    public void setId(String id) {
        this.id = id;
    }

    //get id
    public String getId() {
        return id;
    }
}