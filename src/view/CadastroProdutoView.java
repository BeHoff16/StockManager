/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import control.ControladorCadastroProduto;
import control.ControladorTela;
import javax.swing.JOptionPane;
import model.Produto;

/**
 *
 * @author behof
 */
public class CadastroProdutoView extends javax.swing.JPanel {

    private ControladorCadastroProduto controladorCadastroProduto;
    private ControladorTela controladorTela;
    private boolean voltarAoMenu;

    public CadastroProdutoView(ControladorTela controladorTela, int idProduto, boolean voltarAoMenu) {
        this.controladorTela = controladorTela;
        this.voltarAoMenu = voltarAoMenu;
        initComponents();
        controladorCadastroProduto = new ControladorCadastroProduto(controladorTela, idProduto);
        Produto p = controladorCadastroProduto.getProduto();
        if (p != null) {
            jLabelTitulo.setText("Editar produto");
            jTextFieldNovoProduto.setText(p.getNome());
            jSpinnerQuant.setValue(p.getQuantidade());
            jTextFieldPreco.setText(String.valueOf(p.getPreco()));
            jTextFieldCodBarras.setText(p.getCodigoBarras());
            jTextAreaDescricao.setText(p.getDescricao());
        }
    }

    private void voltar() {
        if (voltarAoMenu) {
            controladorTela.abrirTelaMenu();
        } else {
            controladorTela.abrirTelaStock();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNovoProduto = new javax.swing.JTextField();
        jLabelCod = new javax.swing.JLabel();
        jTextFieldCodBarras = new javax.swing.JTextField();
        jLabelQuant = new javax.swing.JLabel();
        jSpinnerQuant = new javax.swing.JSpinner();
        jLabelPreco = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabelDesc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSubmitProduto = new javax.swing.JButton();

        setForeground(new java.awt.Color(51, 51, 51));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabelTitulo.setText("Novo produto");

        jLabelNome.setText("Nome");

        jLabelCod.setText("Código de Barras");

        jLabelQuant.setText("Quantidade");

        jLabelPreco.setText("Preço (ex: 9.99)");

        jLabelDesc.setText("Descrição");

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setRows(4);
        jScrollPane1.setViewportView(jTextAreaDescricao);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(this::jButtonCancelarActionPerformed);

        jButtonSubmitProduto.setText("Salvar");
        jButtonSubmitProduto.addActionListener(this::jButtonSubmitProdutoActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNome)
                            .addComponent(jTextFieldNovoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(jLabelQuant)
                            .addComponent(jSpinnerQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCod)
                            .addComponent(jTextFieldCodBarras, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(jLabelPreco)
                            .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelDesc)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jButtonSubmitProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelTitulo)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jLabelCod))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNovoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCodBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelQuant)
                    .addComponent(jLabelPreco))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinnerQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabelDesc)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSubmitProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        voltar();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSubmitProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitProdutoActionPerformed
        String nome = jTextFieldNovoProduto.getText();
        int quant = (int) jSpinnerQuant.getValue();
        String cod = jTextFieldCodBarras.getText();
        String desc = jTextAreaDescricao.getText();
        double preco;
        try {
            preco = Double.parseDouble(jTextFieldPreco.getText().replace(",", "."));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Preço inválido. Digite um número, por exemplo 9.99.");
            return;
        }
        if (preco < 0 || Double.isNaN(preco) || Double.isInfinite(preco)) {
            JOptionPane.showMessageDialog(this, "Preço inválido. Digite um número, por exemplo 9.99.");
            return;
        }
        if (controladorCadastroProduto.nomeExiste(nome)) {
            JOptionPane.showMessageDialog(this, "Já existe um produto com esse nome.");
            return;
        }
        if (controladorCadastroProduto.codigoExiste(cod)) {
            JOptionPane.showMessageDialog(this, "Já existe um produto com esse código de barras.");
            return;
        }
        controladorCadastroProduto.salvarProduto(nome, quant, preco, cod, desc);
        voltar();
    }//GEN-LAST:event_jButtonSubmitProdutoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSubmitProduto;
    private javax.swing.JLabel jLabelCod;
    private javax.swing.JLabel jLabelDesc;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JLabel jLabelQuant;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerQuant;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextField jTextFieldCodBarras;
    private javax.swing.JTextField jTextFieldNovoProduto;
    private javax.swing.JTextField jTextFieldPreco;
    // End of variables declaration//GEN-END:variables
}
