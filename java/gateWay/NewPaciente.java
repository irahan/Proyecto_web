/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateWay;

import agentes.AgenteConsulta;
import jade.wrapper.gateway.GatewayAgent;
import ontologias.Pacientes;


/**
 *
 * @author eduardo
 */
public class NewPaciente extends GatewayAgent{
        Pacientes pac = null;
;

    protected void processCommand(java.lang.Object obj) {

        //comprobamos que el objeto recibido sea un usuario
        if (obj instanceof Pacientes){
            pac = (Pacientes) obj;
            
            AgenteConsulta AC = new AgenteConsulta();
            
            AC.agregar_Pacientes(pac.getNombre(),pac.getApellido_P(),pac.getApellido_M(),pac.getEdad(),pac.getSexo(),pac.getTemperatura(),pac.getFrecuencia_C(),pac.getFrecuencia_R(),pac.getTalla(),pac.getPeso(),pac.getTension_A());
            releaseCommand(pac);

        }
        


    }
    
}
