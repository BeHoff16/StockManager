/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import control.ControladorGerencia;
import control.ControladorMenu;
import control.ControladorTela;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import model.Produto;

/**
 *
 * @author behof
 */
public class GerenciaView extends javax.swing.JPanel {

    private ControladorGerencia controladorGerencia;
    private ControladorTela controladorTela;

    public GerenciaView(ControladorTela controladorTela) {
        this.controladorTela = controladorTela;
        initComponents();
        controladorGerencia = new ControladorGerencia();
        jLabelTotal.setOpaque(true);
        jLabelTotal.setBackground(new Color(245, 197, 24));
        jLabelTotal.setForeground(new Color(30, 43, 38));
        jLabelTotal.setBorder(BorderFactory.createEmptyBorder(6, 16, 6, 16));
        atualizarRelatorio();
    }

    private void atualizarRelatorio() {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTableVendas.getModel();
        modelo.setRowCount(0);
        for (Object[] linha : controladorGerencia.vendasPorProduto()) {
            modelo.addRow(new Object[]{linha[0], linha[1], "R$ " + String.format("%,.2f", (double) linha[2])});
        }
        jLabelTotal.setText("Total vendido: R$ " + String.format("%,.2f", controladorGerencia.totalVendido()));

        ArrayList<Produto> baixo = controladorGerencia.estoqueBaixo();
        modelo = (javax.swing.table.DefaultTableModel) jTableBaixo.getModel();
        modelo.setRowCount(0);
        for (Produto p : baixo) {
            modelo.addRow(new Object[]{p.getNome(), p.getQuantidade()});
        }
        jScrollPaneBaixo.setVisible(!baixo.isEmpty());
        if (baixo.isEmpty()) {
            jLabelAviso.setForeground(new Color(30, 43, 38));
            jLabelAviso.setText("Nenhum produto com menos de " + ControladorMenu.ESTOQUE_BAIXO + " unidades.");
        } else {
            jLabelAviso.setForeground(new Color(160, 40, 30));
            jLabelAviso.setText("Atenção: " + baixo.size() + (baixo.size() == 1 ? " produto" : " produtos")
                    + " com menos de " + ControladorMenu.ESTOQUE_BAIXO + " unidades");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jButtonMenu = new javax.swing.JButton();
        jLabelVendas = new javax.swing.JLabel();
        jScrollPaneVendas = new javax.swing.JScrollPane();
        jTableVendas = new javax.swing.JTable();
        jLabelTotal = new javax.swing.JLabel();
        jLabelAviso = new javax.swing.JLabel();
        jScrollPaneBaixo = new javax.swing.JScrollPane();
        jTableBaixo = new javax.swing.JTable();

        setForeground(new java.awt.Color(51, 51, 51));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabelTitulo.setText("Gerência");

        jButtonMenu.setText("Voltar ao Menu");
        jButtonMenu.addActionListener(this::jButtonMenuActionPerformed);

        jLabelVendas.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabelVendas.setText("Vendas por produto");

        jTableVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Unidades vendidas", "Total vendido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
        jScrollPaneVendas.setViewportView(jTableVendas);
        if (jTableVendas.getColumnModel().getColumnCount() > 0) {
            jTableVendas.getColumnModel().getColumn(0).setPreferredWidth(240);
            jTableVendas.getColumnModel().getColumn(1).setPreferredWidth(110);
            jTableVendas.getColumnModel().getColumn(2).setPreferredWidth(110);
        }

        jLabelTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTotal.setText("Total vendido: R$ 0,00");

        jLabelAviso.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabelAviso.setText("Estoque baixo");

        jTableBaixo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Qtd"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneBaixo.setViewportView(jTableBaixo);
        if (jTableBaixo.getColumnModel().getColumnCount() > 0) {
            jTableBaixo.getColumnModel().getColumn(0).setPreferredWidth(230);
            jTableBaixo.getColumnModel().getColumn(1).setPreferredWidth(70);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonMenu))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVendas)
                            .addComponent(jScrollPaneVendas, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                            .addComponent(jLabelTotal))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAviso)
                            .addComponent(jScrollPaneBaixo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitulo)
                    .addComponent(jButtonMenu))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelVendas)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPaneVendas, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabelTotal))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelAviso)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPaneBaixo, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        controladorTela.abrirTelaMenu();
    }//GEN-LAST:event_jButtonMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JLabel jLabelAviso;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelVendas;
    private javax.swing.JScrollPane jScrollPaneBaixo;
    private javax.swing.JScrollPane jScrollPaneVendas;
    private javax.swing.JTable jTableBaixo;
    private javax.swing.JTable jTableVendas;
    // End of variables declaration//GEN-END:variables
}
