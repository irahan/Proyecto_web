package ontologias;

/**
 *
 * @author eduardo
 */
public class Historial {
    
    int id_his = 0;
    int id_cuadroclinic = 0;
    int id_medico = 0;
    String fecha ="";
    
    public int getId_H(){
        return id_his;
    }
    
    public void setId_H(int id_h){
        this.id_his = id_h;
    }
    
    public int getId_C(){
        return id_cuadroclinic;
    }
    
    public void setId_C(int id_cuadro){
        this.id_cuadroclinic = id_cuadro;
    }
    
    public int getId_M(){
        return id_medico;
    }
    
    public void setId_M(int id_med){
        this.id_medico = id_med;
    }
    
    public String getFecha(){
        return fecha;
    }
    
    public void setFecha(String date){
        this.fecha = date;
    }
            
}
