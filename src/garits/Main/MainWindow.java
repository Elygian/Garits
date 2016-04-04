package Garits.Main;

import Data.*;
import Garits.GUI.Forms.*;
import java.awt.Dimension;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends JFrame {

    private Connection con;
    private MainGUI mainGUI;
    public Lists lists;
    private BookingPopup bookingPopup;
    public CustomerAccountsPopup customersPopup;
    private JobsPopUp jobsPopUp;
    private ManufacturerPopup manufacturerPopup;
    private StockPopup stockPopup;
    private UserPopup userPopup;
    private VehiclePopup vehiclePopup;
    private static final String URL = ("jdbc:mysql://173.194.234.254:3306/garits?user=team");
    //private static final String URL = ("jdbc:mysql://localhost/garits");
    private static final String USER = "";
    private static final String PW = "";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MainWindow mainWindow = new MainWindow("Tom");
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
    public Dimension size;

    public MainWindow(String name) throws SQLException, ClassNotFoundException {
        super(name);
        setup();
        size = getSize();
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
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainGUI = new MainGUI(this);

        add(mainGUI);

        pack();

        setVisible(true);

        connectToDB();

        verifyLogin("Penelope", "PinkMobile");
    }

    //Hide MainGUI, create List
    public void showLists() {
        remove(mainGUI);

        lists = new Lists(this);

        add(lists);

        pack();
    }

    /* Parse the results */
    private void parseStock(ArrayList<Stock> stocks, String search) {
        DefaultTableModel stockTable = (DefaultTableModel) lists.stockList.getModel();
        cleanList(stockTable);
        for (Stock s : stocks) {
            if (dataContainsString(s, search)) {
                stockTable.addRow(new Object[]{s.ID, s.partName, s.quantity, s.years, s.price, s.threshold, s.pendingQuantity});
            }
        }
    }

    private void parseCustomer(ArrayList<Customer> customers, String search) {
        DefaultTableModel customerTable = (DefaultTableModel) lists.customerList.getModel();
        cleanList(customerTable);
        for (Customer c : customers) {
            if (dataContainsString(c, search)) {
                customerTable.addRow(new Object[]{c.ID, c.fName, c.lName, c.dob, c.dateRegistered});
            }
        }
    }

    private void parseBooking(ArrayList<Booking> bookings, String search) {
        DefaultTableModel bookingsTable = (DefaultTableModel) lists.bookingList.getModel();
        cleanList(bookingsTable);
        for (Booking b : bookings) {
            if (dataContainsString(b, search)) {
                bookingsTable.addRow(new Object[]{b.ID, b.customer.fName, b.customer.lName, b.type, b.dateBooked, b.quotedPrice, b.description});
            }
        }

    }

    private void parseJob(ArrayList<Job> jobs, String search) {
        DefaultTableModel jobsTable = (DefaultTableModel) lists.jobList.getModel();
        cleanList(jobsTable);
        for (Job j : jobs) {
            if (dataContainsString(j, search)) {
                jobsTable.addRow(new Object[]{j.ID, j.dateCreated, j.dateDue, j.detailedDescription, j.duration, j.price});
            }
        }
    }

    private void parseUsers(ArrayList<User> users, String search) {
        DefaultTableModel usersTable = (DefaultTableModel) lists.usersList.getModel();
        cleanList(usersTable);
        for (User u : users) {
            if (dataContainsString(u, search)) {
                usersTable.addRow(new Object[]{u.ID, u.username, u.pWord, u.DOB, u.email});

            }
        }
    }

    private void parseVehicle(ArrayList<Vehicle> vehicles, String search) {
        DefaultTableModel vehicleTable = (DefaultTableModel) lists.vehicleList.getModel();
        cleanList(vehicleTable);
        for (Vehicle u : vehicles) {
            if (dataContainsString(u, search)) {
                vehicleTable.addRow(new Object[]{u.ID, u.rNumber, u.vType, u.make, u.model});
            }
        }
    }

    private boolean dataContainsString(StringComparable data, String search) {
        if (Lists.DEFAULT_TEXT.equals(search) || search == null || "".equals(search)) {
            return true;
        }
        return data.toComparisonString().contains(search);
    }

    /* Clean the lists - fixes a bug */
    private void cleanList(DefaultTableModel model) {

        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    /* Populate lists by fetching data from Database */
    public void populateCustomer(String search) throws SQLException {
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
                String vehicleIDs = rs.getString("VehicleID");

                ArrayList<Vehicle> vehicleArray = new ArrayList<>();
                if (vehicleIDs.length() > 0) {
                    ArrayList<Integer> count = new ArrayList<>();
                    while (vehicleIDs.contains(",")) {
                        count.add(Integer.parseInt(vehicleIDs.substring(0, vehicleIDs.indexOf(","))));
                        vehicleIDs = vehicleIDs.substring(vehicleIDs.indexOf(",") + 1);
                    }
                    count.add(Integer.parseInt(vehicleIDs));

                    for (int i = 0; i < count.size(); i++) {
                        vehicleArray.add(getVehicle(count.get(i)));
                    }
                }

                Customer c = new Customer(ID, dateRegistered, fName, lName, cName, address, city, pCode, tNumber, faxNumber, dob, email, reminderCount, responseRate, vehicleArray);
                customers.add(c);
            }
            parseCustomer(customers, search);
        }
    }

    public void populateStock(String search) throws SQLException {
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
                float price = rs.getFloat("Price");
                int threshold = rs.getInt("Threshold");
                int pendingQuantity = rs.getInt("pendingQuantity");
                String pendingDate = rs.getString("pendingDate");
                int manufacturerID = rs.getInt("ManufacturerID");
                Manufacturer manu = getManufacturer(manufacturerID);
                Stock s = new Stock(ID, quantity, partName, vType, years, manu, price, threshold, pendingQuantity, pendingDate);
                stocks.add(s);
            }
            parseStock(stocks, search);
        }
    }

    public void populateBooking(String search) throws SQLException {
        if (con != null) {
            PreparedStatement ps
                    = con.prepareStatement("SELECT * FROM bookings");
            ResultSet rs = ps.executeQuery();
            bookings = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("BookingsID");
                Customer customer = getCustomer(rs.getInt("CustomerID"));
                String bType = intToBookingType(rs.getInt("type"));
                String description = rs.getString("description");
                String dateBooked = rs.getString("dateBooked");
                String expectedCompletionDate = rs.getString("expectedCompletionDate");
                float quotedPrice = rs.getFloat("quotedPrice");
                boolean paidFor = rs.getBoolean("paidFor");
                Booking b = new Booking(ID, customer, bType, description, dateBooked, expectedCompletionDate, quotedPrice, paidFor);
                bookings.add(b);
            }
            parseBooking(bookings, search);
        }
    }

    public void populateJob(String search) throws SQLException {
        if (con != null) {
            PreparedStatement ps
                    = con.prepareStatement("SELECT * FROM job");
            ResultSet rs = ps.executeQuery();
            jobs = new ArrayList<>();
            while (rs.next()) {
                String stockIDs = rs.getString("StockID");
                int ID = rs.getInt("JobID");
                String dateCreated = rs.getString("dateCreated");
                String dateDue = rs.getString("dateDue");
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
            parseJob(jobs, search);
        }
    }

    public void populateVehicle(String search) throws SQLException {
        if (con != null) {
            PreparedStatement ps
                    = con.prepareStatement("SELECT * from vehicle");
            ResultSet rs = ps.executeQuery();
            vehicles = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("VehicleID");
                String rNumber = rs.getString("rNumber");
                String make = rs.getString("make");
                String vType = intToVehicleType(rs.getInt("vType"));
                String model = rs.getString("model");
                String engineSerialNumber = rs.getString("engineSerialNumber");
                String chasisNumber = rs.getString("chassisNumber");
                String color = rs.getString("color");
                int mileage = rs.getInt("mileage");
                Vehicle v = new Vehicle(ID, vType, rNumber, make, model, engineSerialNumber, chasisNumber, color, mileage, null);
                vehicles.add(v);
            }
            parseVehicle(vehicles, search);
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

    public void populateUsers(String search) throws SQLException {
        if (con != null) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();
            users = new ArrayList<>();
            while (rs.next()) {
                int ID = rs.getInt("UserID");
                String username = rs.getString("username");
                String password = rs.getString("Password");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String pCode = rs.getString("pCode");
                String tNumber = rs.getString("tNumber");
                String email = rs.getString("email");
                String DOB = rs.getString("DOB");
                int accessLevel = rs.getInt("AccessLevel");
                User u = new User(ID, username, password, address, city, pCode, tNumber, email, DOB, accessLevel);
                users.add(u);
            }
            parseUsers(users, search);
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

    public Manufacturer getManufacturer(int ID) {
        for (Manufacturer manufacturer : manufacturers) {
            if (manufacturer.ID == ID) {
                return manufacturer;
            }
        }
        return null;
    }

    public Manufacturer getManufacturerFromName(String s) {
        for (Manufacturer manufacturer : manufacturers) {
            if (manufacturer.name == null ? s == null : manufacturer.name.equals(s)) {
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

    public Vehicle getVehicle(int ID) {
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
        int ID = returnCustomerID(bookingPopup.customerNameField.getText(), bookingPopup.customerSurnameField.getText(), bookingPopup.DOBTextField.getText());
        if (ID != -1) {
            // Customer exists
            System.out.println("Customer Exists");
            if (_ID == -1) {
                // Add customer
                ps.setInt(1, ID);
                ps.setInt(2, bookingTypeToInt(bookingPopup.typeBox.getSelectedItem().toString()));
                ps.setString(3, bookingPopup.descriptionField.getText());
                ps.setString(4, bookingPopup.bookedField.getText());
                ps.setString(5, bookingPopup.dateFinishedField.getText());
                ps.setString(6, bookingPopup.priceField.getText());
                ps.setInt(7, (bookingPopup.paidForCheckbox.isSelected()) ? 1 : 0);
                ps.executeUpdate();
                System.out.println("New Booking Added");
                bookingPopup.setVisible(false);
                populateBooking(null);
            } else {
                PreparedStatement updateStatement = con.prepareStatement("UPDATE bookings "
                        + "SET dateBooked=?, expectedCompletionDate=?, quotedPrice=?, paidFor=?, type=?, description=? "
                        + "WHERE BookingsID=" + _ID);
                updateStatement.setString(1, bookingPopup.bookedField.getText());
                updateStatement.setString(2, bookingPopup.dateFinishedField.getText());
                updateStatement.setString(3, bookingPopup.priceField.getText());
                updateStatement.setInt(4, (bookingPopup.paidForCheckbox.isSelected()) ? 1 : 0);
                updateStatement.setInt(5, bookingTypeToInt(bookingPopup.typeBox.getSelectedItem().toString()));
                updateStatement.setString(6, bookingPopup.descriptionField.getText());
                updateStatement.executeUpdate();
                bookingPopup.setVisible(false);
                populateBooking(null);
                // Modify Customer
                System.out.println("Booking Modified");
            }
        } else {
            // Customer doesnt exist
            System.out.println("Booking Failed - Customer doesn't exist!");
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

    private String intToBookingType(int type) {
        switch (type) {
            case 0:
                return "Repair";
            case 1:
                return "MOT";
            case 2:
                return "Service";
            case 3:
                return "Special";
        }
        return null;
    }

    public void customerPopupSave(int _ID) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO customer "
                + "(fName, lName, cName, dob, dateRegistered, address, city, pCode, tNumber, faxNumber, email, VehicleID) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        int ID = returnCustomerID(customersPopup.fNameTextField.getText(), customersPopup.lNameTextField.getText(), customersPopup.dobTextField.getText());
        if (_ID == -1 && ID == -1) {
            ps.setString(1, customersPopup.fNameTextField.getText());
            ps.setString(2, customersPopup.lNameTextField.getText());
            ps.setString(3, customersPopup.cNameTextField.getText());
            ps.setInt(4, Integer.parseInt(customersPopup.dobTextField.getText()));
            ps.setString(5, customersPopup.dateRegisteredTextField.getText());
            ps.setString(6, customersPopup.addressTextField.getText());
            ps.setString(7, customersPopup.cityTextField.getText());
            ps.setString(8, customersPopup.pCodeTextField.getText());
            ps.setString(9, customersPopup.tNumberTextField.getText());
            ps.setString(10, customersPopup.fNumberTextField.getText());
            ps.setString(11, customersPopup.emailTextField.getText());
            String vehicleIDs = "";
            if (ID != -1) {
                for (Vehicle v : getCustomer(ID).vehicle) {
                    vehicleIDs += v.ID + ", ";
                }
            }
            ps.setString(12, vehicleIDs);
            ps.executeUpdate();
            populateCustomer(null);
            System.out.println("Customer Added");
            return;
        } else if (_ID != -1 && ID != -1) {
            PreparedStatement updateStatement = con.prepareStatement("UPDATE customer "
                    + "SET fName=?, dateRegistered=?, lName=?, pCode=?, faxNumber=?, dob=?, address=?, city=?, tNumber=?, cName=?, email=?"
                    + "WHERE CustomerID=" + _ID);
            updateStatement.setString(1, customersPopup.fNameTextField.getText());
            updateStatement.setString(2, customersPopup.dateRegisteredTextField.getText());
            updateStatement.setString(3, customersPopup.lNameTextField.getText());
            updateStatement.setString(4, customersPopup.pCodeTextField.getText());
            updateStatement.setString(5, customersPopup.fNumberTextField.getText());
            updateStatement.setString(6, customersPopup.dobTextField.getText());
            updateStatement.setString(7, customersPopup.addressTextField.getText());
            updateStatement.setString(8, customersPopup.cityTextField.getText());
            updateStatement.setString(9, customersPopup.tNumberTextField.getText());
            updateStatement.setString(10, customersPopup.cNameTextField.getText());
            updateStatement.setString(11, customersPopup.emailTextField.getText());
            updateStatement.executeUpdate();
            populateCustomer(null);
            // Modify Customer
            System.out.println("Customer Modified");
            return;
        }
        //Customer already exists
    }

    public void jobsPopupSave() throws SQLException {
        // TODO

    }

    public void manufacturerPopupSave() throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO manufacturer "
                + "(name, address, city, pCode, tNumber, faxNumber, website, email) "
                + "VALUES(?,?,?,?,?,?,?,?)");
        int ID = returnManufacturerID(manufacturerPopup.nameTextField.getText());
        if (ID == -1) {
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
                + "(StockID, partName, vType, price, threshold, ManufacturerID, pendingDate, pendingQuantity, years, quantity) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?)");
        int ID = returnStockID(stockPopup.partNameTextField.getText(), stockPopup.manuNameTextField.getText());
        if (_ID == -1 && ID == -1) {
            // Add stock
            ps.setInt(1, ID);
            ps.setString(2, stockPopup.partNameTextField.getText());
            ps.setInt(3, vehicleTypeToInt(stockPopup.vTypeBox.getSelectedItem().toString()));
            ps.setString(4, stockPopup.priceTextField.getText());
            ps.setInt(5, Integer.parseInt(stockPopup.thresholdTextField.getText()));
            ps.setString(6, String.valueOf(returnManufacturerID(stockPopup.manuNameTextField.getText())));
            ps.setString(7, stockPopup.pendingDateTextField.getText());
            ps.setString(8, stockPopup.pendingQuantityTextField.getText());
            ps.setString(9, stockPopup.yearsTextBox.getText());
            ps.setString(10, stockPopup.quantityField.getText());
            ps.executeUpdate();
            System.out.println("Stock added to database");
            populateStock(null);
        } else if (_ID != -1 && ID != -1) {
            PreparedStatement updateStatement = con.prepareStatement("UPDATE stock "
                    + "SET partName=?, vType=?, Years=?, price=?, Threshold=?, pendingDate=?, pendingQuantity=?, quantity=?"
                    + "WHERE StockID=" + _ID);
            updateStatement.setString(1, stockPopup.partNameTextField.getText());
            updateStatement.setInt(2, vehicleTypeToInt(stockPopup.vTypeBox.getSelectedItem().toString()));
            updateStatement.setString(3, stockPopup.yearsTextBox.getText());
            updateStatement.setString(4, (stockPopup.priceTextField.getText()));
            updateStatement.setString(5, (stockPopup.thresholdTextField.getText()));
            updateStatement.setString(6, (stockPopup.pendingDateTextField.getText()));
            updateStatement.setString(7, (stockPopup.pendingQuantityTextField.getText()));
            updateStatement.setString(8, (stockPopup.quantityField.getText()));
            updateStatement.executeUpdate();
            populateStock(null);
            // Modify Customer
            System.out.println("Stock Modified");
        } else {
            // Customer doesnt exist
            System.out.println("@Stock doesn't exist@");
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
            case "e-Car":
                return 2;
            case "Motorbike":
                return 3;
        }
        return -1;
    }

    private String intToVehicleType(int type) {
        switch (type) {
            case 0:
                return "Car";
            case 1:
                return "Van";
            case 2:
                return "e-Car";
            case 3:
                return "Motorbike";
        }
        return null;
    }

    public void userPopupSave(int _ID) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO users "
                + "(username, password, address, city, pCode, dob, tNumber,email,AccessLevel) "
                + "VALUES(?,?,?,?,?,?,?,?,?)");
        int ID = returnEmployeeID(userPopup.fNameTextField.getText(), userPopup.dobTextField.getText());
        if (_ID == -1 && ID == -1) {
            ps.setString(1, userPopup.fNameTextField.getText());
            ps.setString(2, String.valueOf(userPopup.passwordField.getPassword()));
            ps.setString(3, userPopup.addressTextField.getText());
            ps.setString(4, userPopup.cityTextField.getText());
            ps.setString(5, userPopup.pCodeTextField.getText());
            ps.setString(6, userPopup.dobTextField.getText());
            ps.setString(7, userPopup.tNumberTextField.getText());
            ps.setString(8, userPopup.emailTextField.getText());
            ps.setInt(9, Integer.parseInt(userPopup.accessLevelTextField.getText()));
            ps.executeUpdate();
            populateUsers(null);
            System.out.println("User Added");
        } else if (_ID != -1 && ID != -1) {
            PreparedStatement updateStatement = con.prepareStatement("UPDATE users "
                    + "SET username=?, Password=?, address=?, pCode=?, city=?, DOB=?, AccessLevel=?, email=?"
                    + "WHERE UserID=" + _ID);
            updateStatement.setString(1, userPopup.fNameTextField.getText());
            updateStatement.setString(2, String.valueOf(userPopup.passwordField.getPassword()));
            updateStatement.setString(3, userPopup.addressTextField.getText());
            updateStatement.setString(4, userPopup.pCodeTextField.getText());
            updateStatement.setString(5, userPopup.cityTextField.getText());
            updateStatement.setString(6, userPopup.dobTextField.getText());
            updateStatement.setString(7, userPopup.accessLevelTextField.getText());
            updateStatement.setString(8, userPopup.emailTextField.getText());
            updateStatement.executeUpdate();
            populateUsers(null);
            // Modify User
            System.out.println("User Modified");
        }
        // User doesn't exist
    }

    public void vehiclePopupSave(int _ID, Customer customer) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO vehicle "
                + "(rNumber, make, model, engineSerialNumber, chassisNumber, color, mileage, vType, CustomerID) "
                + "VALUES(?,?,?,?,?,?,?,?,?)");
        if (_ID == -1) {
            ps.setString(1, vehiclePopup.regNumberTextField.getText());
            ps.setString(2, vehiclePopup.makeTextField.getText());
            ps.setString(3, vehiclePopup.modelTextField.getText());
            ps.setString(4, vehiclePopup.engSerialNumberTextField.getText());
            ps.setString(5, vehiclePopup.chasisNumberTextField.getText());
            ps.setString(6, vehiclePopup.colorTextField.getText());
            ps.setInt(7, Integer.parseInt(vehiclePopup.mileageTextField.getText()));
            ps.setInt(8, vehicleTypeToInt(vehiclePopup.typeDropdown.getItemAt(vehiclePopup.typeDropdown.getSelectedIndex())));
            ps.setInt(9, customer.ID);
            ps.executeUpdate();
            populateVehicle(null);
            customer.vehicle.add(getVehicle(returnVehicleID(vehiclePopup.regNumberTextField.getText())));
            System.out.println("Vehicle Added");
        } else {
            PreparedStatement updateStatement = con.prepareStatement("UPDATE vehicle "
                    + "SET rNumber=?, make=?, model=?, engineSerialNumber=?, chassisNumber=?, color=?, mileage=?, vType=?, CustomerID=? "
                    + "WHERE VehicleID=" + _ID);
            updateStatement.setString(1, vehiclePopup.regNumberTextField.getText());
            updateStatement.setString(2, vehiclePopup.makeTextField.getText());
            updateStatement.setString(3, vehiclePopup.modelTextField.getText());
            updateStatement.setString(4, vehiclePopup.engSerialNumberTextField.getText());
            updateStatement.setString(5, vehiclePopup.chasisNumberTextField.getText());
            updateStatement.setString(6, vehiclePopup.colorTextField.getText());
            updateStatement.setInt(7, Integer.parseInt(vehiclePopup.mileageTextField.getText()));
            updateStatement.setInt(8, vehicleTypeToInt(vehiclePopup.typeDropdown.getItemAt(vehiclePopup.typeDropdown.getSelectedIndex())));
            updateStatement.setInt(9, customer.ID);
            updateStatement.executeUpdate();
            populateVehicle(null);
            // Modify Vehicle
            System.out.println("Vehicle Modified");
        }
        //Vehicle already exists

    }

    public void populateBookingPopup(Booking bookingFields) {
        //Fill in the Booking popup with values from the Booking object
        bookingPopup.customerNameField.setText(bookingFields.customer.fName);
        bookingPopup.customerSurnameField.setText(bookingFields.customer.lName);
        bookingPopup.DOBTextField.setText(bookingFields.customer.dob);
        bookingPopup.typeBox.setSelectedItem(bookingFields.type);
        bookingPopup.bookedField.setText(bookingFields.dateBooked);
        bookingPopup.priceField.setText(Float.toString(bookingFields.quotedPrice));
        bookingPopup.paidForCheckbox.setSelected(bookingFields.paidFor);
        bookingPopup.descriptionField.setText(bookingFields.description);
        bookingPopup.dateFinishedField.setText(bookingFields.expectedCompletionDate);

        bookingPopup.customerNameField.setEditable(false);
        bookingPopup.customerSurnameField.setEditable(false);
        bookingPopup.DOBTextField.setEditable(false);
    }

    public void populateStockPopup(Stock stockFields) {
        //Fill in the Booking popup with values from the Booking object
        stockPopup.partNameTextField.setText(stockFields.partName);
        stockPopup.vTypeBox.setSelectedItem(stockFields.vType);
        stockPopup.yearsTextBox.setText(stockFields.years);
        stockPopup.priceTextField.setText(Float.toString(stockFields.price));
        stockPopup.thresholdTextField.setText(Integer.toString(stockFields.threshold));
        stockPopup.manuNameTextField.setText(stockFields.manufacturer.name);
        stockPopup.pendingDateTextField.setText(stockFields.pendingDate);
        stockPopup.pendingQuantityTextField.setText(Integer.toString(stockFields.pendingQuantity));
        stockPopup.quantityField.setText(Integer.toString(stockFields.quantity));
    }

    public void populateCustomerPopup(Customer customer) {
        customersPopup.fNameTextField.setText(customer.fName);
        customersPopup.addressTextField.setText(customer.address);
        customersPopup.cityTextField.setText(customer.city);
        customersPopup.tNumberTextField.setText(customer.tNumber);
        customersPopup.cNameTextField.setText(customer.cName);
        customersPopup.dateRegisteredTextField.setText(customer.dateRegistered);
        customersPopup.lNameTextField.setText(customer.lName);
        customersPopup.pCodeTextField.setText(customer.pCode);
        customersPopup.fNumberTextField.setText(customer.faxNumber);
        customersPopup.dobTextField.setText(customer.dob);
        customersPopup.emailTextField.setText(customer.email);

        for (Vehicle v : customer.vehicle) {
            customersPopup.vehicleDropdown.addItem(v.rNumber);
        }

        customersPopup.fNameTextField.setEditable(false);
        customersPopup.lNameTextField.setEditable(false);
        customersPopup.dobTextField.setEditable(false);
    }

    public void populateUserPopup(User userFields) {
        userPopup.fNameTextField.setText(userFields.username);
        userPopup.addressTextField.setText(userFields.address);
        userPopup.cityTextField.setText(userFields.city);
        userPopup.tNumberTextField.setText(userFields.tNumber);
        userPopup.passwordField.setText(userFields.pWord);
        userPopup.pCodeTextField.setText(userFields.pCode);
        userPopup.dobTextField.setText(userFields.DOB);
        userPopup.emailTextField.setText(userFields.email);
        userPopup.accessLevelTextField.setText(Integer.toString(userFields.accessLevel));

        userPopup.fNameTextField.setEditable(false);
        userPopup.passwordField.setEditable(false);
        userPopup.dobTextField.setEditable(false);
    }

    public Vehicle getVehicleFromRNumber(String rNumber) {
        for (Vehicle v : vehicles) {
            if (v.rNumber == null ? rNumber == null : v.rNumber.equals(rNumber)) {
                return v;
            }
        }
        return null;
    }

    public void populateVehiclePopup(Vehicle vehicleFields) {
        vehiclePopup.regNumberTextField.setText(vehicleFields.rNumber);
        vehiclePopup.makeTextField.setText(vehicleFields.make);
        vehiclePopup.modelTextField.setText(vehicleFields.model);
        vehiclePopup.engSerialNumberTextField.setText(vehicleFields.engineSerialNumber);
        vehiclePopup.chasisNumberTextField.setText(vehicleFields.chasisNumber);
        vehiclePopup.colorTextField.setText(vehicleFields.color);
        vehiclePopup.mileageTextField.setText(Integer.toString(vehicleFields.mileage));
        vehiclePopup.typeDropdown.setSelectedIndex(vehicleTypeToInt(vehicleFields.vType));
    }

    public void populateManuPopup(Manufacturer manu) {
        manufacturerPopup.addressTextField.setText(manu.address);
        manufacturerPopup.cityTextField.setText(manu.address);
        manufacturerPopup.emailTextField.setText(manu.email);
        manufacturerPopup.fNumberTextField.setText(manu.faxNumber);
        manufacturerPopup.nameTextField.setText(manu.name);
        manufacturerPopup.postCodeTextField.setText(manu.pCode);
        manufacturerPopup.tNumberTextField.setText(manu.tNumber);
        manufacturerPopup.websiteTextField.setText(manu.website);
    }

    public void populateJobPopup(Job job) {
        jobsPopUp.customerNameTextField.setText("" + job.vehicle.customer.ID);
        jobsPopUp.vehicleRegTextField.setText(job.vehicle.rNumber);
        jobsPopUp.makeTextField.setText(job.vehicle.make);
        jobsPopUp.modelTextField.setText(job.vehicle.model);
        jobsPopUp.estTimeTextField.setText("" + job.dateDue);
        jobsPopUp.timeTakeTextField.setText("" + job.duration);
        jobsPopUp.descriptionTextField.setText(job.initialDescription);

        String date = "" + job.dateCreated;

        //jobsPopUp.Day.setSelectedIndex(date.substring());
        //jobsPopUp.Month.setSelectedIndex();
        //jobsPopUp.Year.setSelectedIndex();
    }

    //Create varius popups like BookingPopup
    public void showPopup(int type, int id) {
        switch (type) {
            case 0:
                bookingPopup = new BookingPopup(this, id);
                bookingPopup.setVisible(true);
                break;
            case 1:
                customersPopup = new CustomerAccountsPopup(this, id);
                customersPopup.setVisible(true);
                break;
            case 2:
                jobsPopUp = new JobsPopUp(this);
                jobsPopUp.setVisible(true);
                break;
            case 3:
                manufacturerPopup = new ManufacturerPopup(this);
                manufacturerPopup.setVisible(true);
                break;
            case 4:
                stockPopup = new StockPopup(this, id);
                stockPopup.setVisible(true);
                break;
            case 5:
                userPopup = new UserPopup(this, id);
                userPopup.setVisible(true);
                break;
            default:
                break;
        }
    }

    public void showVehiclePopup(int ID, int customerId) {
        vehiclePopup = new VehiclePopup(this, ID, getCustomer(customerId));
        vehiclePopup.setVisible(true);
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
            mainGUI.redLabel.setText("Can't connect to the Database");
        }
    }

    //Called in MainGUI
    public boolean login(String username, String password) throws SQLException {
        boolean loggedIn = false;
        PreparedStatement ps = con.prepareStatement("SELECT Username, Password FROM users WHERE username=? AND Password=?");
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (username.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
                loggedIn = true;
            }
        }
        return loggedIn;
    }

    //Calls login and handles outcome
    public void verifyLogin(String name, String pw) throws SQLException {
        if (con == null) {
            return;
        }
        if (login(name, pw.replace("[", "").replace("]", ""))) {
            showLists();
            populateVehicle(null);
            populateCustomer(null);
            //set customer in vehicle
            for (Customer c : customers) {
                ArrayList<Vehicle> vehicleArray = c.vehicle;
                for (Vehicle v : vehicleArray) {
                    v.customer = c;
                }
            }

            populateUsers(null);
            populateManufacturer();
            populateStock(null);
            populateBooking(null);
            populateJob(null);
            populateReminder();
            populateJobInvoice();
        } else {
            mainGUI.redLabel.setText("Incorrect Username or Password");
        }
    }

    public int returnCustomerID(String name, String surname, String dob) {
        for (Customer customer : customers) {
            if ((customer.fName == null ? name == null : customer.fName.equals(name))
                    && (customer.lName == null ? surname == null : customer.lName.equals(surname))
                    && (String.valueOf(customer.dob) == null ? dob == null : String.valueOf(customer.dob).equals(dob))) {
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

    private int returnEmployeeID(String name, String dob) {
        for (User user : users) {
            if ((user.username == null ? name == null : user.username.equals(name))
                    && (user.DOB == dob)) {
                return user.ID;
            }
        }
        return -1;
    }

    public int returnVehicleID(String rNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.rNumber == null ? rNumber == null : vehicle.rNumber.equals(rNumber)) {
                return vehicle.ID;
            }
        }
        return -1;
    }

    public void removeBooking(int _ID) throws SQLException {
        PreparedStatement deleteStatement = con.prepareStatement("DELETE FROM bookings WHERE BookingsID = " + _ID);
        deleteStatement.executeUpdate();
        populateBooking(null);
    }

    public void removeCustomer(int _ID) throws SQLException {
        PreparedStatement deleteStatement = con.prepareStatement("DELETE FROM customer WHERE CustomerID = " + _ID);
        deleteStatement.executeUpdate();
        populateCustomer(null);
    }

    public void removeUser(int _ID) throws SQLException {
        PreparedStatement deleteStatement = con.prepareStatement("DELETE FROM users WHERE UserID = " + _ID);
        deleteStatement.executeUpdate();
        populateUsers(null);
    }

    public void removeStock(int _ID) throws SQLException {
        PreparedStatement deleteStatement = con.prepareStatement("DELETE FROM stock WHERE StockID = " + _ID);
        deleteStatement.executeUpdate();
        populateStock(null);
    }

    public void removeJob(int _ID) throws SQLException {
        PreparedStatement deleteStatement = con.prepareStatement("DELETE FROM job WHERE JobID = " + _ID);
        deleteStatement.executeUpdate();
        populateJob(null);
    }

    public void removeVehicle(int _ID) throws SQLException {
        PreparedStatement deleteStatement = con.prepareStatement("DELETE FROM vehicle WHERE VehicleID = " + _ID);
        deleteStatement.executeUpdate();
        populateVehicle(null);
    }
}
