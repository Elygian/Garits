
package Data;


public class Manufacturer {
    public Manufacturer(){
    }
    public Manufacturer(int ID, String name, String address, String city, String pCode, String tNumber, String faxNumber, String website, String email) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.city = city;
        this.pCode = pCode;
        this.tNumber = tNumber;
        this.faxNumber = faxNumber;
        this.website = website;
        this.email = email;
    }
    public int ID;
    public String name;
    public String address;
    public String city;
    public String pCode;
    public String tNumber;
    public String faxNumber;
    public String website;
    public String email;
}
