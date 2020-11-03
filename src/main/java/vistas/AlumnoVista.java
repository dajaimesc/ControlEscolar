/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
