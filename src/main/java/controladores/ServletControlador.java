/*
 * UNIVERSIDAD AUTONOMA DE CAMPECHE
 * PROGRAMACION DE APLICACIONES WEB
 * 2020
 */
package controladores;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Front Controller de MVC
 * 
 * @author dajaimes
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        
    }
}
