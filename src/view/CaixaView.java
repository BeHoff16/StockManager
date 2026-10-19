/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import control.ControladorCaixa;
import control.ControladorTela;
import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import model.Produto;

/**
 *
 * @author behof
 */
public class CaixaView extends javax.swing.JPanel {

    private ControladorCaixa controladorCaixa;
    private ControladorTela controladorTela;
    private ArrayList<Produto> resultadosExibidos = new ArrayList<>();
    private ArrayList<Produto> itensCarrinho = new ArrayList<>();

    public CaixaView(ControladorTela controladorTela) {
        this.controladorTela = controladorTela;
        initComponents();
        jLabelTotal.setOpaque(true);
        jLabelTotal.setBackground(new Color(245, 197, 24));
        jLabelTotal.setForeground(new Color(30, 43, 38));
        jLabelTotal.setBorder(BorderFactory.createEmptyBorder(6, 16, 6, 16));
        controladorCaixa = new ControladorCaixa(controladorTela, this);
        controladorCaixa.atualizarLista();
        atualizarResultados("");
    }

    public void atualizarCarrinho(LinkedHashMap<Produto, Integer> carrinho, double total) {
        itensCarrinho = new ArrayList<>(carrinho.keySet());
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTableCarrinho.getModel();
        modelo.setRowCount(0);
        for (Produto p : itensCarrinho) {
            int quantidade = carrinho.get(p);
            double subtotal = p.getPreco() * quantidade;
            modelo.addRow(new Object[]{p.getNome(), quantidade, "R$ " + String.format("%.2f", p.getPreco()), "R$ " + String.format("%.2f", subtotal)});
        }
        jLabelTotal.setText("Total: R$ " + String.format("%,.2f", total));
    }

    private void atualizarResultados(String texto) {
        resultadosExibidos = controladorCaixa.buscar(texto);
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTableResultados.getModel();
        modelo.setRowCount(0);
        for (Produto p : resultadosExibidos) {
            modelo.addRow(new Object[]{p.getNome(), "R$ " + String.format("%.2f", p.getPreco())});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneCarrinho = new javax.swing.JScrollPane();
        jTableCarrinho = new javax.swing.JTable();
        jLabelTotal = new javax.swing.JLabel();
        jLabelBusca = new javax.swing.JLabel();
        jTextFieldBusca = new javax.swing.JTextField();
        jScrollPaneResultados = new javax.swing.JScrollPane();
        jTableResultados = new javax.swing.JTable();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jButtonDarBaixa = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();

        setForeground(new java.awt.Color(51, 51, 51));

        jTableCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Qtd", "Preço Unit.", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneCarrinho.setViewportView(jTableCarrinho);
        if (jTableCarrinho.getColumnModel().getColumnCount() > 0) {
            jTableCarrinho.getColumnModel().getColumn(0).setPreferredWidth(180);
            jTableCarrinho.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTableCarrinho.getColumnModel().getColumn(2).setPreferredWidth(90);
            jTableCarrinho.getColumnModel().getColumn(3).setPreferredWidth(90);
        }

        jLabelTotal.setText("Total: R$ 0,00");
        jLabelTotal.setFont(new java.awt.Font("Segoe UI", 1, 22));

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
                "Nome", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
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

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(this::jButtonAdicionarActionPerformed);

        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(this::jButtonRemoverActionPerformed);

        jButtonDarBaixa.setText("Dar Baixa");
        jButtonDarBaixa.addActionListener(this::jButtonDarBaixaActionPerformed);

        jButtonVoltar.setText("Voltar ao Menu");
        jButtonVoltar.addActionListener(this::jButtonVoltarActionPerformed);

        jLabelTitulo.setText("Caixa");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneCarrinho, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(jLabelTotal))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelBusca)
                    .addComponent(jTextFieldBusca, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jScrollPaneResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jButtonRemover, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jButtonDarBaixa, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneCarrinho, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabelTotal))
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
                        .addComponent(jButtonDarBaixa)
                        .addGap(8, 8, 8)
                        .addComponent(jButtonVoltar)))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscaActionPerformed
        String texto = jTextFieldBusca.getText().trim();
        Produto p = controladorCaixa.buscarPorCodigo(texto);
        if (p == null && resultadosExibidos.size() == 1) {
            p = resultadosExibidos.get(0);
        }
        if (p == null) return;
        controladorCaixa.adicionarAoCarrinho(p);
        jTextFieldBusca.setText("");
        atualizarResultados("");
        jTextFieldBusca.requestFocusInWindow();
    }//GEN-LAST:event_jTextFieldBuscaActionPerformed

    private void jTextFieldBuscaKeyReleased(java.awt.event.KeyEvent evt) {
        atualizarResultados(jTextFieldBusca.getText().trim());
    }

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        int index = jTableResultados.getSelectedRow();
        if (index < 0 || index >= resultadosExibidos.size()) return;
        controladorCaixa.adicionarAoCarrinho(resultadosExibidos.get(index));
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        int index = jTableCarrinho.getSelectedRow();
        if (index < 0 || index >= itensCarrinho.size()) return;
        controladorCaixa.removerDoCarrinho(itensCarrinho.get(index));
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonDarBaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDarBaixaActionPerformed
        if (itensCarrinho.isEmpty()) return;
        Produto insuficiente = controladorCaixa.itemComEstoqueInsuficiente();
        if (insuficiente != null) {
            JOptionPane.showMessageDialog(this, "Estoque insuficiente de " + insuficiente.getNome() + ".");
            return;
        }
        int resposta = JOptionPane.showConfirmDialog(this, "Dar baixa no estoque e finalizar a venda?", "Dar Baixa", JOptionPane.YES_NO_OPTION);
        if (resposta != JOptionPane.YES_OPTION) return;
        controladorCaixa.darBaixa();
    }//GEN-LAST:event_jButtonDarBaixaActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        controladorTela.abrirTelaMenu();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonDarBaixa;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabelBusca;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JScrollPane jScrollPaneCarrinho;
    private javax.swing.JScrollPane jScrollPaneResultados;
    private javax.swing.JTable jTableCarrinho;
    private javax.swing.JTable jTableResultados;
    private javax.swing.JTextField jTextFieldBusca;
    // End of variables declaration//GEN-END:variables
}
