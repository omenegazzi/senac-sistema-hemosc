/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author gabriel.ferrandin
 */
public class Doadores {

    private int id_doador;
    private Cidades id_cidade;
    private TipoSanguineo id_tipo_sanguineo;
    private String nome;
    private String endereco;
    private Date data_nascimento;
    private int telefone;
    private String email;
    private String cpf;

    public int getId_doador() {
        return id_doador;
    }

    public void setId_doador(int id_doador) {
        this.id_doador = id_doador;
    }

    public Cidades getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(Cidades id_cidade) {
        this.id_cidade = id_cidade;
    }

    public TipoSanguineo getId_tipo_sanguineo() {
        return id_tipo_sanguineo;
    }

    public void setId_tipo_sanguineo(TipoSanguineo id_tipo_sanguineo) {
        this.id_tipo_sanguineo = id_tipo_sanguineo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}