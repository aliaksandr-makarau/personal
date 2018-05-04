package com.epam.mentoring.module0502.beans;

public class Engineer {
    private String name;
    private String skill;
    private String level;

    public Engineer() {
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
