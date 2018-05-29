package com.epam.mentoring.module12.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "shift")
public class Shift {

    @Id
    private int id;

    @Column(name = "cab_id")
    private int cabId;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driverId;

    @Column(name = "company_id")
    private int companyId;

    @Column(name = "date")
    private Date date;

    public Shift() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCabId() {
        return cabId;
    }

    public void setCabId(int cabId) {
        this.cabId = cabId;
    }

    public Driver getDriverId() {
        return driverId;
    }

    public void setDriverId(Driver driverId) {
        this.driverId = driverId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
