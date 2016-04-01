package Garits.Main;

import Data.*;
import Garits.GUI.Forms.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends JFrame {

    private Connection con;
    private MainGUI mainGUI;
    public Lists lists;
    private BookingPopup bookingPopup;
    private CustomerAccountsPopup customersPopup;
    private JobsPopUp jobsPopUp;
    private ManufacturerPopup manufacturerPopup;
    private StockPopup stockPopup;
    private UserPopup userPopup;
    private VehiclePopup vehiclePopup;
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

        lists = new Lists(this);

        add(lists);

        pack();
    }

    /* Parse the results */
    private void parseStock(ArrayList<Stock> stocks) {
        DefaultTableModel stockTable = (DefaultTableModel) lists.stockList.getModel();
        cleanList(stockTable);
        for (Stock s : stocks) {
            stockTable.addRow(new Object[]{s.ID, s.partName, s.quantity, s.price, s.threshold, s.pendingQuantity});
        }
    }

    private void parseCustomer(ArrayList<Customer> customers) {
        DefaultTableModel customerTable = (DefaultTableModel) lists.customerList.getModel();
        cleanList(customerTable);
        for (Customer c : customers) {
            customerTable.addRow(new Object[]{c.ID, c.dateRegistered, c.fName, c.lName, c.dob});
        }
    }

    private void parseBooking(ArrayList<Booking> bookings) {
        DefaultTableModel bookingsTable = (DefaultTableModel) lists.bookingList.getModel();
        cleanList(bookingsTable);
        for (Booking b : bookings) {
            bookingsTable.addRow(new Object[]{b.ID, b.customer.fName, b.customer.lName, b.type, b.dateBooked, b.quotedPrice, b.description});
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
            usersTable.addRow(new Object[]{u.ID, u.fName, u.lName, u.DOB, u.email});
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
                int dob = rs.getInt("DOB");
                String email = rs.getString("email");
                int reminderCount = rs.getInt("reminderCount");
                int responseRate = rs.getInt("responseRate");
                String vehicleIDs = rs.getString("VehicleID");

                ArrayList<Integer> count = new ArrayList<>();
                while (vehicleIDs.contains(",")) {
                    count.add(Integer.parseInt(vehicleIDs.substring(0, vehicleIDs.indexOf(","))));
                    vehicleIDs = vehicleIDs.substring(vehicleIDs.indexOf(",") + 1);
                }
                count.add(Integer.parseInt(vehicleIDs));

                Vehicle[] vehicleArray = new Vehicle[count.size()];
                for (int i = 0; i < count.size(); i++) {
                    vehicleArray[i] = getVehicle(count.get(i));
                }

                Customer c = new Customer(ID, dateRegistered, fName, lName, cName, address, city, pCode, tNumber, faxNumber, dob, email, reminderCount, responseRate, vehicleArray);
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
                String years = rs.getString("Years");
                int manufacturerID = rs.getInt("ManufacturerID");
                float price = rs.getFloat("Price");
                int threshold = rs.getInt("Threshold");
                int pendingQuantity = rs.getInt("pendingQuantity");
                int pendingDate = rs.getInt("pendingDate");
                Manufacturer manu = getManufacturer(manufacturerID);
                Stock s = new Stock(ID, quantity, partName, vType, years, manu, price, threshold, pendingQuantity, pendingDate);
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
                Booking b = new Booking(ID, customer, bType, description, dateBooked, expectedCompletionDate, quotedPrice, paidFor);
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
                User u = new User(ID, fName, lName, address, city, pCode, tNumber, email, DOB, username, password, accessLevel);
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

    public Stock getStock(int ID) {
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

    public Customer getCustomer(int ID) {
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

    private Vehicle getVehicle(int ID) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.ID == ID) {
                return vehicle;
            }
        }
        return null;
    }

    public Booking getBooking(int ID) {
        for (Booking booking : bookings) {
            if (booking.ID == ID) {
                return booking;
            }
        }
        return null;
    }

    public User getUser(int ID) {
        for (User user : users) {
            if (user.ID == ID) {
                return user;
            }
        }
        return null;
    }

    /* Making the buttons in the GUI work */
    public void bookingPopupSave(int _ID) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO bookings "
                + "(CustomerId, type, description, dateBooked, expectedCompletionDate, quotedPrice, paidFor) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?)");
        int ID = returnCustomerID(bookingPopup.customerNameField.getText(), bookingPopup.customerSurnameField.getText(), Integer.parseInt(bookingPopup.DOBTextField.getText()));
        if (ID != -1) {
            ps.setInt(1, ID);
            ps.setInt(2, bookingTypeToInt(bookingPopup.typeBox.getSelectedItem().toString()));
            ps.setString(3, bookingPopup.descriptionField.getText());
            ps.setString(4, bookingPopup.bookedField.getText());
            ps.setString(5, bookingPopup.dateFinishedField.getText());
            ps.setString(6, bookingPopup.priceField.getText());
            ps.setInt(7, (bookingPopup.paidForCheckbox.isSelected()) ? 1 : 0);
            ps.executeUpdate();
            System.out.println("Booking added to database");
        } else {
            System.out.println("Booking failed - Customer doesn't exist");
        }
    }

    private int bookingTypeToInt(String type) {
        switch (type) {
            case "Repair":
                return 0;
            case "MOT":
                return 1;
            case "Service":
                return 2;
            case "Special":
                return 3;
        }
        return -1;
    }

    public void customerPopupSave() throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO customer "
                + "(fName, lName, cName, dob, dateRegistered, address, city, pCode, tNumber, faxNumber, VehicleID) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        if (returnCustomerID(customersPopup.fNameTextField.getText(), customersPopup.lNameTextField.getText(), Integer.parseInt(customersPopup.dobTextField.getText())) == -1) {
            ps.setString(1, customersPopup.fNameTextField.getText());
            ps.setString(2, customersPopup.lNameTextField.getText());
            ps.setString(3, customersPopup.cNameTextField.getText());
            ps.setInt(4, Integer.parseInt(customersPopup.dobTextField.getText()));
            ps.setString(5, customersPopup.dateRegisteredTextField.getText());
            ps.setString(6, customersPopup.addressTextField1.getText() + " " + customersPopup.addressTextField2.getText());
            ps.setString(7, customersPopup.cityTextField.getText());
            ps.setString(8, customersPopup.pCodeTextField.getText());
            ps.setString(9, customersPopup.tNumberTextField.getText());
            ps.setString(10, customersPopup.fNumberTextField.getText());
            ps.setInt(11, -1);
            ps.executeUpdate();
            System.out.println("Customer Added");
        } else {
            System.out.println("Customer Already Exists");
        }
    }

    public void jobsPopupSave() throws SQLException {
        // TODO
    }

    public void manufacturerPopupSave() throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO manufacturer "
                + "(name, address, city, pCode, tNumber, faxNumber, website, email) "
                + "VALUES(?,?,?,?,?,?,?,?)");
        int ID = returnManufacturerID(manufacturerPopup.nameTextField.getText());
        if (ID != -1) {
            ps.setString(1, manufacturerPopup.nameTextField.getText());
            ps.setString(2, manufacturerPopup.addressTextField.getText());
            ps.setString(3, manufacturerPopup.cityTextField.getText());
            ps.setString(4, manufacturerPopup.postCodeTextField.getText());
            ps.setString(5, manufacturerPopup.tNumberTextField.getText());
            ps.setString(6, manufacturerPopup.fNumberTextField.getText());
            ps.setString(7, manufacturerPopup.websiteTextField.getText());
            ps.setString(8, manufacturerPopup.emailTextField.getText());
            ps.executeUpdate();
            System.out.println("Manufacturer Added");
        } else {
            System.out.println("Manufacturer Already Exists");
        }
    }

    public void stockPopupSave(int _ID) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO stock "
                + "(StockID, partName, vType, price, threshold, ManufacturerID, pendingDate, pendingQuantity, years) "
                + "VALUES(?,?,?,?,?,?,?,?,?)");
        int ID = returnStockID(stockPopup.partNameTextField.getText(), stockPopup.manuNameTextField.getText());
        if (ID != -1) {
            ps.setInt(1, ID);
            ps.setString(2, stockPopup.partNameTextField.getText());
            ps.setInt(3, vehicleTypeToInt(stockPopup.vTypeBox.getSelectedItem().toString()));
            ps.setString(4, stockPopup.priceTextField.getText());
            ps.setInt(5, Integer.parseInt(stockPopup.thresholdTextField.getText()));
            ps.setString(6, String.valueOf(returnManufacturerID(stockPopup.manuNameTextField.getText())));
            ps.setString(7, stockPopup.pendingDateTextField.getText());
            ps.setString(8, stockPopup.pendingQuantityTextField.getText());
            ps.setString(9, stockPopup.yearsTextBox.getText());
            ps.executeUpdate();
            System.out.println("Stock Added");
        } else {
            System.out.println("Stock Already Exists");
        }
    }

    private int returnManufacturerID(String name) {
        for (Manufacturer manufacturer : manufacturers) {
            if (manufacturer.name == null ? name == null : manufacturer.name.equals(name)) {
                return manufacturer.ID;
            }
        }
        return -1;
    }

    private int vehicleTypeToInt(String type) {
        switch (type) {
            case "Car":
                return 0;
            case "Van":
                return 1;
        }
        return -1;
    }

    public void userPopupSave() throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO users "
                + "(fName, lName, address, city, pCode, dob, tNumber) "
                + "VALUES(?,?,?,?,?,?,?)");
        int ID = returnEmployeeID(userPopup.fNameTextField.getText(), userPopup.lNameTextField.getText(), Integer.parseInt(userPopup.dobTextField.getText()));
        if (ID != -1) {
            ps.setString(1, userPopup.fNameTextField.getText());
            ps.setString(2, userPopup.lNameTextField.getText());
            ps.setString(3, userPopup.addressTextField.getText() + " " + userPopup.addressTextField2.getText());
            ps.setString(4, userPopup.cityTextField.getText());
            ps.setString(5, userPopup.pCodeTextField.getText());
            ps.setString(6, userPopup.dobTextField.getText());
            ps.setString(7, userPopup.tNumberTextField.getText());
            ps.executeUpdate();
            System.out.println("User Added");
        } else {
            System.out.println("User Already Exists");
        }

    }

    public void vehiclePopupSave() throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO vehicle "
                + "(rNumber, make, model, engineSerialNumber, chassisNumber, color, mileage) "
                + "VALUES(?,?,?,?,?,?,?)");
        int ID = returnVehicleID(vehiclePopup.regNumberTextField.getText());
        if (ID != -1) {
            ps.setString(1, vehiclePopup.regNumberTextField.getText());
            ps.setString(2, vehiclePopup.makeTextField.getText());
            ps.setString(3, vehiclePopup.modelTextField.getText());
            ps.setString(4, vehiclePopup.engSerialNumberTextField.getText());
            ps.setString(5, vehiclePopup.chasisNumberTextField.getText());
            ps.setString(6, vehiclePopup.colorTextField.getText());
            ps.setString(7, vehiclePopup.mileageTextField.getText());
            ps.executeUpdate();
            System.out.println("Vehicle Added");
        } else {
            System.out.println("Vehicle Already Exists");
        }
    }

    public void populateBookingPopup(Booking bookingFields) {
        //Fill in the Booking popup with values from the Booking object
        bookingPopup.customerNameField.setText(bookingFields.customer.fName);
        bookingPopup.customerSurnameField.setText(bookingFields.customer.lName);
        bookingPopup.DOBTextField.setText(Integer.toString(bookingFields.customer.dob));
        bookingPopup.typeBox.setSelectedItem(bookingFields.type);
        bookingPopup.bookedField.setText(Integer.toString(bookingFields.dateBooked));
        bookingPopup.priceField.setText(Float.toString(bookingFields.quotedPrice));
        bookingPopup.paidForCheckbox.setSelected(bookingFields.paidFor);
        bookingPopup.descriptionField.setText(bookingFields.description);
        bookingPopup.dateFinishedField.setText(Integer.toString(bookingFields.expectedCompletionDate));
    }

    public void populateStockPopup(Stock stockFields) {
        //Fill in the Booking popup with values from the Booking object
        stockPopup.partNameTextField.setText(stockFields.partName);
        stockPopup.vTypeBox.setSelectedItem(stockFields.vType);
        stockPopup.yearsTextBox.setText(stockFields.years);
        stockPopup.priceTextField.setText(Float.toString(stockFields.price));
        stockPopup.thresholdTextField.setText(Integer.toString(stockFields.threshold));
        stockPopup.manuNameTextField.setText(stockFields.manufacturer.name);
        stockPopup.pendingDateTextField.setText(Integer.toString(stockFields.pendingDate));
        stockPopup.pendingQuantityTextField.setText(Integer.toString(stockFields.pendingQuantity));
    }

    public void populateCustomerPopup(Customer customerFields) {
        customersPopup.fNameTextField.setText(customerFields.fName);
        customersPopup.addressTextField1.setText(customerFields.address);
        customersPopup.cityTextField.setText(customerFields.city);
        customersPopup.tNumberTextField.setText(customerFields.tNumber);
        customersPopup.cNameTextField.setText(customerFields.cName);
        customersPopup.dateRegisteredTextField.setText(customerFields.dateRegistered);
        customersPopup.lNameTextField.setText(customerFields.lName);
        customersPopup.pCodeTextField.setText(customerFields.pCode);
        customersPopup.fNumberTextField.setText(customerFields.faxNumber);
        customersPopup.dobTextField.setText(Integer.toString(customerFields.dob));
    }

    public void populateUserPopup(User userFields) {
        userPopup.fNameTextField.setText(userFields.fName);
        userPopup.addressTextField.setText(userFields.address);
        userPopup.cityTextField.setText(userFields.city);
        userPopup.tNumberTextField.setText(userFields.tNumber);
        userPopup.lNameTextField.setText(userFields.lName);
        userPopup.pCodeTextField.setText(userFields.pCode);
        userPopup.dobTextField.setText(Integer.toString(userFields.DOB));
    }

    //Create varius popups like BookingPopup
    public void showPopup(int type) {
        if (type == 0) {
            bookingPopup = new BookingPopup(this);
            bookingPopup.setVisible(true);
        } else if (type == 1) {
            customersPopup = new CustomerAccountsPopup(this);
            customersPopup.setVisible(true);
        } else if (type == 2) {
            jobsPopUp = new JobsPopUp(this);
            jobsPopUp.setVisible(true);
        } else if (type == 3) {
            manufacturerPopup = new ManufacturerPopup(this);
            manufacturerPopup.setVisible(true);
        } else if (type == 4) {
            stockPopup = new StockPopup(this);
            stockPopup.setVisible(true);
        } else if (type == 5) {
            userPopup = new UserPopup(this);
            userPopup.setVisible(true);
        } else if (type == 6) {
            vehiclePopup = new VehiclePopup(this);
            vehiclePopup.setVisible(true);
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
            populateVehicle();
            populateCustomer();
            populateUsers();
            populateManufacturer();
            populateStock();
            populateBooking();
            populateJob();
            populateReminder();
            populateJobInvoice();
            //showPopup(0);
        } else {
            mainGUI.redLabel.setText("Incorrect Username or Password");
        }
    }

    private int returnCustomerID(String name, String surname, int dob) {
        for (Customer customer : customers) {
            if ((customer.fName == null ? name == null : customer.fName.equals(name))
                    && (customer.lName == null ? surname == null : customer.lName.equals(surname))
                    && (customer.dob == dob)) {
                return customer.ID;
            }
        }
        return -1;
    }

    private int returnStockID(String partName, String manuName) {
        for (Stock stock : stocks) {
            if ((stock.partName == null ? partName == null : stock.partName.equals(partName))
                    && (stock.manufacturer.name == null ? manuName == null : stock.manufacturer.name.equals(manuName))) {
                return stock.ID;
            }
        }
        return -1;
    }

    private int returnEmployeeID(String name, String surname, int dob) {
        for (User user : users) {
            if ((user.fName == null ? name == null : user.fName.equals(name))
                    && (user.lName == null ? surname == null : user.lName.equals(surname))
                    && (user.DOB == dob)) {
                return user.ID;
            }
        }
        return -1;
    }

    private int returnVehicleID(String rNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.rNumber == null ? rNumber == null : vehicle.rNumber.equals(rNumber)) {
                return vehicle.ID;
            }
        }
        return -1;
    }
}
