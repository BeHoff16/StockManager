/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import db.QProduto;
import db.QVenda;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import model.Produto;
import model.Venda;
import view.CaixaView;

/**
 *
 * @author behof
 */
public class ControladorCaixa {

    private ArrayList<Produto> produtos;
    private QProduto qProduto = new QProduto();
    private QVenda qVenda = new QVenda();
    private LinkedHashMap<Produto, Integer> carrinho = new LinkedHashMap<>();
    private ControladorTela controladorTela;
    private CaixaView tela;

    public ControladorCaixa(ControladorTela controladorTela, CaixaView tela) {
        this.produtos = qProduto.carregar();
        this.controladorTela = controladorTela;
        this.tela = tela;
    }

    public Produto buscarPorCodigo(String codigo) {
        for (Produto p : produtos) {
            if (p.getCodigoBarras().equals(codigo)) return p;
        }
        return null;
    }

    public ArrayList<Produto> buscar(String texto) {
        ArrayList<Produto> encontrados = new ArrayList<>();
        String busca = texto.toLowerCase();
        for (Produto p : produtos) {
            if (p.getNome().toLowerCase().contains(busca) || p.getCodigoBarras().toLowerCase().contains(busca)) {
                encontrados.add(p);
            }
        }
        return encontrados;
    }

    public void adicionarAoCarrinho(Produto p) {
        if (p == null) return;
        int quantidade = carrinho.getOrDefault(p, 0);
        carrinho.put(p, quantidade + 1);
        atualizarLista();
    }

    public void removerDoCarrinho(Produto p) {
        if (p == null) return;
        carrinho.remove(p);
        atualizarLista();
    }

    public double getTotal() {
        double total = 0;
        for (Produto p : carrinho.keySet()) {
            total += p.getPreco() * carrinho.get(p);
        }
        return total;
    }

    public Produto itemComEstoqueInsuficiente() {
        for (Produto p : carrinho.keySet()) {
            if (carrinho.get(p) > p.getQuantidade()) return p;
        }
        return null;
    }

    public void darBaixa() {
        int itens = 0;
        for (int quantidade : carrinho.values()) itens += quantidade;
        for (Produto p : carrinho.keySet()) {
            p.setQuantidade(p.getQuantidade() - carrinho.get(p));
        }
        qProduto.salvar(produtos);
        ArrayList<Venda> vendas = qVenda.carregar();
        for (Produto p : carrinho.keySet()) {
            vendas.add(new Venda(p.getId(), p.getNome(), carrinho.get(p), p.getPreco()));
        }
        qVenda.salvar(vendas);
        new ControladorLogs(controladorTela).registrarLog("Venda finalizada: -" + itens + " itens, R$ " + String.format("%.2f", getTotal()));
        carrinho.clear();
        atualizarLista();
    }

    public void atualizarLista() {
        tela.atualizarCarrinho(carrinho, getTotal());
    }
}
