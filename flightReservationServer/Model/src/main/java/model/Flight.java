package model;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

public class Flight {

    private int id;
    private String destination;
    private Date date;
    private Time time;
    private String airport;
    private int places;

    public Flight(int id, String destination, Date date, Time time, String airport, int places) {
        this.id = id;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.airport = airport;
        this.places = places;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id &&
                places == flight.places &&
                Objects.equals(destination, flight.destination) &&
                Objects.equals(date, flight.date) &&
                Objects.equals(time, flight.time) &&
                Objects.equals(airport, flight.airport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, destination, date, time, airport, places);
    }
}
