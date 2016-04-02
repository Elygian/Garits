package Data;

public class Vehicle {

    public Vehicle() {
    }

    public Vehicle(int ID, String vType, String rNumber, String make, String model, String engineSerialNumber, String chasisNumber, String color, int mileage) {
        this.ID = ID;
        this.rNumber = rNumber;
        this.vType = vType;
        this.make = make;
        this.model = model;
        this.engineSerialNumber = engineSerialNumber;
        this.chasisNumber = chasisNumber;
        this.color = color;
        this.mileage = mileage;
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
}
