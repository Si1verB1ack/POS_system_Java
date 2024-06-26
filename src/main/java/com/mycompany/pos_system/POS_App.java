/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pos_system;

/**
 *
 * @author User
 */
public class POS_App extends javax.swing.JFrame {

    /**
     * Creates new form POS_App
     */
    public POS_App() {
        initComponents();
        PanelContent.removeAll();
        SalePanel sale = new SalePanel();
        sale.setSize(700, 528);
        sale.setLocation(0,0);
        PanelContent.add(sale);
        PanelContent.revalidate();
        PanelContent.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuButton = new javax.swing.ButtonGroup();
        PanelTop = new javax.swing.JPanel();
        PanelBottom = new javax.swing.JPanel();
        PanelMenu = new javax.swing.JPanel();
        BtnSale = new javax.swing.JToggleButton();
        BtnProduct = new javax.swing.JToggleButton();
        BtnReturn = new javax.swing.JToggleButton();
        BtnCategory = new javax.swing.JToggleButton();
        BtnExit = new javax.swing.JToggleButton();
        BtnCustomer = new javax.swing.JToggleButton();
        BtnReport = new javax.swing.JToggleButton();
        PanelContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelTop.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout PanelTopLayout = new javax.swing.GroupLayout(PanelTop);
        PanelTop.setLayout(PanelTopLayout);
        PanelTopLayout.setHorizontalGroup(
            PanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelTopLayout.setVerticalGroup(
            PanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        PanelBottom.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout PanelBottomLayout = new javax.swing.GroupLayout(PanelBottom);
        PanelBottom.setLayout(PanelBottomLayout);
        PanelBottomLayout.setHorizontalGroup(
            PanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelBottomLayout.setVerticalGroup(
            PanelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        PanelMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        MenuButton.add(BtnSale);
        BtnSale.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        BtnSale.setText("Sale");
        BtnSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaleActionPerformed(evt);
            }
        });

        MenuButton.add(BtnProduct);
        BtnProduct.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        BtnProduct.setText("Products");
        BtnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnProductActionPerformed(evt);
            }
        });

        MenuButton.add(BtnReturn);
        BtnReturn.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        BtnReturn.setText("Return");
        BtnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReturnActionPerformed(evt);
            }
        });

        MenuButton.add(BtnCategory);
        BtnCategory.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        BtnCategory.setText("Categories");
        BtnCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCategoryActionPerformed(evt);
            }
        });

        MenuButton.add(BtnExit);
        BtnExit.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        BtnExit.setText("Exit");
        BtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExitActionPerformed(evt);
            }
        });

        MenuButton.add(BtnCustomer);
        BtnCustomer.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        BtnCustomer.setText("Customers");
        BtnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCustomerActionPerformed(evt);
            }
        });

        MenuButton.add(BtnReport);
        BtnReport.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        BtnReport.setText("Report");
        BtnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(BtnCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnReturn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(BtnCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(BtnReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(BtnSale, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(BtnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        PanelContent.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelContent.setPreferredSize(new java.awt.Dimension(700, 528));

        javax.swing.GroupLayout PanelContentLayout = new javax.swing.GroupLayout(PanelContent);
        PanelContent.setLayout(PanelContentLayout);
        PanelContentLayout.setHorizontalGroup(
            PanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );
        PanelContentLayout.setVerticalGroup(
            PanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BtnExitActionPerformed

    private void BtnSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaleActionPerformed
        // TODO add your handling code here:
        PanelContent.removeAll();
        SalePanel sale = new SalePanel();
        sale.setSize(700, 528);
        sale.setLocation(0,0);
        PanelContent.add(sale);
        PanelContent.revalidate();
        PanelContent.repaint();
    }//GEN-LAST:event_BtnSaleActionPerformed

    private void BtnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProductActionPerformed
        // TODO add your handling code here:
        PanelContent.removeAll();
        ProductPanel product = new ProductPanel();
        product.setSize(700, 528);
        product.setLocation(0,0);
        PanelContent.add(product);
        PanelContent.revalidate();
        PanelContent.repaint();
    }//GEN-LAST:event_BtnProductActionPerformed

    private void BtnCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCategoryActionPerformed
        // TODO add your handling code here:
        PanelContent.removeAll();
        CategoryPanel category = new CategoryPanel();
        category.setSize(700, 528);
        category.setLocation(0,0);
        PanelContent.add(category);
        PanelContent.revalidate();
        PanelContent.repaint();
    }//GEN-LAST:event_BtnCategoryActionPerformed

    private void BtnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReturnActionPerformed
        // TODO add your handling code here:
        PanelContent.removeAll();
        ReturnPanel Return = new ReturnPanel();
        Return.setSize(700, 528);
        Return.setLocation(0,0);
        PanelContent.add(Return);
        PanelContent.revalidate();
        PanelContent.repaint();
    }//GEN-LAST:event_BtnReturnActionPerformed

    private void BtnCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCustomerActionPerformed
        // TODO add your handling code here:
        PanelContent.removeAll();
        CustomerPanel cus = new CustomerPanel();
        cus.setSize(700, 528);
        cus.setLocation(0,0);
        PanelContent.add(cus);
        PanelContent.revalidate();
        PanelContent.repaint();
    }//GEN-LAST:event_BtnCustomerActionPerformed

    private void BtnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReportActionPerformed
        // TODO add your handling code here:
        PanelContent.removeAll();
        ReportPanel reportPanel = new ReportPanel();
        reportPanel.setSize(700, 528);
        reportPanel.setLocation(0,0);
        PanelContent.add(reportPanel);
        PanelContent.revalidate();
        PanelContent.repaint();
    }//GEN-LAST:event_BtnReportActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(POS_App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(POS_App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(POS_App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(POS_App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new POS_App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BtnCategory;
    private javax.swing.JToggleButton BtnCustomer;
    private javax.swing.JToggleButton BtnExit;
    private javax.swing.JToggleButton BtnProduct;
    private javax.swing.JToggleButton BtnReport;
    private javax.swing.JToggleButton BtnReturn;
    private javax.swing.JToggleButton BtnSale;
    private javax.swing.ButtonGroup MenuButton;
    private javax.swing.JPanel PanelBottom;
    private javax.swing.JPanel PanelContent;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JPanel PanelTop;
    // End of variables declaration//GEN-END:variables
}
