/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_DAO;

import Database.ConexaoBanco;
import Model.Cidades;
import Model.Entidades;
import Model.SaidadeSangue;
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
 * @author lethicia.favretto
 */
public class saidas_de_sangue {
    public List <SaidadeSangue> Listar() {
        Connection conn = ConexaoBanco.conectaBanco();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<SaidadeSangue> SaidadeSangue = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("select saida_sangue.id_saida_sangue,id_entidade,id_tipo_sanguineo,data quantidade from saida_sangue\n"
                    + "inner join entidades on (entidades.id_entidade = saida_sangue.id_entidade)\n"
                    + "inner join tipos_sanguineos on (tipos_sanguineos.id_tipo_sanguineo = saida_sangue.id_tipo_sanguineo);");
            rs = stmt.executeQuery();

            while (rs.next()) {
                SaidadeSangue s = new SaidadeSangue();
                s.setId_saida_sangue(rs.getInt("Id_saida_sangue"));
                s.setData(rs.getDate("data"));
                s.setQuantidade(rs.getInt("quantidade"));
           
                Entidades e = new Entidades();
                  Cidades c = new Cidades();
                e.setNome(rs.getString("nome"));
                e.setEndereco(rs.getString("endereço"));
              
                
                TipoSanguineo t = new TipoSanguineo();
                t.setDescricao(rs.getString("descrição"));
                t.setFator_rh(rs.getString("fator_rh"));
                t.setEstoque(rs.getInt("estoque"));
                t.setEstoque_minimo(rs.getInt("estoque_minimo"));
                
                

                SaidadeSangue.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(saidas_de_sangue.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SaidadeSangue;
        }
    }

