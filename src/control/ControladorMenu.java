/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import db.QProduto;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author behof
 */
public class ControladorMenu {

    public static final int ESTOQUE_BAIXO = 10;

    private ArrayList<Produto> produtos;

    public ControladorMenu() {
        this.produtos = new QProduto().carregar();
    }

    public int getQuantidadeProdutos() { return produtos.size(); }

    public double valorTotal() {
        double total = 0;
        for (Produto p : produtos) {
            total += p.getPreco() * p.getQuantidade();
        }
        return total;
    }

    public ArrayList<Produto> estoqueBaixo() {
        ArrayList<Produto> resultado = new ArrayList<>();
        for (Produto p : produtos) {
            if (p.getQuantidade() < ESTOQUE_BAIXO) resultado.add(p);
        }
        return resultado;
    }
}
