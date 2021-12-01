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
import java.sql.Connection;
import java.util.Date;
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
            stmt.setTimestamp(5, new java.sql.Timestamp(d.getData_nascimento().getTime()));
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
            stmt = conn.prepareStatement("select cidades.descricao as cidade,id_doador,nome,endereco,data_nascimento,telefone,email,cpf,tipos_sanguineos.descricao as tipos_sanguineo from doadores\n"
                    + "              inner join cidades on (cidades.id_cidade = doadores.id_cidade ) \n"
                    + "              inner join tipos_sanguineos on (tipos_sanguineos.id_tipo_sanguineo= doadores.id_tipo_sanguineo);");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Doadores d = new Doadores();
                d.setId_doador(rs.getInt("id_doador"));

                d.setNome(rs.getString("nome"));
                d.setEndereco(rs.getString("endereco"));
                d.setData_nascimento(rs.getDate("data_nascimento"));
                d.setTelefone(rs.getInt("telefone"));
                d.setEmail(rs.getString("email"));
                d.setCpf(rs.getString("cpf"));

                Cidades cid = new Cidades();
                cid.setDescricao(rs.getString("cidade"));
                d.setId_cidade(cid);

                TipoSanguineo Ts = new TipoSanguineo();
                Ts.setDescricao(rs.getString("tipos_sanguineo"));
                d.setId_tipo_sanguineo(Ts);

                doadores.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoadoresDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return doadores;
    }

    public void excluir(Doadores d) {
        Connection conn = ConexaoBanco.conectaBanco();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("DELETE FROM doadores WHERE id_doador = ?;");
            stmt.setInt(1, d.getId_doador());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Doador excluído com sucesso!");

        } catch (SQLException ex) {

        }

    }

    public void alterar(Doadores e) {
        Connection conn = ConexaoBanco.conectaBanco();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = conn.prepareStatement("UPDATE doadores set id_cidade = ?, id_tipo_sanguineo = ?, nome = ?, endereco = ?, data_nascimento = ?, telefone = ? ,email= ?,cpf=? where id_doador = ? ");

            stmt.setInt(1, e.getId_cidade().getId_cidade());
            stmt.setInt(2, e.getId_tipo_sanguineo().getId_TipoSanguineo());

            stmt.setString(3, e.getNome());
            stmt.setString(4, e.getEndereco());
            stmt.setDate(5, new java.sql.Date(e.getData_nascimento().getTime()));
            stmt.setInt(6, e.getTelefone());
            stmt.setString(7, e.getEmail());
            stmt.setString(8, e.getCpf());
            stmt.setInt(9, e.getId_doador());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Alteração Realizada com sucesso");

        } catch (SQLException ex) {
        }
    }

    public List<Doadores> pesquisar(String texto) {

        Connection conn = ConexaoBanco.conectaBanco();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Doadores> Doadores = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM doadores where nome like ?");
            stmt.setString(1, "%" + texto + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Doadores d = new Doadores();
                d.setId_doador(rs.getInt("Id_doador"));

                Cidades c = new Cidades();
                c.setId_cidade(rs.getInt("Id_Cidade"));

                d.setId_cidade(c);

                TipoSanguineo ts = new TipoSanguineo();
                ts.setId_TipoSanguineo(rs.getInt("Id_tipo_sanguineo"));

                d.setId_tipo_sanguineo(ts);

                d.setNome(rs.getString("Nome"));
                d.setEndereco(rs.getString("Endereco"));
                d.setData_nascimento(rs.getDate("Data_Nascimento"));
                d.setTelefone(rs.getInt("Telefone"));
                d.setEmail(rs.getString("Email"));
                d.setCpf(rs.getString("Cpf"));

                Doadores.add(d);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DoadoresDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Doadores;
    }

}
