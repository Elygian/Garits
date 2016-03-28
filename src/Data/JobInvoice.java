
package Data;


public class JobInvoice {

    public JobInvoice(int ID, String message, Customer customer, Stock[] Arraystock, Job job) {
        this.ID = ID;
        this.message = message;
        this.customer = customer;
        this.Arraystock = Arraystock;
        this.job = job;
    }
    public int ID;
    public String message;
    public Customer customer;
    public Stock[] Arraystock;
    public Job job;
}
