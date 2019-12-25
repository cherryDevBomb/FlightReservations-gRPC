package repository;

import model.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class TicketRepository implements ITicketRepository {

    private JdbcUtils jdbcUtils;
    private static final Logger logger = LogManager.getLogger();

    /**
     * constructor
     * @param properties
     */
    public TicketRepository(Properties properties) {
        logger.info("Initializing TicketRepository with properties: {} ", properties);
        jdbcUtils = new JdbcUtils(properties);
    }


    /**
     * method that saves a ticket to the database
     * @param entity
     */
    @Override
    public void save(Ticket entity) {

        logger.traceEntry("Saving ticket {} ", entity);

        Connection con = jdbcUtils.getConnection();

        try (PreparedStatement statement = con.prepareStatement("insert into Tickets (ClientId, FlightId, TouristFirstName, TouristLastName) values (?,?,?,?)")) {
            statement.setInt(1, entity.getClientId());
            statement.setInt(2, entity.getFlightId());
            statement.setString(3, entity.getTouristFirstName());
            statement.setString(4, entity.getTouristLastName());
            int result = statement.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex);
        }
        logger.traceExit("Saved ticket");
    }


    /**
     * method that deletes a Ticket by its id
     * @param id
     */
    @Override
    public void delete(int id) {

        logger.traceEntry("Deleting ticket with id {}", id);

        Connection con = jdbcUtils.getConnection();
        try (PreparedStatement statement = con.prepareStatement("delete from Tickets where Id = ?")) {
            statement.setInt(1, id);
            int result = statement.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex);
        }
        logger.traceExit();
    }


    /**
     * method that finds a Ticket entity by its id
     * @param id
     * @return Ticket object if found, null if not
     */
    @Override
    public Ticket findOne(int id) {

        logger.traceEntry("Finding Ticket with id {} ", id);
        Connection con = jdbcUtils.getConnection();

        try (PreparedStatement statement = con.prepareStatement("select * from Tickets where Id = ?")) {
            statement.setInt(1, id);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    int Id = result.getInt("Id");
                    int clientId = result.getInt("ClientId");
                    int flightId = result.getInt("FlightId");
                    String touristFirstName = result.getString("TouristFirstName");
                    String touristLastName = result.getString("TouristLastName");
                    Ticket t = new Ticket(Id, clientId, flightId, touristFirstName, touristLastName);
                    logger.traceExit(t);
                    return t;
                }
            }
        } catch (SQLException ex) {
            logger.error(ex);
        }
        logger.traceExit("No ticket found with id {}", id);

        return null;
    }


    /**
     * method that gets the ticketId for specified ticket entity
     * @param ticket
     * @return
     */
    @Override
    public int getId(Ticket ticket) {
        logger.traceEntry("Finding Ticket id");
        Connection con = jdbcUtils.getConnection();

        try (PreparedStatement statement = con.prepareStatement("select * from Tickets where ClientId = ? and FlightId = ? and TouristFirstName = ? and TouristLastName = ?")) {
            statement.setInt(1, ticket.getClientId());
            statement.setInt(2, ticket.getFlightId());
            statement.setString(3, ticket.getTouristFirstName());
            statement.setString(4, ticket.getTouristLastName());
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    int foundId = result.getInt("Id");
                    logger.traceExit(foundId);
                    return foundId;
                }
            }
        } catch (SQLException ex) {
            logger.error(ex);
        }
        logger.traceExit("No ticket found");

        return 0;
    }

}

