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
public class CrearDietaNoTipoException extends Exception{
    /**
     * Creates a new instance of <code>CrearDietaNoTipoException</code> without detail
     * message.
     */
    public CrearDietaNoTipoException() {
    }

    /**
     * Constructs an instance of <code>CrearDietaNoTipoException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public CrearDietaNoTipoException(String msg) {
        super(msg);
    }
}
