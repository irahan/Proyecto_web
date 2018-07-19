/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import agentes.AgenteConsulta;
import jade.wrapper.gateway.JadeGateway;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ontologias.Cuadro_Clinico;
import ontologias.Pacientes;
import ontologias.Prescripcion;

/**
 *
 * @author eduardo
 */
@WebServlet(name = "NewID", urlPatterns = {"/NewID"})
public class NewID extends HttpServlet {
    
    static final long serialVersionUID = 1L;
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreAccion = request.getParameter("accion");

        if (!nombreAccion.equals("validar")) {
            response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
            return;
        } else {
            //creamos el objeto que enviaremos a JADE
            Pacientes pac = new Pacientes();
            int id_pac = Integer.parseInt(request.getParameter("id_pac"));
            
            Prescripcion pr = AgenteConsulta.consultarPacienteP(id_pac);
            Cuadro_Clinico cc = AgenteConsulta.consultarPaciente(id_pac);
            if (pr != null & cc == null ) {
                
                 request.setAttribute("pr", pr);

                request.getRequestDispatcher("Historial_1.jsp").forward(request, response);
                
            } else {
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert(' No existe historial');");
                out.println("location='Historial.jsp';");
                out.println("</script>");
            }
            
            if (cc != null & pr == null) {
                
                
               request.setAttribute("cc", cc);
                
                request.getRequestDispatcher("Historial_2.jsp").forward(request, response);
            } else {
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert(' No existe historial');");
                out.println("location='Historial.jsp';");
                out.println("</script>");
            }
            if (cc != null & pr != null ) {
                
                
               request.setAttribute("cc", cc);
               request.setAttribute("pr", pr);
               
                
                request.getRequestDispatcher("Historial_3.jsp").forward(request, response);
            } else {
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert(' No existe historial');");
                out.println("location='Historial.jsp';");
                out.println("</script>");
            }
            



        }

 
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
