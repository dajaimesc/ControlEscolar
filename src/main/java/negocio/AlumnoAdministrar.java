/*
 * UNIVERSIDAD AUTONOMA DE CAMPECHE
 * PROGRAMACION DE APLICACIONES WEB
 * 2020
 */
package negocio;

import datos.AlumnoDatos;
import datos.IAlumnoDatos;
import domain.AlumnoEntidad;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementación de la Interface de Alumnos
 * 
 * @author dajaimes
 */
public class AlumnoAdministrar implements IAlumnoAdministrar{

    // Definir el objeto alumno
    private final IAlumnoDatos alumno;

    public AlumnoAdministrar() {
        this.alumno = new AlumnoDatos();
    }

    @Override
    public void seleccionarAlumnno(AlumnoEntidad alumno) { //Listar
        List<AlumnoEntidad> alumnos = null;
        try {
            alumnos = this.alumno.seleccionar();
        }
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        for (AlumnoEntidad alumnotmp : alumnos) {
            System.out.println("alumnotmp = " + alumnotmp);
        }
    }

    @Override
    public void buscarAlumnno(AlumnoEntidad alumno) {
        try {
            this.alumno.buscar(alumno);
        }
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        System.out.println("alumno = " + alumno);
    }

    @Override
    public void agregarAlumno(AlumnoEntidad alumno) {
        try {
            this.alumno.insertar(alumno);
        }
        catch (SQLException ex) {
            ex.printStackTrace(System.out); // Enviar la excepción a la consiola
        }
    }

    @Override
    public void eliminarAlumno(AlumnoEntidad alumno) {
    }

    @Override
    public void actualizarAlumno(AlumnoEntidad alumno) {
    }
    
}
