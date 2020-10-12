package custom.flight_model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightOfferResponse {
    private final String flightNumber;
    private final String departure;
    private final String destination;
    private final String departureTime;
    private final String price;

    @JsonCreator
    public FlightOfferResponse(
        @JsonProperty("flightNumber") String flightNumber,
        @JsonProperty("departure") String departure,
        @JsonProperty("destination") String destination,
        @JsonProperty("departureTime") String departureTime,
        @JsonProperty("price") String price) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
        this.price = price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "FlightOfferResponse{" +
            "flightNumber='" + flightNumber + '\'' +
            ", departure='" + departure + '\'' +
            ", destination='" + destination + '\'' +
            ", departureTime='" + departureTime + '\'' +
            ", price='" + price + '\'' +
            '}';
    }
}
