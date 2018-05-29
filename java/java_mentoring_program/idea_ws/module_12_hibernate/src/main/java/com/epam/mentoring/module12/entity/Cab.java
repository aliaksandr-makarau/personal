package com.epam.mentoring.module12.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "cab")
public class Cab {
    @Id
    private int id;
    @Column(name = "manufacture_year")
    private Date manufactureYear;
    @Column(name = "car_make")
    private String carMake;
    @Column(name = "licence_plate")
    private String licencePlate;
    @Column(name = "capacity")
    private int capacity;
    @Column(name = "has_baby_chair")
    private int hasBabyChair;

    public Cab() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(Date manufactureYear) {
        this.manufactureYear = manufactureYear;
    }


    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }


    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public int getHasBabyChair() {
        return hasBabyChair;
    }

    public void setHasBabyChair(int hasBabyChair) {
        this.hasBabyChair = hasBabyChair;
    }
}
