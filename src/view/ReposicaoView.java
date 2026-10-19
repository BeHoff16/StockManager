/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import control.ControladorReposicao;
import control.ControladorTela;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.swing.JOptionPane;
import model.Produto;

/**
 *
 * @author behof
 */
public class ReposicaoView extends javax.swing.JPanel {

    private ControladorReposicao controladorReposicao;
    private ControladorTela controladorTela;
    private ArrayList<Produto> resultadosExibidos = new ArrayList<>();
    private ArrayList<Produto> itensConferencia = new ArrayList<>();

    public ReposicaoView(ControladorTela controladorTela) {
        this.controladorTela = controladorTela;
        initComponents();
        controladorReposicao = new ControladorReposicao(controladorTela, this);
        controladorReposicao.atualizarLista();
    }

    public void atualizarConferencia(LinkedHashMap<Produto, Integer> conferencia) {
        itensConferencia = new ArrayList<>(conferencia.keySet());
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTableConferencia.getModel();
        modelo.setRowCount(0);
        for (Produto p : itensConferencia) {
            modelo.addRow(new Object[]{p.getNome(), conferencia.get(p)});
        }
        atualizarResultados();
    }

    private void atualizarResultados() {
        String texto = jTextFieldBusca.getText().trim();
        resultadosExibidos = controladorReposicao.buscar(texto);
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTableResultados.getModel();
        modelo.setRowCount(0);
        for (Produto p : resultadosExibidos) {
            modelo.addRow(new Object[]{p.getNome(), p.getQuantidade()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneConferencia = new javax.swing.JScrollPane();
        jTableConferencia = new javax.swing.JTable();
        jLabelBusca = new javax.swing.JLabel();
        jTextFieldBusca = new javax.swing.JTextField();
        jScrollPaneResultados = new javax.swing.JScrollPane();
        jTableResultados = new javax.swing.JTable();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();

        setForeground(new java.awt.Color(51, 51, 51));

        jTableConferencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Qtd a Adicionar"
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
        jScrollPaneConferencia.setViewportView(jTableConferencia);
        if (jTableConferencia.getColumnModel().getColumnCount() > 0) {
            jTableConferencia.getColumnModel().getColumn(0).setPreferredWidth(250);
            jTableConferencia.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        jLabelBusca.setText("Código de barras ou nome");

        jTextFieldBusca.addActionListener(this::jTextFieldBuscaActionPerformed);
        jTextFieldBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscaKeyReleased(evt);
            }
        });

        jTableResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Estoque Atual"
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
        jScrollPaneResultados.setViewportView(jTableResultados);
        if (jTableResultados.getColumnModel().getColumnCount() > 0) {
            jTableResultados.getColumnModel().getColumn(0).setPreferredWidth(180);
            jTableResultados.getColumnModel().getColumn(1).setPreferredWidth(80);
        }

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(this::jButtonAdicionarActionPerformed);

        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(this::jButtonRemoverActionPerformed);

        jButtonConfirmar.setText("Confirmar Reposição");
        jButtonConfirmar.addActionListener(this::jButtonConfirmarActionPerformed);

        jButtonVoltar.setText("Voltar ao Menu");
        jButtonVoltar.addActionListener(this::jButtonVoltarActionPerformed);

        jLabelTitulo.setText("Reposição");
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
                .addComponent(jScrollPaneConferencia, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelBusca)
                    .addComponent(jTextFieldBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jScrollPaneResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jButtonRemover, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jButtonConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelTitulo)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneConferencia, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelBusca)
                        .addGap(3, 3, 3)
                        .addComponent(jTextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPaneResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(jButtonAdicionar)
                        .addGap(8, 8, 8)
                        .addComponent(jButtonRemover)
                        .addGap(8, 8, 8)
                        .addComponent(jButtonConfirmar)
                        .addGap(8, 8, 8)
                        .addComponent(jButtonVoltar)))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscaActionPerformed
        String texto = jTextFieldBusca.getText().trim();
        Produto p = controladorReposicao.buscarPorCodigo(texto);
        if (p == null && resultadosExibidos.size() == 1) {
            p = resultadosExibidos.get(0);
        }
        if (p == null) return;
        controladorReposicao.adicionarNaConferencia(p);
        jTextFieldBusca.setText("");
        atualizarResultados();
        jTextFieldBusca.requestFocusInWindow();
    }//GEN-LAST:event_jTextFieldBuscaActionPerformed

    private void jTextFieldBuscaKeyReleased(java.awt.event.KeyEvent evt) {
        atualizarResultados();
    }

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        int index = jTableResultados.getSelectedRow();
        if (index < 0 || index >= resultadosExibidos.size()) return;
        controladorReposicao.adicionarNaConferencia(resultadosExibidos.get(index));
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        int index = jTableConferencia.getSelectedRow();
        if (index < 0 || index >= itensConferencia.size()) return;
        controladorReposicao.removerDaConferencia(itensConferencia.get(index));
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        if (itensConferencia.isEmpty()) return;
        int resposta = JOptionPane.showConfirmDialog(this, "Confirmar a reposição e atualizar o estoque?", "Confirmar Reposição", JOptionPane.YES_NO_OPTION);
        if (resposta != JOptionPane.YES_OPTION) return;
        controladorReposicao.confirmar();
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        controladorTela.abrirTelaMenu();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabelBusca;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPaneConferencia;
    private javax.swing.JScrollPane jScrollPaneResultados;
    private javax.swing.JTable jTableConferencia;
    private javax.swing.JTable jTableResultados;
    private javax.swing.JTextField jTextFieldBusca;
    // End of variables declaration//GEN-END:variables
}
