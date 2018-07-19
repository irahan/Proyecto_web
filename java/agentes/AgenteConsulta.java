/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import static agentes.AgenteInterfaz.getConnection;
import jade.core.Agent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import ontologias.Cuadro_Clinico;
import ontologias.Medicos;
import ontologias.Pacientes;
import ontologias.Prescripcion;


/**
 *
 * @author eduardo
 */
public class AgenteConsulta extends Agent{
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
        
        public void agregar_Med(String nom, String app, String apm, String esp,String dir,String cor,String cel,String tel) {
            
            String nombre = nom;
            String apellido_p = app;
            String apellido_m = apm;
            String especialidad = esp;
            String direccion = dir;
            String correo = cor;
            String celular = cel;
            String telefono = tel;
            
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("insert into  medicos(nombre,apellido_p,apellido_m,especialidad,direccion,correo,celular,telefono) values(?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido_p);
            preparedStatement.setString(3, apellido_m);
            preparedStatement.setString(4, especialidad);
            preparedStatement.setString(5, direccion);
            preparedStatement.setString(6, correo);
            preparedStatement.setString(7, celular);
            preparedStatement.setString(8, telefono);
            

            preparedStatement.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
        
        
        public void agregar_Usuario(int id_med,String u,String c){
            
            int id_medico = id_med;
            String usuario = u;
            String contraseña = c;

                try {
            connection = getConnection();

            
            preparedStatement = connection.prepareStatement("insert into usuarios_med(id_medico,usuario,contraseña) values(?,?,?)");
            
            preparedStatement.setInt(1,id_medico);
            preparedStatement.setString(2,usuario);
            preparedStatement.setString(3,contraseña);
            
            
            preparedStatement.executeUpdate();
            
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        }
        
        public void agregar_Pacientes(String nom,String app, String apm,String ed, String sex, String temp, String frecc,String frecr,String tal,String pes,String ta){
            String nombre = nom;
            String apellido_p = app;
            String apellido_m = apm;
            String edad = ed;
            String sexo = sex;
            String temperatura = temp;
            String frecuencia_cardiaca = frecc;
            String frecuencia_respiratoria = frecr;
            String talla = tal;
            String peso = pes;
            String tension_arterial = ta;
            
                    try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("insert into pacientes(nombre,apellido_p,apellido_m,edad,sexo,temperatura,frecuencia_cardiaca,frecuencia_respiratoria,talla,peso,tension_arterial) values (?,?,?,?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido_p);
            preparedStatement.setString(3, apellido_m);
            preparedStatement.setString(4, edad);
            preparedStatement.setString(5, sexo);
            preparedStatement.setString(6, temperatura);
            preparedStatement.setString(7, frecuencia_cardiaca);
            preparedStatement.setString(8, frecuencia_respiratoria);
            preparedStatement.setString(9, talla);
            preparedStatement.setString(10, peso);
            preparedStatement.setString(11, tension_arterial);
            

            preparedStatement.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        }
            
            
        }
        
        public ArrayList<Pacientes> getPacientes(){
            ArrayList<Pacientes> pacientes = new ArrayList<Pacientes>();
            try{
                Statement stmt = getConnection().createStatement();
                ResultSet result = stmt.executeQuery("select id_paciente,nombre,apellido_p,apellido_m from pacientes");
                while(result.next()){
                    Pacientes paciente = new Pacientes();
                    
                    paciente.setID((Integer) result.getObject(1));
                    paciente.setNombre((String) result.getObject(2));
                    paciente.setApellido_P((String) result.getObject(3));
                    paciente.setApellido_M((String) result.getObject(4));
                    pacientes.add(paciente);
                                        
                }
                             
                
            }catch (Exception e){
                System.out.println(e);
                
            }
           return pacientes; 
        }
        public ArrayList<Medicos> getMedicos(){
            ArrayList<Medicos> med = new ArrayList<Medicos>();
            try{
                Statement stmt = getConnection().createStatement();
                ResultSet result = stmt.executeQuery("select id_medico,nombre,apellido_p,apellido_m from medicos;");
                while(result.next()){
                    Medicos medico = new Medicos();
                    
                    medico.setID((Integer) result.getObject(1));
                    medico.setNombre((String) result.getObject(2));
                    medico.setApellido_P((String) result.getObject(3));
                    medico.setApellido_M((String) result.getObject(4));
                    
                    med.add(medico);                   
                                        
                }
                                           
            }catch (Exception e){
                System.out.println(e);
                
            }
           return med; 
        }
        
        public static Cuadro_Clinico consultarPaciente(int id_pac) {
            Cuadro_Clinico cc = null;
     
        try {
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select tipo_interrogatorio, unidad_medica, fecha_elabo from cuadro_clinico where id_paciente = "+id_pac+";");
            while (rs.next()) {
                cc = new Cuadro_Clinico(rs.getString(1),rs.getString(2),rs.getString(3));
            }
            rs.close();
            
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return cc;
        }
        
        
        public static Prescripcion consultarPacienteP(int id_pac) {
            
            Prescripcion pr = null;
            
     
        try {
            Statement stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select medicamento,dosis,fecha,recomendacion from prescripcion where id_paciente = "+id_pac+";");
            while (rs.next()) {
                pr = new Prescripcion(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
               
            }
            rs.close();
            
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return pr;
        }
        
        
        
        
        
       

}
