package Controller_DAO;

import Database.ConexaoBanco;
import Model.Colaboradores;
import Model.Doacoes;
import Model.Doadores;
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
 * @author marcelo.nascimento1
 */
public class DoacoesDao {

    public List<Doacoes> pesquisar(String texto) {

        Connection conn = ConexaoBanco.conectaBanco();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Doacoes> doacoes = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT id_doacao,data,doadores.nome AS nome_doador, tipos_sanguineos.descricao,tipos_sanguineos.fator_rh, colaboradores.nome AS nome_colaborador FROM doacoes \n"
                    + "INNER JOIN doadores ON (doadores.id_doador = doacoes.id_doador) \n"
                    + "INNER JOIN tipos_sanguineos ON (tipos_sanguineos.id_tipo_sanguineo = doacoes.id_tipo_sanguineo)\n"
                    + "INNER JOIN colaboradores ON (colaboradores.id_colaborador = doacoes.id_colaborador)\n"
                    + "WHERE id_doador like (?)");
            stmt.setString(1, "%" + texto + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Doacoes D = new Doacoes();
                D.setId_doacao(rs.getInt("id_doacao"));
                D.setData(rs.getDate("data"));

                Doadores doar = new Doadores();
                doar.setNome(rs.getString("nome_doador"));
                D.setId_doador(doar);

                TipoSanguineo T = new TipoSanguineo();
                T.setDescricao(rs.getString("tipo_sanguineo"));
                D.setId_tipo_sanguineo(T);

                Colaboradores C = new Colaboradores();
                C.setNome(rs.getString("nome_colaborador"));
                D.setId_colaborador(C);

                doacoes.add(D);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncoesDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return doacoes;
    }

    public List<Doacoes> listar() {

        Connection conn = ConexaoBanco.conectaBanco();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Doacoes> doacoes = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("select id_doacao, doadores.nome as nome_doador, tipos_sanguineos.descricao as descricao_ts, colaboradores.nome as nome_desc from doacoes\n"
                    + "inner join doadores on (doadores.id_doador = doacoes.id_doador)\n"
                    + "inner join tipos_sanguineos on (tipos_sanguineos.id_tipo_sanguineo = doacoes.id_tipo_sanguineo)\n"
                    + "inner join colaboradores on (colaboradores.id_colaborador = doacoes.id_colaborador)");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Doacoes d = new Doacoes();
                d.setId_doacao(rs.getInt("id_doacao"));
               
                Doadores d1 = new Doadores();
                d1.setNome(rs.getString("nome_doador"));
                d.setId_doador(d1);

               /* Doadores doa = new Doadores();
                doa.setId_doador(rs.getString("nome"));
                d.setId_doador(doa);*/

                TipoSanguineo Ts = new TipoSanguineo();
                Ts.setDescricao(rs.getString("descricao_ts"));
                d.setId_tipo_sanguineo(Ts);

                Colaboradores Col = new Colaboradores();
                Col.setNome(rs.getString("nome_desc"));
                d.setId_colaborador(Col);

                doacoes.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoadoresDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return doacoes;
    }
}
