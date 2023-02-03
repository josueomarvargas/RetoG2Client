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
public class UsuarioInterfaceException extends Exception {

    /**
     * Creates a new instance of <code>UsuarioInterfaceException</code> without
     * detail message.
     */
    public UsuarioInterfaceException() {
    }

    /**
     * Constructs an instance of <code>UsuarioInterfaceException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UsuarioInterfaceException(String msg) {
        super(msg);
    }
}
