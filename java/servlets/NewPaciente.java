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
import ontologias.Pacientes;


/**
 *
 * @author eduardo
 */
@WebServlet(name = "NewPaciente", urlPatterns = {"/NewPaciente"})
public class NewPaciente extends HttpServlet {
static final long serialVersionUID = 1L;
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //obtenemos la acción a realizar
        String nombreAccion = request.getParameter("accion2");

        if (!nombreAccion.equals("validar2")) {
            response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
            return;
        } else {
            //creamos el objeto que enviaremos a JADE
            Pacientes pac = new Pacientes();
            
            pac.setNombre(request.getParameter("nom"));
            pac.setApellido_P(request.getParameter("app"));
            pac.setApellido_M(request.getParameter("apm"));
            pac.setEdad(request.getParameter("ed"));
            pac.setSexo(request.getParameter("sex"));
            pac.setTemperatura(request.getParameter("temp"));
            pac.setFrecuencia_C(request.getParameter("fc"));
            pac.setFrecuencia_R(request.getParameter("fr"));
            pac.setTalla(request.getParameter("alt"));
            pac.setPeso(request.getParameter("peso"));
            pac.setTension_A(request.getParameter("ta"));         
        
          
            //mandamos el usuario al agente GateWayAgent de JADE
            try {
                JadeGateway.execute(pac);

                
            } catch (Exception e) {
                e.printStackTrace();
            }

            //creamos la salida del servlet
            
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert(' Paciente Agregado');");
            out.println("location='RegistrarPac.html';");
            out.println("</script>");
            
            
            /*
            out.println("<script type=\"text/javascript\">");
            out.println("location='/#!';");
            out.println("</script>");
            
            boolean login = usuario.getLogin();
            if (login == true) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Bienvenido "+usuario.getUsuario()+"');");
                out.println("location='IniciarSesion.html';");
                out.println("</script>");
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('El usuario o la contraseña no son correctos');");
                out.println("location='index.html';");
                out.println("</script>");
            } 
*/
            //out.print("Usuario agregado: " + usuario.getUsuario() + "-" + usuario.getContraseña() + "<br>");
            //out.print("<br/><a href='index.jsp'> Volver a validar </a>");
            


            out.flush();
            out.close();

        }
    }
        public void init() throws ServletException {
 
        //Establecemos qué clase será la GateGayAgent

            JadeGateway.init("gateWay.NewPaciente",null);
            
  
        
 
    }
}
