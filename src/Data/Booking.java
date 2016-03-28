package Data;

public class Booking {

    public Booking() {
    }

    public Booking(int ID, Vehicle vehicle, Customer customer, int type, String description, int dateBooked, int expectedCompletionDate, float quotedPrice, boolean paidFor) {
        this.ID = ID;
        this.vehicle = vehicle;
        this.customer = customer;
        this.type = type;
        this.description = description;
        this.dateBooked = dateBooked;
        this.expectedCompletionDate = expectedCompletionDate;
        this.quotedPrice = quotedPrice;
        this.paidFor = paidFor;
    }
    public int ID;
    public Vehicle vehicle;
    public Customer customer;
    public int type;
    public String description;
    public int dateBooked;
    public int expectedCompletionDate;
    public float quotedPrice;
    public boolean paidFor;
}
