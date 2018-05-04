package com.epam.mentoring.module05.springdemo.beans;

public class Developer {

    private String name;
    private String skill;
    private int level;
    private boolean isCoffeeConsumer;

    public Developer(String name, String skill, int level, boolean isCoffeeConsumer) {
        this.name = name;
        this.skill = skill;
        this.level = level;
        this.isCoffeeConsumer = isCoffeeConsumer;
    }

    public Developer() {
        System.out.println("Developer::Developer()");
    }

    public Developer(String name) {
        this.name = name;
    }

    public Developer(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isCoffeeConsumer() {
        return isCoffeeConsumer;
    }

    public void setIsCoffeeConsumer(boolean coffeeConsumer) {
        isCoffeeConsumer = coffeeConsumer;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", level=" + level +
                ", isCoffeeConsumer=" + isCoffeeConsumer +
                '}';
    }
}
