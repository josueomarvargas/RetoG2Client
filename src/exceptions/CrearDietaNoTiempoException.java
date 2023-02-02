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
public class CrearDietaNoTiempoException extends Exception{
    /**
     * Creates a new instance of <code>CrearDietaNoTiempoException</code> without detail
     * message.
     */
    public CrearDietaNoTiempoException() {
    }

    /**
     * Constructs an instance of <code>CrearDietaNoTiempoException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public CrearDietaNoTiempoException(String msg) {
        super(msg);
    }
}
