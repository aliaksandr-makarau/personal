package com.epam.mentoring.module0502.beans;

import java.util.Map;

public class Developer extends Engineer {
    private Map<String, Integer> yearsInFramework;
    private boolean isCoffeeConsumer;

    public Developer() {
        System.out.println("Developer Constructor");
    }

    public Map<String, Integer> getYearsInFramework() {
        return yearsInFramework;
    }

    public void setYearsInFramework(Map<String, Integer> yearsInFramework) {
        this.yearsInFramework = yearsInFramework;
    }

    public boolean isCoffeeConsumer() {
        return isCoffeeConsumer;
    }

    public void setCoffeeConsumer(boolean coffeeConsumer) {
        isCoffeeConsumer = coffeeConsumer;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "yearsInFramework=" + yearsInFramework +
                ", isCoffeeConsumer=" + isCoffeeConsumer +
                "} " + super.toString();
    }

    public void destroyMe() {
        System.out.println("Developer::destroyMe");
    }
}
