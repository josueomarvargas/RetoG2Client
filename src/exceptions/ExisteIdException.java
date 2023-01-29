/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author josue
 */
public class ExisteIdException extends Exception {

    /**
     * Creates a new instance of <code>ExisteIdException</code> without detail
     * message.
     */
    public ExisteIdException() {
    }

    /**
     * Constructs an instance of <code>ExisteIdException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExisteIdException(String msg) {
        super(msg);
    }
}
