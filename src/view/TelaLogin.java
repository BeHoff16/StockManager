/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import control.ControladorLogin;
import control.ControladorTela;
/**
 *
 * @author behof
 */
public class TelaLogin extends javax.swing.JPanel {

    private ControladorTela controladorTela;

    public TelaLogin(ControladorTela controladorTela) {
        this.controladorTela = controladorTela;
        initComponents();
        inicio();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JTextField();
        jLabelSenha = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jButtonEntrar = new javax.swing.JButton();
        jLabelAviso = new javax.swing.JLabel();

        setForeground(new java.awt.Color(51, 51, 51));

        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/logo.png"))); // NOI18N

        jLabelUser.setText("Usuário");

        jLabelSenha.setText("Senha");

        jPassword.addActionListener(this::jPasswordActionPerformed);

        jButtonEntrar.setText("Entrar");
        jButtonEntrar.addActionListener(this::jButtonEntrarActionPerformed);

        jLabelAviso.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelTitulo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelUser)
                        .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelSenha)
                        .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelAviso)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(20, 20, 20)
                .addComponent(jLabelUser)
                .addGap(4, 4, 4)
                .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabelSenha)
                .addGap(4, 4, 4)
                .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButtonEntrar)
                .addGap(10, 10, 10)
                .addComponent(jLabelAviso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
        c.tentarLogin();
    }//GEN-LAST:event_jButtonEntrarActionPerformed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        c.tentarLogin();
    }//GEN-LAST:event_jPasswordActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JLabel jLabelAviso;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jTextFieldUser;
    // End of variables declaration//GEN-END:variables
    ControladorLogin c;
    public void inicio(){
        c = new ControladorLogin(jLabelAviso, jPassword, jTextFieldUser, controladorTela);
    }
}