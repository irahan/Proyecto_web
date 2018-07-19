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
import ontologias.Medicos;
import ontologias.Usuario_Medico;

/**
 *
 * @author eduardo
 */
@WebServlet(name = "NewMedico_1", urlPatterns = {"/NewMedico_1"})
public class NewMedico_1 extends HttpServlet {
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
            Medicos med = new Medicos();

            
            med.setNombre(request.getParameter("nom"));
            med.setApellido_M(request.getParameter("app"));
            med.setApellido_P(request.getParameter("apm"));
            med.setEspecialidad(request.getParameter("esp"));
            med.setDireccion(request.getParameter("dir"));
            med.setCorreo(request.getParameter("cor"));
            med.setCelular(request.getParameter("cel"));
            med.setTelefono(request.getParameter("tel"));

          

            //mandamos el usuario al agente GateWayAgent de JADE
            try {
                JadeGateway.execute(med);

                
            } catch (Exception e) {
                e.printStackTrace();
            }

            //creamos la salida del servlet
            
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert(' Usuario Agregado');");
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

            JadeGateway.init("gateWay.NewMedico",null);
            
  
        
 
    }
}
