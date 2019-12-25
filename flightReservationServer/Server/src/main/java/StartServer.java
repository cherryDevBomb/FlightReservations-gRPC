import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import repository.AgencyRepository;
import repository.ClientRepository;
import repository.FlightRepository;
import repository.TicketRepository;
import service.FlightService;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;


public class StartServer {

    private static final Logger logger = Logger.getLogger(StartServer.class.getName());

    private final int port;
    private final Server server;

    private StartServer(int port, AgencyRepository agencyRepository, FlightRepository flightRepository, ClientRepository clientRepository, TicketRepository ticketRepository) {
        this.port = port;
        ServerBuilder<?> serverBuilder = ServerBuilder.forPort(port);
        server = serverBuilder.addService(new FlightService(agencyRepository, flightRepository, clientRepository, ticketRepository)).build();
    }

    public static void main(String[] args) {

        ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:SpringConfig.xml");
        AgencyRepository agencyRepo = factory.getBean(AgencyRepository.class);
        FlightRepository flightRepo = factory.getBean(FlightRepository.class);
        ClientRepository clientRepo = factory.getBean(ClientRepository.class);
        TicketRepository ticketRepo = factory.getBean(TicketRepository.class);

        Properties serverProps = (Properties) factory.getBean("jdbcProps");

        int serverPort = 55555;
        try {
            serverPort = Integer.parseInt(serverProps.getProperty("server.port"));
        }
        catch (NumberFormatException nef) {
            System.err.println("Wrong  Port Number" + nef.getMessage());
            System.err.println("Using default port 55555");
        }
        System.out.println("Starting server on port: " + serverPort);

        StartServer server = new StartServer(serverPort, agencyRepo, flightRepo, clientRepo, ticketRepo);
        try {
            server.start();
            server.blockUntilShutdown();
        }
        catch (IOException | InterruptedException e) {
            System.err.println("Error starting the server" + e.getMessage());
        }
    }


    private void start() throws IOException {
        server.start();
        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                StartServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
