// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: flightReservations.proto

package proto;

public final class FlightReservationsProto {
  private FlightReservationsProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_Agency_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_Agency_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_Client_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_Client_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_Flight_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_Flight_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_Ticket_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_Ticket_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_LoginResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_LoginResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_Void_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_Void_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_UpdateResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_UpdateResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_GetByDestAndDateRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_GetByDestAndDateRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\030flightReservations.proto\022\005proto\",\n\006Age" +
      "ncy\022\020\n\010username\030\001 \001(\t\022\020\n\010password\030\002 \001(\t\"" +
      "J\n\006Client\022\n\n\002id\030\001 \001(\005\022\021\n\tfirstName\030\002 \001(\t" +
      "\022\020\n\010lastName\030\003 \001(\t\022\017\n\007address\030\004 \001(\t\"f\n\006F" +
      "light\022\n\n\002id\030\001 \001(\005\022\023\n\013destination\030\002 \001(\t\022\014" +
      "\n\004date\030\003 \001(\t\022\014\n\004time\030\004 \001(\t\022\017\n\007airport\030\005 " +
      "\001(\t\022\016\n\006places\030\006 \001(\005\"k\n\006Ticket\022\n\n\002id\030\001 \001(" +
      "\005\022\020\n\010clientId\030\002 \001(\005\022\020\n\010flightId\030\003 \001(\005\022\030\n" +
      "\020touristFirstName\030\004 \001(\t\022\027\n\017touristLastNa" +
      "me\030\005 \001(\t\"#\n\rLoginResponse\022\022\n\nsuccessful\030" +
      "\001 \001(\010\"\006\n\004Void\"\020\n\016UpdateResponse\"<\n\027GetBy" +
      "DestAndDateRequest\022\023\n\013destination\030\001 \001(\t\022" +
      "\014\n\004date\030\002 \001(\t2\251\003\n\rFlightService\022.\n\005login" +
      "\022\r.proto.Agency\032\024.proto.LoginResponse\"\000\022" +
      "/\n\rgetAllFlights\022\013.proto.Void\032\r.proto.Fl" +
      "ight\"\0000\001\022E\n\020getByDestAndDate\022\036.proto.Get" +
      "ByDestAndDateRequest\032\r.proto.Flight\"\0000\001\022" +
      ")\n\taddClient\022\r.proto.Client\032\013.proto.Void" +
      "\"\000\022-\n\013getClientId\022\r.proto.Client\032\r.proto" +
      ".Client\"\000\022*\n\nsaveTicket\022\r.proto.Ticket\032\013" +
      ".proto.Void\"\000\0222\n\022updateFlightPlaces\022\r.pr" +
      "oto.Flight\032\013.proto.Void\"\000\0226\n\016notifyAgenc" +
      "ies\022\013.proto.Void\032\025.proto.UpdateResponse\"" +
      "\000B\"\n\005protoB\027FlightReservationsProtoP\001b\006p" +
      "roto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_proto_Agency_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_proto_Agency_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_Agency_descriptor,
        new java.lang.String[] { "Username", "Password", });
    internal_static_proto_Client_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_proto_Client_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_Client_descriptor,
        new java.lang.String[] { "Id", "FirstName", "LastName", "Address", });
    internal_static_proto_Flight_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_proto_Flight_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_Flight_descriptor,
        new java.lang.String[] { "Id", "Destination", "Date", "Time", "Airport", "Places", });
    internal_static_proto_Ticket_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_proto_Ticket_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_Ticket_descriptor,
        new java.lang.String[] { "Id", "ClientId", "FlightId", "TouristFirstName", "TouristLastName", });
    internal_static_proto_LoginResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_proto_LoginResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_LoginResponse_descriptor,
        new java.lang.String[] { "Successful", });
    internal_static_proto_Void_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_proto_Void_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_Void_descriptor,
        new java.lang.String[] { });
    internal_static_proto_UpdateResponse_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_proto_UpdateResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_UpdateResponse_descriptor,
        new java.lang.String[] { });
    internal_static_proto_GetByDestAndDateRequest_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_proto_GetByDestAndDateRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_GetByDestAndDateRequest_descriptor,
        new java.lang.String[] { "Destination", "Date", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}