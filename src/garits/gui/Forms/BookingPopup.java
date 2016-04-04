package Garits.GUI.Forms;

import Data.Customer;
import Data.Vehicle;
import Garits.Main.MainWindow;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookingPopup extends javax.swing.JFrame {

    MainWindow main;
    private final int id;

    public BookingPopup(MainWindow main, int id) {
        initComponents();
        this.main = main;
        this.id = id;
        this.setLocation(main.size.width / 2 - this.getWidth() / 2, main.size.height / 2 - this.getHeight() / 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saveButton = new javax.swing.JButton();
        bookedField = new javax.swing.JTextField();
        customerNameField = new javax.swing.JTextField();
        dateFinishedField = new javax.swing.JTextField();
        customerSurnameField = new javax.swing.JTextField();
        customerNameLabel = new javax.swing.JLabel();
        customerSurnameLabel = new javax.swing.JLabel();
        dateBookedLabel = new javax.swing.JLabel();
        dateDueLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        quotedPriceLabel = new javax.swing.JLabel();
        paidForLabel = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        bookingTitleLabel = new javax.swing.JLabel();
        viewCustomerButton = new javax.swing.JButton();
        removeBookingButton = new javax.swing.JButton();
        typeBox = new javax.swing.JComboBox();
        paidForCheckbox = new javax.swing.JCheckBox();
        customerSurnameLabel1 = new javax.swing.JLabel();
        DOBTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionField = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        bookedField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookedFieldActionPerformed(evt);
            }
        });

        customerNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameFieldActionPerformed(evt);
            }
        });

        dateFinishedField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateFinishedFieldActionPerformed(evt);
            }
        });

        customerSurnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerSurnameFieldActionPerformed(evt);
            }
        });

        customerNameLabel.setText("Customer Name");

        customerSurnameLabel.setText("Customer Surname");

        dateBookedLabel.setText("Date Booked");

        dateDueLabel.setText("Date finished by");

        typeLabel.setText("Type");

        descriptionLabel.setText("Description");

        quotedPriceLabel.setText("Quoted Price");

        paidForLabel.setText("Paid For");

        priceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceFieldActionPerformed(evt);
            }
        });

        bookingTitleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        bookingTitleLabel.setText("Booking");

        viewCustomerButton.setText("View Customer");
        viewCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCustomerButtonActionPerformed(evt);
            }
        });

        removeBookingButton.setText("Remove Booking");
        removeBookingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBookingButtonActionPerformed(evt);
            }
        });

        typeBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Repair", "MOT", "Service", "Special" }));

        paidForCheckbox.setText("Paid");
        paidForCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidForCheckboxActionPerformed(evt);
            }
        });

        customerSurnameLabel1.setText("Customer DOB");

        DOBTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DOBTextFieldActionPerformed(evt);
            }
        });

        descriptionField.setColumns(20);
        descriptionField.setRows(3);
        jScrollPane1.setViewportView(descriptionField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(viewCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(removeBookingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(91, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(typeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(customerSurnameLabel1)
                                            .addComponent(customerSurnameLabel))
                                        .addGap(53, 53, 53)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(customerNameField)
                                            .addComponent(customerSurnameField)
                                            .addComponent(typeBox, 0, 137, Short.MAX_VALUE)
                                            .addComponent(DOBTextField)))
                                    .addComponent(customerNameLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateBookedLabel)
                                    .addComponent(dateDueLabel)
                                    .addComponent(quotedPriceLabel)
                                    .addComponent(paidForLabel))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(paidForCheckbox)
                                    .addComponent(bookedField, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateFinishedField, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jScrollPane1)))
                        .addGap(127, 127, 127))))
            .addGroup(layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(bookingTitleLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(bookingTitleLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(DOBTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(customerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerSurnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bookedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateBookedLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dateFinishedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateDueLabel)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(customerNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(customerSurnameLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(quotedPriceLabel)
                                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(customerSurnameLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(paidForLabel)
                            .addComponent(paidForCheckbox))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descriptionLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 22, Short.MAX_VALUE)
                        .addComponent(viewCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeBookingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            main.bookingPopupSave(id);
        } catch (SQLException ex) {
            Logger.getLogger(BookingPopup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void bookedFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookedFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookedFieldActionPerformed

    private void customerNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerNameFieldActionPerformed

    private void dateFinishedFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateFinishedFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateFinishedFieldActionPerformed

    private void customerSurnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerSurnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerSurnameFieldActionPerformed

    private void priceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceFieldActionPerformed

    private void viewCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCustomerButtonActionPerformed
        Customer customer = main.getCustomer(main.returnCustomerID(this.customerNameField.getText(), this.customerSurnameField.getText(), this.DOBTextField.getText()));
        if (customer != null) {
            main.showPopup(1, customer.ID);
            main.populateCustomerPopup(customer);
        } else {
            //Display Error Message
        }
    }//GEN-LAST:event_viewCustomerButtonActionPerformed

    private void removeBookingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBookingButtonActionPerformed
        if (id != -1) {
            try {
                main.removeBooking(id);
                setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(BookingPopup.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_removeBookingButtonActionPerformed

    private void paidForCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidForCheckboxActionPerformed

    }//GEN-LAST:event_paidForCheckboxActionPerformed

    private void DOBTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DOBTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DOBTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField DOBTextField;
    public javax.swing.JTextField bookedField;
    private javax.swing.JLabel bookingTitleLabel;
    public javax.swing.JTextField customerNameField;
    private javax.swing.JLabel customerNameLabel;
    public javax.swing.JTextField customerSurnameField;
    private javax.swing.JLabel customerSurnameLabel;
    private javax.swing.JLabel customerSurnameLabel1;
    private javax.swing.JLabel dateBookedLabel;
    private javax.swing.JLabel dateDueLabel;
    public javax.swing.JTextField dateFinishedField;
    public javax.swing.JTextArea descriptionField;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JCheckBox paidForCheckbox;
    private javax.swing.JLabel paidForLabel;
    public javax.swing.JTextField priceField;
    private javax.swing.JLabel quotedPriceLabel;
    private javax.swing.JButton removeBookingButton;
    private javax.swing.JButton saveButton;
    public javax.swing.JComboBox typeBox;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JButton viewCustomerButton;
    // End of variables declaration//GEN-END:variables
}
