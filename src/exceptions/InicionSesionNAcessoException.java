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
public class InicionSesionNAcessoException extends Exception {

    /**
     * Creates a new instance of <code>InicionSesionNAcessoException</code>
     * without detail message.
     */
    public InicionSesionNAcessoException() {
    }

    /**
     * Constructs an instance of <code>InicionSesionNAcessoException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public InicionSesionNAcessoException(String msg) {
        super(msg);
    }
}
