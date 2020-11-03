/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.palmartec.controlescolar.excepciones;

/**
 * Clase madre para el manejo de excepciones
 * 
 * @author dajaimes
 * 
 */
public class AccesoDatosExcepcion extends Exception {

    public AccesoDatosExcepcion(String mensaje) {
        super(mensaje);
    }
    
}
