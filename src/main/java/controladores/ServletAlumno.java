/*
 * UNIVERSIDAD AUTONOMA DE CAMPECHE
 * PROGRAMACION DE APLICACIONES WEB
 * 2020
 */
package controladores;

import datos.AlumnoDatos;
import datos.IAlumnoDatos;
import domain.AlumnoEntidad;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Front Controller de MVC
 *
 * @author dajaimes
 */
@WebServlet("/ServletAlumno")

public class ServletAlumno extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String accion = request.getParameter("accion");

        switch (accion) {
            case "seleccionar":
                IAlumnoDatos alumno = new AlumnoDatos();
                List<AlumnoEntidad> alumnos = new ArrayList<>();
                try {
                    alumnos = alumno.seleccionar();
                }
                catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
                
                // Calcular Promedio y Desviación Estándar de clase Estadística
                Estadistica estadistica = new Estadistica(alumnos);
                double promedioGeneral = estadistica.getMedia();
                double desviacionEstandarGeneral = estadistica.getDesviacionEstandar();
                
                // Compartir las variables con el JSP
                request.setAttribute("promedioGeneral", promedioGeneral);
                request.setAttribute("desviacionEstandarGeneral", desviacionEstandarGeneral);
                
                // Compartimos la información obtenida
                request.setAttribute("alumnos", alumnos);

                // Hacemos un forward a la vista. alumnos.jsp debe ir en Web Pages
                request.getRequestDispatcher("alumnos.jsp").forward(request, response);
                break;

            default:
                throw new AssertionError();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // TEST
        /*PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<body>");
        out.print("servlet Alumno doPost()");
        out.print("<body>");
        out.print("<html>"); */
    }
}
