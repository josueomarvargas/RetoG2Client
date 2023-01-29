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
public class AlimentoInterfaceException extends Exception {

    /**
     * Creates a new instance of <code>AlimentoInterfaceException</code> without
     * detail message.
     */
    public AlimentoInterfaceException() {
    }

    /**
     * Constructs an instance of <code>AlimentoInterfaceException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public AlimentoInterfaceException(String msg) {
        super(msg);
    }
}
