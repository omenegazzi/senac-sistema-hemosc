package Controller_DAO;

import Database.ConexaoBanco;
import Model.Cidades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    
}
    

