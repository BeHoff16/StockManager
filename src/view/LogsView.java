/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import control.ControladorLogs;
import control.ControladorTela;
import model.Log;

/**
 *
 * @author behof
 */
public class LogsView extends javax.swing.JPanel {

    private ControladorLogs controladorLogs;
    private ControladorTela controladorTela;

    public LogsView(ControladorTela controladorTela) {
        this.controladorTela = controladorTela;
        initComponents();
        controladorLogs = new ControladorLogs(controladorTela);
        atualizarLista();
    }

    private void atualizarLista() {
        java.util.ArrayList<Log> logs = controladorLogs.getLogs();
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTableLogs.getModel();
        modelo.setRowCount(0);
        for (int i = logs.size() - 1; i >= 0; i--) {
            Log l = logs.get(i);
            modelo.addRow(new Object[]{l.getDataHora(), l.getUsuario(), l.getAcao()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jScrollPaneLogs = new javax.swing.JScrollPane();
        jTableLogs = new javax.swing.JTable();
        jButtonVoltar = new javax.swing.JButton();

        setForeground(new java.awt.Color(51, 51, 51));

        jLabelTitulo.setText("Logs de Alterações");
        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 20));

        jTableLogs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data/Hora", "Usuário", "Ação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneLogs.setViewportView(jTableLogs);
        if (jTableLogs.getColumnModel().getColumnCount() > 0) {
            jTableLogs.getColumnModel().getColumn(0).setPreferredWidth(150);
            jTableLogs.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTableLogs.getColumnModel().getColumn(2).setPreferredWidth(330);
        }

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(this::jButtonVoltarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo)
                    .addComponent(jScrollPaneLogs, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelTitulo)
                .addGap(8, 8, 8)
                .addComponent(jScrollPaneLogs, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jButtonVoltar)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        controladorTela.abrirTelaUsuarios();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPaneLogs;
    private javax.swing.JTable jTableLogs;
    // End of variables declaration//GEN-END:variables
}
