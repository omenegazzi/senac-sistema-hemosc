/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_DAO;

import Database.ConexaoBanco;
import Model.TipoSanguineo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diegomenegazzi
 */
public class TipoSanguineoDao {

    public List<TipoSanguineo> listar() {
        Connection conn = ConexaoBanco.conectaBanco();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<TipoSanguineo> TipoSanguineo = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM tipos_sanguineos");

            rs = stmt.executeQuery();
            while (rs.next()) {
                TipoSanguineo ts = new TipoSanguineo();
                ts.setId_TipoSanguineo(rs.getInt("id_tipo_sanguineo"));
                ts.setDescricao(rs.getString("descricao"));
                ts.setFator_rh(rs.getString("fator_rh"));
                ts.setEstoque(rs.getInt("estoque"));
                ts.setEstoque_minimo(rs.getInt("estoque_minimo"));

                TipoSanguineo.add(ts);

            }

        } catch (SQLException ex) {
            Logger.getLogger(TipoSanguineoDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return TipoSanguineo;
    }

    public List<TipoSanguineo> pesquisar(String texto) {

        Connection conn = ConexaoBanco.conectaBanco();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<TipoSanguineo> TipoSanguineo = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM tipos_sanguineos where descricao like ? ");
            stmt.setString(1, "%" + texto + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {

                TipoSanguineo ts = new TipoSanguineo();
                ts.setId_TipoSanguineo(rs.getInt("id_Tipo_Sanguineo"));
                ts.setDescricao(rs.getString("Descricao"));
                ts.setFator_rh(rs.getString("Fator_rh"));
                ts.setEstoque(rs.getInt("Estoque"));
                ts.setEstoque_minimo(rs.getInt("Estoque_minimo"));

                TipoSanguineo.add(ts);

            }

        } catch (SQLException ex) {
            Logger.getLogger(CidadesDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return TipoSanguineo;
    }
}
