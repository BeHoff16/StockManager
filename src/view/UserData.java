/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import control.ControladorTela;
import control.ControladorUsuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Usuario;
/**
 *
 * @author behof
 */
public class UserData extends javax.swing.JPanel {

    private ControladorUsuario controladorUsuario;
    private ControladorTela controladorTela;

    public UserData(ControladorTela controladorTela) {
        this.controladorTela = controladorTela;
        initComponents();
        controladorUsuario = new ControladorUsuario(controladorTela, this);
        controladorUsuario.atualizarLista();
    }

    public void atualizarLista(ArrayList<Usuario> usuarios) {
        listUsuarios.removeAll();
        for (Usuario u : usuarios) {
            listUsuarios.add("[" + u.getId() + "] " + u.getUser() + " - " + u.getFuncao());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listUsuarios = new java.awt.List();
        jTextFieldUser = new javax.swing.JTextField();
        jTextFieldCpf = new javax.swing.JTextField();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jTextFieldSenha = new javax.swing.JTextField();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonExcluirUsuario = new javax.swing.JButton();
        jButtonEditarUsuario = new javax.swing.JButton();
        jButtonLogs = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();

        setForeground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(640, 400));

        listUsuarios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listUsuariosItemStateChanged(evt);
            }
        });

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "estoquista" }));

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonVoltar.setText("Voltar ao Menu");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuário");

        jLabel2.setText("CPF");

        jLabel3.setText("Tipo");

        jLabel4.setText("Senha");

        jButtonExcluirUsuario.setText("Excluir");
        jButtonExcluirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirUsuarioActionPerformed(evt);
            }
        });

        jButtonEditarUsuario.setText("Editar");
        jButtonEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarUsuarioActionPerformed(evt);
            }
        });

        jButtonLogs.setText("Ver Logs");
        jButtonLogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogsActionPerformed(evt);
            }
        });

        jLabelTitulo.setText("Painel Admin");
        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelTitulo))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(listUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldUser, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(jTextFieldSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(jButtonAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonExcluirUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEditarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonLogs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelTitulo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(listUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)
                        .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(5, 5, 5)
                        .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addComponent(jTextFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jButtonAdicionar)
                        .addGap(8, 8, 8)
                        .addComponent(jButtonExcluirUsuario)
                        .addGap(8, 8, 8)
                        .addComponent(jButtonEditarUsuario)
                        .addGap(8, 8, 8)
                        .addComponent(jButtonLogs)
                        .addGap(8, 8, 8)
                        .addComponent(jButtonVoltar)))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {
        String tipo = (String) jComboBoxTipo.getSelectedItem();
        if (controladorUsuario.loginExiste(jTextFieldUser.getText(), null)) {
            JOptionPane.showMessageDialog(this, "Já existe um usuário com esse login.");
            return;
        }
        controladorUsuario.adicionarUsuario(
            jTextFieldUser.getText(),
            jTextFieldCpf.getText(),
            tipo,
            jTextFieldSenha.getText()
        );
    }

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        controladorTela.abrirTelaMenu();
    }

    private void jButtonExcluirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirUsuarioActionPerformed
        int index = listUsuarios.getSelectedIndex();
        Usuario u = controladorUsuario.getUsuario(index);
        if (u == null) return;
        if (u.getUser().equals("admin")) {
            JOptionPane.showMessageDialog(this, "O usuário admin não pode ser excluído.");
            return;
        }
        if (u.getId() == controladorTela.getUsuarioLogado().getId()) {
            JOptionPane.showMessageDialog(this, "Não é possível excluir o usuário que está logado.");
            return;
        }
        int resposta = JOptionPane.showConfirmDialog(this, "Excluir o usuário " + u.getUser() + "?", "Excluir", JOptionPane.YES_NO_OPTION);
        if (resposta != JOptionPane.YES_OPTION) return;
        controladorUsuario.excluirUsuario(index);
    }//GEN-LAST:event_jButtonExcluirUsuarioActionPerformed

    private void jButtonEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarUsuarioActionPerformed
        int index = listUsuarios.getSelectedIndex();
        Usuario u = controladorUsuario.getUsuario(index);
        if (u == null) return;
        String user = jTextFieldUser.getText();
        String tipo = (String) jComboBoxTipo.getSelectedItem();
        if (controladorUsuario.loginExiste(user, u)) {
            JOptionPane.showMessageDialog(this, "Já existe um usuário com esse login.");
            return;
        }
        if (u.getUser().equals("admin") && (!user.equals("admin") || !tipo.equals("admin"))) {
            JOptionPane.showMessageDialog(this, "Não é possível mudar o login nem o tipo do admin.");
            return;
        }
        int resposta = JOptionPane.showConfirmDialog(this, "Salvar as alterações do usuário " + u.getUser() + "?", "Editar", JOptionPane.YES_NO_OPTION);
        if (resposta != JOptionPane.YES_OPTION) return;
        controladorUsuario.editarUsuario(index, user, jTextFieldCpf.getText(), tipo, jTextFieldSenha.getText());
    }//GEN-LAST:event_jButtonEditarUsuarioActionPerformed

    private void jButtonLogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogsActionPerformed
        controladorTela.abrirTelaLogs();
    }//GEN-LAST:event_jButtonLogsActionPerformed

    private void listUsuariosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listUsuariosItemStateChanged
        int index = listUsuarios.getSelectedIndex();
        Usuario u = controladorUsuario.getUsuario(index);
        if (u == null) return;
        jTextFieldUser.setText(u.getUser());
        jTextFieldCpf.setText(u.getCpf());
        jComboBoxTipo.setSelectedItem(u.getFuncao());
        jTextFieldSenha.setText(u.getSenha());
    }//GEN-LAST:event_listUsuariosItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonEditarUsuario;
    private javax.swing.JButton jButtonExcluirUsuario;
    private javax.swing.JButton jButtonLogs;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JTextField jTextFieldCpf;
    private javax.swing.JTextField jTextFieldSenha;
    private javax.swing.JTextField jTextFieldUser;
    private java.awt.List listUsuarios;
    // End of variables declaration//GEN-END:variables
}
