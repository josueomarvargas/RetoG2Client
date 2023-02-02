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
public class ExisteEmailException extends Exception {

    /**
     * Creates a new instance of <code>ExisteEmail</code> without detail
     * message.
     */
    public ExisteEmailException() {
    }

    /**
     * Constructs an instance of <code>ExisteEmail</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ExisteEmailException(String msg) {
        super(msg);
    }
}
