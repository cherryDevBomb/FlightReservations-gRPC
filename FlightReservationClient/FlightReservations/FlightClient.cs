using FlightReservations.controller;
using FlightReservations.model;
using System;
using System.Collections.Generic;
using System.Threading;

namespace FlightReservations
{
    public class FlightClient
    {
        readonly Proto.FlightService.FlightServiceClient serviceClient;

        public FlightController flightCtrl;
  

        public FlightClient(Proto.FlightService.FlightServiceClient serviceClient)
        {
            this.serviceClient = serviceClient;
        }

        public void Login(Proto.Agency agency, FlightController flightCtrl)
        {
            this.flightCtrl = flightCtrl;
            Proto.LoginResponse response = serviceClient.login(agency);
            WaitForUpdate();
        }

        public List<Flight> GetAllFlights()
        {
            List<Flight> found = new List<Flight>();
            Proto.Void request = new Proto.Void();
            using (var call = serviceClient.getAllFlights(request))
            {
                while (call.ResponseStream.MoveNext().Result)
                {
                    Proto.Flight f = call.ResponseStream.Current;
                    string datetimeString = f.Date + " " + f.Time;
                    DateTime compoundDate = DateTime.ParseExact(datetimeString, "yyyy-MM-dd HH:mm:ss", null);
                    Flight fl = new Flight(f.Id, f.Destination, compoundDate, f.Airport, f.Places);
                    found.Add(fl);
                }
            }
            return found;
        }


        public List<Flight> GetByDestAndDate(string destination, DateTime date)
        {
            List<Flight> found = new List<Flight>();
            string strDate = date.ToString("yyyy-MM-dd");
            Proto.GetByDestAndDateRequest request = new Proto.GetByDestAndDateRequest { Destination = destination, Date = strDate };
            using (var call = serviceClient.getByDestAndDate(request))
            {
                while (call.ResponseStream.MoveNext().Result)
                {
                    Proto.Flight f = call.ResponseStream.Current;
                    string datetimeString = f.Date + " " + f.Time;
                    DateTime compoundDate = DateTime.ParseExact(datetimeString, "yyyy-MM-dd HH:mm:ss", null);
                    Flight fl = new Flight(f.Id, f.Destination, compoundDate, f.Airport, f.Places);
                    found.Add(fl);
                }
            }
            return found;
        }


        public void AddClient(Client client)
        {
            Proto.Client request = new Proto.Client { Id = 0, FirstName = client.FirstName, LastName = client.LastName, Address = client.Address };
            Proto.Void response = serviceClient.addClient(request);
        }

        public int GetClientId(Client client)
        {
            Proto.Client request = new Proto.Client { Id = 0, FirstName = client.FirstName, LastName = client.LastName, Address = client.Address };
            Proto.Client response = serviceClient.getClientId(request);
            return response.Id;
        }

        public void SaveTicket(Ticket ticket)
        {
            Proto.Ticket request = new Proto.Ticket { Id = ticket.Id, ClientId = ticket.ClientId, FlightId = ticket.FlightId, TouristFirstName = ticket.TouristFirstName, TouristLastName = ticket.TouristLastName };
            Proto.Void response = serviceClient.saveTicket(request);
        }

        public void UpdateFlightPlaces(Flight flight)
        {
            Proto.Flight request = new Proto.Flight { Id = flight.Id, Places = flight.Places };
            Proto.Void response = serviceClient.updateFlightPlaces(request);
        }


        public void WaitForUpdate()
        {
            new Thread(() =>
            {
                Thread.CurrentThread.IsBackground = true;
                Proto.Void request = new Proto.Void();
                Proto.UpdateResponse updateResponse = serviceClient.notifyAgencies(request);
                //update callback
                flightCtrl.SomeoneBoughtTickets();
            }).Start();
        }
    }
}
