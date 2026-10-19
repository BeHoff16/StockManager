/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import db.QLogs;
import java.util.ArrayList;
import model.Log;
import model.Usuario;

/**
 *
 * @author behof
 */
public class ControladorLogs {

    private ArrayList<Log> logs;
    private QLogs qLogs = new QLogs();
    private ControladorTela controladorTela;

    public ControladorLogs(ControladorTela controladorTela) {
        this.controladorTela = controladorTela;
        this.logs = qLogs.carregar();
    }

    public ArrayList<Log> getLogs() { return logs; }

    public void registrarLog(String acao) {
        Usuario u = controladorTela.getUsuarioLogado();
        String usuario = u != null ? u.getUser() : "sistema";
        logs.add(new Log(usuario, acao));
        qLogs.salvar(logs);
    }
}
