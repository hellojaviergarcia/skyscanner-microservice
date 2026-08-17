# Hoen Archipelago Microservice

A Dropwizard microservice for searching hotels and rental cars in the Hoen Archipelago.

## Build

```bash
mvn package
```

## Run

```bash
java -jar target/skyscanner-microservice-1.0-SNAPSHOT.jar server config.yml
```

## API

### Search by city

```
GET /search?city={city}
```

**Response:**

```json
{
  "hotels": [
    {
      "city": "Aeloria",
      "name": "The Grand Aeloria",
      "stars": 5,
      "pricePerNight": 320.0
    }
  ],
  "rentalCars": [
    {
      "city": "Aeloria",
      "company": "Hoen Wheels",
      "carType": "Economy",
      "pricePerDay": 35.0
    }
  ]
}
```

**Example:**

```bash
curl "http://localhost:8080/search?city=Aeloria"
```

## Data

Add hotels to `src/main/resources/data/hotels.csv`:
```
city,name,stars,pricePerNight
```

Add rental cars to `src/main/resources/data/rental_cars.csv`:
```
city,company,carType,pricePerDay
```
