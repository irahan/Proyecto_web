/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateWay;

import agentes.AgenteConsulta;
import jade.wrapper.gateway.GatewayAgent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ontologias.Medicos;
import ontologias.Usuario_Medico;

/**
 *
 * @author eduardo
 */
public class NewMedico extends GatewayAgent{
    Usuario_Medico usuario = null;
    Medicos medicos = null;

    protected void processCommand(java.lang.Object obj) {

        //comprobamos que el objeto recibido sea un usuario
        if (obj instanceof Medicos){
            medicos = (Medicos) obj;
            
            AgenteConsulta AC = new AgenteConsulta();
            
            AC.agregar_Med(medicos.getNombre(), medicos.getApellido_P(),medicos.getApellido_M(),medicos.getEspecialidad(),medicos.getDireccion(),medicos.getCorreo(),medicos.getCelular(),medicos.getTelefono());
            releaseCommand(medicos);
        }
        


    }

    
}
