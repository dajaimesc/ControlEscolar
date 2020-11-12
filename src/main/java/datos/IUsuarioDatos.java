/*
 * UNIVERSIDAD AUTONOMA DE CAMPECHE
 * PROGRAMACION DE APLICACIONES WEB
 * 2020
 */
package datos;

import domain.UsuarioEntidad;
import java.sql.SQLException;

/**
 *
 * @author dajaimes
 */
public interface IUsuarioDatos {

    public UsuarioEntidad buscar(UsuarioEntidad usuario) throws SQLException;

}
