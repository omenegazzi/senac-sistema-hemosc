/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_DAO;

import Database.ConexaoBanco;
import Model.Doadores;
import Model.Entidades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author marcelo.nascimento1
 */
public class EntidadesDao {

    public void alterar(Entidades ent) {

        Connection conn = ConexaoBanco.conectaBanco();

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("UPDATE entidades set id_cidade = ?, nome = ?, endereco = ? where id_entidade = ? ");

            stmt.setInt(1, ent.getCidades().getId_cidade());
            stmt.setString(2, ent.getNome());
            stmt.setString(3, ent.getEndereco());
            stmt.setInt(4, ent.getId_entidade());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Entidade Atualizada com Sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar! Tente novamente mais tarde!");
            Logger.getLogger(EntidadesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void excluir(Entidades d) throws SQLException {

        Connection conn = ConexaoBanco.conectaBanco();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("DELETE entidades set id_cidade = ?, nome = ?, endereco = ? where Id_entidade = ? ");
            
            stmt.setInt(1, d.getCidades().getId_cidade());
            stmt.setString(2, d.getNome());
            stmt.setString(3, d.getEndereco());
            stmt.setInt(4, d.getId_entidade());
            

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Entidade excluída com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar! Tente novamente mais tarde!");
            Logger.getLogger(EntidadesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


