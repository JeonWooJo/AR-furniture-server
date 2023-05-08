package com.arfurniture.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Furniture {
    @Id
    private String id;

    // @ManyToOne
    // @JoinColumn(name = "home_id")
    // private String homeId;

    @Column
    private double position;

    @Column
    private double rotation;

    @Column
    private double scale;

    //getter
    public String getId() {
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


    //setter
    public void setId(String id) {
        this.id = id;
    }

    public void setPosition(double position) {
        this.position = position;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

}
