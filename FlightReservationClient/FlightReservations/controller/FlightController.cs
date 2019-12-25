using FlightReservations.model;
using FlightReservations.utils;
using System;
using System.Collections.Generic;


namespace FlightReservations.controller
{
    public class FlightController
    {
        public FlightClient ServiceClient { get; }
        public event EventHandler<UpdateEventArgs> UpdateEvent; //ctrl calls it when it has received an update

        public FlightController(FlightClient client)
        {
            this.ServiceClient = client;
        }

        public List<Flight> FindFlightsByDestinationAndDate(String destination, DateTime date)
        {
            return ServiceClient.GetByDestAndDate(destination, date);
        }

        public List<Flight> FindAllFlights()
        {
            return ServiceClient.GetAllFlights();
        }

        public void SomeoneBoughtTickets()
        {
            OnUserEvent(new UpdateEventArgs());
        }

        protected virtual void OnUserEvent(UpdateEventArgs e)
        {
            if (UpdateEvent == null) return;
            UpdateEvent(this, e);
            Console.WriteLine("Update Event called");
            ServiceClient.WaitForUpdate();
        }

    }
}
