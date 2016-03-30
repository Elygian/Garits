package Data;


public class Customer {

    public Customer(int ID, String dateRegistered, String fName, String lName, String cName, 
            String address, String city, String pCode, String tNumber, String faxNumber, int dob, 
            String email, int reminderCount, int responseRate, Vehicle[] vehicle) {
        this.ID = ID;
        this.dateRegistered = dateRegistered;
        this.fName = fName;
        this.lName = lName;
        this.cName = cName;
        this.address = address;
        this.city = city;
        this.pCode = pCode;
        this.tNumber = tNumber;
        this.faxNumber = faxNumber;
        this.dob = dob;
        this.email = email;
        this.reminderCount = reminderCount;
        this.responseRate = responseRate;
        this.vehicle = vehicle;
    }
   public int ID;
   public String dateRegistered;
   public String fName;
   public String lName;
   public String cName;
   public String address;
   public String city;
   public String pCode;
   public String tNumber;
   public String faxNumber;
   public int dob;
   public String email;
   public int reminderCount;
   public int responseRate;
   public Vehicle[] vehicle;

    public Customer() {
        
    }
}
