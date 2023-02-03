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
public class CrearAlimentoException extends Exception {

    /**
     * Creates a new instance of <code>CrearAlimentoException</code> without
     * detail message.
     */
    public CrearAlimentoException() {
    }

    /**
     * Constructs an instance of <code>CrearAlimentoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CrearAlimentoException(String msg) {
        super(msg);
    }
}
