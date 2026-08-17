package com.skyscanner.microservice.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RentalCar {
    private String city;
    private String company;
    private String carType;
    private double pricePerDay;

    public RentalCar() {}

    public RentalCar(String city, String company, String carType, double pricePerDay) {
        this.city = city;
        this.company = company;
        this.carType = carType;
        this.pricePerDay = pricePerDay;
    }

    @JsonProperty
    public String getCity() { return city; }

    @JsonProperty
    public String getCompany() { return company; }

    @JsonProperty
    public String getCarType() { return carType; }

    @JsonProperty
    public double getPricePerDay() { return pricePerDay; }

    public void setCity(String city) { this.city = city; }
    public void setCompany(String company) { this.company = company; }
    public void setCarType(String carType) { this.carType = carType; }
    public void setPricePerDay(double pricePerDay) { this.pricePerDay = pricePerDay; }
}
