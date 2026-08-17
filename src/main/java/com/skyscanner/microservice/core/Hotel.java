package com.skyscanner.microservice.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hotel {
    private String city;
    private String name;
    private int stars;
    private double pricePerNight;

    public Hotel() {}

    public Hotel(String city, String name, int stars, double pricePerNight) {
        this.city = city;
        this.name = name;
        this.stars = stars;
        this.pricePerNight = pricePerNight;
    }

    @JsonProperty
    public String getCity() { return city; }

    @JsonProperty
    public String getName() { return name; }

    @JsonProperty
    public int getStars() { return stars; }

    @JsonProperty
    public double getPricePerNight() { return pricePerNight; }

    public void setCity(String city) { this.city = city; }
    public void setName(String name) { this.name = name; }
    public void setStars(int stars) { this.stars = stars; }
    public void setPricePerNight(double pricePerNight) { this.pricePerNight = pricePerNight; }
}
