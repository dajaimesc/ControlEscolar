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
 * Capa de presentacion 
 * Capa vista en el patrón de diseño MVC
 * 
 * @author dajaimes
 */
public class AlumnoVista {
    public static void main(String[] args) {
        IAlumnoAdministrar alumno = new AlumnoAdministrar();
        
        // Crear el objeto que vendrá del cliente en el modelo MVC
        AlumnoEntidad alumnoweb = new AlumnoEntidad();
        
        // Listar alumnos
        alumno.seleccionarAlumnno(alumnoweb);
        
    }
    
}
