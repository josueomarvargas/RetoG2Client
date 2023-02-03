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
public class ExisteNombreException extends Exception {

    /**
     * Creates a new instance of <code>ExisteNombreException</code> without
     * detail message.
     */
    public ExisteNombreException() {
    }

    /**
     * Constructs an instance of <code>ExisteNombreException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExisteNombreException(String msg) {
        super(msg);
    }
}
