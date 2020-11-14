/*
 * UNIVERSIDAD AUTONÓMA DE CAMPECHE
 * PROGRAMACIÓN DE APLICACIONES WEB
 * 2020
 */
package datos;

import domain.UsuarioEntidad;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dajaimes
 */
public class UsuarioDatos implements IUsuarioDatos {

    private static final String SQLSELECTPORID = "SELECT id, login, password,"
            + "nombre, paterno, materno, sexo, correo, codigo, activo, perfil, alta "
            + "FROM usuarios WHERE login = ? and password = ?";

    @Override
    public UsuarioEntidad buscar(UsuarioEntidad usuario) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQLSELECTPORID);

            // Sustituimos las incógnitas de la cadena SQLSELECTPORID
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getPassword());
            
            rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String login = rs.getString("login");
                String password = rs.getString("password");
                String nombre = rs.getString("nombre");
                String paterno = rs.getString("paterno");
                String materno = rs.getString("materno");
                String sexo = rs.getString("sexo");
                String correo = rs.getString("correo");
                String codigo = rs.getString("codigo");
                int activo = rs.getInt("activo");
                int perfil = rs.getInt("perfil");
                Date alta = rs.getDate("alta");

                //  Usar el objeto alumno del parámetro para devolver valores
                usuario.setId(id);
                usuario.setLogin(login);
                usuario.setPassword(password);
                usuario.setNombre(nombre);
                usuario.setPaterno(paterno);
                usuario.setMaterno(materno);
                usuario.setSexo(sexo);
                usuario.setCorreo(correo);
                usuario.setCodigo(codigo);
                usuario.setActivo(activo);
                usuario.setPerfil(perfil);
                usuario.setAlta(alta);
            }
        }
        catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally {
            rs.close();
            stmt.close();
            conn.close();
        }
        return usuario;
    }
}
