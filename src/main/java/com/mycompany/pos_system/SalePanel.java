/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pos_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class SalePanel extends javax.swing.JPanel {

    public int insertInvoice(int customerId, float totalAmount,int totalqty) throws SQLException {
        String insertInvoiceSQL = "INSERT INTO tblinvoice (customer_id, total_amount,qty_ordered) "
                                + "VALUES (?, ?, ?)";
        try (Connection con = DB_Connection.getConnection();
            PreparedStatement statement = con.prepareStatement(insertInvoiceSQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, customerId);
            statement.setFloat(2, totalAmount);
            statement.setFloat(3, totalqty);
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating invoice failed, no rows affected.");
            }

            // Retrieve the generated invoice_id
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Return the generated invoice_id
                } else {
                    throw new SQLException("Creating invoice failed, no ID obtained.");
                }
            }
        }
    }

    // Method to insert sales data into tblsales
    public void insertSales(int invoiceId, int productId, int quantity, float unitPrice) throws SQLException {
        String insertSalesSQL = "INSERT INTO tblsales "
                + "(invoice_id, product_id, quantity, unit_price, sub_total) "
                + "VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DB_Connection.getConnection();
             PreparedStatement statement = con.prepareStatement(insertSalesSQL)) {
            statement.setInt(1, invoiceId);
            statement.setInt(2, productId);
            statement.setInt(3, quantity);
            statement.setFloat(4, unitPrice);
            statement.setFloat(5, quantity * unitPrice);
            statement.executeUpdate();
        }
    }
    
    private int SearchCusIdByName(String name){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
    
        try {
            int id=0;
            con = DB_Connection.getConnection();
            stmt = con.prepareStatement("""
                                        SELECT 
                                            customer_id
                                        FROM
                                            tblcustomer
                                        WHERE
                                            customer_name=?;""");
            stmt.setString(1, name);
            rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("customer_id");
            }
            return id;
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
        return 0;
    }
    private void showData() {
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    try {
        con = DB_Connection.getConnection();
        stmt = con.prepareStatement("""
                                    SELECT 
                                        product_id,
                                        product_name,
                                        unit_price,
                                        qty_in_stock
                                    FROM 
                                        tblproduct;""");
        
        rs = stmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("product_id");
            String name = rs.getString("product_name");
            int price = rs.getInt("unit_price");
            int qty = rs.getInt("qty_in_stock");
            Object[] rowData = {id,name,qty,price};
            model.addRow(rowData);
        }
        stmt = con.prepareStatement("""
                                    SELECT 
                                        customer_name
                                    FROM 
                                        tblcustomer;""");
        rs = stmt.executeQuery();
        while (rs.next()) {
            cboCustomer.addItem(rs.getString("customer_name"));
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
    DefaultTableModel ordertbl;
    public SalePanel() {
        initComponents();
        model =(DefaultTableModel) jtProductList.getModel();
        ordertbl = (DefaultTableModel) tableOrdered.getModel();
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

        txtPrice = new javax.swing.JTextField();
        txtQtyInStock = new javax.swing.JTextField();
        btnSale = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductList = new javax.swing.JTable();
        txtQty = new javax.swing.JSpinner();
        txtCategory = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cboCustomer = new javax.swing.JComboBox<>();
        txtTotal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableOrdered = new javax.swing.JTable();
        btnAddToCart = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(700, 528));

        txtPrice.setEditable(false);
        txtPrice.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        txtPrice.setFocusable(false);

        txtQtyInStock.setEditable(false);
        txtQtyInStock.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        txtQtyInStock.setFocusable(false);

        btnSale.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        btnSale.setText("Sale");
        btnSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaleActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel9.setText("Product Name");

        jLabel10.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel10.setText("Instock");

        jLabel11.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel11.setText("Categogry");

        jLabel12.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel12.setText("Price");

        jLabel13.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel13.setText("Quantity");

        txtName.setEditable(false);
        txtName.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        txtName.setFocusable(false);
        txtName.setMinimumSize(new java.awt.Dimension(160, 30));

        jtProductList.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtProductList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "In Stock", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProductList.setRowHeight(30);
        jtProductList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProductListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProductList);
        if (jtProductList.getColumnModel().getColumnCount() > 0) {
            jtProductList.getColumnModel().getColumn(0).setPreferredWidth(40);
            jtProductList.getColumnModel().getColumn(0).setMaxWidth(40);
            jtProductList.getColumnModel().getColumn(1).setPreferredWidth(125);
            jtProductList.getColumnModel().getColumn(2).setPreferredWidth(50);
            jtProductList.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        txtQty.setModel(new javax.swing.SpinnerNumberModel(0, 0, 0, 1));
        txtQty.setMinimumSize(new java.awt.Dimension(160, 30));
        txtQty.setPreferredSize(new java.awt.Dimension(160, 30));
        txtQty.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtQtyStateChanged(evt);
            }
        });

        txtCategory.setEditable(false);
        txtCategory.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        txtCategory.setFocusable(false);

        jLabel14.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel14.setText("Customer");

        cboCustomer.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        txtTotal.setFocusable(false);
        txtTotal.setMinimumSize(new java.awt.Dimension(160, 30));

        jLabel15.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel15.setText("Total Amount");

        tableOrdered.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tableOrdered.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Qty", "Unit Price", "Cus ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableOrdered.setRowHeight(30);
        tableOrdered.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableOrderedMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableOrdered);
        if (tableOrdered.getColumnModel().getColumnCount() > 0) {
            tableOrdered.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableOrdered.getColumnModel().getColumn(0).setMaxWidth(40);
            tableOrdered.getColumnModel().getColumn(1).setPreferredWidth(125);
            tableOrdered.getColumnModel().getColumn(1).setMaxWidth(125);
            tableOrdered.getColumnModel().getColumn(2).setPreferredWidth(40);
            tableOrdered.getColumnModel().getColumn(2).setMaxWidth(40);
            tableOrdered.getColumnModel().getColumn(3).setPreferredWidth(100);
            tableOrdered.getColumnModel().getColumn(4).setPreferredWidth(50);
            tableOrdered.getColumnModel().getColumn(4).setMaxWidth(50);
        }

        btnAddToCart.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        btnAddToCart.setText("Add To Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cboCustomer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtQtyInStock, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtCategory, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSale, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtQtyInStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSale, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void updateQty(int qtyOrdered){
        int selectedIndex = jtProductList.getSelectedRow();
        int qtyInStock = Integer.parseInt(txtQtyInStock.getText());
        if(selectedIndex != -1){
            Connection con = null;
            PreparedStatement stmt = null;  
            ResultSet rs = null;
            int productId =Integer.parseInt(jtProductList.getValueAt(selectedIndex, 0).toString());


            try {

                con = DB_Connection.getConnection();
                stmt = con.prepareStatement("UPDATE tblproduct"
                        + " SET qty_in_stock=?"
                        + " WHERE product_id=?");

                stmt.setFloat(1, qtyInStock-qtyOrdered);
                stmt.setInt(2, productId); // You need to replace 'productId' with the actual product ID you want to update

                stmt.executeUpdate();
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
    }
    private void btnSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleActionPerformed
        // TODO add your handling code here:
        if(tableOrdered.getRowCount()==0)
        {
            JOptionPane.showMessageDialog(this, "There is no item in cart");
        }else {
            int invoiceId=0;
            int totalqty=0;
            double total =0.0;
            for(int i=0;i<tableOrdered.getRowCount();i++){
                totalqty += Integer.parseInt(tableOrdered.getValueAt(i,2).toString());
                total += Double.parseDouble(tableOrdered.getValueAt(i,3).toString())*Integer.parseInt(tableOrdered.getValueAt(i,2).toString());
            }
//            JOptionPane.showMessageDialog(this, total);// Handle exception properly, maybe log it or show an error message               
//            JOptionPane.showMessageDialog(this, totalqty);
            try{
                int cusId = Integer.parseInt(tableOrdered.getValueAt(0,4).toString());
                invoiceId = insertInvoice(cusId,(float)total,totalqty);
                } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(this, ex.getMessage());// Handle exception properly, maybe log it or show an error message
                }
            for(int i=0;i<tableOrdered.getRowCount();i++){
               int proId = Integer.parseInt(tableOrdered.getValueAt(i,0).toString());
//               String proName = tableOrdered.getValueAt(i,1)+"";
               int qtyOrderedSale = Integer.parseInt(tableOrdered.getValueAt(i,2).toString());
               float unitPrice = Float.parseFloat(tableOrdered.getValueAt(i,3).toString());
//               JOptionPane.showMessageDialog(this, proId);
//               JOptionPane.showMessageDialog(this, qtyOrderedSale);
//               JOptionPane.showMessageDialog(this, unitPrice);
               try{
                    insertSales(invoiceId, proId, qtyOrderedSale, unitPrice);
                    JOptionPane.showMessageDialog(this, "Sale Completed");
               } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());// Handle exception properly, maybe log it or show an error message
               }  

//               JOptionPane.showMessageDialog(this, invoiceId);
               
            }
        }
    }//GEN-LAST:event_btnSaleActionPerformed

    private void jtProductListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProductListMouseClicked
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int selectedIndex = jtProductList.getSelectedRow();
        try {
            con = DB_Connection.getConnection();
            stmt = con.prepareStatement("""
                                        SELECT
                                            p.product_id,
                                            p.product_name,
                                            c.category_name,
                                            p.qty_in_stock,
                                            p.unit_price
                                        FROM 
                                            tblproduct p
                                        LEFT JOIN 
                                            tblproductcategory c ON p.category_id = c.category_id
                                        WHERE p.product_id = ?;""");
            stmt.setString(1, jtProductList.getValueAt(selectedIndex, 0).toString());
            rs = stmt.executeQuery();
            while (rs.next()) {
                txtName.setText(rs.getString("product_name"));
                txtCategory.setText(rs.getString("category_name"));
                txtPrice.setText(rs.getFloat("unit_price")+"");
                txtQtyInStock.setText(jtProductList.getValueAt(selectedIndex, 2).toString());
                txtQty.setModel(new SpinnerNumberModel(0, 0, Integer.parseInt(jtProductList.getValueAt(selectedIndex, 2).toString()), 1));
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, ex.getMessage());// Handle exception properly, maybe log it or show an error message
             // Handle exception properly, maybe log it or show an error message
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace(); // Handle exception properly, maybe log it or show an error message
            }
        }    
    }//GEN-LAST:event_jtProductListMouseClicked

    private void txtQtyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtQtyStateChanged
        // TODO add your handling code here:
            Double total = Double.parseDouble(txtPrice.getText())*Double.parseDouble(txtQty.getValue().toString());
            String totalAmount = total.toString();
            txtTotal.setText(totalAmount);
    }//GEN-LAST:event_txtQtyStateChanged

    private void tableOrderedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableOrderedMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableOrderedMouseClicked

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        if(
            txtName.getText().equals("") ||
            txtCategory.getText().equals("") ||
            txtPrice.getText().equals(""))
            {
            JOptionPane.showMessageDialog(this, "Please choose a product to add to card");
        }else{
                int selectedIndex = jtProductList.getSelectedRow();
                String Id = jtProductList.getValueAt(selectedIndex, 0).toString();
                String Pname = txtName.getText();
                String qty = txtQty.getValue().toString();
                String unitprice = txtPrice.getText();
                int cusId = SearchCusIdByName(cboCustomer.getSelectedItem().toString());
                if(txtQtyInStock.getText().equals("0")){
                    JOptionPane.showMessageDialog(this, "Product out of stock");
                    }
                else{
                    if(qty.equals("0")){
                    JOptionPane.showMessageDialog(this, "Enter quantity to add to card");
                    }
                    else{
                        try {
                            Object[] rowData = {Id,Pname,qty,unitprice,cusId};
                            ordertbl.addRow(rowData); 
                            jtProductList.setValueAt(Integer.parseInt(jtProductList.getValueAt(selectedIndex, 2).toString())-Integer.parseInt(qty),selectedIndex, 2);
                            updateQty(Integer.parseInt(qty));
                            clear();
                        } catch (Exception ex) {
                           JOptionPane.showMessageDialog(this, ex.getMessage());// Handle exception properly, maybe log it or show an error message
                         // Handle exception properly, maybe log it or show an error message
                        }
                    }
                    
                }
        }
        
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void clear(){
        txtName.setText("");
        txtCategory.setText("");
        txtQtyInStock.setText("");
        cboCustomer.setSelectedIndex(0);
        txtPrice.setText("");
        txtTotal.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnSale;
    private javax.swing.JComboBox<String> cboCustomer;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtProductList;
    private javax.swing.JTable tableOrdered;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JSpinner txtQty;
    private javax.swing.JTextField txtQtyInStock;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
