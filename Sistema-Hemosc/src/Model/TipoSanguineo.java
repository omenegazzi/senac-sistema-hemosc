/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author lethicia.favretto
 */
public class TipoSanguineo {
    private int id_TipoSanguineo;
    private String descricao;
    private String fator_rh;
    private int estoque;
    private int estoque_minimo;

    public int getId_TipoSanguineo() {
        return id_TipoSanguineo;
    }

    public void setId_TipoSanguineo(int id_TipoSanguineo) {
        this.id_TipoSanguineo = id_TipoSanguineo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFator_rh() {
        return fator_rh;
    }

    public void setFator_rh(String fator_rh) {
        this.fator_rh = fator_rh;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getEstoque_minimo() {
        return estoque_minimo;
    }

    public void setEstoque_minimo(int estoque_minimo) {
        this.estoque_minimo = estoque_minimo;
    }
    
    
    
}
