/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import domain.AlumnoEntidad;

/**
 * Capa de alumnos para la lógica el negocio
 * Aquí van los métodos que utiliza el usuario final
 * 
 * @author dajaimes
 */
public interface IAlumnoAdministrar {
    
    void seleccionarAlumnno(AlumnoEntidad alumno);
    void agregarAlumno(AlumnoEntidad alumno);
    void eliminarAlumno(AlumnoEntidad alumno);
    void actualizarAlumno(AlumnoEntidad alumno);
}
