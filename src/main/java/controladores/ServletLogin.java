/*
 * UNIVERSIDAD AUTONOMA DE CAMPECHE
 * PROGRAMACION DE APLICACIONES WEB
 * 2020
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dajaimes
 */
public class ServletLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");

        switch (accion) {
            case "salir":
                response.sendRedirect("index.jsp");
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "ingresar":
                // Validar usuario y generar session y mandar al menú
                response.sendRedirect("menu.jsp");
                break;
            default:
                throw new AssertionError();
        }
    }

}
