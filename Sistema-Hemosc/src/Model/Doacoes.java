/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author adriana.gunther
 */
public class Doacoes {

    private int id_doacao;
    private Date data;
    private Doadores id_doador;
    private TipoSanguineo id_tipo_sanguineo;
    private Colaboradores id_colaborador;

    public int getId_doacao() {
        return id_doacao;
    }

    public void setId_doacao(int id_doacao) {
        this.id_doacao = id_doacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Doadores getId_doador() {
        return id_doador;
    }

    public void setId_doador(Doadores id_doador) {
        this.id_doador = id_doador;
    }

    public TipoSanguineo getId_tipo_sanguineo() {
        return id_tipo_sanguineo;
    }

    public void setId_tipo_sanguineo(TipoSanguineo id_tipo_sanguineo) {
        this.id_tipo_sanguineo = id_tipo_sanguineo;
    }

    public Colaboradores getId_colaborador() {
        return id_colaborador;
    }

    public void setId_colaborador(Colaboradores id_colaborador) {
        this.id_colaborador = id_colaborador;
    }
}
