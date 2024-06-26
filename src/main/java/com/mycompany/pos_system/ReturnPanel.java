/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pos_system;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ReturnPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProductPanel
     */
    private int getQtyOrderByInvoiceId(int invoiceId){
        int qty=0;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = DB_Connection.getConnection();
            stmt = con.prepareStatement("""
                select qty_ordered from tblinvoice where invoice_id = ?;""");
            stmt.setInt(1,invoiceId);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    qty = rs.getInt("qty_ordered");
                }
            } catch (SQLException ex) {
                ex.printStackTrace(); // Handle exception properly, maybe log it or show an error message
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (con != null) con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace(); // Handle exception properly, maybe log it or show an error message
                }
            }
        
        return qty;
    }
    private void showData(){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = DB_Connection.getConnection();
            stmt = con.prepareStatement("""
                select 
                                        invoice_id,
                                        customer_name,
                                        total_amount,
                                        status,
                                        date_recorded 
                                        from tblinvoice i 
                                        left join 
                                        tblcustomer c 
                                        on i.customer_id = c.customer_id ;""");
                rs = stmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("invoice_id");
                    String name = rs.getString("customer_name");
                    Float total = rs.getFloat("total_amount");
                    String status = rs.getString("status");
                    String dateOrdered = rs.getString("date_recorded");

                    Object[] rowData = {id, name, total, status, dateOrdered};

                    model.addRow(rowData);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(); // Handle exception properly, maybe log it or show an error message
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (con != null) con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace(); // Handle exception properly, maybe log it or show an error message
                }
            }
    }
    DefaultTableModel model;
    public ReturnPanel() {
        initComponents();
        model =(DefaultTableModel) jtProductList.getModel();
        showData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductList = new javax.swing.JTable();
        btnReturn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(700, 528));

        jtProductList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Customer Name", "Total Amount", "Status", "Date Recoreded"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtProductList);
        if (jtProductList.getColumnModel().getColumnCount() > 0) {
            jtProductList.getColumnModel().getColumn(0).setPreferredWidth(50);
            jtProductList.getColumnModel().getColumn(1).setPreferredWidth(200);
            jtProductList.getColumnModel().getColumn(2).setPreferredWidth(150);
            jtProductList.getColumnModel().getColumn(3).setPreferredWidth(75);
            jtProductList.getColumnModel().getColumn(4).setPreferredWidth(200);
        }

        btnReturn.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        btnReturn.setText("Return");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnReturn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReturn, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        int selectedIndex = jtProductList.getSelectedRow();
    if(selectedIndex != -1){
        Connection con = null;
        PreparedStatement stmt = null;  
        ResultSet rs = null;
        
        int invoiceId = Integer.parseInt(jtProductList.getValueAt(selectedIndex, 0).toString());
        float returnedQty = getQtyOrderByInvoiceId(invoiceId); // Assuming this method retrieves the returned quantity
        
        List<Integer> productIds = new ArrayList<>();
 // List to store product IDs
        
        try {
            con = DB_Connection.getConnection();
            
            // Retrieve the product IDs from tblsales
            stmt = con.prepareStatement("SELECT product_id FROM tblsales WHERE invoice_id = ?");
            stmt.setInt(1, invoiceId);
            rs = stmt.executeQuery();
            
            // Collect all product IDs associated with the invoice
            while (rs.next()) {
                productIds.add(rs.getInt("product_id"));
            }
            
            stmt = con.prepareStatement("UPDATE tblinvoice SET status=? WHERE invoice_id=?");
            stmt.setString(1, "returned");
            stmt.setInt(2, invoiceId);
            stmt.executeUpdate();
            
            // Update the quantity in stock for all returned products
            for (int productId : productIds) {
                updateQty(productId, returnedQty);
            }
            
            JOptionPane.showMessageDialog(this, "Customer has been updated successfully");
            model.setRowCount(0);
            showData();
            if (model.getRowCount() > 0) {
                jtProductList.scrollRectToVisible(jtProductList.getCellRect(model.getRowCount() - 1, 0, true));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle exception properly, maybe log it or show an error message
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace(); // Handle exception properly, maybe log it or show an error message
            }
        }
    }
    }//GEN-LAST:event_btnReturnActionPerformed
        private void updateQty(int productId, float returnedQty) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = DB_Connection.getConnection();
            // Get the current quantity in stock for the product
            stmt = con.prepareStatement("SELECT qty_in_stock FROM tblproduct WHERE product_id = ?");
            stmt.setInt(1, productId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                float currentQtyInStock = rs.getFloat("qty_in_stock");
                // Update the quantity in stock by adding the returned quantity
                float updatedQtyInStock = currentQtyInStock + returnedQty;

                // Update the tblproduct table with the new quantity in stock
                stmt = con.prepareStatement("UPDATE tblproduct SET qty_in_stock = ? WHERE product_id = ?");
                stmt.setFloat(1, updatedQtyInStock);
                stmt.setInt(2, productId);
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle exception properly, maybe log it or show an error message
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace(); // Handle exception properly, maybe log it or show an error message
            }
        }
    }
    private int findQtyInStock(int productId){
        int selectedIndex = jtProductList.getSelectedRow();
        int qtyInStock=0;
        if(selectedIndex != -1){
            Connection con = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;

                try {
                    con = DB_Connection.getConnection();
                    stmt = con.prepareStatement("SELECT * from tblcustomer;");

                    rs = stmt.executeQuery();
                    while (rs.next()) {
                        int id = rs.getInt("customer_id");
                        String name = rs.getString("customer_name");
                        int age = rs.getInt("age");
                        String gender = rs.getString("gender");
                        String contact = rs.getString("contact");
                        String address = rs.getString("address");

                        Object[] rowData = {id, name, age, gender, contact, address};

                        model.addRow(rowData);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace(); // Handle exception properly, maybe log it or show an error message
                } finally {
                    try {
                        if (rs != null) rs.close();
                        if (stmt != null) stmt.close();
                        if (con != null) con.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace(); // Handle exception properly, maybe log it or show an error message
                    }
                }
        }
        return qtyInStock;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtProductList;
    // End of variables declaration//GEN-END:variables
}