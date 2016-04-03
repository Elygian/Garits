/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Garits.GUI.Forms;

import Garits.Main.MainWindow;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lists extends javax.swing.JPanel {

    MainWindow main;
    public static final String DEFAULT_TEXT = "Type here..";

    public Lists(MainWindow main) {
        initComponents();
        this.main = main;

        bookingList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    bookingList.clearSelection();
                }
            }
        });
        jScrollPane5.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                bookingList.clearSelection();

            }
        });

        customerList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    customerList.clearSelection();
                }
            }
        });
        jScrollPane18.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                customerList.clearSelection();

            }
        });

        usersList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    usersList.clearSelection();
                }
            }
        });
        jScrollPane19.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                usersList.clearSelection();

            }
        });

        stockList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    stockList.clearSelection();
                }
            }
        });
        jScrollPane16.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                stockList.clearSelection();

            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainJTabbedPane = new javax.swing.JTabbedPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        bookingList = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        bookingSearchField = new javax.swing.JTextField();
        bookingSearchButton = new javax.swing.JButton();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jScrollPane16 = new javax.swing.JScrollPane();
        stockList = new javax.swing.JTable();
        Order = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        stockSearchField = new javax.swing.JTextField();
        stockSearchButton = new javax.swing.JButton();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        jScrollPane17 = new javax.swing.JScrollPane();
        jobList = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jobsSearchField = new javax.swing.JTextField();
        jobsSearchButton = new javax.swing.JButton();
        jLayeredPane7 = new javax.swing.JLayeredPane();
        jScrollPane18 = new javax.swing.JScrollPane();
        customerList = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        customersSearchField = new javax.swing.JTextField();
        customersSearchButton = new javax.swing.JButton();
        jLayeredPane9 = new javax.swing.JLayeredPane();
        jScrollPane19 = new javax.swing.JScrollPane();
        usersList = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        usersSearchField = new javax.swing.JTextField();
        usersSearchButton = new javax.swing.JButton();

        bookingList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Customer Name", "Customer Surname", "Type", "Date Booked", "Quoted Price", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookingList.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(bookingList);

        jButton4.setText("Add/Modify");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton10.setText("Delete");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        bookingSearchField.setText("Type here..");
        bookingSearchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                bookingSearchFieldFocusLost(evt);
            }
        });
        bookingSearchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookingSearchFieldMouseClicked(evt);
            }
        });
        bookingSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingSearchFieldActionPerformed(evt);
            }
        });
        bookingSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bookingSearchFieldKeyPressed(evt);
            }
        });

        bookingSearchButton.setText("Search");
        bookingSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingSearchButtonActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(jScrollPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(bookingSearchField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(bookingSearchButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bookingSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookingSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bookingSearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bookingSearchField)))
        );

        MainJTabbedPane.addTab("                       Bookings                       ", jLayeredPane1);

        stockList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Part Name", "Quantity", "Years", "Price", "Threshold", "Pending Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stockList.getTableHeader().setReorderingAllowed(false);
        jScrollPane16.setViewportView(stockList);

        Order.setText("Order");

        Add.setText("Add/Modify");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        jButton12.setText("Delete");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        stockSearchField.setText("Type here..");
        stockSearchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                stockSearchFieldFocusLost(evt);
            }
        });
        stockSearchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockSearchFieldMouseClicked(evt);
            }
        });
        stockSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                stockSearchFieldKeyPressed(evt);
            }
        });

        stockSearchButton.setText("Search");
        stockSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockSearchButtonActionPerformed(evt);
            }
        });

        jLayeredPane5.setLayer(jScrollPane16, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(Order, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(Add, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jButton12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(stockSearchField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(stockSearchButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Order, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(stockSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stockSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Order, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(stockSearchField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockSearchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        MainJTabbedPane.addTab("                         Stock                         ", jLayeredPane5);

        jobList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Date Created", "Date Due", "Initial Description", "Duration", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jobList.getTableHeader().setReorderingAllowed(false);
        jScrollPane17.setViewportView(jobList);

        jButton11.setText("Add/Modify");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton13.setText("Delete");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Completed");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jobsSearchField.setText("Type here..");
        jobsSearchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jobsSearchFieldFocusLost(evt);
            }
        });
        jobsSearchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jobsSearchFieldMouseClicked(evt);
            }
        });
        jobsSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobsSearchFieldActionPerformed(evt);
            }
        });
        jobsSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jobsSearchFieldKeyPressed(evt);
            }
        });

        jobsSearchButton.setText("Search");
        jobsSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobsSearchButtonActionPerformed(evt);
            }
        });
        jobsSearchButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jobsSearchButtonKeyPressed(evt);
            }
        });

        jLayeredPane6.setLayer(jScrollPane17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jButton11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jButton13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jButton14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jobsSearchField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jobsSearchButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane6Layout = new javax.swing.GroupLayout(jLayeredPane6);
        jLayeredPane6.setLayout(jLayeredPane6Layout);
        jLayeredPane6Layout.setHorizontalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jobsSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jobsSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jLayeredPane6Layout.setVerticalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jobsSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jobsSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        MainJTabbedPane.addTab("                         Jobs                         ", jLayeredPane6);

        customerList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "First Name", "Last Name", "DOB", "Registered Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customerList.getTableHeader().setReorderingAllowed(false);
        jScrollPane18.setViewportView(customerList);

        jButton7.setText("Add/Modify");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton15.setText("Delete");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Vehicle");

        customersSearchField.setText("Type here..");
        customersSearchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                customersSearchFieldFocusLost(evt);
            }
        });
        customersSearchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customersSearchFieldMouseClicked(evt);
            }
        });
        customersSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                customersSearchFieldKeyPressed(evt);
            }
        });

        customersSearchButton.setText("Search");
        customersSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customersSearchButtonActionPerformed(evt);
            }
        });
        customersSearchButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                customersSearchButtonKeyPressed(evt);
            }
        });

        jLayeredPane7.setLayer(jScrollPane18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jButton7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jButton15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jButton16, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(customersSearchField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(customersSearchButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane7Layout = new javax.swing.GroupLayout(jLayeredPane7);
        jLayeredPane7.setLayout(jLayeredPane7Layout);
        jLayeredPane7Layout.setHorizontalGroup(
            jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
            .addGroup(jLayeredPane7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(customersSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customersSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jLayeredPane7Layout.setVerticalGroup(
            jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane7Layout.createSequentialGroup()
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(customersSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customersSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        MainJTabbedPane.addTab("                         Customers                         ", jLayeredPane7);

        usersList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "First Name", "Password", "DOB", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usersList.getTableHeader().setReorderingAllowed(false);
        jScrollPane19.setViewportView(usersList);

        jButton8.setText("Add/Modify");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton18.setText("Delete");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        usersSearchField.setText("Type here..");
        usersSearchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                usersSearchFieldFocusLost(evt);
            }
        });
        usersSearchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersSearchFieldMouseClicked(evt);
            }
        });
        usersSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usersSearchFieldKeyPressed(evt);
            }
        });

        usersSearchButton.setText("Search");
        usersSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersSearchButtonActionPerformed(evt);
            }
        });
        usersSearchButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usersSearchButtonKeyPressed(evt);
            }
        });

        jLayeredPane9.setLayer(jScrollPane19, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(jButton8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(jButton18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(usersSearchField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(usersSearchButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane9Layout = new javax.swing.GroupLayout(jLayeredPane9);
        jLayeredPane9.setLayout(jLayeredPane9Layout);
        jLayeredPane9Layout.setHorizontalGroup(
            jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
            .addGroup(jLayeredPane9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(usersSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usersSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jLayeredPane9Layout.setVerticalGroup(
            jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane9Layout.createSequentialGroup()
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(usersSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usersSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        MainJTabbedPane.addTab("                        Users                        ", jLayeredPane9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainJTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainJTabbedPane)
        );

        getAccessibleContext().setAccessibleName("");
        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        System.out.println(this.customerList.getSelectedRow());
        if (main.lists.customerList.getSelectedRow() != -1) {
            main.showPopup(1, (int) main.lists.customerList.getValueAt(main.lists.customerList.getSelectedRow(), 0));
            main.populateCustomerPopup(main.getCustomer((int) main.lists.customerList.getValueAt(main.lists.customerList.getSelectedRow(), 0)));
        } else {
            main.showPopup(1, -1);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        System.out.println(this.stockList.getSelectedRow());
        if (main.lists.stockList.getSelectedRow() != -1) {
            main.showPopup(4, (int) main.lists.stockList.getValueAt(main.lists.stockList.getSelectedRow(), 0));
            main.populateStockPopup(main.getStock((int) main.lists.stockList.getValueAt(main.lists.stockList.getSelectedRow(), 0)));
        } else {
            main.showPopup(4, -1);
        }
    }//GEN-LAST:event_AddActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        System.out.println(this.usersList.getSelectedRow());
        if (main.lists.usersList.getSelectedRow() != -1) {
            main.showPopup(5, (int) main.lists.usersList.getValueAt(main.lists.usersList.getSelectedRow(), 0));
            main.populateUserPopup(main.getUser((int) main.lists.usersList.getValueAt(main.lists.usersList.getSelectedRow(), 0)));
        } else {
            main.showPopup(5, -1);
        }       // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.out.println(this.bookingList.getSelectedRow());
        if (main.lists.bookingList.getSelectedRow() != -1) {
            main.showPopup(0, (int) main.lists.bookingList.getValueAt(main.lists.bookingList.getSelectedRow(), 0));
            main.populateBookingPopup(main.getBooking((int) main.lists.bookingList.getValueAt(main.lists.bookingList.getSelectedRow(), 0)));
        } else {
            main.showPopup(0, -1);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
            if (main.lists.bookingList.getSelectedRow() != -1) {
                main.removeBooking((int) main.lists.bookingList.getValueAt(main.lists.bookingList.getSelectedRow(), 0));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lists.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        try {
            if (main.lists.customerList.getSelectedRow() != -1) {
                main.removeCustomer((int) main.lists.customerList.getValueAt(main.lists.customerList.getSelectedRow(), 0));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lists.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        try {
            if (main.lists.usersList.getSelectedRow() != -1) {
                main.removeUser((int) main.lists.usersList.getValueAt(main.lists.usersList.getSelectedRow(), 0));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lists.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

        try {
            if (main.lists.stockList.getSelectedRow() != -1) {
                main.removeStock((int) main.lists.stockList.getValueAt(main.lists.stockList.getSelectedRow(), 0));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Lists.class.getName()).log(Level.SEVERE, null, ex);
        } // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void usersSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersSearchButtonActionPerformed
        try {
            main.populateUsers(usersSearchField.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Lists.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_usersSearchButtonActionPerformed

    private void jobsSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobsSearchButtonActionPerformed
        try {
            main.populateJob(jobsSearchField.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Lists.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jobsSearchButtonActionPerformed

    private void jobsSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobsSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobsSearchFieldActionPerformed

    private void jobsSearchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jobsSearchFieldMouseClicked
        if (DEFAULT_TEXT.equals(jobsSearchField.getText())) {
            jobsSearchField.setText("");
        }
    }//GEN-LAST:event_jobsSearchFieldMouseClicked

    private void bookingSearchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingSearchFieldMouseClicked
        if (DEFAULT_TEXT.equals(bookingSearchField.getText())) {
            bookingSearchField.setText("");
        }
    }//GEN-LAST:event_bookingSearchFieldMouseClicked

    private void stockSearchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockSearchFieldMouseClicked
        if (DEFAULT_TEXT.equals(stockSearchField.getText())) {
            stockSearchField.setText("");
        }
    }//GEN-LAST:event_stockSearchFieldMouseClicked

    private void customersSearchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customersSearchFieldMouseClicked
        if (DEFAULT_TEXT.equals(customersSearchField.getText())) {
            customersSearchField.setText("");
        }
    }//GEN-LAST:event_customersSearchFieldMouseClicked

    private void usersSearchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersSearchFieldMouseClicked
        if (DEFAULT_TEXT.equals(usersSearchField.getText())) {
            usersSearchField.setText("");
        }
    }//GEN-LAST:event_usersSearchFieldMouseClicked

    private void bookingSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingSearchButtonActionPerformed
        try {
            main.populateBooking(bookingSearchField.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Lists.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bookingSearchButtonActionPerformed

    private void stockSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockSearchButtonActionPerformed
        try {
            main.populateStock(stockSearchField.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Lists.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_stockSearchButtonActionPerformed

    private void customersSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customersSearchButtonActionPerformed
        try {
            main.populateCustomer(customersSearchField.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Lists.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_customersSearchButtonActionPerformed

    private void bookingSearchFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bookingSearchFieldFocusLost
        if ("".equals(bookingSearchField.getText())) {
            bookingSearchField.setText(DEFAULT_TEXT);
        }
    }//GEN-LAST:event_bookingSearchFieldFocusLost

    private void stockSearchFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stockSearchFieldFocusLost
        if ("".equals(stockSearchField.getText())) {
            stockSearchField.setText(DEFAULT_TEXT);
        }
    }//GEN-LAST:event_stockSearchFieldFocusLost

    private void jobsSearchFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jobsSearchFieldFocusLost
        if ("".equals(jobsSearchField.getText())) {
            jobsSearchField.setText(DEFAULT_TEXT);
        }
    }//GEN-LAST:event_jobsSearchFieldFocusLost

    private void customersSearchFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_customersSearchFieldFocusLost
        if ("".equals(customersSearchField.getText())) {
            customersSearchField.setText(DEFAULT_TEXT);
        }
    }//GEN-LAST:event_customersSearchFieldFocusLost

    private void usersSearchFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usersSearchFieldFocusLost
        if ("".equals(usersSearchField.getText())) {
            usersSearchField.setText(DEFAULT_TEXT);
        }
    }//GEN-LAST:event_usersSearchFieldFocusLost

    private void bookingSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingSearchFieldActionPerformed

    }//GEN-LAST:event_bookingSearchFieldActionPerformed

    private void bookingSearchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookingSearchFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            bookingSearchButton.doClick();
        }
    }//GEN-LAST:event_bookingSearchFieldKeyPressed

    private void stockSearchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockSearchFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            stockSearchButton.doClick();
        }
    }//GEN-LAST:event_stockSearchFieldKeyPressed

    private void jobsSearchButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jobsSearchButtonKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jobsSearchButton.doClick();
        }
    }//GEN-LAST:event_jobsSearchButtonKeyPressed

    private void customersSearchButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customersSearchButtonKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            customersSearchButton.doClick();
        }
    }//GEN-LAST:event_customersSearchButtonKeyPressed

    private void usersSearchButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usersSearchButtonKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            usersSearchButton.doClick();
        }
    }//GEN-LAST:event_usersSearchButtonKeyPressed

    private void jobsSearchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jobsSearchFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jobsSearchButton.doClick();
        }
    }//GEN-LAST:event_jobsSearchFieldKeyPressed

    private void customersSearchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customersSearchFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            customersSearchButton.doClick();
        }
    }//GEN-LAST:event_customersSearchFieldKeyPressed

    private void usersSearchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usersSearchFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            usersSearchButton.doClick();
        }
    }//GEN-LAST:event_usersSearchFieldKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JTabbedPane MainJTabbedPane;
    private javax.swing.JButton Order;
    public javax.swing.JTable bookingList;
    private javax.swing.JButton bookingSearchButton;
    private javax.swing.JTextField bookingSearchField;
    public javax.swing.JTable customerList;
    private javax.swing.JButton customersSearchButton;
    private javax.swing.JTextField customersSearchField;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JLayeredPane jLayeredPane9;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JTable jobList;
    private javax.swing.JButton jobsSearchButton;
    private javax.swing.JTextField jobsSearchField;
    public javax.swing.JTable stockList;
    private javax.swing.JButton stockSearchButton;
    private javax.swing.JTextField stockSearchField;
    public javax.swing.JTable usersList;
    private javax.swing.JButton usersSearchButton;
    private javax.swing.JTextField usersSearchField;
    // End of variables declaration//GEN-END:variables
}
