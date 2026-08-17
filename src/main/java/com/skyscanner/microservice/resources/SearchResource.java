package com.skyscanner.microservice.resources;

import com.skyscanner.microservice.api.SearchResponse;
import com.skyscanner.microservice.core.DataLoader;
import com.skyscanner.microservice.core.Hotel;
import com.skyscanner.microservice.core.RentalCar;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
public class SearchResource {

    private final List<Hotel> allHotels;
    private final List<RentalCar> allRentalCars;

    public SearchResource() {
        this.allHotels = DataLoader.loadHotels("/data/hotels.csv");
        this.allRentalCars = DataLoader.loadRentalCars("/data/rental_cars.csv");
    }

    @GET
    public Response search(@QueryParam("city") String city) {
        if (city == null || city.isBlank()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\":\"city query parameter is required\"}")
                    .build();
        }

        String normalizedCity = city.trim().toLowerCase();

        List<Hotel> matchedHotels = allHotels.stream()
                .filter(h -> h.getCity().toLowerCase().equals(normalizedCity))
                .collect(Collectors.toList());

        List<RentalCar> matchedCars = allRentalCars.stream()
                .filter(c -> c.getCity().toLowerCase().equals(normalizedCity))
                .collect(Collectors.toList());

        return Response.ok(new SearchResponse(matchedHotels, matchedCars)).build();
    }
}
