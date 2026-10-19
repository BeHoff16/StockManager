/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import db.QProduto;
import db.QVenda;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import model.Produto;
import model.Venda;

/**
 *
 * @author behof
 */
public class ControladorGerencia {

    private ArrayList<Produto> produtos;
    private ArrayList<Venda> vendas;

    public ControladorGerencia() {
        this.produtos = new QProduto().carregar();
        this.vendas = new QVenda().carregar();
    }

    public ArrayList<Object[]> vendasPorProduto() {
        LinkedHashMap<Integer, Object[]> linhas = new LinkedHashMap<>();
        for (Produto p : produtos) {
            linhas.put(p.getId(), new Object[]{p.getNome(), 0, 0.0});
        }
        for (Venda v : vendas) {
            Object[] linha = linhas.get(v.getIdProduto());
            if (linha == null) {
                linha = new Object[]{v.getNomeProduto() + " (excluído)", 0, 0.0};
                linhas.put(v.getIdProduto(), linha);
            }
            linha[1] = (int) linha[1] + v.getQuantidade();
            linha[2] = (double) linha[2] + v.getQuantidade() * v.getPrecoUnitario();
        }
        ArrayList<Object[]> resultado = new ArrayList<>(linhas.values());
        Collections.sort(resultado, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] a, Object[] b) {
                return (int) b[1] - (int) a[1];
            }
        });
        return resultado;
    }

    public double totalVendido() {
        double total = 0;
        for (Venda v : vendas) {
            total += v.getQuantidade() * v.getPrecoUnitario();
        }
        return total;
    }

    public ArrayList<Produto> estoqueBaixo() {
        ArrayList<Produto> resultado = new ArrayList<>();
        for (Produto p : produtos) {
            if (p.getQuantidade() < ControladorMenu.ESTOQUE_BAIXO) resultado.add(p);
        }
        return resultado;
    }
}
