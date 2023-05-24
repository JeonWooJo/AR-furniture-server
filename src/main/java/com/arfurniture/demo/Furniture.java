package com.arfurniture.demo;

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
    private int m_FileID;

    @Column
    private int m_PathID;

    @Column
    private String name;

    @Column
    private double positionX;

    @Column
    private double positionY;

    @Column
    private double positionZ;

    @Column
    private double scaleX;

    @Column
    private double scaleY;

    @Column
    private double scaleZ;

    @Column
    private double rotationX;

    @Column
    private double rotationY;

    @Column
    private double rotationZ;

    @Column
    private double rotationW;

    @ManyToOne
    @JoinColumn(name = "home_id")
    private Home home;

    public void setHome(Home home) {
        this.home = home;
    }

    public long getId() {
        return id;
    }

    public int getM_FileID() {
        return m_FileID;
    }

    public int getM_PathID() {
        return m_PathID;
    }

    public String getName() {
        return name;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public double getPositionZ() {
        return positionZ;
    }

    public double getScaleX() {
        return scaleX;
    }

    public double getScaleY() {
        return scaleY;
    }

    public double getScaleZ() {
        return scaleZ;
    }

    public double getRotationX() {
        return rotationX;
    }

    public double getRotationY() {
        return rotationY;
    }

    public double getRotationZ() {
        return rotationZ;
    }

    public double getRotationW() {
        return rotationW;
    }

    public Furniture() {
    }

    public Furniture(int m_FileID, int m_PathID, String name, double positionX, double positionY, double positionZ, double scaleX, double scaleY, double scaleZ, double rotationX, double rotationY, double rotationZ, double rotationW, Home home)
    {
        this.m_FileID = m_FileID;
        this.m_PathID = m_PathID;
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
        this.positionZ = positionZ;
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.scaleZ = scaleZ;
        this.rotationX = rotationX;
        this.rotationY = rotationY;
        this.rotationZ = rotationZ;
        this.rotationW = rotationW;
        this.home = home;
    }
}