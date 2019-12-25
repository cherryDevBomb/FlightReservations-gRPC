using System.Collections.Generic;

namespace FlightReservations.model
{
    public class Agency
    {
        public string Username;
        public string Password;

        public Agency(string username, string password)
        {
            Username = username;
            Password = password;
        }

        public override bool Equals(object obj)
        {
            var agency = obj as Agency;
            return agency != null &&
                   Username == agency.Username &&
                   Password == agency.Password;
        }

        public override int GetHashCode()
        {
            var hashCode = 568732665;
            hashCode = hashCode * -1521134295 + EqualityComparer<string>.Default.GetHashCode(Username);
            hashCode = hashCode * -1521134295 + EqualityComparer<string>.Default.GetHashCode(Password);
            return hashCode;
        }
    }
}
