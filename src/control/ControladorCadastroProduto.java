/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import db.QProduto;
import db.QVenda;
import java.util.ArrayList;
import model.Produto;
import model.Venda;

/**
 *
 * @author behof
 */
public class ControladorCadastroProduto {

    private ArrayList<Produto> produtos;
    private QProduto qProduto = new QProduto();
    private ControladorTela controladorTela;
    private Produto produto;

    public ControladorCadastroProduto(ControladorTela controladorTela, int idProduto) {
        this.controladorTela = controladorTela;
        this.produtos = qProduto.carregar();
        for (Produto p : produtos) {
            if (p.getId() == idProduto) produto = p;
        }
    }

    public Produto getProduto() { return produto; }

    public int gerarIdProduto() {
        int maior = 0;
        for (Produto p : produtos) {
            if (p.getId() > maior) maior = p.getId();
        }
        for (Venda v : new QVenda().carregar()) {
            if (v.getIdProduto() > maior) maior = v.getIdProduto();
        }
        return maior + 1;
    }

    public boolean nomeExiste(String nome) {
        for (Produto p : produtos) {
            if (p != produto && p.getNome().equalsIgnoreCase(nome)) return true;
        }
        return false;
    }

    public boolean codigoExiste(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) return false;
        for (Produto p : produtos) {
            if (p != produto && p.getCodigoBarras().equals(codigo)) return true;
        }
        return false;
    }

    public void salvarProduto(String nome, int quantidade, double preco, String codBarras, String descricao) {
        String acao;
        if (produto == null) {
            produtos.add(new Produto(gerarIdProduto(), nome, quantidade, preco, codBarras, descricao));
            acao = "Produto adicionado: " + nome + " (+" + quantidade + ")";
        } else {
            int delta = quantidade - produto.getQuantidade();
            produto.setNome(nome);
            produto.setQuantidade(quantidade);
            produto.setPreco(preco);
            produto.setCodigoBarras(codBarras);
            produto.setDescricao(descricao);
            String variacao = delta != 0 ? " (" + (delta > 0 ? "+" : "") + delta + ")" : "";
            acao = "Produto editado: " + nome + variacao;
        }
        qProduto.salvar(produtos);
        new ControladorLogs(controladorTela).registrarLog(acao);
    }
}
