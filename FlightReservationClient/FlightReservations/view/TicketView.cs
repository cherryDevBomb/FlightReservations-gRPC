using FlightReservations.controller;
using FlightReservations.model;
using System;
using System.Windows.Forms;

namespace FlightReservations.view
{
    public partial class TicketView : Form
    {
        public TicketController TicketCtrl;

        public Flight SelectedFlight;
        public int NrOfTickets;

        private TextBox clientFirstName;
        private TextBox clientLastName;
        private TextBox clientAddress;
        private FlowLayoutPanel tourists;
        private Button buyBtn;

        public TicketView(Flight selected, int nr)
        {
            InitializeComponent();
            Width = 500;
            Height = 400;
            TicketCtrl = StartClient.ticketCtrl;
            SelectedFlight = selected;
            NrOfTickets = nr;

            clientFirstName = new TextBox
            {
                Width = 100,
            };
            clientLastName = new TextBox
            {
                Width = 100,
            };
            FlowLayoutPanel namesPanel = new FlowLayoutPanel
            {
                FlowDirection = FlowDirection.LeftToRight,
                Width = 500,
                Height = 30,
                Controls =
                {
                    new Label
                    {
                        Text = "First Name:"
                    },
                    clientFirstName,
                    new Label
                    {
                        Text = "Last Name:"
                    },
                    clientLastName
                },
            };

            clientAddress = new TextBox
            {
                Width = 200,
            };
            FlowLayoutPanel addressPanel = new FlowLayoutPanel
            {
                FlowDirection = FlowDirection.LeftToRight,
                Width = 500,
                Height = 30,
                Controls =
                {
                    new Label
                    {
                        Text = "Address:"
                    },
                    clientAddress,
                },
            };


            tourists = new FlowLayoutPanel
            {
                FlowDirection = FlowDirection.TopDown,
                Width = 500,
                Height = 200
            };

            for (int i = 0; i < NrOfTickets; i++)
            {
                TextBox fn = new TextBox
                {
                    Width = 100,
                };
                TextBox ln = new TextBox
                {
                    Width = 100,
                };
                FlowLayoutPanel onetouristPanel = new FlowLayoutPanel
                {
                    FlowDirection = FlowDirection.LeftToRight,
                    Width = 500,
                    Height = 30,
                    Controls =
                    {
                        new Label
                        {
                            Text = "First Name:"
                        },
                        fn,
                        new Label
                        {
                            Text = "Last Name:"
                        },
                        ln
                    },
                };
                tourists.Controls.Add(onetouristPanel);
            }

            buyBtn = new Button
            {
                Text = "Buy"
            };
            buyBtn.Click += OnBuyClick;

            FlowLayoutPanel panel = new FlowLayoutPanel
            {
                FlowDirection = FlowDirection.TopDown,
                Width = 500,
                Height = 500,
                Controls =
                {
                    new Label
                    {
                        Text = "Client information"
                    },
                    namesPanel,
                    addressPanel,
                    new Label
                    {
                        Text = "Tourist information"
                    },
                    tourists,
                    buyBtn
                }
            };

            Controls.Add(panel);
        }

        private void OnBuyClick(object sender, EventArgs e)
        {
            bool allFieldsComplete = true;

            string cfn = clientFirstName.Text;
            string cln = clientLastName.Text;
            string cad = clientAddress.Text;

            if (cfn.Equals("") || cln.Equals("") || cad.Equals(""))
            {
                allFieldsComplete = false;
            }

            foreach (FlowLayoutPanel tourist in tourists.Controls)
            {
                if (tourist.Controls[0].Text.Equals("") || tourist.Controls[1].Text.Equals(""))
                {
                    allFieldsComplete = false;
                }
            }

            if (allFieldsComplete)
            {
                Client newClient = new Client(cfn, cln, cad);
                int clientId = TicketCtrl.AddClient(newClient);
                int flightId = SelectedFlight.Id;

                foreach (FlowLayoutPanel tourist in tourists.Controls)
                {
                    string tfn = tourist.Controls[0].Text as string;
                    string tln = tourist.Controls[1].Text as string;

                    Ticket newTicket = new Ticket(clientId, flightId, tfn, tln);
                    TicketCtrl.SaveTicket(newTicket);
                    this.Hide();
                }
                SelectedFlight.Places = SelectedFlight.Places - NrOfTickets;
                TicketCtrl.UpdateFlightPlaces(SelectedFlight);
            }
            else
            {
                MessageBox.Show("Complete all fields");
            }
        }
    }
}
