package Data;

public class Stock {

    public Stock(int ID, int quantity, String partName, int vType, String years, Manufacturer manu, float price, int threshold, int pendingQuantity, int pendingDate) {
        this.ID = ID;
        this.quantity = quantity;
        this.partName = partName;
        this.vType = vType;
        this.years = years;
        this.price = price;
        this.threshold = threshold;
        this.pendingQuantity = pendingQuantity;
        this.pendingDate = pendingDate;
        this.manufacturer = manu;
    }
    public int ID;
    public int quantity;
    public String partName;
    public int vType;
    public String years;
    public float price;
    public int threshold;
    public int pendingQuantity;
    public int pendingDate;
    public Manufacturer manufacturer;

}
