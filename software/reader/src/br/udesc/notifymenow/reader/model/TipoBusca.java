/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.model;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public enum TipoBusca {
    SERVICO(1, "Serviço"),
    MANUAL(2, "Manual");

    private int id;
    private String nome;

    private TipoBusca(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }


}
