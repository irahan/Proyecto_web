/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import static agentes.AgenteConsulta.getConnection;
import jade.core.Agent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import ontologias.Pacientes;

/**
 *
 * @author eduardo
 */
public class AgenteGestor extends Agent {
     public static final String url = "jdbc:mysql://127.0.0.1:3306/proyecto";
    public static final String usnm = "root";
    public static final String pwd = "root";

  
    
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        
    
        public void setup(){
            getConnection();

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
               
        
               
        public void agregar_CuadroC(String Uni_M, String Fecha, int id_pac, String tipo_I){
            String Unidad_Medica = Uni_M;
            String Date = Fecha;
            int id_paciente = id_pac;
            String tipo_Interrogatorio = tipo_I;
            
            try {
            connection = getConnection();

            preparedStatement = connection.prepareStatement("insert into cuadro_clinico(unidad_medica,fecha_elabo,id_paciente,tipo_interrogatorio) values(?,?,?,?)");

            preparedStatement.setString(1, Unidad_Medica);
            preparedStatement.setString(2, Date);
            preparedStatement.setInt(3, id_paciente);
            preparedStatement.setString(4, tipo_Interrogatorio);
           
            preparedStatement.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
        public void agregar_Prescripcion(int id_med,String fecha,String medicamento,String dosis,String frec,String recomendacion, int id_pac){
            int id_medi = id_med;
            String fechaa = fecha;
            String medicamentoo = medicamento;
            String dosiss = dosis;
            String frecu = frec;
            String recomendacionn = recomendacion;
            int id_paci = id_pac;
            
            try {
            connection = getConnection();

            preparedStatement = connection.prepareStatement("insert into prescripcion(id_medico,fecha,medicamento,dosis,frecuencia,recomendacion,id_paciente) values(?,?,?,?,?,?,?)");

            
            preparedStatement.setInt(1, id_medi);
            preparedStatement.setString(2, fechaa);
            preparedStatement.setString(3, medicamentoo);          
            preparedStatement.setString(4, dosiss);
            preparedStatement.setString(5, frecu);
            preparedStatement.setString(6, recomendacionn);
            preparedStatement.setInt(7, id_paci);
            
            
            preparedStatement.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
            
        
        
        
    
}
