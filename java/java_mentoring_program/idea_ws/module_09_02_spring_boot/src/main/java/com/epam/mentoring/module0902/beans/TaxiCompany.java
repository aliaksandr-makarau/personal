package com.epam.mentoring.module0902.beans;

import javax.persistence.*;

@Entity
@Table(name = "taxi_company")
public class TaxiCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private Integer rate;

    public TaxiCompany() {
    }

    public TaxiCompany(Long id, String name, String address, Integer rate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Integer getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "TaxiCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rate=" + rate +
                '}';
    }
}
