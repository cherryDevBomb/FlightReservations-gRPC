using System;
using System.Collections.Generic;

namespace FlightReservations.model
{
    public class Flight
    {
        public int Id { get; set; }
        public string Destination { get; set; }
        public DateTime FlightDateTime { get; set; }
        public string Airport { get; set; }
        public int Places { get; set; }

        public Flight(int id, string destination, DateTime flightDateTime, string airport, int places)
        {
            Id = id;
            Destination = destination;
            FlightDateTime = flightDateTime;
            Airport = airport;
            Places = places;
        }

        public override bool Equals(object obj)
        {
            var flight = obj as Flight;
            return flight != null &&
                   Id == flight.Id &&
                   Destination == flight.Destination &&
                   FlightDateTime == flight.FlightDateTime &&
                   Airport == flight.Airport &&
                   Places == flight.Places;
        }

        public override int GetHashCode()
        {
            var hashCode = -772600038;
            hashCode = hashCode * -1521134295 + Id.GetHashCode();
            hashCode = hashCode * -1521134295 + EqualityComparer<string>.Default.GetHashCode(Destination);
            hashCode = hashCode * -1521134295 + FlightDateTime.GetHashCode();
            hashCode = hashCode * -1521134295 + EqualityComparer<string>.Default.GetHashCode(Airport);
            hashCode = hashCode * -1521134295 + Places.GetHashCode();
            return hashCode;
        }

        public override string ToString()
        {
            return "Id:" + Id + ";Destination:" + Destination + ";DateTime:" + FlightDateTime + ";Airport:" + Airport + ";Places:" + Places;
        }
    }
}
