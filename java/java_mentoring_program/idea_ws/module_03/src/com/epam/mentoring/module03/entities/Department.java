package com.epam.mentoring.module03.entities;

public class Department {

    private String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{\'name\'=" + name + "}";
    }
}
