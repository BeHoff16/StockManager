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
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    private String dataHora;
    private int idProduto;
    private String nomeProduto;
    private int quantidade;
    private double precoUnitario;

    public Venda(int idProduto, String nomeProduto, int quantidade, double precoUnitario) {
        this.dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public String getDataHora() { return dataHora; }
    public int getIdProduto() { return idProduto; }
    public String getNomeProduto() { return nomeProduto; }
    public int getQuantidade() { return quantidade; }
    public double getPrecoUnitario() { return precoUnitario; }
}
