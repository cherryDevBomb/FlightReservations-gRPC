using FlightReservations.model;


namespace FlightReservations.controller
{
    public class LoginController
    {
        private readonly FlightClient serviceClient;
        public FlightController FlightCtrl;

        public LoginController(FlightClient serviceClient)
        {
            this.serviceClient = serviceClient;
        }

        public void Login(Agency agency)
        {
            FlightCtrl = new FlightController(serviceClient);
            Proto.Agency a = new Proto.Agency { Username = agency.Username, Password = agency.Password };
            serviceClient.Login(a, FlightCtrl);
        }
    }
}
