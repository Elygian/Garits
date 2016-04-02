package Data;

public class User {

    public User(int ID, String username, String pWord, String address, String city, String pCode, String tNumber, String email, int DOB, int accessLevel) {
        this.ID = ID;
        this.username = username;
        this.pWord = pWord;
        this.address = address;
        this.city = city;
        this.pCode = pCode;
        this.tNumber = tNumber;
        this.email = email;
        this.DOB = DOB;
        this.accessLevel = accessLevel;
    }
    public int ID;
    public String username;
    public String pWord;
    public String address;
    public String city;
    public String pCode;
    public String tNumber;
    public String email;
    public int DOB;
    public int accessLevel;
}