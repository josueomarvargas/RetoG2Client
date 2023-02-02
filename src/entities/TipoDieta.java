/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Gonzalo
 */
public enum TipoDieta {

    /**
     *
     */
    VEGETARIANA,

    /**
     *
     */
    VEGANA,

    /**
     *
     */
    OMNIVORO;

    /**
     *
     * @param text
     * @return
     */
    public static TipoDieta parse(String text) {
        TipoDieta tip = null;
        if(VEGETARIANA.name().equals(text)){
            tip = VEGETARIANA;
        } else if (VEGANA.name().equals(text)){
            tip = VEGANA;
        } else if(OMNIVORO.name().equals(text)){
            tip = OMNIVORO;
        }
        return tip;
}
}
