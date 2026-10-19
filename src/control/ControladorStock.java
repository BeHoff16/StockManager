/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import db.QProduto;
import java.util.ArrayList;
import model.Produto;
import view.StockView;

/**
 *
 * @author behof
 */
public class ControladorStock {

    private ArrayList<Produto> produtos;
    private QProduto qProduto = new QProduto();
    private ControladorTela controladorTela;
    private StockView tela;

    public ControladorStock(ControladorTela controladorTela, StockView tela) {
        this.controladorTela = controladorTela;
        this.tela = tela;
        this.produtos = qProduto.carregar();
    }

    public void excluirProduto(Produto p) {
        if (p == null) return;
        produtos.remove(p);
        qProduto.salvar(produtos);
        new ControladorLogs(controladorTela).registrarLog("Produto excluído: " + p.getNome() + " (-" + p.getQuantidade() + ")");
        atualizarLista();
    }

    public void atualizarLista() {
        tela.atualizarLista(produtos);
    }
}
