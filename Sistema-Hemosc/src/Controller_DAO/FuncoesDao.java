package Controller_DAO;

import Database.ConexaoBanco;
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
 * @author marcelo.nascimento1
 */
public class FuncoesDao {
    
     public void cadastrar(Funcoes F){
        
        Connection conn = ConexaoBanco.conectaBanco();
        
        PreparedStatement stmt = null;       
        
        try{
            stmt = conn.prepareStatement("INSERT INTO funcoes(id_funcao, funcao, descricao, salario) values (?,?,?,?)");
            stmt.setInt(1, F.getId_funcao());
            stmt.setString(2, F.getFuncao());
            stmt.setString(3, F.getDescricao());
            stmt.setDouble(4, F.getSalario());                                            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Função Cadastrada Com Sucesso!");
                    
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar! Tente novamente mais tarde!");
        }
    }
       
    public List<Funcoes> listar(){
        
        Connection conn = ConexaoBanco.conectaBanco();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Funcoes> funcoes = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM funcoes");
            
            rs = stmt.executeQuery();
        
            while (rs.next()){
                Funcoes fun = new Funcoes();
                fun.setId_funcao(rs.getInt("id_funcao"));
                fun.setFuncao(rs.getString("funcao"));
                fun.setDescricao(rs.getString("descricao"));
                fun.setSalario(rs.getDouble("salario"));
           
                funcoes.add(fun);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncoesDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return funcoes;
    }
    
    
    public void alterar(Funcoes f){
        
        Connection conn = ConexaoBanco.conectaBanco();
        
        PreparedStatement stmt = null;
        
        try{
            stmt = conn.prepareStatement("UPDATE funcoes set funcao = ? , descricao = ?, salario = ? where id_funcao = (?) ");
            stmt.setString(1, f.getFuncao());
            stmt.setString(2, f.getDescricao());
            stmt.setDouble(3, f.getSalario());
            stmt.setInt(4, f.getId_funcao());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Função Atualizada com Sucesso!");
                    
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar! Tente novamente mais tarde!");
            Logger.getLogger(FuncoesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void excluir(Funcoes F){
        
        Connection conn = ConexaoBanco.conectaBanco();
        
        PreparedStatement stmt = null;
        
        try{
            stmt = conn.prepareStatement("DELETE FROM funcoes where id_funcao = (?) ");          
            stmt.setInt(1, F.getId_funcao());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Função Excluida com Sucesso!");
                    
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Excluir! Tente novamente mais tarde!");
            Logger.getLogger(FuncoesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public List<Funcoes> pesquisar(String texto){
        
        Connection conn = ConexaoBanco.conectaBanco();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Funcoes> funcoes = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM funcoes where funcao like (?)");
            stmt.setString(1,"%"+texto+"%");
            
            rs = stmt.executeQuery();
        
            while (rs.next()){
                Funcoes F = new Funcoes();
                F.setId_funcao(rs.getInt("id_funcao"));
                F.setFuncao(rs.getString("funcao"));
                F.setDescricao(rs.getString("descricao"));
                F.setSalario(rs.getDouble("salario"));
           
                funcoes.add(F);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncoesDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return funcoes;
    }
}

