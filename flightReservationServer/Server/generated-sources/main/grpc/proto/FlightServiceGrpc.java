package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.20.0)",
    comments = "Source: flightReservations.proto")
public final class FlightServiceGrpc {

  private FlightServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.FlightService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.Agency,
      proto.LoginResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = proto.Agency.class,
      responseType = proto.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Agency,
      proto.LoginResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<proto.Agency, proto.LoginResponse> getLoginMethod;
    if ((getLoginMethod = FlightServiceGrpc.getLoginMethod) == null) {
      synchronized (FlightServiceGrpc.class) {
        if ((getLoginMethod = FlightServiceGrpc.getLoginMethod) == null) {
          FlightServiceGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<proto.Agency, proto.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.FlightService", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Agency.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.LoginResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FlightServiceMethodDescriptorSupplier("login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.Void,
      proto.Flight> getGetAllFlightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllFlights",
      requestType = proto.Void.class,
      responseType = proto.Flight.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<proto.Void,
      proto.Flight> getGetAllFlightsMethod() {
    io.grpc.MethodDescriptor<proto.Void, proto.Flight> getGetAllFlightsMethod;
    if ((getGetAllFlightsMethod = FlightServiceGrpc.getGetAllFlightsMethod) == null) {
      synchronized (FlightServiceGrpc.class) {
        if ((getGetAllFlightsMethod = FlightServiceGrpc.getGetAllFlightsMethod) == null) {
          FlightServiceGrpc.getGetAllFlightsMethod = getGetAllFlightsMethod = 
              io.grpc.MethodDescriptor.<proto.Void, proto.Flight>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "proto.FlightService", "getAllFlights"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Void.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Flight.getDefaultInstance()))
                  .setSchemaDescriptor(new FlightServiceMethodDescriptorSupplier("getAllFlights"))
                  .build();
          }
        }
     }
     return getGetAllFlightsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.GetByDestAndDateRequest,
      proto.Flight> getGetByDestAndDateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getByDestAndDate",
      requestType = proto.GetByDestAndDateRequest.class,
      responseType = proto.Flight.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<proto.GetByDestAndDateRequest,
      proto.Flight> getGetByDestAndDateMethod() {
    io.grpc.MethodDescriptor<proto.GetByDestAndDateRequest, proto.Flight> getGetByDestAndDateMethod;
    if ((getGetByDestAndDateMethod = FlightServiceGrpc.getGetByDestAndDateMethod) == null) {
      synchronized (FlightServiceGrpc.class) {
        if ((getGetByDestAndDateMethod = FlightServiceGrpc.getGetByDestAndDateMethod) == null) {
          FlightServiceGrpc.getGetByDestAndDateMethod = getGetByDestAndDateMethod = 
              io.grpc.MethodDescriptor.<proto.GetByDestAndDateRequest, proto.Flight>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "proto.FlightService", "getByDestAndDate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.GetByDestAndDateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Flight.getDefaultInstance()))
                  .setSchemaDescriptor(new FlightServiceMethodDescriptorSupplier("getByDestAndDate"))
                  .build();
          }
        }
     }
     return getGetByDestAndDateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.Client,
      proto.Void> getAddClientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addClient",
      requestType = proto.Client.class,
      responseType = proto.Void.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Client,
      proto.Void> getAddClientMethod() {
    io.grpc.MethodDescriptor<proto.Client, proto.Void> getAddClientMethod;
    if ((getAddClientMethod = FlightServiceGrpc.getAddClientMethod) == null) {
      synchronized (FlightServiceGrpc.class) {
        if ((getAddClientMethod = FlightServiceGrpc.getAddClientMethod) == null) {
          FlightServiceGrpc.getAddClientMethod = getAddClientMethod = 
              io.grpc.MethodDescriptor.<proto.Client, proto.Void>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.FlightService", "addClient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Client.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Void.getDefaultInstance()))
                  .setSchemaDescriptor(new FlightServiceMethodDescriptorSupplier("addClient"))
                  .build();
          }
        }
     }
     return getAddClientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.Client,
      proto.Client> getGetClientIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getClientId",
      requestType = proto.Client.class,
      responseType = proto.Client.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Client,
      proto.Client> getGetClientIdMethod() {
    io.grpc.MethodDescriptor<proto.Client, proto.Client> getGetClientIdMethod;
    if ((getGetClientIdMethod = FlightServiceGrpc.getGetClientIdMethod) == null) {
      synchronized (FlightServiceGrpc.class) {
        if ((getGetClientIdMethod = FlightServiceGrpc.getGetClientIdMethod) == null) {
          FlightServiceGrpc.getGetClientIdMethod = getGetClientIdMethod = 
              io.grpc.MethodDescriptor.<proto.Client, proto.Client>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.FlightService", "getClientId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Client.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Client.getDefaultInstance()))
                  .setSchemaDescriptor(new FlightServiceMethodDescriptorSupplier("getClientId"))
                  .build();
          }
        }
     }
     return getGetClientIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.Ticket,
      proto.Void> getSaveTicketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saveTicket",
      requestType = proto.Ticket.class,
      responseType = proto.Void.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Ticket,
      proto.Void> getSaveTicketMethod() {
    io.grpc.MethodDescriptor<proto.Ticket, proto.Void> getSaveTicketMethod;
    if ((getSaveTicketMethod = FlightServiceGrpc.getSaveTicketMethod) == null) {
      synchronized (FlightServiceGrpc.class) {
        if ((getSaveTicketMethod = FlightServiceGrpc.getSaveTicketMethod) == null) {
          FlightServiceGrpc.getSaveTicketMethod = getSaveTicketMethod = 
              io.grpc.MethodDescriptor.<proto.Ticket, proto.Void>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.FlightService", "saveTicket"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Ticket.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Void.getDefaultInstance()))
                  .setSchemaDescriptor(new FlightServiceMethodDescriptorSupplier("saveTicket"))
                  .build();
          }
        }
     }
     return getSaveTicketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.Flight,
      proto.Void> getUpdateFlightPlacesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateFlightPlaces",
      requestType = proto.Flight.class,
      responseType = proto.Void.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Flight,
      proto.Void> getUpdateFlightPlacesMethod() {
    io.grpc.MethodDescriptor<proto.Flight, proto.Void> getUpdateFlightPlacesMethod;
    if ((getUpdateFlightPlacesMethod = FlightServiceGrpc.getUpdateFlightPlacesMethod) == null) {
      synchronized (FlightServiceGrpc.class) {
        if ((getUpdateFlightPlacesMethod = FlightServiceGrpc.getUpdateFlightPlacesMethod) == null) {
          FlightServiceGrpc.getUpdateFlightPlacesMethod = getUpdateFlightPlacesMethod = 
              io.grpc.MethodDescriptor.<proto.Flight, proto.Void>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.FlightService", "updateFlightPlaces"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Flight.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Void.getDefaultInstance()))
                  .setSchemaDescriptor(new FlightServiceMethodDescriptorSupplier("updateFlightPlaces"))
                  .build();
          }
        }
     }
     return getUpdateFlightPlacesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.Void,
      proto.UpdateResponse> getNotifyAgenciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "notifyAgencies",
      requestType = proto.Void.class,
      responseType = proto.UpdateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Void,
      proto.UpdateResponse> getNotifyAgenciesMethod() {
    io.grpc.MethodDescriptor<proto.Void, proto.UpdateResponse> getNotifyAgenciesMethod;
    if ((getNotifyAgenciesMethod = FlightServiceGrpc.getNotifyAgenciesMethod) == null) {
      synchronized (FlightServiceGrpc.class) {
        if ((getNotifyAgenciesMethod = FlightServiceGrpc.getNotifyAgenciesMethod) == null) {
          FlightServiceGrpc.getNotifyAgenciesMethod = getNotifyAgenciesMethod = 
              io.grpc.MethodDescriptor.<proto.Void, proto.UpdateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.FlightService", "notifyAgencies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Void.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.UpdateResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FlightServiceMethodDescriptorSupplier("notifyAgencies"))
                  .build();
          }
        }
     }
     return getNotifyAgenciesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FlightServiceStub newStub(io.grpc.Channel channel) {
    return new FlightServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FlightServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FlightServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FlightServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FlightServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class FlightServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void login(proto.Agency request,
        io.grpc.stub.StreamObserver<proto.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void getAllFlights(proto.Void request,
        io.grpc.stub.StreamObserver<proto.Flight> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllFlightsMethod(), responseObserver);
    }

    /**
     */
    public void getByDestAndDate(proto.GetByDestAndDateRequest request,
        io.grpc.stub.StreamObserver<proto.Flight> responseObserver) {
      asyncUnimplementedUnaryCall(getGetByDestAndDateMethod(), responseObserver);
    }

    /**
     */
    public void addClient(proto.Client request,
        io.grpc.stub.StreamObserver<proto.Void> responseObserver) {
      asyncUnimplementedUnaryCall(getAddClientMethod(), responseObserver);
    }

    /**
     */
    public void getClientId(proto.Client request,
        io.grpc.stub.StreamObserver<proto.Client> responseObserver) {
      asyncUnimplementedUnaryCall(getGetClientIdMethod(), responseObserver);
    }

    /**
     */
    public void saveTicket(proto.Ticket request,
        io.grpc.stub.StreamObserver<proto.Void> responseObserver) {
      asyncUnimplementedUnaryCall(getSaveTicketMethod(), responseObserver);
    }

    /**
     */
    public void updateFlightPlaces(proto.Flight request,
        io.grpc.stub.StreamObserver<proto.Void> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateFlightPlacesMethod(), responseObserver);
    }

    /**
     */
    public void notifyAgencies(proto.Void request,
        io.grpc.stub.StreamObserver<proto.UpdateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getNotifyAgenciesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Agency,
                proto.LoginResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getGetAllFlightsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                proto.Void,
                proto.Flight>(
                  this, METHODID_GET_ALL_FLIGHTS)))
          .addMethod(
            getGetByDestAndDateMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                proto.GetByDestAndDateRequest,
                proto.Flight>(
                  this, METHODID_GET_BY_DEST_AND_DATE)))
          .addMethod(
            getAddClientMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Client,
                proto.Void>(
                  this, METHODID_ADD_CLIENT)))
          .addMethod(
            getGetClientIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Client,
                proto.Client>(
                  this, METHODID_GET_CLIENT_ID)))
          .addMethod(
            getSaveTicketMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Ticket,
                proto.Void>(
                  this, METHODID_SAVE_TICKET)))
          .addMethod(
            getUpdateFlightPlacesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Flight,
                proto.Void>(
                  this, METHODID_UPDATE_FLIGHT_PLACES)))
          .addMethod(
            getNotifyAgenciesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Void,
                proto.UpdateResponse>(
                  this, METHODID_NOTIFY_AGENCIES)))
          .build();
    }
  }

  /**
   */
  public static final class FlightServiceStub extends io.grpc.stub.AbstractStub<FlightServiceStub> {
    private FlightServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FlightServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlightServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FlightServiceStub(channel, callOptions);
    }

    /**
     */
    public void login(proto.Agency request,
        io.grpc.stub.StreamObserver<proto.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllFlights(proto.Void request,
        io.grpc.stub.StreamObserver<proto.Flight> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetAllFlightsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getByDestAndDate(proto.GetByDestAndDateRequest request,
        io.grpc.stub.StreamObserver<proto.Flight> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetByDestAndDateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addClient(proto.Client request,
        io.grpc.stub.StreamObserver<proto.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddClientMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getClientId(proto.Client request,
        io.grpc.stub.StreamObserver<proto.Client> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetClientIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void saveTicket(proto.Ticket request,
        io.grpc.stub.StreamObserver<proto.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSaveTicketMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateFlightPlaces(proto.Flight request,
        io.grpc.stub.StreamObserver<proto.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateFlightPlacesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void notifyAgencies(proto.Void request,
        io.grpc.stub.StreamObserver<proto.UpdateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getNotifyAgenciesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FlightServiceBlockingStub extends io.grpc.stub.AbstractStub<FlightServiceBlockingStub> {
    private FlightServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FlightServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlightServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FlightServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.LoginResponse login(proto.Agency request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.Flight> getAllFlights(
        proto.Void request) {
      return blockingServerStreamingCall(
          getChannel(), getGetAllFlightsMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.Flight> getByDestAndDate(
        proto.GetByDestAndDateRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetByDestAndDateMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Void addClient(proto.Client request) {
      return blockingUnaryCall(
          getChannel(), getAddClientMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Client getClientId(proto.Client request) {
      return blockingUnaryCall(
          getChannel(), getGetClientIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Void saveTicket(proto.Ticket request) {
      return blockingUnaryCall(
          getChannel(), getSaveTicketMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Void updateFlightPlaces(proto.Flight request) {
      return blockingUnaryCall(
          getChannel(), getUpdateFlightPlacesMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.UpdateResponse notifyAgencies(proto.Void request) {
      return blockingUnaryCall(
          getChannel(), getNotifyAgenciesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FlightServiceFutureStub extends io.grpc.stub.AbstractStub<FlightServiceFutureStub> {
    private FlightServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FlightServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlightServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FlightServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.LoginResponse> login(
        proto.Agency request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Void> addClient(
        proto.Client request) {
      return futureUnaryCall(
          getChannel().newCall(getAddClientMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Client> getClientId(
        proto.Client request) {
      return futureUnaryCall(
          getChannel().newCall(getGetClientIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Void> saveTicket(
        proto.Ticket request) {
      return futureUnaryCall(
          getChannel().newCall(getSaveTicketMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Void> updateFlightPlaces(
        proto.Flight request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateFlightPlacesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.UpdateResponse> notifyAgencies(
        proto.Void request) {
      return futureUnaryCall(
          getChannel().newCall(getNotifyAgenciesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_GET_ALL_FLIGHTS = 1;
  private static final int METHODID_GET_BY_DEST_AND_DATE = 2;
  private static final int METHODID_ADD_CLIENT = 3;
  private static final int METHODID_GET_CLIENT_ID = 4;
  private static final int METHODID_SAVE_TICKET = 5;
  private static final int METHODID_UPDATE_FLIGHT_PLACES = 6;
  private static final int METHODID_NOTIFY_AGENCIES = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FlightServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FlightServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((proto.Agency) request,
              (io.grpc.stub.StreamObserver<proto.LoginResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_FLIGHTS:
          serviceImpl.getAllFlights((proto.Void) request,
              (io.grpc.stub.StreamObserver<proto.Flight>) responseObserver);
          break;
        case METHODID_GET_BY_DEST_AND_DATE:
          serviceImpl.getByDestAndDate((proto.GetByDestAndDateRequest) request,
              (io.grpc.stub.StreamObserver<proto.Flight>) responseObserver);
          break;
        case METHODID_ADD_CLIENT:
          serviceImpl.addClient((proto.Client) request,
              (io.grpc.stub.StreamObserver<proto.Void>) responseObserver);
          break;
        case METHODID_GET_CLIENT_ID:
          serviceImpl.getClientId((proto.Client) request,
              (io.grpc.stub.StreamObserver<proto.Client>) responseObserver);
          break;
        case METHODID_SAVE_TICKET:
          serviceImpl.saveTicket((proto.Ticket) request,
              (io.grpc.stub.StreamObserver<proto.Void>) responseObserver);
          break;
        case METHODID_UPDATE_FLIGHT_PLACES:
          serviceImpl.updateFlightPlaces((proto.Flight) request,
              (io.grpc.stub.StreamObserver<proto.Void>) responseObserver);
          break;
        case METHODID_NOTIFY_AGENCIES:
          serviceImpl.notifyAgencies((proto.Void) request,
              (io.grpc.stub.StreamObserver<proto.UpdateResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class FlightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FlightServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.FlightReservationsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FlightService");
    }
  }

  private static final class FlightServiceFileDescriptorSupplier
      extends FlightServiceBaseDescriptorSupplier {
    FlightServiceFileDescriptorSupplier() {}
  }

  private static final class FlightServiceMethodDescriptorSupplier
      extends FlightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FlightServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FlightServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FlightServiceFileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .addMethod(getGetAllFlightsMethod())
              .addMethod(getGetByDestAndDateMethod())
              .addMethod(getAddClientMethod())
              .addMethod(getGetClientIdMethod())
              .addMethod(getSaveTicketMethod())
              .addMethod(getUpdateFlightPlacesMethod())
              .addMethod(getNotifyAgenciesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
