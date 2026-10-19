/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author behof
 */
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;
    private String dataHora;
    private String usuario;
    private String acao;

    public Log(String usuario, String acao) {
        this.dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        this.usuario = usuario;
        this.acao = acao;
    }

    public String getDataHora() { return dataHora; }
    public String getUsuario() { return usuario; }
    public String getAcao() { return acao; }
}
