/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import jade.core.Agent;
import jade.domain.DFService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author eduardo
 */
public class AgenteInterfaz extends Agent{
    public static final String url = "jdbc:mysql://127.0.0.1:3306/proyecto";
    public static final String usnm = "root";
    public static final String pwd = "root";

  
    
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        
    
        public void setup(){
            getConnection();

        }
        
             protected void takeDown()
       {
          try { DFService.deregister(this); }
          catch (Exception e) {}
       }
        
        public static Connection getConnection() {
        
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, usnm,pwd);
        } catch (Exception e) {
            System.out.println(e);
        }        
        return con;
        } 
        
        public boolean siExiste(String us, String pass) throws SQLException {

        String sql = "SELECT * FROM usuarios_med WHERE usuario='" + us + "' AND contraseña='" + pass + "'";
        PreparedStatement ps = getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        return rs.next();
    }        
        
        
    
}
