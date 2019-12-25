package repository;

import model.Flight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FlightRepository implements IFlightRepository {

    private JdbcUtils jdbcUtils;
    private static final Logger logger = LogManager.getLogger();

    /**
     * constructor
     * @param properties
     */
    public FlightRepository(Properties properties) {
        logger.info("Initializing FlightRepository with properties: {} ", properties);
        jdbcUtils = new JdbcUtils(properties);
    }


    /**
     * method that saves a flight to the database
     * @param entity
     */
    @Override
    public void save(Flight entity) {

        logger.traceEntry("Saving flight {} " , entity);

        Connection con = jdbcUtils.getConnection();

        if (findOne(entity.getId()) == null) {
            try (PreparedStatement statement = con.prepareStatement("insert into Flights values (?,?,?,?,?,?)")) {
                statement.setInt(1, entity.getId());
                statement.setString(2, entity.getDestination());

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = format.format(entity.getDate());
                statement.setString(3, dateString);
                statement.setString(4, entity.getTime().toString());
                statement.setString(5, entity.getAirport());
                statement.setInt(6, entity.getPlaces());
                int result = statement.executeUpdate();
            }
            catch (SQLException ex) {
                logger.error(ex);
            }
            logger.traceExit("Saved flight");
        }
        else {
            logger.info("Flight with specified id already exists");
        }
    }


    /**
     * method that finds a Flight entity by its id
     * @param id
     * @return Flight object if found, null if not
     */
    @Override
    public Flight findOne(int id) {

        logger.traceEntry("Finding Flight with id {} ", id);
        Connection con = jdbcUtils.getConnection();

        try (PreparedStatement statement = con.prepareStatement("select * from Flights where Id = ?")) {
            statement.setInt(1, id);
            try (ResultSet result=statement.executeQuery()) {
                if (result.next()) {
                    int Id = result.getInt("Id");
                    String destination = result.getString("Destination");
                    //Date date = result.getDate("FlightDate");
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    String dateString = result.getString("FlightDate");
                    Date date = new Date(format.parse (dateString).getTime());

                    //SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                    String timeString = result.getString("FlightTime");
                    Time time = Time.valueOf(timeString);
                    //Time time = result.getTime("FlightTime");
                    String airport = result.getString("Airport");
                    int places = result.getInt("Places");
                    Flight f = new Flight(Id, destination, date, time, airport, places);
                    logger.traceExit(f);
                    return f;
                }
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
        catch (SQLException ex){
            logger.error(ex);
        }
        logger.traceExit("No flight found with id {}", id);

        return null;
    }


    /**
     * method that finds all flights stores in the database
     * @return flights
     */
    @Override
    public Iterable<Flight> findAll() {

        logger.traceEntry("Finding all stored flights");
        Connection con = jdbcUtils.getConnection();
        List<Flight> flights = new ArrayList<>();

        try (PreparedStatement statement = con.prepareStatement("select * from Flights")) {
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    int Id = result.getInt("Id");
                    String destination = result.getString("Destination");

                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    String dateString = result.getString("FlightDate");
                    Date date = new Date(format.parse (dateString).getTime());

                    String timeString = result.getString("FlightTime");
                    Time time = Time.valueOf(timeString);

                    String airport = result.getString("Airport");
                    int places = result.getInt("Places");
                    Flight f = new Flight(Id, destination, date, time, airport, places);
                    flights.add(f);
                }
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        logger.traceExit(flights);
        return flights;
    }


    /**
     * method that finds a list of flights to destination specified by parameter
     * @param destination
     * @return list of flights to destination
     */
    @Override
    public Iterable<Flight> findByDestinationAndDate(String destination, Date date) {

        logger.traceEntry("Finding all flights to {}", destination);
        Connection con = jdbcUtils.getConnection();
        List<Flight> flights = new ArrayList<>();

        try (PreparedStatement statement = con.prepareStatement("select * from Flights where Destination=? and FlightDate=?")) {
            statement.setString(1, destination);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dString = dateFormat.format(date);
            //statement.setDate(2, date);
            statement.setString(2, dString);
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    int Id = result.getInt("Id");
                    String foundDestination = result.getString("Destination");

                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    String dateString = result.getString("FlightDate");
                    Date foundDate = new Date(format.parse (dateString).getTime());

                    String timeString = result.getString("FlightTime");
                    Time time = Time.valueOf(timeString);

                    String airport = result.getString("Airport");
                    int places = result.getInt("Places");
                    Flight f = new Flight(Id, foundDestination, foundDate, time, airport, places);
                    flights.add(f);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        logger.traceExit(flights);
        return flights;
    }


    /**
     * method that updates flight places
     * @param id flightId
     * @param newNumberOfPlaces number of places to set for specified flightId
     */
    @Override
    public void updatePlaces(int id, int newNumberOfPlaces) {

        logger.traceEntry("Updating places for flight with id {}", id);
        Connection con = jdbcUtils.getConnection();
        try( PreparedStatement statement = con.prepareStatement("update Flights set Places = ? where Id = ?")) {
            statement.setInt(1, newNumberOfPlaces);
            statement.setInt(2, id);
            int result = statement.executeUpdate();
        }
        catch (SQLException ex){
            logger.error(ex);
        }
        logger.traceExit("Updated flight places");
    }

}
