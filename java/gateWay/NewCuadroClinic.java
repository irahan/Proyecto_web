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


/**
 *
 * @author eduardo
 */
public class NewCuadroClinic extends GatewayAgent{
    Cuadro_Clinico cc = null;


    protected void processCommand(java.lang.Object obj) {

        //comprobamos que el objeto recibido sea un usuario
        if (obj instanceof Cuadro_Clinico){
            cc = (Cuadro_Clinico) obj;
            
            AgenteGestor AG = new AgenteGestor();
            
            AG.agregar_CuadroC(cc.getUnidad_M(),cc.getFecha(),cc.getId_paciente(),cc.getTipo_int());
            releaseCommand(cc);


        }
        


    }
    
}
