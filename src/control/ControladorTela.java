/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JDesktopPane;
import model.Usuario;
import view.CadastroProdutoView;
import view.CaixaView;
import view.GerenciaView;
import view.LogsView;
import view.MenuView;
import view.ReposicaoView;
import view.StockView;
import view.TelaLogin;
import view.UserData;

/**
 *
 * @author behof
 */
public class ControladorTela {

    JDesktopPane jDesktop;

    private Usuario usuarioLogado;

    public ControladorTela(JDesktopPane jDesktop) {
        this.jDesktop = jDesktop;
        jDesktop.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                for (Component tela : jDesktop.getComponents()) {
                    tela.setSize(jDesktop.getSize());
                    tela.validate();
                }
            }
        });
    }

    public Usuario getUsuarioLogado() { return usuarioLogado; }

public void setUsuarioLogado(Usuario usuarioLogado) { this.usuarioLogado = usuarioLogado; }

    public void abrirTelaLogin() {
        jDesktop.removeAll();
        jDesktop.updateUI();
        Dimension resolution = jDesktop.getSize();
        TelaLogin tela1 = new TelaLogin(this);
        tela1.setSize(resolution);
        tela1.setLocation(0, 0);
        jDesktop.add(tela1);
        tela1.setVisible(true);
    }

    public void abrirTelaMenu() {
        jDesktop.removeAll();
        jDesktop.updateUI();
        Dimension resolution = jDesktop.getSize();
        MenuView tela1 = new MenuView(this);
        tela1.setSize(resolution);
        tela1.setLocation(0, 0);
        jDesktop.add(tela1);
        tela1.setVisible(true);
    }

    public void abrirTelaStock() {
        jDesktop.removeAll();
        jDesktop.updateUI();
        Dimension resolution = jDesktop.getSize();
        StockView tela1 = new StockView(this);
        tela1.setSize(resolution);
        tela1.setLocation(0, 0);
        jDesktop.add(tela1);
        tela1.setVisible(true);
    }

    public void abrirTelaUsuarios() {
        jDesktop.removeAll();
        jDesktop.updateUI();
        Dimension resolution = jDesktop.getSize();
        UserData tela1 = new UserData(this);
        tela1.setSize(resolution);
        tela1.setLocation(0, 0);
        jDesktop.add(tela1);
        tela1.setVisible(true);
    }

    public void abrirTelaCadastroProduto(int idProduto, boolean voltarAoMenu) {
        jDesktop.removeAll();
        jDesktop.updateUI();
        Dimension resolution = jDesktop.getSize();
        CadastroProdutoView tela1 = new CadastroProdutoView(this, idProduto, voltarAoMenu);
        tela1.setSize(resolution);
        tela1.setLocation(0, 0);
        jDesktop.add(tela1);
        tela1.setVisible(true);
    }

    public void abrirTelaCaixa() {
        jDesktop.removeAll();
        jDesktop.updateUI();
        Dimension resolution = jDesktop.getSize();
        CaixaView tela1 = new CaixaView(this);
        tela1.setSize(resolution);
        tela1.setLocation(0, 0);
        jDesktop.add(tela1);
        tela1.setVisible(true);
    }

    public void abrirTelaReposicao() {
        jDesktop.removeAll();
        jDesktop.updateUI();
        Dimension resolution = jDesktop.getSize();
        ReposicaoView tela1 = new ReposicaoView(this);
        tela1.setSize(resolution);
        tela1.setLocation(0, 0);
        jDesktop.add(tela1);
        tela1.setVisible(true);
    }

    public void abrirTelaGerencia() {
        jDesktop.removeAll();
        jDesktop.updateUI();
        Dimension resolution = jDesktop.getSize();
        GerenciaView tela1 = new GerenciaView(this);
        tela1.setSize(resolution);
        tela1.setLocation(0, 0);
        jDesktop.add(tela1);
        tela1.setVisible(true);
    }

    public void abrirTelaLogs() {
        jDesktop.removeAll();
        jDesktop.updateUI();
        Dimension resolution = jDesktop.getSize();
        LogsView tela1 = new LogsView(this);
        tela1.setSize(resolution);
        tela1.setLocation(0, 0);
        jDesktop.add(tela1);
        tela1.setVisible(true);
    }
}
