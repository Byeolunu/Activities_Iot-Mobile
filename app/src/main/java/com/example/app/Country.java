package com.example.app;

public class Country {
    private String name;
    private int flagResource;

    public Country(String name, int flagResource) {
        this.name = name;
        this.flagResource = flagResource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlagResource() {
        return flagResource;
    }

    public void setFlagResource(int flagResource) {
        this.flagResource = flagResource;
    }
}
