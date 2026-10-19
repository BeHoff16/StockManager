/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.ControladorStock;
import control.ControladorTela;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Produto;

/**
 *
 * @author behof
 */
public class StockView extends javax.swing.JPanel {

    private ControladorStock controladorStock;
    private ControladorTela controladorTela;
    private ArrayList<Produto> produtosExibidos = new ArrayList<>();

    public StockView(ControladorTela controladorTela) {
        this.controladorTela = controladorTela;
        initComponents();
        controladorStock = new ControladorStock(controladorTela, this);
        controladorStock.atualizarLista();
    }

    public void atualizarLista(ArrayList<Produto> produtos) {
        String busca = jTextFieldBusca.getText().trim().toLowerCase();
        produtosExibidos = new ArrayList<>();
        double valorTotal = 0;
        for (Produto p : produtos) {
            valorTotal += p.getPreco() * p.getQuantidade();
            if (busca.isEmpty() || p.getNome().toLowerCase().contains(busca) || p.getCodigoBarras().toLowerCase().contains(busca)) {
                produtosExibidos.add(p);
            }
        }
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTableProdutos.getModel();
        modelo.setRowCount(0);
        for (Produto p : produtosExibidos) {
            modelo.addRow(new Object[]{p.getNome(), p.getQuantidade(), "R$ " + String.format("%.2f", p.getPreco()), p.getCodigoBarras()});
        }
        jLabelValorTotal.setText("Valor total em estoque: R$ " + String.format("%,.2f", valorTotal));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelBusca = new javax.swing.JLabel();
        jTextFieldBusca = new javax.swing.JTextField();
        jScrollPaneProdutos = new javax.swing.JScrollPane();
        jTableProdutos = new javax.swing.JTable();
        jLabelValorTotal = new javax.swing.JLabel();
        jButtonExcluirProduto = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonMenu = new javax.swing.JButton();
        jButtonNovoProduto = new javax.swing.JButton();
        jButtonEditarProduto = new javax.swing.JButton();

        setForeground(new java.awt.Color(51, 51, 51));

        jLabelBusca.setText("Buscar");

        jTextFieldBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscaKeyReleased(evt);
            }
        });

        jTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Qtd", "Preço", "Código"
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
        jScrollPaneProdutos.setViewportView(jTableProdutos);

        jLabelValorTotal.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabelValorTotal.setText("Valor total em estoque: R$ 0,00");

        jButtonExcluirProduto.setText("Excluir");
        jButtonExcluirProduto.addActionListener(this::jButtonExcluirProdutoActionPerformed);

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabelTitulo.setText("Estoque");

        jButtonMenu.setText("Voltar ao Menu");
        jButtonMenu.addActionListener(this::jButtonMenuActionPerformed);

        jButtonNovoProduto.setText("Novo produto");
        jButtonNovoProduto.addActionListener(this::jButtonNovoProdutoActionPerformed);

        jButtonEditarProduto.setText("Editar");
        jButtonEditarProduto.addActionListener(this::jButtonEditarProdutoActionPerformed);

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
                    .addComponent(jLabelBusca)
                    .addComponent(jTextFieldBusca)
                    .addComponent(jScrollPaneProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelValorTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonNovoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jButtonEditarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jButtonExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitulo)
                    .addComponent(jButtonMenu))
                .addGap(12, 12, 12)
                .addComponent(jLabelBusca)
                .addGap(3, 3, 3)
                .addComponent(jTextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jScrollPaneProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelValorTotal)
                    .addComponent(jButtonNovoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirProdutoActionPerformed
        int index = jTableProdutos.getSelectedRow();
        if (index < 0 || index >= produtosExibidos.size()) return;
        Produto p = produtosExibidos.get(index);
        int resposta = JOptionPane.showConfirmDialog(this, "Excluir o produto " + p.getNome() + "?", "Excluir", JOptionPane.YES_NO_OPTION);
        if (resposta != JOptionPane.YES_OPTION) return;
        controladorStock.excluirProduto(p);
    }//GEN-LAST:event_jButtonExcluirProdutoActionPerformed

    private void jTextFieldBuscaKeyReleased(java.awt.event.KeyEvent evt) {
        controladorStock.atualizarLista();
    }

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        controladorTela.abrirTelaMenu();
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jButtonNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoProdutoActionPerformed
        controladorTela.abrirTelaCadastroProduto(-1, false);
    }//GEN-LAST:event_jButtonNovoProdutoActionPerformed

    private void jButtonEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarProdutoActionPerformed
        int index = jTableProdutos.getSelectedRow();
        if (index < 0 || index >= produtosExibidos.size()) return;
        controladorTela.abrirTelaCadastroProduto(produtosExibidos.get(index).getId(), false);
    }//GEN-LAST:event_jButtonEditarProdutoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditarProduto;
    private javax.swing.JButton jButtonExcluirProduto;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonNovoProduto;
    private javax.swing.JLabel jLabelBusca;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelValorTotal;
    private javax.swing.JScrollPane jScrollPaneProdutos;
    private javax.swing.JTable jTableProdutos;
    private javax.swing.JTextField jTextFieldBusca;
    // End of variables declaration//GEN-END:variables
}
