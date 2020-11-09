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
import static java.lang.Integer.parseInt;
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

        try {
            // Listar todos los alumnos
            this.accionDefault(request, response);
        }
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // TEST /*PrintWriter out = response.getWriter(); out.print("<html>");*/
        // Post es para formularios
        String accion = request.getParameter("accion");

        switch (accion) {
            case "agregar": {
                try {
                    this.agregarAlumno(request, response);
                }
                catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }
            break;

            default: {
                try {
                    // Página de inicio de alumnos
                    this.accionDefault(request, response);
                }
                catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }

        }
    }

    // Listar todos los alumnos es la acción default
    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        IAlumnoDatos alumno = new AlumnoDatos();
        List<AlumnoEntidad> alumnos = new ArrayList<>();

        alumnos = alumno.seleccionar();

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
    }

    // Método privado, solo para modular el código
    private void seleccionarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {

    }

// Método privado, solo para modular el código
    private int agregarAlumno(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {

        // Recuperamos los valores del formulario
        AlumnoEntidad alumnoForm = new AlumnoEntidad();
        
        alumnoForm.setNombre(request.getParameter("nombre"));
        alumnoForm.setPaterno(request.getParameter("paterno"));
        alumnoForm.setMaterno(request.getParameter("materno"));
        alumnoForm.setCorreo(request.getParameter("correo"));
        alumnoForm.setSexo(request.getParameter("sexo"));
        alumnoForm.setMatricula(request.getParameter("matricula"));
        
        double promedio = Double.parseDouble(request.getParameter("promedio"));
        alumnoForm.setPromedio(promedio);
        
        int activo = parseInt(request.getParameter("activo"));
        alumnoForm.setActivo(activo);

        // Agregamos el registro a la Base de Datos
        IAlumnoDatos alumnoD = new AlumnoDatos();
        int rows = alumnoD.insertar(alumnoForm);
        System.out.println("rows = " + rows);

        // Ejecutamos nuevamente la acción default para actualizar el cliente.
        this.accionDefault(request, response);

        return rows;
    }
}
