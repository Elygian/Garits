package Garits.GUI.Forms;
import Garits.Main.MainWindow;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class BookingPopup extends javax.swing.JFrame {
    MainWindow main;
    
    public BookingPopup(MainWindow main) {
        initComponents();
        this.main = main;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewVehicleButton = new javax.swing.JButton();
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
        setAlwaysOnTop(true);

        viewVehicleButton.setText("View Vehicle");
        viewVehicleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewVehicleButtonActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(viewCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewVehicleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeBookingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customerNameLabel)
                    .addComponent(customerSurnameLabel)
                    .addComponent(customerSurnameLabel1)
                    .addComponent(typeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(customerNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(customerSurnameField, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(typeBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DOBTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                        .addGap(109, 109, 109)
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
                        .addGap(140, 140, 140)
                        .addComponent(bookingTitleLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(customerNameLabel)
                                    .addComponent(bookedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateBookedLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(customerSurnameLabel)
                                    .addComponent(dateFinishedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateDueLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(quotedPriceLabel)
                                        .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(DOBTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(customerSurnameLabel1)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(customerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customerSurnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(typeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(typeLabel)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(paidForLabel)
                                    .addComponent(paidForCheckbox)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bookingTitleLabel)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descriptionLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewVehicleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeBookingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewVehicleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewVehicleButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewVehicleButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            main.bookingPopupSave((int) main.lists.bookingList.getValueAt(main.lists.bookingList.getSelectedRow(), 0));        // TODO add your handling code here:
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
        // TODO add your handling code here:
    }//GEN-LAST:event_viewCustomerButtonActionPerformed

    private void removeBookingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBookingButtonActionPerformed

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
    private javax.swing.JButton viewVehicleButton;
    // End of variables declaration//GEN-END:variables
}
