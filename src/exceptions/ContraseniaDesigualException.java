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
public class ContraseniaDesigualException extends Exception {

    /**
     * Creates a new instance of <code>ContraseniaDesigualException</code>
     * without detail message.
     */
    public ContraseniaDesigualException() {
    }

    /**
     * Constructs an instance of <code>ContraseniaDesigualException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ContraseniaDesigualException(String msg) {
        super(msg);
    }
}
