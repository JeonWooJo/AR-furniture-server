package com.arfurniture.demo;

import java.sql.Timestamp;
import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Home {
    @Id
    private String id;

    public Home() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        int randomInt = new Random().nextInt(90000) + 10000;

        String combinedString = timestamp.toString() + String.valueOf(randomInt);
        id = combinedString;
    }

    // id getter
    public String getId() {
        return id;
    }

}