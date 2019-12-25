using System.Collections.Generic;

namespace FlightReservations.model
{
    public class Ticket
    {
        public int Id;
        public int ClientId;
        public int FlightId;
        public string TouristFirstName;
        public string TouristLastName;

        public Ticket(int id, int clientId, int flightId, string touristFirstName, string touristLastName)
        {
            Id = id;
            ClientId = clientId;
            FlightId = flightId;
            TouristFirstName = touristFirstName;
            TouristLastName = touristLastName;
        }

        public Ticket(int clientId, int flightId, string touristFirstName, string touristLastName)
        {
            ClientId = clientId;
            FlightId = flightId;
            TouristFirstName = touristFirstName;
            TouristLastName = touristLastName;
        }

        public override bool Equals(object obj)
        {
            var ticket = obj as Ticket;
            return ticket != null &&
                   Id == ticket.Id &&
                   ClientId == ticket.ClientId &&
                   FlightId == ticket.FlightId &&
                   TouristFirstName == ticket.TouristFirstName &&
                   TouristLastName == ticket.TouristLastName;
        }

        public override int GetHashCode()
        {
            var hashCode = -577858635;
            hashCode = hashCode * -1521134295 + Id.GetHashCode();
            hashCode = hashCode * -1521134295 + ClientId.GetHashCode();
            hashCode = hashCode * -1521134295 + FlightId.GetHashCode();
            hashCode = hashCode * -1521134295 + EqualityComparer<string>.Default.GetHashCode(TouristFirstName);
            hashCode = hashCode * -1521134295 + EqualityComparer<string>.Default.GetHashCode(TouristLastName);
            return hashCode;
        }

        public override string ToString()
        {
            return "Id:" + Id + ";ClientId:" + ClientId + ";FlightId:" + FlightId + ";TouristFirstName:" + TouristFirstName + ";TouristLastName:" + TouristLastName;
        }
    }
}
