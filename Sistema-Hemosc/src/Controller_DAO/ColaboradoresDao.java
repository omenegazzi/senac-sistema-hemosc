/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_DAO;

import Database.ConexaoBanco;
import Model.Cidades;
import Model.Colaboradores;
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
 * @author gabriel
 */
public class ColaboradoresDao {
    
    public void cadastrar(Colaboradores c) {

        Connection conn = ConexaoBanco.conectaBanco();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO colaborador (id_cidade,nome,endereco,funcao) VALUES (?,?,?,?)");
            stmt.setInt(1, c.getCidade().getId_cidade());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getEndereco());
            stmt.setString(4, c.getFuncao());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Colaborador cadastrado com sucesso!");

        } catch (SQLException ex) {

        }

    }

    public List<Colaboradores> listar() {
        Connection conn = ConexaoBanco.conectaBanco();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Colaboradores> Colaboradores = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM colaboradores");

            rs = stmt.executeQuery();
            while (rs.next()) {
                Colaboradores c = new Colaboradores();
                c.setId_colaborador(rs.getInt("id_colaborador"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));
                c.setFuncao(rs.getString("funcao"));
                
                Cidades ci = new Cidades();
                ci.setId_cidade(rs.getInt("id_cidade"));
                c.setCidade(ci);

                Colaboradores.add(c);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ColaboradoresDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return Colaboradores;
    }

    public List<Colaboradores> pesquisar(String texto) {

        Connection conn = ConexaoBanco.conectaBanco();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Colaboradores> Colaboradores = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM colaboradores where nome like ? ");
            stmt.setString(1, "%" + texto + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Colaboradores c = new Colaboradores();
                c.setId_colaborador(rs.getInt("id_colaborador"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));
                c.setFuncao(rs.getString("funcao"));
                
                Cidades ci = new Cidades();
                ci.setId_cidade(rs.getInt("id_cidade"));
                c.setCidade(ci);
                
               
                Colaboradores.add(c);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ColaboradoresDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return Colaboradores;
    }

}
    
    

