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
 * Alumno
 * 
 * @author dajaimes
 */
@WebServlet("/ServletAlumno")
public class ServletAlumno extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{              
        IAlumnoDatos alumno = new AlumnoDatos();

        List<AlumnoEntidad> alumnos =  new ArrayList<>();
        
        try {
            alumnos =  alumno.seleccionar();
        }
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        // Compartimos la información obtenida
        request.setAttribute("alumnos", alumnos);
        
        // Hacemos un forward a la vista.
        request.getRequestDispatcher("alumnos.jsp").forward(request, response);

    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{              
        IAlumnoDatos alumno = new AlumnoDatos();

        List<AlumnoEntidad> alumnos =  new ArrayList<>();
        
        try {
            alumnos =  alumno.seleccionar();
        }
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        // Compartimos la información obtenida
        request.setAttribute("alumnos", alumnos);
        
        // Hacemos un forward a la vista.
        request.getRequestDispatcher("alumnos.jsp").forward(request, response);

    }
}
