/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Gonzalo
 */
public class SoloNumerosException extends Exception{
     /**
     * Creates a new instance of <code>FiltroDietaException</code> without detail
     * message.
     */
    public SoloNumerosException() {
    }

    /**
     * Constructs an instance of <code>FiltroDietaException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public SoloNumerosException(String msg) {
        super(msg);
    }
}
