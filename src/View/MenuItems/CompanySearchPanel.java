/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.MenuItems;

import Connection.MySQL;
import Entities.Company;
import Entities.OnlyNumbers;
import javax.swing.JOptionPane;


public class CompanySearchPanel extends javax.swing.JFrame {

MySQL conectar = new MySQL();
Company newCompany = new Company();

    public CompanySearchPanel() {
        initComponents();
        setLocationRelativeTo(null);
        txtCnpj.setDocument(new OnlyNumbers());
    }

    
    private void SearchCompany(Company newCompany) {
        this.conectar.conectaBanco();
        
        String consultaCnpj = this.txtCnpj.getText();
        
        try {
            this.conectar.executarSQL(
            "SELECT "
            + "name,"
            + "cnpj,"
            + "category,"
            + "monthsContractTime,"
            + "DATE_FORMAT(dateCreation, \"%d/%m/%Y\")"
             + " FROM"
            + " company"
          + " WHERE"
            + " cnpj = '" + consultaCnpj + "'" + ";"
            );
        while(this.conectar.getResultSet().next()) {
            newCompany.SetName(this.conectar.getResultSet().getString(1));
            newCompany.SetCnpj(this.conectar.getResultSet().getString(2));
            newCompany.SetCategory(this.conectar.getResultSet().getString(3));
            newCompany.SetMonthsContractTime(Integer.parseInt(this.conectar.getResultSet().getString(4)));
            newCompany.SetCreationDate(this.conectar.getResultSet().getString(5));
        }
        if(newCompany.GetCnpj() == "") {
            JOptionPane.showMessageDialog(null, "Company não encontrado!");
        }
        
        } catch (Exception e) {
            System.out.println("Erro ao consultar Company " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao buscar Company!");
        
        } finally {
            txtName.setText(newCompany.GetName());
            txtCnpj.setText(newCompany.GetCnpj());
            txtCategory.setText(newCompany.GetCategory());
            txtMonths.setText(Integer.toString(newCompany.GetMonthsContractTime()));
            txtCreationDate.setText(newCompany.GetCreationDate().replace('-', '/'));
            this.conectar.fechaBanco();     
    }
    }
    
        private void UpdateCompany(Company newCompany) {
        
        newCompany.SetName(txtName.getText());
        newCompany.SetCnpj(txtCnpj.getText());
        newCompany.SetCategory(txtCategory.getText());
        newCompany.SetMonthsContractTime(Integer.parseInt(txtMonths.getText()));
        newCompany.SetCreationDate(txtCreationDate.getText());
          
        this.conectar.conectaBanco();
        try {
            this.conectar.updateSQL(
            "UPDATE company SET "
            + "name = '" + newCompany.GetName() + "',"
            + "cnpj = '" + newCompany.GetCnpj() + "',"
            + "category = '" + newCompany.GetCategory() + "',"
            + "monthsContractTime = " + newCompany.GetMonthsContractTime() + ","
            + "dateCreation = STR_TO_DATE(\"" + newCompany.GetCreationDate() + "\", \"%d/%m/%Y\")"
            + " WHERE cnpj = '" + newCompany.GetCnpj() + "';"
            );
            JOptionPane.showMessageDialog(null, "Empresa atualizada com sucesso!");
            } catch (Exception e) {
            System.out.println("Erro ao atualizar a empresa: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao atualizar a empresa!");
        
        } finally {
            ClearData();
            this.conectar.fechaBanco();
    }
    }
        
    private void DeleteCompany() {
        
        this.conectar.conectaBanco();
        String deleteCnpj = this.txtCnpj.getText();
        
        try {
            this.conectar.updateSQL(
            "DELETE FROM company "
                    + "WHERE cnpj = '" + deleteCnpj + "';"
            );
            JOptionPane.showMessageDialog(null, "Empresa removida!");
        } catch (Exception e) {
            System.out.println("Erro ao deletar empresa: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao deletar empresa!");
        
        } finally {
            ClearData();
            this.conectar.fechaBanco();     
    }
        
    }        
        
        
        private void ClearData() {
        txtName.setText("");
        txtCnpj.setText("");
        txtCategory.setText("");   
        txtMonths.setText("");
        txtCreationDate.setText("");
    }
    
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblCategory = new javax.swing.JLabel();
        lblContract = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtCreationDate = new javax.swing.JTextField();
        lblName1 = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        txtCategory = new javax.swing.JTextField();
        lblContract1 = new javax.swing.JLabel();
        txtMonths = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta de Empresas"));
        jPanel1.setName("Consulta de Empresas"); // NOI18N

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblName.setText("Nome:");

        lblCategory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCategory.setText("Categoria:");

        lblContract.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblContract.setText("Contrato (meses):");

        lblName1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblName1.setText("CNPJ:");

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setText("DELETAR");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSearch.setText("BUSCAR");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setText("LIMPAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setText("ATUALIZAR");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        txtCategory.setFocusable(false);

        lblContract1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblContract1.setText("Data de Início:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblContract)
                            .addComponent(lblCategory)
                            .addComponent(lblName)
                            .addComponent(lblName1))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtName)
                    .addComponent(txtCnpj)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtMonths, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblContract1))
                            .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCreationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategory)
                    .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCreationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContract)
                    .addComponent(lblContract1)
                    .addComponent(txtMonths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        UpdateCompany(newCompany);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        ClearData();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DeleteCompany();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        SearchCompany(newCompany);
    }//GEN-LAST:event_btnSearchActionPerformed

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
            java.util.logging.Logger.getLogger(CompanySearchPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompanySearchPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompanySearchPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompanySearchPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompanySearchPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblContract;
    private javax.swing.JLabel lblContract1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName1;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextField txtCnpj;
    private javax.swing.JTextField txtCreationDate;
    private javax.swing.JTextField txtMonths;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
