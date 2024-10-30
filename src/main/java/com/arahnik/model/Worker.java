package com.arahnik.model;

import com.arahnik.model.properties.Coordinates;
import com.arahnik.model.properties.Position;
import com.arahnik.model.properties.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Worker {
    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически

    @Column(nullable = false)
    @NotBlank
    private String name; //Поле не может быть null, Строка не может быть пустой

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Coordinates coordinates; //Поле не может быть null

    @Column(nullable = false, updatable = false)
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Organization organization; //Поле не может быть null

    @Min(1)
    private double salary; //Значение поля должно быть больше 0

    @Min(1)
    private int rating; //Значение поля должно быть больше 0

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Position position; //Поле не может быть null

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status; //Поле не может быть null

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Person person; //Поле не может быть null

    @PrePersist
    public void onCreate() {
        creationDate = new java.util.Date();
        creationDate.setTime(LocalDateTime.now().getSecond());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
