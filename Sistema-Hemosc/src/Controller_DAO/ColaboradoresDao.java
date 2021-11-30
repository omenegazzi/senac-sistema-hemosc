/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_DAO;

import Database.ConexaoBanco;
import Model.Cidades;
import Model.Colaboradores;
import Model.Funcoes;
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
            stmt = conn.prepareStatement("INSERT INTO colaboradores (id_cidade,nome,endereco,funcao) VALUES (?,?,?,?)");
            stmt.setInt(1, c.getCidade().getId_cidade());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getEndereco());
            stmt.setString(4, c.getFuncao().getFuncao());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Colaborador cadastrado com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(ColaboradoresDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Colaboradores> listar() {
        Connection conn = ConexaoBanco.conectaBanco();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Colaboradores> Colaboradores = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT id_colaborador, cidades.descricao, colaboradores.nome, colaboradores.endereco, colaboradores.funcao FROM colaboradores \n"
                    + "INNER JOIN cidades ON (cidades.id_cidade = colaboradores.id_cidade)");

            rs = stmt.executeQuery();
            while (rs.next()) {
                Colaboradores c = new Colaboradores();
                c.setId_colaborador(rs.getInt("id_colaborador"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));

                Cidades ci = new Cidades();
                ci.setDescricao(rs.getString("descricao"));
                c.setCidade(ci);

                Funcoes F = new Funcoes();
                F.setFuncao(rs.getString("funcao"));
                c.setFuncao(F);

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
            stmt = conn.prepareStatement("SELECT id_colaborador, cidades.descricao, colaboradores.nome, colaboradores.endereco, colaboradores.funcao FROM colaboradores \n"
                    + "INNER JOIN cidades ON (cidades.id_cidade = colaboradores.id_cidade) \n"
                    + "WHERE nome like ? ");
            stmt.setString(1, "%" + texto + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Colaboradores c = new Colaboradores();
                c.setId_colaborador(rs.getInt("id_colaborador"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));

                Cidades ci = new Cidades();
                ci.setDescricao(rs.getString("descricao"));
                c.setCidade(ci);

                Funcoes F = new Funcoes();
                F.setFuncao(rs.getString("funcao"));
                c.setFuncao(F);

                Colaboradores.add(c);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ColaboradoresDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return Colaboradores;
    }

    public void excluir(Colaboradores c) {
        Connection conn = ConexaoBanco.conectaBanco();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("DELETE FROM colaboradores where id_colaborador= ?,id_cidade = ?, nome = ?,endereco = ?,funcao = ?");
            stmt.setInt(1, c.getId_colaborador());
            stmt.setInt(2, c.getCidade().getId_cidade());
            stmt.setString(3, c.getNome());
            stmt.setString(4, c.getEndereco());
            stmt.setString(5, c.getFuncao().getFuncao());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Colaborador excluido com sucesso!");

        } catch (SQLException ex) {

        }
    }
}
