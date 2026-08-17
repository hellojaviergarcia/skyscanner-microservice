package com.skyscanner.microservice.core;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DataLoader {

    private static final Logger logger = Logger.getLogger(DataLoader.class.getName());

    public static List<Hotel> loadHotels(String resourcePath) {
        List<Hotel> hotels = new ArrayList<>();
        try (InputStream is = DataLoader.class.getResourceAsStream(resourcePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) { firstLine = false; continue; } // skip header
                String[] parts = line.split(",");
                if (parts.length < 4) continue;
                String city = parts[0].trim();
                String name = parts[1].trim();
                int stars = Integer.parseInt(parts[2].trim());
                double price = Double.parseDouble(parts[3].trim());
                hotels.add(new Hotel(city, name, stars, price));
            }
        } catch (Exception e) {
            logger.warning("Failed to load hotels from " + resourcePath + ": " + e.getMessage());
        }
        return hotels;
    }

    public static List<RentalCar> loadRentalCars(String resourcePath) {
        List<RentalCar> cars = new ArrayList<>();
        try (InputStream is = DataLoader.class.getResourceAsStream(resourcePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) { firstLine = false; continue; } // skip header
                String[] parts = line.split(",");
                if (parts.length < 4) continue;
                String city = parts[0].trim();
                String company = parts[1].trim();
                String carType = parts[2].trim();
                double price = Double.parseDouble(parts[3].trim());
                cars.add(new RentalCar(city, company, carType, price));
            }
        } catch (Exception e) {
            logger.warning("Failed to load rental cars from " + resourcePath + ": " + e.getMessage());
        }
        return cars;
    }
}
