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
public class Prescripcion {
    
    int id_med = 0;


    int id_pac =0;
    String fecha = "";
    String medicamento = "";
    String dosis ="";
    String frecuencia="";
    String recomendacion ="";

    public int getId_medico() {
        return id_med;
    }

    public void setId_medico(int id_medico) {
        this.id_med = id_medico;
    }
    
    public int getId_pac() {
        return id_pac;
    }

    public void setId_pac(int id_pac) {
        this.id_pac = id_pac;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }
    
    public Prescripcion(String med,String dosis,String fe,String rec){
        super();
        this.medicamento = med;
        this.dosis = dosis;
        this.fecha = fe;
        this.recomendacion = rec;
        
    }
    public Prescripcion(){
    
    }
}
