/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


public interface DatabaseHandler {
    public void connectDB();
    public void disconnectDB();
    public boolean verifyCredentials();
    public int givePrivelegeLevel();
    public String[] sendSelectQuery(String s);
    public boolean sendInsertQuery(String s);
    public boolean sendUpdateQuery(String S);
}
