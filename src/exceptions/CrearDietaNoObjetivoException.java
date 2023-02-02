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
public class CrearDietaNoObjetivoException extends Exception{
    /**
     * Creates a new instance of <code>CrearDietaNoObjetivoException</code> without detail
     * message.
     */
    public CrearDietaNoObjetivoException() {
    }

    /**
     * Constructs an instance of <code>CrearDietaNoObjetivoException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public CrearDietaNoObjetivoException(String msg) {
        super(msg);
    }
}
