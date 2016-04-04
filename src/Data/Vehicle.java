package Data;

public class Vehicle extends StringComparable {

    public Vehicle() {
    }

    public Vehicle(int ID, String vType, String rNumber, String make, String model, String engineSerialNumber, String chasisNumber, String color, int mileage, Customer customer) {
        this.ID = ID;
        this.rNumber = rNumber;
        this.vType = vType;
        this.make = make;
        this.model = model;
        this.engineSerialNumber = engineSerialNumber;
        this.chasisNumber = chasisNumber;
        this.color = color;
        this.mileage = mileage;
        this.customer = customer;
    }
    public int ID;
    public String rNumber;
    public String vType;
    public String make;
    public String model;
    public String engineSerialNumber;
    public String chasisNumber;
    public String color;
    public int mileage;
    public Customer customer;

    @Override
    public String toComparisonString() {
        return ID + " " + rNumber + " " + vType + " " + make + " " + model + " " + engineSerialNumber + " " + chasisNumber + " " + color + " " + mileage;
    }
}
