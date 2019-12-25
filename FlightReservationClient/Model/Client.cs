using System.Collections.Generic;

namespace FlightReservations.model
{
    public class Client
    {
        public int Id;
        public string FirstName;
        public string LastName;
        public string Address;

        public Client(int id, string firstName, string lastName, string address)
        {
            Id = id;
            FirstName = firstName;
            LastName = lastName;
            Address = address;
        }

        public Client(string firstName, string lastName, string address)
        {
            FirstName = firstName;
            LastName = lastName;
            Address = address;
        }

        public override bool Equals(object obj)
        {
            var client = obj as Client;
            return client != null &&
                   Id == client.Id &&
                   FirstName == client.FirstName &&
                   LastName == client.LastName &&
                   Address == client.Address;
        }

        public override int GetHashCode()
        {
            var hashCode = -1399804081;
            hashCode = hashCode * -1521134295 + Id.GetHashCode();
            hashCode = hashCode * -1521134295 + EqualityComparer<string>.Default.GetHashCode(FirstName);
            hashCode = hashCode * -1521134295 + EqualityComparer<string>.Default.GetHashCode(LastName);
            hashCode = hashCode * -1521134295 + EqualityComparer<string>.Default.GetHashCode(Address);
            return hashCode;
        }

        public override string ToString()
        {
            return "Id:" + Id + ";FirstName:" + FirstName + ";LastName:" + LastName + ";Adderss:" + Address; 
        }
    }
}
