/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author adriana.gunther
 */
public class SaidadeSangue {
    
    private int id_saida_sangue;
    private Entidades id_entidade;
    private TipoSanguineo id_tipo_sanguineo;
    private Date data;
    private int quantidade;

    public int getId_saida_sangue() {
        return id_saida_sangue;
    }

    public void setId_saida_sangue(int id_saida_sangue) {
        this.id_saida_sangue = id_saida_sangue;
    }

    public Entidades getId_entidade() {
        return id_entidade;
    }

    public void setId_entidade(Entidades id_entidade) {
        this.id_entidade = id_entidade;
    }

    public TipoSanguineo getId_tipo_sanguineo() {
        return id_tipo_sanguineo;
    }

    public void setId_tipo_sanguineo(TipoSanguineo id_tipo_sanguineo) {
        this.id_tipo_sanguineo = id_tipo_sanguineo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

   

    
}


