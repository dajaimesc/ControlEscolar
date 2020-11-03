/*
 * UNIVERSIDAD AUTONOMA DE CAMPECHE
 * PROGRAMACION DE APLICACIONES WEB
 * 2020
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
