package repository;

import model.Flight;

import java.sql.Date;

public interface IFlightRepository extends IRepository<Flight> {

    public Iterable<Flight> findByDestinationAndDate(String destination, Date date);
    public Iterable<Flight> findAll();
    public void updatePlaces(int id, int newNumberOfPlaces);
}
