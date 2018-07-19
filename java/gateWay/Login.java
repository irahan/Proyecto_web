/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateWay;

import agentes.AgenteInterfaz;
import jade.wrapper.gateway.GatewayAgent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ontologias.Usuario_Medico;

/**
 *
 * @author eduardo
 */
public class Login extends GatewayAgent{
    
    Usuario_Medico usuario = null;

    protected void processCommand(java.lang.Object obj) {

        //comprobamos que el objeto recibido sea un usuario
        if (obj instanceof Usuario_Medico) {
            usuario = (Usuario_Medico) obj;
            
            AgenteInterfaz AI = new AgenteInterfaz();
            try {
               usuario.setLogin(AI.siExiste(usuario.getUsuario(), usuario.getContraseña()));
                
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            


            //devolvemos el objeto usuario al servlet con la autentificación
            releaseCommand(usuario);

        } else {
            System.out.println("error aquí");
        }

    }

    
}
