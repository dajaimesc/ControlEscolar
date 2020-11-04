/*
 * UNIVERSIDAD AUTONOMA DE CAMPECHE
 * PROGRAMACION DE APLICACIONES WEB
 * 2020
 */
package pruebas;

import datos.AlumnoDatos;
import datos.IAlumnoDatos;
import domain.AlumnoEntidad;
import java.sql.SQLException;

/**
 *
 * @author dajaimes
 */
public class AlumnoProbar1 {

    public static void main(String[] args) throws SQLException {
        IAlumnoDatos alumno = new AlumnoDatos();

        // Estos datos vendrán del JSP cliente
        AlumnoEntidad alumnoDeHTML = new AlumnoEntidad();

        // SELECT
         System.out.println(alumno.seleccionar());
        
        // PROBANDO Buscar por ID
        /*
         alumnoDeHTML.setId(3);
         alumno.buscarAlumnno(alumnoDeHTML);
         */
        // INSERT 
        /*
        alumnoDeHTML.setActivo(1);
        alumnoDeHTML.setCorreo("al061620@uacam.mx");
        alumnoDeHTML.setMaterno("ALDANA");
        alumnoDeHTML.setMatricula("61620");
        alumnoDeHTML.setNombre("MIGUEL ADRIÁN");
        alumnoDeHTML.setPaterno("BARBOSA");
        alumnoDeHTML.setPromedio(9.3);
        alumnoDeHTML.setSexo("H");
        
        alumno.agregarAlumno(alumnoDeHTML);
         */
        // DELETE 
        /*
        alumnoDeHTML.setId(3);
        alumno.eliminarAlumno(alumnoDeHTML);
         */
        // UPDATE
        /*
        alumnoDeHTML.setId(4);
        alumnoDeHTML.setActivo(1);
        alumnoDeHTML.setCorreo("al060881@uacam.mx");
        alumnoDeHTML.setMaterno("CANUL");
        alumnoDeHTML.setMatricula("60881");
        alumnoDeHTML.setNombre("JESÚS ABRAHAM");
        alumnoDeHTML.setPaterno("NAVARRETE");
        alumnoDeHTML.setPromedio(8.3);
        alumnoDeHTML.setSexo("H");
        alumno.actualizarAlumno(alumnoDeHTML);
        */
    }
}
