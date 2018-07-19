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
public class Cuadro_Clinico {
    String unidad_M = "";
    String fecha = "";
    int id_paciente = 0;
    String tipo_int ="";

    public String getUnidad_M() {
        return unidad_M;
    }

    public void setUnidad_M(String unidad_M) {
        this.unidad_M = unidad_M;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getTipo_int() {
        return tipo_int;
    }

    public void setTipo_int(String tipo_int) {
        this.tipo_int = tipo_int;
    }
    
    public Cuadro_Clinico(String ti,String um,String fe){
        super();
        this.tipo_int = ti;
        this.unidad_M = um;
        this.fecha = fe;
        
    }
    public Cuadro_Clinico(){
        
    }
    
    
}
