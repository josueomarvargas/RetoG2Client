/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Gonzalo
 */
public class CrearDietaNoNombreException extends Exception{
    /**
     * Creates a new instance of <code>CrearDietaNoNombreException</code> without detail
     * message.
     */
    public CrearDietaNoNombreException() {
    }

    /**
     * Constructs an instance of <code>CrearDietaNoNombreException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public CrearDietaNoNombreException(String msg) {
        super(msg);
    }
}
