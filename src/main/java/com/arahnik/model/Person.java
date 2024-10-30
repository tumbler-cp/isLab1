package com.arahnik.model;

import com.arahnik.model.properties.Color;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Color eyeColor; //Поле может быть null

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Color hairColor; //Поле может быть null

    @ManyToOne(optional = false)
    private Location location; //Поле может быть null

    @Min(1)
    private double height; //Значение поля должно быть больше 0

    @Min(1)
    private int weight; //Значение поля должно быть больше 0

    @Column(nullable = false)
    private String passportID; //Поле не может быть null

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }
}
