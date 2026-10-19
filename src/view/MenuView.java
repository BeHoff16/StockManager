/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

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
public class MenuView extends javax.swing.JPanel {

    private ControladorMenu controladorMenu;
    private ControladorTela controladorTela;

    public MenuView(ControladorTela controladorTela) {
        this.controladorTela = controladorTela;
        initComponents();
        controladorMenu = new ControladorMenu();
        jPanelTopo.setBackground(new Color(46, 91, 79));
        jLabelTitulo.setForeground(Color.WHITE);
        jLabelUsuario.setForeground(new Color(214, 228, 221));
        jLabelValor.setOpaque(true);
        jLabelValor.setBackground(new Color(245, 197, 24));
        jLabelValor.setForeground(new Color(30, 43, 38));
        jLabelValor.setBorder(BorderFactory.createEmptyBorder(6, 16, 6, 16));
        jLabelUsuario.setText("Conectado como " + controladorTela.getUsuarioLogado().getUser());
        if (!controladorTela.getUsuarioLogado().getFuncao().equalsIgnoreCase("admin")) {
            jButtonMenuUsuarios.setVisible(false);
            jButtonGerencia.setVisible(false);
        }
        atualizarResumo();
    }

    private void atualizarResumo() {
        jLabelValor.setText("R$ " + String.format("%,.2f", controladorMenu.valorTotal()));
        jLabelResumo.setText(controladorMenu.getQuantidadeProdutos() + " produtos cadastrados");
        ArrayList<Produto> baixo = controladorMenu.estoqueBaixo();
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) jTableBaixo.getModel();
        modelo.setRowCount(0);
        for (Produto p : baixo) {
            modelo.addRow(new Object[]{p.getNome(), p.getQuantidade()});
        }
        jScrollPaneBaixo.setVisible(!baixo.isEmpty());
        if (baixo.isEmpty()) {
            jLabelBaixo.setText("Nenhum produto com menos de " + ControladorMenu.ESTOQUE_BAIXO + " unidades");
        } else {
            jLabelBaixo.setText("Estoque baixo (menos de " + ControladorMenu.ESTOQUE_BAIXO + " unidades)");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTopo = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jButtonSair = new javax.swing.JButton();
        jLabelValorTitulo = new javax.swing.JLabel();
        jLabelValor = new javax.swing.JLabel();
        jLabelResumo = new javax.swing.JLabel();
        jButtonEstoque = new javax.swing.JButton();
        jButtonCaixa = new javax.swing.JButton();
        jButtonReposicao = new javax.swing.JButton();
        jButtonMenuUsuarios = new javax.swing.JButton();
        jLabelBaixo = new javax.swing.JLabel();
        jScrollPaneBaixo = new javax.swing.JScrollPane();
        jTableBaixo = new javax.swing.JTable();
        jButtonCadastrarProduto = new javax.swing.JButton();
        jButtonGerencia = new javax.swing.JButton();

        setForeground(new java.awt.Color(51, 51, 51));

        jLabelTitulo.setText("StockManager67");
        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 22));

        jLabelUsuario.setText("Conectado como");

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(this::jButtonSairActionPerformed);

        javax.swing.GroupLayout jPanelTopoLayout = new javax.swing.GroupLayout(jPanelTopo);
        jPanelTopo.setLayout(jPanelTopoLayout);
        jPanelTopoLayout.setHorizontalGroup(
            jPanelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelUsuario)
                .addGap(16, 16, 16)
                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanelTopoLayout.setVerticalGroup(
            jPanelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTopoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitulo)
                    .addComponent(jLabelUsuario)
                    .addComponent(jButtonSair))
                .addGap(16, 16, 16))
        );

        jLabelValorTitulo.setText("Valor em estoque");

        jLabelValor.setText("R$ 0,00");
        jLabelValor.setFont(new java.awt.Font("Segoe UI", 1, 28));

        jLabelResumo.setText("0 produtos cadastrados");

        jButtonEstoque.setText("<html><b>Estoque</b><br>Buscar, editar e excluir produtos</html>");
        jButtonEstoque.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonEstoque.addActionListener(this::jButtonEstoqueActionPerformed);

        jButtonCaixa.setText("<html><b>Caixa</b><br>Registrar uma venda</html>");
        jButtonCaixa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonCaixa.addActionListener(this::jButtonCaixaActionPerformed);

        jButtonReposicao.setText("<html><b>Reposição</b><br>Conferir mercadoria recebida</html>");
        jButtonReposicao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonReposicao.addActionListener(this::jButtonReposicaoActionPerformed);

        jButtonMenuUsuarios.setText("<html><b>Painel Admin</b><br>Usuários e histórico de alterações</html>");
        jButtonMenuUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonMenuUsuarios.addActionListener(this::jButtonMenuUsuariosActionPerformed);

        jLabelBaixo.setText("Estoque baixo");

        jTableBaixo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Qtd"
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

        jButtonCadastrarProduto.setText("<html><b>Cadastrar produto</b><br>Incluir um produto novo no estoque</html>");
        jButtonCadastrarProduto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonCadastrarProduto.addActionListener(this::jButtonCadastrarProdutoActionPerformed);

        jButtonGerencia.setText("<html><b>Gerência</b><br>Vendas por produto e estoque baixo</html>");
        jButtonGerencia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonGerencia.addActionListener(this::jButtonGerenciaActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTopo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelValorTitulo)
                    .addComponent(jLabelValor)
                    .addComponent(jLabelResumo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(jButtonCadastrarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(jButtonReposicao, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonGerencia, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(jButtonMenuUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelBaixo)
                    .addComponent(jScrollPaneBaixo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTopo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelValorTitulo)
                        .addGap(6, 6, 6)
                        .addComponent(jLabelValor)
                        .addGap(8, 8, 8)
                        .addComponent(jLabelResumo)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(jButtonCadastrarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(jButtonReposicao, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonGerencia, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(jButtonMenuUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelBaixo)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPaneBaixo, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        controladorTela.abrirTelaLogin();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEstoqueActionPerformed
        controladorTela.abrirTelaStock();
    }//GEN-LAST:event_jButtonEstoqueActionPerformed

    private void jButtonCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCaixaActionPerformed
        controladorTela.abrirTelaCaixa();
    }//GEN-LAST:event_jButtonCaixaActionPerformed

    private void jButtonReposicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReposicaoActionPerformed
        controladorTela.abrirTelaReposicao();
    }//GEN-LAST:event_jButtonReposicaoActionPerformed

    private void jButtonMenuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuUsuariosActionPerformed
        controladorTela.abrirTelaUsuarios();
    }//GEN-LAST:event_jButtonMenuUsuariosActionPerformed

    private void jButtonCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarProdutoActionPerformed
        controladorTela.abrirTelaCadastroProduto(-1, true);
    }//GEN-LAST:event_jButtonCadastrarProdutoActionPerformed

    private void jButtonGerenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciaActionPerformed
        controladorTela.abrirTelaGerencia();
    }//GEN-LAST:event_jButtonGerenciaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrarProduto;
    private javax.swing.JButton jButtonCaixa;
    private javax.swing.JButton jButtonEstoque;
    private javax.swing.JButton jButtonGerencia;
    private javax.swing.JButton jButtonMenuUsuarios;
    private javax.swing.JButton jButtonReposicao;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabelBaixo;
    private javax.swing.JLabel jLabelResumo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JLabel jLabelValorTitulo;
    private javax.swing.JPanel jPanelTopo;
    private javax.swing.JScrollPane jScrollPaneBaixo;
    private javax.swing.JTable jTableBaixo;
    // End of variables declaration//GEN-END:variables
}
