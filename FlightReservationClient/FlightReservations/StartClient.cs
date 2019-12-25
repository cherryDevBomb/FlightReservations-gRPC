using FlightReservations.controller;
using Grpc.Core;
using Proto;
using System;
using System.Windows.Forms;


namespace FlightReservations
{
    public static class StartClient
    {
        public static LoginController loginCtrl;
        public static FlightController flightCtrl;
        public static TicketController ticketCtrl;


        [STAThread]
        static void Main(string[] args)
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);

            var channel = new Channel("127.0.0.1:55556", ChannelCredentials.Insecure);
            var client = new FlightClient(new FlightService.FlightServiceClient(channel));

            LoginController loginCtrl = new LoginController(client);

            LoginView form = new LoginView();
            form.LController = loginCtrl;
            Application.Run(form);
        }
    }
}
