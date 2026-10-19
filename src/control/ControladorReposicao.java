/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import db.QProduto;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import model.Produto;
import view.ReposicaoView;

/**
 *
 * @author behof
 */
public class ControladorReposicao {

    private ArrayList<Produto> produtos;
    private QProduto qProduto = new QProduto();
    private LinkedHashMap<Produto, Integer> conferencia = new LinkedHashMap<>();
    private ControladorTela controladorTela;
    private ReposicaoView tela;

    public ControladorReposicao(ControladorTela controladorTela, ReposicaoView tela) {
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

    public void adicionarNaConferencia(Produto p) {
        if (p == null) return;
        int quantidade = conferencia.getOrDefault(p, 0);
        conferencia.put(p, quantidade + 1);
        atualizarLista();
    }

    public void removerDaConferencia(Produto p) {
        if (p == null) return;
        conferencia.remove(p);
        atualizarLista();
    }

    public void confirmar() {
        int itens = 0;
        for (int quantidade : conferencia.values()) itens += quantidade;
        for (Produto p : conferencia.keySet()) {
            p.setQuantidade(p.getQuantidade() + conferencia.get(p));
        }
        qProduto.salvar(produtos);
        new ControladorLogs(controladorTela).registrarLog("Reposição confirmada: +" + itens + " itens");
        conferencia.clear();
        atualizarLista();
    }

    public void atualizarLista() {
        tela.atualizarConferencia(conferencia);
    }
}
