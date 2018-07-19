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
public class Medicos {
    
    int id_medico = 0;
    String nombre = "";
    String apellido_p ="";
    String apellido_m = "";
    String especialidad = "";
    String direccion = "";
    String correo = "";
    String celular = "";
    String telefono = "";
    
    
    public int getID(){
        return id_medico;
    }
    
    public void setID(int id){
        this.id_medico = id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nom){
        this.nombre = nom;
    }
    
    public String getApellido_P(){
        return apellido_p;
    }
    
    public void setApellido_P(String apellidop){
        this.apellido_p = apellidop;
    }
    
    public String getApellido_M(){
        return apellido_m;
    }
    
    public  void setApellido_M(String apellidom){
        this.apellido_m = apellidom;
    }
    
    public String getEspecialidad(){
        return especialidad;
    }
    
    public void setEspecialidad(String esp){
        this.especialidad = esp;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public void setDireccion(String dir){
        this.direccion = dir;
    }
    
    public String getCorreo(){
        return correo;
    }
    
    public void setCorreo(String cor){
        this.correo = cor;
    }
    
    public String getCelular(){
        return celular;
    }
    
    public  void setCelular(String cel){
        this.celular = cel;
    }
    
    public String getTelefono(){
        return telefono;
    }
    
    public void setTelefono(String tel){
        this.telefono = tel;
    }
    
    
    
    
}
