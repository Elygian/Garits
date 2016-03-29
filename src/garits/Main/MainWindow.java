package Garits.Main;

import Data.*;
import Garits.GUI.BookingPopup;
import Garits.GUI.Forms.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends JFrame {

    private Connection con;
    private MainGUI mainGUI;
    private Lists lists;
    private Garits.GUI.Forms.BookingPopup bookingPopup;
    private static final String URL = ("jdbc:mysql://173.194.234.254:3306/garits?user=team");

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new MainWindow("Tom");
    }
    private ArrayList<Customer> customers;
    private ArrayList<Stock> stocks;
    private ArrayList<Booking> bookings;
    private ArrayList<Job> jobs;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Reminder> reminders;
    private ArrayList<Manufacturer> manufacturers;
    private ArrayList<User> users;
    private ArrayList<JobInvoice> invoices;

    public MainWindow(String name) throws SQLException, ClassNotFoundException {
        super(name);

        setup();
    }

    //Creates MainGUI, Setups up Frame
    private void setup() throws SQLException, ClassNotFoundException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Garits.GUI.BookingPopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainGUI = new MainGUI(this);

        add(mainGUI);

        pack();

        setVisible(true);

        connectToDB();
    }

    //Hide MainGUI, create List
    public void showLists() {
        remove(mainGUI);

        lists = new Lists();

        add(lists);

        pack();
    }

    /* Parse the results */
    private void parseStock(ArrayList<Stock> stocks) {
        DefaultTableModel stockTable = (DefaultTableModel) lists.stockList.getModel();
        cleanList(stockTable);
        for (Stock s : stocks) {
            stockTable.addRow(new Object[]{s.partName, s.quantity, s.price, s.threshold, s.pendingQuantity});
        }
    }

    private void parseCustomer(ArrayList<Customer> customers) {
        DefaultTableModel customerTable = (DefaultTableModel) lists.customerList.getModel();
        cleanList(customerTable);
        for (Customer c : customers) {
            customerTable.addRow(new Object[]{c.dateRegistered, c.fName, c.lName, c.dob});
        }
    }

    private void parseBooking(ArrayList<Booking> bookings) {
        DefaultTableModel bookingsTable = (DefaultTableModel) lists.bookingList.getModel();
        cleanList(bookingsTable);
        for (Booking b : bookings) {
            bookingsTable.addRow(new Object[]{b.customer.fName, b.customer.lName, b.type, b.dateBooked, b.quotedPrice, b.description});
        }
    }

    private void parseJob(ArrayList<Job> jobs) {
        DefaultTableModel jobsTable = (DefaultTableModel) lists.jobList.getModel();
        cleanList(jobsTable);
        for (Job j : jobs) {
            jobsTable.addRow(new Object[]{j.ID, j.dateCreated, j.dateDue, j.detailedDescription, j.duration, j.price});
        }
    }

    private void parseUsers(ArrayList<User> users) {
        DefaultTableModel usersTable = (DefaultTableModel) lists.usersList.getModel();
        cleanList(usersTable);
        for (User u : users) {
            usersTable.addRow(new Object[]{u.fName, u.lName, u.DOB, u.email});
        }
    }

    /* Clean the lists - fixes a bug */
    private void cleanList(DefaultTableModel model) {

        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    /* Populate lists by fetching data from Database */
    private void populateCustomer() throws SQLException {
        if (con != null) {
            PreparedStatement ps
                    = con.prepareStatement("SELECT * FROM customer");
            ResultSet rs = ps.executeQuery();
            customers = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("CustomerID");
                String dateRegistered = rs.getString("dateRegistered");
                String fName = rs.getString("fName");
                String lName = rs.getString("lName");
                String cName = rs.getString("cName");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String pCode = rs.getString("pCode");
                String tNumber = rs.getString("tNumber");
                String faxNumber = rs.getString("faxNumber");
                String dob = rs.getString("DOB");
                String email = rs.getString("email");
                int reminderCount = rs.getInt("reminderCount");
                int responseRate = rs.getInt("responseRate");
                Customer c = new Customer(ID, dateRegistered, fName, lName, cName, address, city, pCode, tNumber, faxNumber, dob, email, reminderCount, responseRate, new Vehicle());
                customers.add(c);
            }
            parseCustomer(customers);
        }
    }

    private void populateStock() throws SQLException {
        if (con != null) {
            PreparedStatement ps
                    = con.prepareStatement("SELECT * FROM stock");
            ResultSet rs = ps.executeQuery();
            stocks = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("StockID");
                int quantity = rs.getInt("quantity");
                String partName = rs.getString("partName");
                int vType = rs.getInt("vType");
                String years = rs.getString("years");
                int manufacturerID = rs.getInt("ManufacturerID");
                float price = rs.getFloat("Price");
                int threshold = rs.getInt("Threshold");
                int pendingQuantity = rs.getInt("pendingQuantity");
                int pendingDate = rs.getInt("pendingDate");
                Manufacturer manu = getManufacturer(manufacturerID);
                Stock s = new Stock(ID, quantity, partName, vType, years, manu, price, threshold, pendingQuantity, pendingDate, new Manufacturer()
                );
                stocks.add(s);
            }
            parseStock(stocks);
        }
    }

    private void populateBooking() throws SQLException {
        if (con != null) {
            PreparedStatement ps
                    = con.prepareStatement("SELECT * FROM bookings");
            ResultSet rs = ps.executeQuery();
            bookings = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("BookingsID");
                Customer customer = getCustomer(rs.getInt("CustomerID"));
                int bType = rs.getInt("type");
                String description = rs.getString("description");
                int dateBooked = rs.getInt("dateBooked");
                int expectedCompletionDate = rs.getInt("expectedCompletionDate");
                float quotedPrice = rs.getFloat("quotedPrice");
                boolean paidFor = rs.getBoolean("paidFor");
                Booking b = new Booking(ID, new Vehicle(), customer, bType, description, dateBooked, expectedCompletionDate, quotedPrice, paidFor);
                bookings.add(b);
            }
            parseBooking(bookings);
        }
    }

    private void populateJob() throws SQLException {
        if (con != null) {
            PreparedStatement ps
                    = con.prepareStatement("SELECT * FROM job");
            ResultSet rs = ps.executeQuery();
            jobs = new ArrayList<>();
            while (rs.next()) {
                String stockIDs = rs.getString("StockID");
                int ID = rs.getInt("JobID");
                int dateCreated = rs.getInt("dateCreated");
                int dateDue = rs.getInt("dateDue");
                String initialDescription = rs.getString("initialDescription");
                String detailedDescription = rs.getString("detailedDescription");
                int duration = rs.getInt("duration");
                float price = rs.getFloat("price");

                ArrayList<Integer> count = new ArrayList<>();
                while (stockIDs.contains(",")) {
                    count.add(Integer.parseInt(stockIDs.substring(0, stockIDs.indexOf(","))));
                    stockIDs = stockIDs.substring(stockIDs.indexOf(",") + 1);
                }
                count.add(Integer.parseInt(stockIDs));

                Stock[] stockArray = new Stock[count.size()];
                for (int i = 0; i < count.size(); i++) {
                    stockArray[i] = getStock(count.get(i));
                }

                Job j = new Job(ID, dateCreated, dateDue, initialDescription, detailedDescription, stockArray, duration, price, new Vehicle());
                jobs.add(j);
            }
            parseJob(jobs);
        }
    }

    private void populateVehicle() throws SQLException {
        if (con != null) {
            PreparedStatement ps
                    = con.prepareStatement("SELECT * from vehicle");
            ResultSet rs = ps.executeQuery();
            vehicles = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("VehicleID");
                String rNumber = rs.getString("rNumber");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String engineSerialNumber = rs.getString("engineSerialNumber");
                String chasisNumber = rs.getString("chassisNumber");
                String color = rs.getString("color");
                int mileage = rs.getInt("mileage");

                Vehicle v = new Vehicle(ID, rNumber, make, model, engineSerialNumber, chasisNumber, color, mileage);
                vehicles.add(v);
            }
        }
    }

    private void populateReminder() throws SQLException {
        if (con != null) {
            PreparedStatement ps
                    = con.prepareStatement("SELECT * FROM reminder");
            ResultSet rs = ps.executeQuery();
            reminders = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("ReminderID");
                String type = rs.getString("type");
                String title = rs.getString("title");
                String message = rs.getString("message");

                Reminder r = new Reminder(ID, type, title, message);
                reminders.add(r);
            }
        }
    }

    private void populateManufacturer() throws SQLException {
        if (con != null) {
            PreparedStatement ps
                    = con.prepareStatement("SELECT * FROM manufacturer");
            ResultSet rs = ps.executeQuery();
            manufacturers = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("ManufacturerID");
                String manuName = rs.getString("name");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String pCode = rs.getString("pCode");
                String tNumber = rs.getString("tNumber");
                String faxNumber = rs.getString("faxNumber");
                String website = rs.getString("website");
                String email = rs.getString("email");

                Manufacturer m = new Manufacturer(ID, manuName, address, city, pCode, tNumber, faxNumber, website, email);
                manufacturers.add(m);
            }
        }
    }

    private void populateUsers() throws SQLException {
        if (con != null) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();
            users = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("UserID");
                String fName = rs.getString("fName");
                String lName = rs.getString("lName");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String pCode = rs.getString("pCode");
                String tNumber = rs.getString("tNumber");
                String email = rs.getString("email");
                int DOB = rs.getInt("DOB");
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                int accessLevel = rs.getInt("AccessLevel");
                User u = new User(ID, fName, lName, address, city, pCode, tNumber, email,
                        DOB, username, password, accessLevel);
                users.add(u);
            }
            parseUsers(users);
        }
    }

    private void populateJobInvoice() throws SQLException {
        if (con != null) {
            PreparedStatement ps
                    = con.prepareStatement("SELECT * FROM jobinvoice");
            ResultSet rs = ps.executeQuery();
            invoices = new ArrayList<>();
            while (rs.next()) {
                String stockIDs = rs.getString("StockID");
                int ID = rs.getInt("InvoiceID");
                String message = rs.getString("message");
                Customer customer = getCustomer(rs.getInt("CustomerID"));
                Job job = getJob(rs.getInt("JobID"));

                ArrayList<Integer> count = new ArrayList<>();
                while (stockIDs.contains(",")) {
                    count.add(Integer.parseInt(stockIDs.substring(0, stockIDs.indexOf(","))));
                    stockIDs = stockIDs.substring(stockIDs.indexOf(",") + 1);
                }
                count.add(Integer.parseInt(stockIDs));

                Stock[] stockArray = new Stock[count.size()];
                for (int i = 0; i < count.size(); i++) {
                    stockArray[i] = getStock(count.get(i));
                }

                JobInvoice i = new JobInvoice(ID, message, customer, stockArray, job);
                invoices.add(i);
            }
        }
    }

    private Stock getStock(int ID) {
        for (Stock stock : stocks) {
            if (stock.ID == ID) {
                return stock;
            }
        }
        return null;
    }

    private Manufacturer getManufacturer(int ID) {
        for (Manufacturer manufacturer : manufacturers) {
            if (manufacturer.ID == ID) {
                return manufacturer;
            }
        }
        return null;
    }

    private Customer getCustomer(int ID) {
        for (Customer customer : customers) {
            if (customer.ID == ID) {
                return customer;
            }
        }
        return null;
    }

    private Job getJob(int ID) {
        for (Job job : jobs) {
            if (job.ID == ID) {
                return job;
            }
        }
        return null;
    }

    /* Making the buttons in the GUI work */
    /*public void bookingPopupSave() throws SQLException {
        if (con != null) {
            PreparedStatement ps = con.prepareStatement("INSERT "
                    + "type, description, dateBooked, expectedCompletionDate, quotedPrice, paidFor"
                    + "INTO booking WHERE"
                    + "");
            if(doesCustomerExist(bookingPopup.customerNameField.getText(), bookingPopup.customerSurnameField.getText(), bookingPopup.DOBTextField.getText())){
            ps.setString(1, bookingPopup.customerNameField.getText());
            ps.setString(2, bookingPopup.customerSurnameField.getText());
            ps.setString(3, bookingPopup.DOBTextField.getText());
            ps.setString(3, bookingPopup.vehicleRegField.getText());
            ps.setString(4, bookingPopup.typeBox.getSelectedItem().toString());
            ps.setString(5, bookingPopup.descriptionField.getText());
            ps.setString(6, bookingPopup.bookedField.getText());
            ps.setString(7, bookingPopup.dateFinishedField.getText());
            ps.setString(8, bookingPopup.priceField.getText());
            ps.setString(9, Boolean.toString(bookingPopup.paidForCheckbox.isSelected()));
            System.out.println("Booking added to database");
            }else{
                System.out.println("Booking failed");
            }

            ResultSet rs = ps.executeQuery();
        }
    }*/

    //Create varius popups like BookingPopup
    public void showPopup(int type) {
        if (type == 0) {
            BookingPopup bookingPopup = new BookingPopup();
        } else if (type == 1) {
            CustomerAccountsPopup customerAccounts = new CustomerAccountsPopup();
        } else if (type == 2) {
            JobsPopUp jobsPopUp = new JobsPopUp();
        } else if (type == 3) {
            ManufacturerPopup manufacturerPopup = new ManufacturerPopup();
        } else if (type == 4) {
            StockPopup stockPopup = new StockPopup();
        } else if (type == 5) {
            VehiclePopup vehiclePopup = new VehiclePopup();
        }
    }

    //Override pack to go fullscreen on call
    @Override
    public void pack() {
        super.pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    //Connects to remote database and saves it as con
    private void connectToDB() throws ClassNotFoundException, SQLException {
        System.out.println("Connecting to database...");

        try {
            con = DriverManager.getConnection(URL);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            System.out.println("Can't Connect at: " + URL);
        }
    }

    //Called in MainGUI
    public boolean login(String username, String password) throws SQLException {
        if (con != null) {
            boolean loggedIn = false;
            PreparedStatement ps = con.prepareStatement("SELECT Username, Password FROM users WHERE Username=? AND Password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                if (username.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
                    loggedIn = true;
                    System.out.println("Logged In");
                }
            } else {
                System.out.println("Nope Nope Nope Nope");
            }
            return loggedIn;
        }
        return false;
    }

    //Calls login and handles outcome
    public void verifyLogin(String name, String pw) throws SQLException {
        if (login(name, pw.replace("[", "").replace("]", ""))) {
            showLists();
            populateCustomer();
            populateUsers();
            populateManufacturer();
            populateStock();
            populateBooking();
            populateJob();
            populateVehicle();
            populateReminder();
            populateJobInvoice();
            //showPopup(0);
        } else {
            mainGUI.redLabel.setText("Incorrect Username or Password");
        }
    }
    
    private boolean doesCustomerExist(String name, String surname, String dob){
        for(Customer customer: customers){
            if((customer.fName == null ? name == null : customer.fName.equals(name))
                    || (customer.lName == null ? surname == null : customer.lName.equals(surname))
                    || (customer.dob == null ? dob == null : customer.dob.equals(dob))){
                return true;
            }
        }        
        return false;
    }
}
