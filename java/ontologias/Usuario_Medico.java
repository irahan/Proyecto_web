/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ontologias;

/**
 *
 * @author eduardo
 */
public class Usuario_Medico {
    int id_usuario = 0;
    int id_medico = 0;
    String usuario = "";
    String contraseña = "";
    boolean login = false;
    
    public void setLogin(boolean log){
        this.login = log;
    }
    
    public boolean getLogin(){
        return login;
    }
   
    
    public int getId_U(){
        return id_usuario;
    }
    
    public void setId_U(int id_u){
        this.id_usuario = id_u;
    }
    
    public int getId_M(){
        return id_medico;
    }
    
    public void setId_M(int id_m){
        this.id_medico = id_m;
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public String getContraseña(){
        return contraseña;
    }
    
    public void setContraseña(String con){
        this.contraseña = con;
    }
    
}
