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
public class UsuarioNullException extends Exception {

    /**
     * Creates a new instance of <code>UsuarioNullException</code> without
     * detail message.
     */
    public UsuarioNullException() {
    }

    /**
     * Constructs an instance of <code>UsuarioNullException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UsuarioNullException(String msg) {
        super(msg);
    }
}
