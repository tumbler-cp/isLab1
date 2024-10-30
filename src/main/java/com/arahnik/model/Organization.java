package com.arahnik.model;

import com.arahnik.model.properties.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Address officialAddress; //Поле может быть null

    @Min(1)
    private long annualTurnover; //Значение поля должно быть больше 0

    @Column(nullable = false)
    @Min(1)
    private Long employeesCount; //Поле не может быть null, Значение поля должно быть больше 0

    @NotBlank
    @Column(nullable = false, unique = true)
    private String fullName; //Строка не может быть пустой, Значение этого поля должно быть уникальным, Поле не может быть null

    @Min(1)
    private long rating; //Значение поля должно быть больше 0

    public Address getOfficialAddress() {
        return officialAddress;
    }

    public void setOfficialAddress(Address officialAddress) {
        this.officialAddress = officialAddress;
    }

    public long getAnnualTurnover() {
        return annualTurnover;
    }

    public void setAnnualTurnover(long annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    public Long getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(Long employeesCount) {
        this.employeesCount = employeesCount;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
