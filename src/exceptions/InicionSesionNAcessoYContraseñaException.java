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
public class InicionSesionNAcessoYContraseñaException extends Exception {

    /**
     * Creates a new instance of
     * <code>InicionSesionNAcessoYContraseñaException</code> without detail
     * message.
     */
    public InicionSesionNAcessoYContraseñaException() {
    }

    /**
     * Constructs an instance of
     * <code>InicionSesionNAcessoYContraseñaException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public InicionSesionNAcessoYContraseñaException(String msg) {
        super(msg);
    }
}
