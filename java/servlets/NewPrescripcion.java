/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import jade.wrapper.gateway.JadeGateway;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ontologias.Prescripcion;

/**
 *
 * @author eduardo
 */
@WebServlet(name = "NewPrescripcion", urlPatterns = {"/NewPrescripcion"})
public class NewPrescripcion extends HttpServlet {
    
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
            Prescripcion pr = new Prescripcion();
            
            pr.setId_medico(Integer.parseInt(request.getParameter("id_med")));
            pr.setFecha(request.getParameter("fecha"));
            pr.setMedicamento(request.getParameter("medi"));
            pr.setDosis(request.getParameter("dosis"));
            pr.setFrecuencia(request.getParameter("frec"));
            pr.setRecomendacion(request.getParameter("rec"));
            pr.setId_pac(Integer.parseInt(request.getParameter("id_pac")));
                 
            

            //mandamos el usuario al agente GateWayAgent de JADE
            try {
                JadeGateway.execute(pr);
                
            } catch (Exception e) {
                e.printStackTrace();
            }

            //creamos la salida del servlet
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert(' Prescripcion agregada');");
            out.println("location='RegistrarPres.jsp';");
            out.println("</script>");
            //out.print("Usuario agregado: " + usuario.getUsuario() + "-" + usuario.getContraseña() + "<br>");
            //out.print("<br/><a href='index.jsp'> Volver a validar </a>");
            


            out.flush();
            out.close();

        }
    }
        public void init() throws ServletException {
 
        //Establecemos qué clase será la GateGayAgent

            JadeGateway.init("gateWay.NewPrescripcion",null);
  
        
 
    }
}
