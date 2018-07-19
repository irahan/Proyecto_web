/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateWay;

import agentes.AgenteConsulta;
import agentes.AgenteGestor;
import jade.wrapper.gateway.GatewayAgent;
import ontologias.Cuadro_Clinico;
import ontologias.Pacientes;

/**
 *
 * @author eduardo
 */
public class NewID extends GatewayAgent{
    
    Pacientes pac = null;


    protected void processCommand(java.lang.Object obj) {

        //comprobamos que el objeto recibido sea un usuario
        if (obj instanceof Pacientes){
            pac = (Pacientes) obj;
            
            AgenteConsulta AC = new AgenteConsulta();
            
            int id= pac.getID();
            

            releaseCommand(pac);


        }
    
}
}
