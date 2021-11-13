/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_DAO;

import Database.ConexaoBanco;
import Model.Cidades;
import Model.Doadores;
import Model.TipoSanguineo;
import Model.Usuarios;
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
 * @author lucas.nardi
 */
public class DoadoresDao {

    public void cadastrar(Doadores d) {

        Connection conn = ConexaoBanco.conectaBanco();

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO doadores (id_cidade,id_tipo_sanguineo,nome,endereco,data_nascimento,telefone,email,cpf) VALUES (?,?,?,?,?,?,?,?)");
            stmt.setInt(1, d.getId_cidade().getId_cidade());
            stmt.setInt(2, d.getId_tipo_sanguineo().getId_TipoSanguineo());
            stmt.setString(3, d.getNome());
            stmt.setString(4, d.getEndereco());
            stmt.setDate(5, d.getData_nascimento());
            stmt.setInt(6, d.getTelefone());
            stmt.setString(7, d.getEmail());
            stmt.setString(8, d.getCpf());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuário cadastrado com Sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar o Usuário! Por favor, tente mais tarde.");
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Doadores> listar() {

        Connection conn = ConexaoBanco.conectaBanco();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Doadores> doadores = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM doadores");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Doadores d = new Doadores();
                d.setNome(rs.getString("nome"));
                d.setEndereco(rs.getString("endereco"));
                d.setData_nascimento(rs.getDate("data_nascimento"));
                d.setTelefone(rs.getInt("telefone"));
                d.setEmail(rs.getString("email"));
                d.setCpf(rs.getString("cpf"));
                
                Cidades cid = new Cidades();
                cid.setId_cidade(rs.getInt("id_cidade"));
                d.setId_cidade(cid);
                
                
                TipoSanguineo Ts = new TipoSanguineo();
                Ts.setId_TipoSanguineo(rs.getInt("id_tipo_sanguineo"));
                d.setId_tipo_sanguineo(Ts);
                
                doadores.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoadoresDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return doadores;
    }
}