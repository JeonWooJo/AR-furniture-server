package com.arfurniture.demo;

import java.sql.Timestamp;
import java.util.Random;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Furniture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private double position;

    @Column
    private double rotation;

    @Column
    private double scale;

    @ManyToOne
    @JoinColumn(name = "home_id")
    private Home home;

    public void setHome(Home home) {
        this.home = home;
    }

    public long getId() {
        return id;
    }

    public double getPosition() {
        return position;
    }

    public double getRotation() {
        return rotation;
    }

    public double getScale() {
        return scale;
    }

    public Furniture() {
    }

    public Furniture(double position, double rotation, double scale, Home home) {
        this.position = position;
        this.rotation = rotation;
        this.scale = scale;
        this.home = home;
    }

}