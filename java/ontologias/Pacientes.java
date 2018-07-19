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
public class Pacientes {
    int id_paciente = 0;
    String nombre = "";
    String apellido_p ="";
    String apellido_m = "";
    String edad = "";
    String sexo ="";
    String temperatura="";
    String frecuencia_cardiaca = "";
    String frecuencia_respiratoria = "";
    String talla = "";
    String peso = "";
    String tension_arterial = "";
    
    
    public int getID(){
        return id_paciente;
    }
    
    public void setID(int id){
        this.id_paciente = id;
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
    
    public String getEdad(){
        return edad;
    }
    
    public void setEdad(String ed){
        this.edad = ed;
    }
    
    public String getSexo(){
        return sexo;
    }
    
    public void setSexo(String sex){
        this.sexo = sex;
    }
    
    public String getTemperatura(){
        return temperatura;
    }
    
    public void setTemperatura(String temp){
        this.temperatura = temp;
    }
    
    public String getFrecuencia_C(){
        return frecuencia_cardiaca;
    }
    
    public  void setFrecuencia_C(String frec_c){
        this.frecuencia_cardiaca = frec_c;
    }
    
    public String getFrecuencia_R(){
        return frecuencia_respiratoria;
    }
    
    public void setFrecuencia_R(String frec_r){
        this.frecuencia_respiratoria = frec_r;
    }
    
    public String getTalla(){
        return talla;
    }
    
    public  void setTalla(String talla){
        this.talla = talla;
    }
    
    public String getPeso(){
        return peso;
    }
    
    public void setPeso(String peso){
        this.peso = peso;
    }
    
    public String getTension_A(){
        return tension_arterial;
    }
    
    public void setTension_A(String tensiona){
        this.tension_arterial = tensiona;
    }
        
    
}
