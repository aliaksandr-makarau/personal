package com.epam.mentoring.module0502.beans;

public class AutomationTester extends Engineer {
    private String favoriteFramework;
    private boolean isBro;

    public AutomationTester() {
        System.out.println("AutomationTester Constructor");
    }

    public String getFavoriteFramework() {
        return favoriteFramework;
    }

    public void setFavoriteFramework(String favoriteFramework) {
        this.favoriteFramework = favoriteFramework;
    }

    public boolean getIsBro() {
        return isBro;
    }

    public void setIsBro(boolean bro) {
        isBro = bro;
    }

    @Override
    public String toString() {
        return "AutomationTester{" +
                "favoriteFramework='" + favoriteFramework + '\'' +
                ", isBro=" + isBro +
                "} " + super.toString();
    }
}
