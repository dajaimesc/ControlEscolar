/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.AlumnoEntidad;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dajaimes
 */
public class AlumnoDatos implements IAlumnoDatos{
    
// Atributos para los querys
    private static final String SQLSELECT = "SELECT id, activo, promedio,"
            + "nombre, paterno, materno, matricula, correo, sexo "
            + "FROM alumnos";

    private static final String SQLUPDATE = "";
    private static final String SQLDELETE = "";
    private static final String SQLINSERT = "";
    
    @Override
    public List<AlumnoEntidad> seleccionar() throws SQLException {
    
    //  Objetos necesarios para conectar, ejecutar y obtener resultados  
    Connection conn = null;
    Statement stmt = null;         
    ResultSet rs = null;

    // Variable de tipo entidad AlumnoEntidad
    AlumnoEntidad alumno = null;

    // Variable tipo Lista de alumnos
    List<AlumnoEntidad> alumnos =  new ArrayList<>();

    // Conectarnos a la Base de Datos
    conn = Conexion.getConnection();

    // Preparamos la consulta
    stmt = conn.createStatement();

    // Ejecutar la consulta
    rs = stmt.executeQuery(SQLSELECT);

    // Recorremos el RecorSet
    while (rs.next()) {

        // Obtener valores de BD en variables.
        int id = rs.getInt("id");
        int activo = rs.getInt("activo");
        float promedio =  rs.getFloat("promedio");  
        String nombre = rs.getString("nombre");
        String paterno = rs.getString("paterno");
        String materno = rs.getString("materno");
        String matricula = rs.getString("matricula");
        String correo = rs.getString("correo");
        String sexo = rs.getString("sexo");

        //  Crear el objeto alumno
        alumno = new AlumnoEntidad(id, activo, promedio, nombre, paterno, materno, 
                            matricula, correo, sexo);

        // Agregar el alumno a la Lista de alumnos
        alumnos.add(alumno);
    }
    rs.close();
    stmt.close();
    conn.close();
    return alumnos;
    }

    @Override
    public void insertar(AlumnoEntidad alumno) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void borrar(AlumnoEntidad alumno) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void actualizar(AlumnoEntidad alumno) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
