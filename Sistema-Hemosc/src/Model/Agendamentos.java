/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author adriana.gunther
 */
public class Agendamentos {

    private int id_agendamento;
    private Date data;
    private Time hora;
    private Doadores id_doador;

    public int getId_agendamento() {
        return id_agendamento;
    }

    public void setId_agendamento(int id_agendamento) {
        this.id_agendamento = id_agendamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Doadores getId_doador() {
        return id_doador;
    }

    public void setId_doador(Doadores id_doador) {
        this.id_doador = id_doador;
    }
    
}