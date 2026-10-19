/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author behof
 */
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String user;
    private String cpf;
    private String tipo;
    private String senha;
 
    public Usuario(int id, String user, String cpf, String tipo, String senha) {
        this.id = id;
        this.user = user;
        this.cpf = cpf;
        this.tipo = tipo;
        this.senha = senha;
    }
 
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
 
    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }
 
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
 
    public String getFuncao() { return tipo; }
    public void setFuncao(String tipo) { this.tipo = tipo; }
 
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    
}