package Data;

public class Job extends StringComparable {

    public Job(int ID, int dateCreated, int dateDue, String initialDescription, String detailedDescription, Stock[] Arraystock, int duration, float price, Vehicle vehicle) {
        this.ID = ID;
        this.dateCreated = dateCreated;
        this.dateDue = dateDue;
        this.initialDescription = initialDescription;
        this.detailedDescription = detailedDescription;
        this.Arraystock = Arraystock;
        this.duration = duration;
        this.price = price;
        this.vehicle = vehicle;
    }
    public int ID;
    public int dateCreated;
    public int dateDue;
    public String initialDescription;
    public String detailedDescription;
    public Stock[] Arraystock;
    public int duration;
    public float price;
    public Vehicle vehicle;

    @Override
    public String toComparisonString() {
        String a = (vehicle != null) ? vehicle.toComparisonString() : "";
        String s = "";
        for (Stock stock : Arraystock) {
            s += stock.toComparisonString() + " ";
        }
        return ID + " " + dateCreated + " " + dateDue + " " + initialDescription + " " + detailedDescription + " " + duration + " " + price
                + " " + a + ", " + s;
    }
}
