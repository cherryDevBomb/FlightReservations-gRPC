using FlightReservations.controller;
using FlightReservations.model;
using FlightReservations.utils;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Linq;
using System.Windows.Forms;

namespace FlightReservations.view
{
    public partial class FlightView : Form, IObserver
    {
        public FlightController FController;

        private TextBox destinationField;
        private DateTimePicker dateTimePicker;
        private Button searchBtn;
        private DataGridView table;
        private NumericUpDown numberSpinner;
        private Button buyBtn;
        private Button logoutBtn;
        

        public FlightView(FlightController fCtrl)
        {
            InitializeComponent();
            Width = 600;
            Height = 500;
            FController = fCtrl;
            FController.UpdateEvent += Update;

            destinationField = new TextBox
            {
                Width = 200
            };
            dateTimePicker = new DateTimePicker
            {
                Format = DateTimePickerFormat.Short
            };

            searchBtn = new Button
            {
                Text = "Search"
            };
            searchBtn.Click += OnSearchClick;

            FlowLayoutPanel searchPanel = new FlowLayoutPanel
            {
                FlowDirection = FlowDirection.LeftToRight,
                Width = 600,
                Height = 50,
                Controls =
                {
                    destinationField,
                    dateTimePicker,
                    searchBtn
                }
            };


            table = new DataGridView
            {
                Width = 550,
                Height = 300,
                AllowUserToAddRows = false,
                AllowUserToDeleteRows = false,
                AutoGenerateColumns = true,
                SelectionMode = DataGridViewSelectionMode.FullRowSelect
            };
            InitData();

            FlowLayoutPanel tablePanel = new FlowLayoutPanel
            {
                FlowDirection = FlowDirection.LeftToRight,
                Width = 600,
                Height = 300,
                Controls =
                {
                    table
                }
            };


            numberSpinner = new NumericUpDown
            {
                Minimum = 1
            };
            buyBtn = new Button
            {
                Text = "Buy",
            };
            buyBtn.Click += OnBuyClick;
            logoutBtn = new Button
            {
                Text = "Log out"
            };
            logoutBtn.Click += OnLogoutClick;

            FlowLayoutPanel buyPanel = new FlowLayoutPanel
            {
                FlowDirection = FlowDirection.LeftToRight,
                Width = 600,
                Height = 50,
                Controls =
                {
                    new Label
                    {
                        Text = "Number of tickets:",
                    },
                    numberSpinner, 
                    buyBtn,
                    logoutBtn
                }
            };


            FlowLayoutPanel panel = new FlowLayoutPanel
            {
                FlowDirection = FlowDirection.TopDown,
                Width = 600,
                Height = 500,
                Controls =
                {
                    new Label
                    {
                        Text = "Destination:",
                    },
                    searchPanel,
                    tablePanel,
                    buyPanel
                }
            };

            Controls.Add(panel);
        }

        private void OnBuyClick(object sender, EventArgs e)
        {
            Flight selected = table.CurrentRow.DataBoundItem as Flight;
            int nr = Decimal.ToInt32(numberSpinner.Value);
            if (nr > selected.Places)
            {
                MessageBox.Show("Not enough places");
                return;
            }

            TicketView buy = new TicketView(selected, nr);
            buy.TicketCtrl = new TicketController(FController.ServiceClient);
            buy.Show();
        }

        private void OnLogoutClick(object sender, EventArgs e)
        {
            LoginView form = new LoginView();
            form.LController = new LoginController(FController.ServiceClient);
            form.Show();
            Hide();
        }

        private void OnSearchClick(object sender, EventArgs e)
        {
            string destination = destinationField.Text;
            DateTime date = dateTimePicker.Value;
            if (destination.Equals("") && date == null)
            {
                InitData();
                return;
            }
            else if (destination.Equals("") || date == null)
            {
                MessageBox.Show("Wrong input");
                return;
            }
            List<Flight> flights = FController.FindFlightsByDestinationAndDate(destination, date);
            flights = flights.Where(f => f.Places > 0).ToList();
            var bindingList = new BindingList<Flight>(flights);
            var source = new BindingSource(bindingList, null);
            table.DataSource = source;
        }

        private void InitData()
        {
            List<Flight> allFlights = FController.FindAllFlights();
            allFlights = allFlights.Where(f => f.Places > 0).ToList();
            var bindingList = new BindingList<Flight>(allFlights);
            var source = new BindingSource(bindingList, null);
            table.DataSource = source;
        }

        public void Update(object sender, UpdateEventArgs e)
        {
            BeginInvoke(new UpdateCallback(UpdateData));
        }

        private void UpdateData()
        {
            InitData();
        }

        public delegate void UpdateCallback();
    }
}
