using FlightReservations.controller;
using FlightReservations.model;
using FlightReservations.view;
using System;
using System.Windows.Forms;

namespace FlightReservations
{
    public partial class LoginView : Form
    {
        public LoginController LController;

        private TextBox usernameField;
        private TextBox passwordField;
        private Button loginBtn;


        public LoginView()
        {
            InitializeComponent();
            Width = 600;
            Height = 500;

            usernameField = new TextBox
            {
                Width = 100,
                Margin = new Padding(250, 0, 0, 10),
            };
            passwordField = new TextBox
            {
                Width = 100,
                Margin = new Padding(250, 0, 0, 10),
            };

            loginBtn = new Button
            {
                Text = "Log in",
                Width = 100,
                Margin = new Padding(250, 15, 0, 10),
            };
            loginBtn.Click += OnLoginClick;

            FlowLayoutPanel panel = new FlowLayoutPanel
            {
                FlowDirection = FlowDirection.TopDown,
                Width = 600,
                Height = 500,
                Controls =
                {
                    new Label
                    {
                        Text = "Username:",
                        Margin = new Padding(250, 150, 0, 0),
                    },
                    usernameField,
                    new Label
                    {
                        Text = "Password:",
                        Margin = new Padding(250, 0, 0, 0),
                    },
                    passwordField,
                    loginBtn
                }
            };

            Controls.Add(panel); 
        }



        private void OnLoginClick(object sender, EventArgs e)
        {
            string username = usernameField.Text;
            string password = passwordField.Text;
            try
            {
                LController.Login(new Agency(username, password));
                FlightView main = new FlightView(LController.FlightCtrl);
                main.Show();
                Hide();
            }
            catch (Exception ex)
            {
                MessageBox.Show("Login Error");
                Console.WriteLine(ex.StackTrace);
            }
        }
    }
}
