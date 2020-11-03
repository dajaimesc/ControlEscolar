/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.AlumnoEntidad;
import java.sql.SQLException;
import java.util.List;

/**
 * Interface para la entidad alumnos
 * 
 * @author dajaimes
 */
public interface IAlumnoDatos {
    public List<AlumnoEntidad> seleccionar() throws SQLException;
    public void insertar(AlumnoEntidad alumno) throws SQLException;
    public void borrar(AlumnoEntidad alumno) throws SQLException;
    public void actualizar(AlumnoEntidad alumno) throws SQLException;
}
