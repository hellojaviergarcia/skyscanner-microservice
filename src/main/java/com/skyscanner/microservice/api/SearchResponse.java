package com.skyscanner.microservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skyscanner.microservice.core.Hotel;
import com.skyscanner.microservice.core.RentalCar;

import java.util.List;

public class SearchResponse {
    private List<Hotel> hotels;
    private List<RentalCar> rentalCars;

    public SearchResponse(List<Hotel> hotels, List<RentalCar> rentalCars) {
        this.hotels = hotels;
        this.rentalCars = rentalCars;
    }

    @JsonProperty
    public List<Hotel> getHotels() { return hotels; }

    @JsonProperty
    public List<RentalCar> getRentalCars() { return rentalCars; }
}
