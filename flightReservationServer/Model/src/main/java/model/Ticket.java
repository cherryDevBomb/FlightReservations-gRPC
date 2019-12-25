package model;

import java.util.Objects;

public class Ticket {

    private int id;
    private int clientId;
    private int flightId;
    private String touristFirstName;
    private String touristLastName;

    public Ticket(int id, int clientId, int flightId, String touristFirstName, String touristLastName) {
        this.id = id;
        this.clientId = clientId;
        this.flightId = flightId;
        this.touristFirstName = touristFirstName;
        this.touristLastName = touristLastName;
    }

    public Ticket(int clientId, int flightId, String touristFirstName, String touristLastName) {
        this.clientId = clientId;
        this.flightId = flightId;
        this.touristFirstName = touristFirstName;
        this.touristLastName = touristLastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getTouristFirstName() {
        return touristFirstName;
    }

    public void setTouristFirstName(String touristFirstName) {
        this.touristFirstName = touristFirstName;
    }

    public String getTouristLastName() {
        return touristLastName;
    }

    public void setTouristLastName(String touristLastName) {
        this.touristLastName = touristLastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id &&
                clientId == ticket.clientId &&
                flightId == ticket.flightId &&
                Objects.equals(touristFirstName, ticket.touristFirstName) &&
                Objects.equals(touristLastName, ticket.touristLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, flightId, touristFirstName, touristLastName);
    }
}
