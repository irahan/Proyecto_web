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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ontologias.Usuario_Medico;
import jade.core.Runtime;


/**
 *
 * @author eduardo
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
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
            Usuario_Medico usuario = new Usuario_Medico();

            usuario.setUsuario(request.getParameter("usuario"));
            usuario.setContraseña(request.getParameter("contrasena"));

            //mandamos el usuario al agente GateWayAgent de JADE
            try {
                JadeGateway.execute(usuario);
                
            } catch (Exception e) {
                e.printStackTrace();
            }

            //creamos la salida del servlet
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
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
            //out.print("Usuario agregado: " + usuario.getUsuario() + "-" + usuario.getContraseña() + "<br>");
            //out.print("<br/><a href='index.jsp'> Volver a validar </a>");
            


            out.flush();
            out.close();

        }
    }
        public void init() throws ServletException {
 
        //Establecemos qué clase será la GateGayAgent

            JadeGateway.init("gateWay.Login",null);
            
            Runtime rt = Runtime.instance();
            rt.setCloseVM(true);
            ContainerController cc = rt.createMainContainer(new ProfileImpl(true));

            try {
                // creo el agente y lo pongo en accion
                (cc.createNewAgent("AgenteLogin", "agentes.AgenteInterfaz", new Object[0])).start();
            } catch (Exception e) {
            }
  
        
 
    }
}
