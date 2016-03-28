
package Data;

public class Job {

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
    
}
