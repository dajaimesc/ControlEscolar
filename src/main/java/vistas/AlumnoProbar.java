/*
 * UNIVERSIDAD AUTONOMA DE CAMPECHE
 * PROGRAMACION DE APLICACIONES WEB
 * 2020
 */
package vistas;

import domain.AlumnoEntidad;
import negocio.AlumnoAdministrar;
import negocio.IAlumnoAdministrar;

/**
 *
 * @author dajaimes
 */
public class AlumnoProbar {
    public static void main(String[] args) {
        IAlumnoAdministrar alumno = new AlumnoAdministrar();
 
        // PROBANDO Listar alumnos
        // AlumnoEntidad alumnoDeHTML = new AlumnoEntidad();
        // alumno.seleccionarAlumnno(alumnoDeHTML);
        
        // PROBANDO Buscar por ID
        // AlumnoEntidad alumnoDeHTML =  new AlumnoEntidad(); // Simula la captura
        // alumnoDeHTML.setId(3);
        // alumno.buscarAlumnno(alumnoDeHTML);
        
        // PROBANDO Insertar 
        AlumnoEntidad alumnoDeHTML =  new AlumnoEntidad(); 
        
        // Simulamos la captura en HTML del alumno
        alumnoDeHTML.setActivo(1);
        alumnoDeHTML.setCorreo("al061620@uacam.mx");
        alumnoDeHTML.setMaterno("ALDANA");
        alumnoDeHTML.setMatricula("61620");
        alumnoDeHTML.setNombre("MIGUEL ADRIÁN");
        alumnoDeHTML.setPaterno("BARBOSA");
        alumnoDeHTML.setPromedio(9.3);
        alumnoDeHTML.setSexo("H");
        
        alumno.agregarAlumno(alumnoDeHTML);
        
    }
}
