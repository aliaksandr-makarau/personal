package com.epam.mentoring.module0502.beans;

import java.util.Set;

public class Manager {
    private String name;
    private int emailPerHour;
    private Set<Engineer> engineers;

    public Manager() {
        System.out.println("Manager Constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmailPerHour() {
        return emailPerHour;
    }

    public void setEmailPerHour(int emailPerHour) {
        this.emailPerHour = emailPerHour;
    }

    public Set<Engineer> getEngineers() {
        return engineers;
    }

    public void setEngineers(Set<Engineer> engineers) {
        this.engineers = engineers;
    }

    public void setLevel(String level) {
        System.out.println("Fake method");
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", emailPerHour=" + emailPerHour +
                ", engineers=" + engineers +
                '}';
    }
}
