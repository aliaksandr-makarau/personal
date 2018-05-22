package com.epam.mentoring.module0902.beans;

import java.util.Date;

public class Cab {

    private Date manufactureYear;
    private String carMake;
    private String licencePlate;
    private boolean hasBabyChair;

    public Cab(Date manufactureYear, String carMake, String licencePlate, boolean hasBabyChair) {
        this.manufactureYear = manufactureYear;
        this.carMake = carMake;
        this.licencePlate = licencePlate;
        this.hasBabyChair = hasBabyChair;
    }

    public Cab() {
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

    public boolean isHasBabyChair() {
        return hasBabyChair;
    }

    public void setHasBabyChair(boolean hasBabyChair) {
        this.hasBabyChair = hasBabyChair;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "manufactureYear=" + manufactureYear +
                ", carMake='" + carMake + '\'' +
                ", licencePlate='" + licencePlate + '\'' +
                ", hasBabyChair=" + hasBabyChair +
                '}';
    }
}
