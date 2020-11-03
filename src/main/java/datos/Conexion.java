/*
 * UNIVERSIDAD AUTONOMA DE CAMPECHE
 * PROGRAMACION DE APLICACIONES WEB
 * 2020
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase para conexión a base de datos
 * 
 * @author dajaimes
 */

public class Conexion {

    // (1) atributos
    private static final String URL = "jdbc:mysql://localhost:3306/"
            + "controlescolar?"
            + "useSSL=false"
            + "&useTimezone=true"
            + "&serverTimezone=UTC"
            + "&allowPublickeyRetrieval=true";

    private static final String USUARIO = "admince";
    private static final String PASSWORD = "Admince_2103";

    // (2) Método de conexión
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }

    // (3) Método para cerrar objetos, sobrecargados.
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }

    public static void close(Connection conn) throws SQLException{
        conn.close();
    }

    public static void close(Statement stmt) throws SQLException{
        stmt.close();
    }
}