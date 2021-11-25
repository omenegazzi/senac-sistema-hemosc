/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_DAO;

import Database.ConexaoBanco;
import Model.Cidades;
import Model.Doadores;
import Model.Entidades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author marcelo.nascimento1
 */
public class EntidadesDao {

    public void cadastrar(Entidades e) {

        Connection conn = ConexaoBanco.conectaBanco();

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO entidades (id_entidade,id_cidade,nome,endereco) VALUES (?,?,?,?)");
            
            stmt.setInt(1, e.getId_entidade());
            stmt.setInt(2, e.getCidades().getId_cidade());
            stmt.setString(3, e.getNome());
            stmt.setString(4, e.getEndereco());
    

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuário cadastrado com Sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar o Usuário! Por favor, tente mais tarde.");
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public List<Entidades> listar() {
        Connection conn = ConexaoBanco.conectaBanco();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Entidades> entidade = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("select cidades.descricao as cidade, id_entidade,nome,endereco from entidades\n" +
"     inner join cidades on (cidades.id_cidade = entidades.id_cidade);");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Entidades l = new Entidades();

                l.setId_entidade(rs.getInt("id_entidade"));
                l.setNome(rs.getString("nome"));
                l.setEndereco(rs.getString("endereco"));

                Cidades c = new Cidades();
                c.setDescricao(rs.getString("cidade"));
                l.setCidades(c);
              
                entidade.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntidadesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entidade;
    }
    
    public void alterar(Entidades ent){
        
        Connection conn = ConexaoBanco.conectaBanco();
        
        PreparedStatement stmt = null;
        
        try{
            stmt = conn.prepareStatement("UPDATE entidades set id_cidade = ?, nome = ?, endereco = ? where id_entidade = ? ");            

            stmt.setInt (1, ent.getCidades().getId_cidade());
            stmt.setString(2, ent.getNome());
            stmt.setString(3, ent.getEndereco());            
            stmt.setInt(4, ent.getId_entidade());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Entidade Atualizada com Sucesso!");
                    
        }catch (SQLException ex){
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