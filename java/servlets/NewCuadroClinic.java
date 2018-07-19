/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import jade.core.ProfileImpl;
import jade.wrapper.ContainerController;
import jade.wrapper.gateway.JadeGateway;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ontologias.Cuadro_Clinico;


/**
 *
 * @author eduardo
 */
@WebServlet(name = "NewCuadroClinic", urlPatterns = {"/NewCuadroClinic"})
public class NewCuadroClinic extends HttpServlet {
    
    static final long serialVersionUID = 1L;
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //obtenemos la acción a realizar
        String nombreAccion = request.getParameter("accion");

        if (!nombreAccion.equals("validar")) {
            response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
            return;
        } else {
            //creamos el objeto que enviaremos a JADE
            Cuadro_Clinico cc = new Cuadro_Clinico();
            
            cc.setUnidad_M(request.getParameter("UM"));
            cc.setFecha(request.getParameter("Fecha"));
            cc.setId_paciente(Integer.parseInt(request.getParameter("id_pac")));
            cc.setTipo_int(request.getParameter("TI"));
            
            

            //mandamos el usuario al agente GateWayAgent de JADE
            try {
                JadeGateway.execute(cc);
                
            } catch (Exception e) {
                e.printStackTrace();
            }

            //creamos la salida del servlet
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert(' Cuadro Clinico Agregado');");
            out.println("location='CuadroClinico.jsp';");
            out.println("</script>");
            //out.print("Usuario agregado: " + usuario.getUsuario() + "-" + usuario.getContraseña() + "<br>");
            //out.print("<br/><a href='index.jsp'> Volver a validar </a>");
            


            out.flush();
            out.close();

        }
    }
        public void init() throws ServletException {
 
        //Establecemos qué clase será la GateGayAgent

            JadeGateway.init("gateWay.NewCuadroClinic",null);
            
            jade.core.Runtime rt = jade.core.Runtime.instance();
            rt.setCloseVM(true);
            ContainerController cc = rt.createAgentContainer(new ProfileImpl(false));

            try {
                // creo el agente y lo pongo en accion
                (cc.createNewAgent("AgenteCuadroClinico", "gateWay.NewCuadroClinic", new Object[1])).start();
            } catch (Exception e) {
            }
  
        
 
    }
}
