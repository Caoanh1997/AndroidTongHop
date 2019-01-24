package com.example.caoan.androidtonghop;

public class Country {
    private String name;
    private int flagImage;

    public Country(String name, int flagImage) {
        this.name = name;
        this.flagImage = flagImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlagImage() {
        return flagImage;
    }

    public void setFlagImage(int flagImage) {
        this.flagImage = flagImage;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", flagImage=" + flagImage +
                '}';
    }
}
