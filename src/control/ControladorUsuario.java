/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import db.QUsuario;
import java.util.ArrayList;
import model.Usuario;
import view.UserData;

/**
 *
 * @author behof
 */
public class ControladorUsuario {

    private ArrayList<Usuario> usuarios;
    private QUsuario qUsuario = new QUsuario();
    private ControladorTela controladorTela;
    private UserData tela;

    public ControladorUsuario(ControladorTela controladorTela) {
        this.controladorTela = controladorTela;
        this.usuarios = qUsuario.carregar();
        boolean carregou = !usuarios.isEmpty();
        garantirAdmin();
        if (!carregou) {
            usuarios.add(new Usuario(gerarIdUsuario(), "joao", "111.111.111-11", "estoquista", "123"));
        }
    }

    public ControladorUsuario(ControladorTela controladorTela, UserData tela) {
        this(controladorTela);
        this.tela = tela;
    }

    private void garantirAdmin() {
        for (Usuario u : usuarios) {
            if (u.getUser().equals("admin")) return;
        }
        usuarios.add(new Usuario(gerarIdUsuario(), "admin", "000.000.000-00", "admin", "123"));
    }

    public int gerarIdUsuario() {
        int maior = -1;
        for (Usuario u : usuarios) {
            if (u.getId() > maior) maior = u.getId();
        }
        return maior + 1;
    }

    public ArrayList<Usuario> getUsuarios() { return usuarios; }

    public void adicionarUsuario(String user, String cpf, String tipo, String senha) {
        Usuario u = new Usuario(gerarIdUsuario(), user, cpf, tipo, senha);
        usuarios.add(u);
        qUsuario.salvar(usuarios);
        new ControladorLogs(controladorTela).registrarLog("Usuário adicionado: " + user);
        atualizarLista();
    }

    public void editarUsuario(int index, String user, String cpf, String tipo, String senha) {
        if (index < 0 || index >= usuarios.size()) return;
        Usuario u = usuarios.get(index);
        u.setUser(user);
        u.setCpf(cpf);
        u.setFuncao(tipo);
        u.setSenha(senha);
        qUsuario.salvar(usuarios);
        new ControladorLogs(controladorTela).registrarLog("Usuário editado: " + user);
        atualizarLista();
    }

    public boolean loginExiste(String user, Usuario ignorado) {
        for (Usuario u : usuarios) {
            if (u != ignorado && u.getUser().equals(user)) return true;
        }
        return false;
    }

    public void excluirUsuario(int index) {
        if (index < 0 || index >= usuarios.size()) return;
        Usuario u = usuarios.get(index);
        usuarios.remove(index);
        qUsuario.salvar(usuarios);
        new ControladorLogs(controladorTela).registrarLog("Usuário excluído: " + u.getUser());
        atualizarLista();
    }

    public Usuario getUsuario(int index) {
        if (index < 0 || index >= usuarios.size()) return null;
        return usuarios.get(index);
    }

    public void atualizarLista() {
        tela.atualizarLista(usuarios);
    }
}
