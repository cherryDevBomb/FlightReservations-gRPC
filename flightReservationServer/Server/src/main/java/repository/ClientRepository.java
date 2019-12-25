package repository;

import model.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class ClientRepository implements IClientRepository {

    private JdbcUtils jdbcUtils;
    private static final Logger logger = LogManager.getLogger();

    /**
     * constructor
     * @param properties
     */
    public ClientRepository(Properties properties) {
        logger.info("Initializing ClientRepository with properties: {} ", properties);
        jdbcUtils = new JdbcUtils(properties);
    }


    /**
     * method that saves a client to the database
     * @param entity
     */
    @Override
    public void save(Client entity) {

        logger.traceEntry("Saving client {} " , entity);

        Connection con = jdbcUtils.getConnection();

        try (PreparedStatement statement = con.prepareStatement("insert into Clients (FirstName, LastName, Address) values (?,?,?)")) {
            //statement.setInt(1, entity.getId());
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getAddress());
            int result = statement.executeUpdate();
        }
        catch (SQLException ex) {
            logger.error(ex);
        }
        logger.traceExit("Saved client");
    }


    /**
     * method that deletes a client by its id
     * @param id
     */
    @Override
    public void delete(int id) {

        logger.traceEntry("Deleting client with id {}" , id);

        Connection con = jdbcUtils.getConnection();
        try (PreparedStatement statement = con.prepareStatement("delete from Clients where Id = ?")){
            statement.setInt(1, id);
            int result = statement.executeUpdate();
        }
        catch (SQLException ex){
            logger.error(ex);
        }
        logger.traceExit();
    }

    /**
     * method that finds a client entity by its id
     * @param id
     * @return client object if found, null if not
     */
    @Override
    public Client findOne(int id) {

        logger.traceEntry("Finding client with id {} ", id);
        Connection con = jdbcUtils.getConnection();

        try (PreparedStatement statement = con.prepareStatement("select * from Clients where Id = ?")) {
            statement.setInt(1, id);
            try (ResultSet result=statement.executeQuery()) {
                if (result.next()) {
                    int Id = result.getInt("Id");
                    String firstName = result.getString("FirstName");
                    String lastName = result.getString("LastName");
                    String address = result.getString("Address");
                    Client c = new Client(Id, firstName, lastName, address);
                    logger.traceExit(c);
                    return c;
                }
            }
        }
        catch (SQLException ex){
            logger.error(ex);
        }
        logger.traceExit("No client found with id {}", id);

        return null;
    }


    /**
     * method that returns the id of a client
     * @param client
     * @return client id
     */
    public int getId(Client client) {

        logger.traceEntry("Finding client id");
        Connection con = jdbcUtils.getConnection();

        try (PreparedStatement statement = con.prepareStatement("select * from Clients where FirstName = ? and LastName = ? and Address = ?")) {
            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getLastName());
            statement.setString(3, client.getAddress());
            try (ResultSet result=statement.executeQuery()) {
                if (result.next()) {
                    int foundId = result.getInt("Id");
                    logger.traceExit(foundId);
                    return foundId;
                }
            }
        }
        catch (SQLException ex){
            logger.error(ex);
        }
        logger.traceExit("No client found");
        return 0;
    }

}
