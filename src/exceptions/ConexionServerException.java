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
public class ConexionServerException extends Exception {

    /**
     * Creates a new instance of <code>ConexionServerException</code> without
     * detail message.
     */
    public ConexionServerException() {
    }

    /**
     * Constructs an instance of <code>ConexionServerException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ConexionServerException(String msg) {
        super(msg);
    }
}
