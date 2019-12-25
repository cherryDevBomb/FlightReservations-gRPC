package service;

import model.Client;
import model.Flight;
import model.Ticket;
import proto.FlightServiceGrpc;
import proto.LoginResponse;
import repository.AgencyRepository;
import repository.ClientRepository;
import repository.FlightRepository;
import repository.TicketRepository;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class FlightService extends FlightServiceGrpc.FlightServiceImplBase {

    private AgencyRepository agencyRepository;
    private FlightRepository flightRepository;
    private ClientRepository clientRepository;
    private TicketRepository ticketRepository;

    private volatile boolean shouldSendUpdateToClients;

    public FlightService(AgencyRepository agencyRepository, FlightRepository flightRepository, ClientRepository clientRepository, TicketRepository ticketRepository) {
        this.agencyRepository = agencyRepository;
        this.flightRepository = flightRepository;
        this.clientRepository = clientRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void login(proto.Agency request, io.grpc.stub.StreamObserver<proto.LoginResponse> responseObserver) {
        boolean found = agencyRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        proto.LoginResponse response = LoginResponse.newBuilder().setSuccessful(found).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllFlights(proto.Void request, io.grpc.stub.StreamObserver<proto.Flight> responseObserver) {
        Iterable<Flight> flights = flightRepository.findAll();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (Flight f : flights) {
            String dateString = dateFormat.format(f.getDate());
            String timeString = f.getTime().toString();
            proto.Flight fl = proto.Flight.newBuilder().setId(f.getId()).setDestination(f.getDestination()).setDate(dateString).setTime(timeString).setAirport(f.getAirport()).setPlaces(f.getPlaces()).build();
            responseObserver.onNext(fl);
        }
        responseObserver.onCompleted();
        System.out.println("Found all flights");
    }


    @Override
    public void getByDestAndDate(proto.GetByDestAndDateRequest request, io.grpc.stub.StreamObserver<proto.Flight> responseObserver) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = new Date(format.parse(request.getDate()).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Iterable<Flight> flights = flightRepository.findByDestinationAndDate(request.getDestination(), date);
        for (Flight f : flights) {
            String dateString = format.format(f.getDate());
            String timeString = f.getTime().toString();
            proto.Flight fl = proto.Flight.newBuilder().setId(f.getId()).setDestination(f.getDestination()).setDate(dateString).setTime(timeString).setAirport(f.getAirport()).setPlaces(f.getPlaces()).build();
            responseObserver.onNext(fl);
        }
        responseObserver.onCompleted();

        System.out.println("Found flights to " + request.getDestination() + " on " + date);
    }


    @Override
    public void addClient(proto.Client request, io.grpc.stub.StreamObserver<proto.Void> responseObserver) {
        Client client = new Client(request.getId(), request.getFirstName(), request.getLastName(), request.getAddress());
        clientRepository.save(client);
        proto.Void response = proto.Void.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
        System.out.println("Client saved" + client);
    }


    @Override
    public void getClientId(proto.Client request, io.grpc.stub.StreamObserver<proto.Client> responseObserver) {
        Client client = new Client(request.getId(), request.getFirstName(), request.getLastName(), request.getAddress());
        int id = clientRepository.getId(client);
        client.setId(id);
        proto.Client response = proto.Client.newBuilder().setId(client.getId()).setFirstName(client.getFirstName()).setLastName(client.getLastName()).setAddress(client.getAddress()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void saveTicket(proto.Ticket request, io.grpc.stub.StreamObserver<proto.Void> responseObserver) {
        Ticket ticket = new Ticket(request.getId(), request.getFlightId(), request.getClientId(), request.getTouristFirstName(), request.getTouristLastName());
        ticketRepository.save(ticket);
        proto.Void response = proto.Void.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
        System.out.println("Ticket saved" + ticket);
    }


    @Override
    public void updateFlightPlaces(proto.Flight request, io.grpc.stub.StreamObserver<proto.Void> responseObserver) {
        flightRepository.updatePlaces(request.getId(), request.getPlaces());
        proto.Void response = proto.Void.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
        shouldSendUpdateToClients = true;
    }


    @Override
    public void notifyAgencies(proto.Void request, io.grpc.stub.StreamObserver<proto.UpdateResponse> responseObserver) {
        shouldSendUpdateToClients = false;
        while (!shouldSendUpdateToClients) {
            //waiting
        }
        proto.UpdateResponse response = proto.UpdateResponse.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
