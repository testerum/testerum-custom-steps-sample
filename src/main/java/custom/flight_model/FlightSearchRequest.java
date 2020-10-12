package custom.flight_model;

import java.time.LocalDate;

public class FlightSearchRequest {
    private String departure;
    private String destination;
    private LocalDate bookingDate;

    public FlightSearchRequest(String departure,
                               String destination,
                               LocalDate bookingDate) {
        this.departure = departure;
        this.destination = destination;
        this.bookingDate = bookingDate;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }
}
