package Data;

public class User {

    public User(int ID, String fName, String lName, String address, String city, String pCode, String tNumber, String email, int DOB, String username, String password, int accessLevel) {
        this.ID = ID;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.city = city;
        this.pCode = pCode;
        this.tNumber = tNumber;
        this.email = email;
        this.DOB = DOB;
        this.username = username;
        this.password = password;
        this.accessLevel = accessLevel;
    }
    public int ID;
    public String fName;
    public String lName;
    public String address;
    public String city;
    public String pCode;
    public String tNumber;
    public String email;
    public int DOB;
    public String username;
    public String password;
    public int accessLevel;
}