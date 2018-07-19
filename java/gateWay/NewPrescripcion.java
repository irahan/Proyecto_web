/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateWay;

import agentes.AgenteGestor;
import jade.wrapper.gateway.GatewayAgent;

import ontologias.Prescripcion;

/**
 *
 * @author eduardo
 */
public class NewPrescripcion extends GatewayAgent{
    Prescripcion pr = null;
  


    protected void processCommand(java.lang.Object obj) {

        //comprobamos que el objeto recibido sea un usuario
        if (obj instanceof Prescripcion){
            pr = (Prescripcion) obj;
                        
            AgenteGestor AG = new AgenteGestor();
            
            AG.agregar_Prescripcion(pr.getId_medico(),pr.getFecha(),pr.getMedicamento(),pr.getDosis(),pr.getFrecuencia(),pr.getRecomendacion(),pr.getId_pac());
            releaseCommand(pr);


        }
        


    }
}
