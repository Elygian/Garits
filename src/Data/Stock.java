package Data;

public class Stock extends StringComparable {

    public Stock(int ID, int quantity, String partName, int vType, String years, Manufacturer manu, float price, int threshold, int pendingQuantity, String pendingDate) {
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
    public String pendingDate;
    public Manufacturer manufacturer;

    @Override
    public String toComparisonString() {
        String s = (manufacturer != null) ? manufacturer.toComparisonString() : "";

        return ID + " " + quantity + " " + partName + " " + vType + " " + years + " " + price + " " + threshold + " " + pendingQuantity + " " + pendingDate
                + " " + s;
    }
}
