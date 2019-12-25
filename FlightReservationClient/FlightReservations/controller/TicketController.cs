using FlightReservations.model;


namespace FlightReservations.controller
{
    public class TicketController
    {
        private FlightClient serviceClient;

        public TicketController(FlightClient client)
        {
            this.serviceClient = client;
        }

        public int AddClient(Client newClient)
        {
            serviceClient.AddClient(newClient);
            return serviceClient.GetClientId(newClient);
        }

        public void SaveTicket(Ticket newTicket)
        {
            serviceClient.SaveTicket(newTicket);
        }

        public void UpdateFlightPlaces(Flight updatedFlight)
        {
            serviceClient.UpdateFlightPlaces(updatedFlight);
        }
    }
}
