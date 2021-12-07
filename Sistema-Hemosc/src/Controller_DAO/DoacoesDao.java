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
import javax.swing.JOptionPane;
import java.util.Date;
/**
 *
 * @author marcelo.nascimento1
 */
public class DoacoesDao {
    
    public void cadastrar(Doacoes D){
        
        Connection conn = ConexaoBanco.conectaBanco();
        
        PreparedStatement stmt = null;       
        
        try{
            stmt = conn.prepareStatement("INSERT INTO doacoes(id_doacao, data, id_doador, id_tipo_sanguineo, id_colaborador) values (?,?,?,?,?)");
            stmt.setInt(1, D.getId_doacao());
            stmt.setTimestamp(2, new java.sql.Timestamp(D.getData().getTime()));
            stmt.setInt(3, D.getId_doador().getId_doador());
            stmt.setInt(4, D.getId_tipo_sanguineo().getId_TipoSanguineo());
            stmt.setInt(5, D.getId_colaborador().getId_colaborador());                                            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Doação Cadastrada Com Sucesso!");
                    
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar! Tente novamente mais tarde!");
        }
    }
    
    public List<Doacoes> listar(){
        
        Connection conn = ConexaoBanco.conectaBanco();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Doacoes> doacoes = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT id_doacao,data,doadores.nome AS nome_doador, tipos_sanguineos.descricao AS tipo_sanguineo, colaboradores.nome AS nome_colaborador FROM doacoes \n" +
                                        "INNER JOIN doadores ON (doadores.id_doador = doacoes.id_doador) \n" +
                                        "INNER JOIN tipos_sanguineos ON (tipos_sanguineos.id_tipo_sanguineo = doacoes.id_tipo_sanguineo)\n" +
                                        "INNER JOIN colaboradores ON (colaboradores.id_colaborador = doacoes.id_colaborador);");
            
            rs = stmt.executeQuery();
        
            while (rs.next()){
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
    
    public void alterar(Doacoes D){
        
        Connection conn = ConexaoBanco.conectaBanco();
        
        PreparedStatement stmt = null;
        
        try{
            stmt = conn.prepareStatement("UPDATE doacoes set data = ? , id_doador = ?, id_tipo_sanguineo = ?, id_colaborador = ? where id_doacao = (?)");
            
            stmt.setTimestamp(1, new java.sql.Timestamp(D.getData().getTime()));
            stmt.setInt(2, D.getId_doador().getId_doador());
            stmt.setInt(3, D.getId_tipo_sanguineo().getId_TipoSanguineo());
            stmt.setInt(4, D.getId_colaborador().getId_colaborador());   
            stmt.setInt(5, D.getId_doacao());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Doação Atualizada com Sucesso!");
                    
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar! Tente novamente mais tarde!");
            Logger.getLogger(FuncoesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void excluir(Doacoes D){
        
        Connection conn = ConexaoBanco.conectaBanco();
        
        PreparedStatement stmt = null;
        
        try{
            stmt = conn.prepareStatement("DELETE FROM doacoes where id_doacao = (?) ");          
            stmt.setInt(1, D.getId_doacao());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Doação Excluida com Sucesso!");
                    
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Excluir! Tente novamente mais tarde!");
            Logger.getLogger(FuncoesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
    public List<Doacoes> pesquisar(String texto){
        
        Connection conn = ConexaoBanco.conectaBanco();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Doacoes> doacoes = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT id_doacao,data,doadores.nome AS nome_doador, tipos_sanguineos.descricao AS tipo_sanguineo, colaboradores.nome AS nome_colaborador FROM doacoes \n" +
                                        "INNER JOIN doadores ON (doadores.id_doador = doacoes.id_doador) \n" +
                                        "INNER JOIN tipos_sanguineos ON (tipos_sanguineos.id_tipo_sanguineo = doacoes.id_tipo_sanguineo)\n" +
                                        "INNER JOIN colaboradores ON (colaboradores.id_colaborador = doacoes.id_colaborador)\n" +
                                        "WHERE doadores.nome like (?)"); 
            stmt.setString(1,"%"+texto+"%");
            
            rs = stmt.executeQuery();
        
            while (rs.next()){
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
}
