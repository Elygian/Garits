
package Interfaces;

import Data.Job;


public interface MechanicTerminal {
    public void NavigateToJoblist();
    public void SearchJob();
    public void ViewJobDetailsDetails(Job j);
    public void addJob(Job j);
    public void createInvoice();
    public void modifyJobDetails();
}
