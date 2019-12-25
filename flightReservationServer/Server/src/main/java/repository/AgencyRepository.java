package repository;

import model.Agency;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class AgencyRepository implements IAgencyRepository {

    private JdbcUtils jdbcUtils;
    private static final Logger logger = LogManager.getLogger();

    /**
     * constructor
     * @param properties
     */
    public AgencyRepository(Properties properties) {
        logger.info("Initializing AgencyRepository with properties: {} ", properties);
        jdbcUtils = new JdbcUtils(properties);
    }


    /**
     * method that saves a agency to the database
     * @param entity
     */
    @Override
    public void save(Agency entity) {

        logger.traceEntry("Saving agency {} " , entity);

        Connection con = jdbcUtils.getConnection();

        if (findUser(entity.getUsername()) == null) {
            try (PreparedStatement statement = con.prepareStatement("insert into Agencies values (?,?)")) {
                statement.setString(1, entity.getUsername());
                statement.setString(2, entity.getPassword());
                int result = statement.executeUpdate();
            } catch (SQLException ex) {
                logger.error(ex);
            }
            logger.traceExit("Saved agency");
        }
        else {
            logger.info("Agency with specified username already exists");
        }
    }


    /**
     * method that finds a agency entity by its username
     * @param username
     * @return agency object if found, null if not
     */
    @Override
    public Agency findUser(String username) {

        logger.traceEntry("Finding agency with username {} ", username);
        Connection con = jdbcUtils.getConnection();

        try (PreparedStatement statement = con.prepareStatement("select * from Agencies where Username = ?")) {
            statement.setString(1, username);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    String user = result.getString("Username");
                    String password = result.getString("Password");
                    Agency a = new Agency(user, password);
                    logger.traceExit(a);
                    return a;
                }
            }
        }
        catch (SQLException ex){
            logger.error(ex);
        }
        logger.traceExit("No user found with username {}", username);

        return null;
    }


    /**
     * method that searches for a Agency entry in the database
     * @param username agency username
     * @param password agency password
     * @return true if found, false if not
     */
    @Override
    public boolean findByUsernameAndPassword(String username, String password) {
        logger.traceEntry("Finding agency with username {} and password {} ", username, password);
        Connection con = jdbcUtils.getConnection();

        try (PreparedStatement statement = con.prepareStatement("select * from Agencies where Username = ? and Password = ?")) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet result=statement.executeQuery()) {
                if (result.next()) {
                    logger.traceExit("login successful");
                    return true;
                }
            }
        }
        catch (SQLException ex){
            logger.error(ex);
        }
        logger.traceExit("login unsuccessful");
        return false;
    }

}
