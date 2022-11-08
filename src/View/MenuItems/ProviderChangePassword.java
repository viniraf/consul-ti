/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.MenuItems;

import Connection.MySQL;
import Entities.Provider;
import javax.swing.JOptionPane;

/**
 *
 * @author AnderSecurity
 */
public class ProviderChangePassword extends javax.swing.JFrame {

MySQL conectar = new MySQL();
Provider newProvider = new Provider();

    public ProviderChangePassword() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void ChangePassword () {
        this.conectar.conectaBanco();
        Provider newProvider = new Provider();
        String consultarUsuario = txtUser.getText();
        
        try {
            this.conectar.executarSQL( "SELECT login, password FROM provider WHERE login = '" + consultarUsuario + "';");
            while(this.conectar.getResultSet().next()) {
            newProvider.SetLogin(this.conectar.getResultSet().getString(1));
            newProvider.SetPassword(this.conectar.getResultSet().getString(2));
        }
            } catch (Exception e) {
            System.out.println("Erro ao encontrar prestador: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao encontrar Prestador!");
        }
        finally {

            
            if(newProvider.GetLogin() == null) {
            JOptionPane.showMessageDialog(null, "Login de prestador não encontrado!");
            ClearData();
            this.conectar.fechaBanco();
            }
                else {
                    String oldPass = txtOldPass.getText();
                    String ProviderOldPass = newProvider.GetPassword();
                    
                    if (oldPass == null ? ProviderOldPass != null : !oldPass.equals(ProviderOldPass)) {
                        JOptionPane.showMessageDialog(null, "A senha antiga está incorreta!");
                        ClearData();
                    }
                    else {
                        UpdatePassword();
                    }
                } 
    }
        
    }
    
    public void UpdatePassword () {
        
        try {
            this.conectar.updateSQL(
            "UPDATE provider SET "
            + "password = '" + txtNewPass.getText() + "'"
            + " WHERE login = '" + txtUser.getText() + "';"
            );
            JOptionPane.showMessageDialog(null, "Senha atualizada com sucesso!");
            } catch (Exception e) {
            System.out.println("Erro ao atualizar a senha: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao atualizar a senha!");
        } finally {
            ClearData();
            this.conectar.fechaBanco();
    }
    }
    
    private void ClearData() {
        txtUser.setText("");
        txtOldPass.setText("");
        txtNewPass.setText("");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        lblOldPass = new javax.swing.JLabel();
        lblNewPass = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        btnChangePass = new javax.swing.JButton();
        txtOldPass = new javax.swing.JPasswordField();
        txtNewPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Alterar Senha"));
        jPanel1.setName("Alterar Senha"); // NOI18N

        lblUser.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        lblUser.setText("Usuário:");

        lblOldPass.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        lblOldPass.setText("Senha Antiga:");

        lblNewPass.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        lblNewPass.setText("Nova Senha:");

        btnChangePass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnChangePass.setText("ALTERAR SENHA");
        btnChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblOldPass)
                            .addComponent(lblNewPass))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOldPass)
                            .addComponent(txtNewPass)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 36, Short.MAX_VALUE)
                        .addComponent(lblUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOldPass)
                    .addComponent(txtOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNewPass)
                    .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnChangePass, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassActionPerformed
        ChangePassword();
    }//GEN-LAST:event_btnChangePassActionPerformed

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
            java.util.logging.Logger.getLogger(ProviderChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProviderChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProviderChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProviderChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProviderChangePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePass;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNewPass;
    private javax.swing.JLabel lblOldPass;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPasswordField txtNewPass;
    private javax.swing.JPasswordField txtOldPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
