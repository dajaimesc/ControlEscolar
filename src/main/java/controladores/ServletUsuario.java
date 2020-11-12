/*
 * UNIVERSIDAD AUTONOMA DE CAMPECHE
 * PROGRAMACION DE APLICACIONES WEB
 * 2020
 */
package controladores;

import datos.IUsuarioDatos;
import datos.UsuarioDatos;
import domain.UsuarioEntidad;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dajaimes
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {

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
            case "ingresar": {
                try {
                    // Validar usuario y generar session y mandar al menú
                    this.buscarUsuario(request, response);
                }
                catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }

            break;

            default:
                throw new AssertionError();
        }
    }

    private void buscarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        String login = request.getParameter("username");
        String password = request.getParameter("password");

        UsuarioEntidad usuarioE = new UsuarioEntidad(login, password);
        IUsuarioDatos usuarioD = new UsuarioDatos();

        usuarioE = usuarioD.buscar(usuarioE);

        if (usuarioE.getNombre() == null) {
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("menu.jsp");
        }

        System.out.println("usuarioE = " + usuarioE);

    }

}
