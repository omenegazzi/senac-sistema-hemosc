package Controller_DAO;

import Database.ConexaoBanco;
import Model.Cidades;
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
 * @author david.castagnaro
 */
public class CidadesDao {

    public void cadastrar(Cidades c) {

        Connection conn = ConexaoBanco.conectaBanco();

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO cidades (codigo_ibge,descricao,uf) VALUES (?,?,?)");
            stmt.setInt(1, c.getCodigo_ibge());
            stmt.setString(2, c.getDescricao());
            stmt.setString(3, c.getUf());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cidade cadastrada com Sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Cidade! Por favor, tente mais tarde.");
            Logger.getLogger(CidadesDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Cidades> listar() {
        Connection conn = ConexaoBanco.conectaBanco();

        PreparedStatement stmn = null;

        ResultSet rs = null;

        List<Cidades> cidades = new ArrayList<>();

        try {
            stmn = conn.prepareStatement("SELECT * FROM  cidades");

            rs = stmn.executeQuery();

            while (rs.next()) {
                Cidades e = new Cidades();
                e.setId_cidade(rs.getInt("id_cidade"));
                e.setCodigo_ibge(rs.getInt("codigo_ibge"));
                e.setDescricao(rs.getString("descricao"));
                e.setUf(rs.getString("uf"));

                cidades.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CidadesDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cidades;
    }

    public List<Cidades> pesquisar(String texto) {

        Connection conn = ConexaoBanco.conectaBanco();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cidades> Cidades = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM cidades where descricao like ? ");
            stmt.setString(1, "%" + texto + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cidades c = new Cidades();
                c.setId_cidade(rs.getInt("Id_cidade"));
                c.setCodigo_ibge(rs.getInt("Codigo_ibge"));
                c.setDescricao(rs.getString("Descricao"));
                c.setUf(rs.getString("Uf"));

                Cidades.add(c);

            }

        } catch (SQLException ex) {
            Logger.getLogger(CidadesDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return Cidades;
    }

    public void excluir(Cidades c) {
        
        Connection conn = ConexaoBanco.conectaBanco();

        PreparedStatement stmt = null;

        ResultSet rs = null;
        
        try {
            stmt = conn.prepareStatement("DELETE FROM cidades WHERE id_cidade = ?");
            stmt.setInt(1, c.getId_cidade());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cidade excluida com Sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(CidadesDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
