/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_DAO;

import Database.ConexaoBanco;
import Model.Agendamentos;
import Model.Doadores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AgendamentosDao {
    public void cadastrar(Agendamentos a) {
        Connection conn = ConexaoBanco.conectaBanco();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO agendamento (id_agendamento,data,hora,id_doador) VALUES (?,?,?,?)");
            stmt.setInt(1, a.getId_agendamento());
            stmt.setDate(2, a.getData());
            stmt.setTime(3, a.getHora());
            stmt.setInt(4, a.getDoador().getId_doador());
            

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, " Agendamento cadastrado com sucesso!");

        } catch (SQLException ex) {

        }

    } 
    
    
    public List<Agendamentos> listar() {

        Connection conn = ConexaoBanco.conectaBanco();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Agendamentos> Agendamentos = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("select A.id_agendamento, A.data, A.hora, D.nome from agendamento A \n"
                    + "inner join doadores D on (D.id_doador = A.id_doador)");

            rs = stmt.executeQuery();
            while (rs.next()) {
                Agendamentos a = new Agendamentos();
                a.setId_agendamento(rs.getInt("id_agendamento"));
                a.setData(rs.getDate("data"));
                a.setHora(rs.getTime("hora"));

                Doadores d = new Doadores();
                d.setNome(rs.getString("nome"));
                a.setDoador(d);

                Agendamentos.add(a);

            }

        } catch (SQLException ex) {
            Logger.getLogger(AgendamentosDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return Agendamentos;
    }  
  
    
    public void excluir(Agendamentos agenda){
        
        Connection conn = ConexaoBanco.conectaBanco();
        
        PreparedStatement stmt = null;
        
        try{
            stmt = conn.prepareStatement("DELETE FROM agendamento where id_agendamento = ? ");          
            stmt.setInt(1, agenda.getId_agendamento());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Agendamento Excluido com Sucesso!");
                    
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Excluir! Tente novamente mais tarde!");
            Logger.getLogger(AgendamentosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public List<Agendamentos> listarDia() {

        Connection conn = ConexaoBanco.conectaBanco();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Agendamentos> Agendamentos = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("select A.id_agendamento, A.data, A.hora, D.nome from agendamento A\n" +
"inner join doadores D on (D.id_doador = A.id_doador) WHERE A.data = CURDATE()");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Agendamentos a = new Agendamentos();
                a.setId_agendamento(rs.getInt("id_agendamento"));
                a.setData(rs.getDate("data"));
                a.setHora(rs.getTime("hora"));

                Doadores d = new Doadores();
                d.setNome(rs.getString("nome"));
                a.setDoador(d);

                Agendamentos.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgendamentosDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Agendamentos;
    }
}
