/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author diegomenegazzi
 */
public class ConexaoBanco {
    public static Connection conectaBanco(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            return DriverManager.getConnection("jdbc:mysql://localhost/db_hemosc?"
                            + "user=root&password=2643");     
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            throw new RuntimeException("Erro ao conectar no banco de dados", ex);
            
        }   
    }
}
