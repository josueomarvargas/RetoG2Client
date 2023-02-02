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
public enum Objetivo {

    /**
     *
     */
    SUBIR_PESO,

    /**
     *
     */
    BAJAR_PESO;

    /**
     *
     * @param text
     * @return
     */
    public static Objetivo parse(String text) {
        if(SUBIR_PESO.name().equals(text)){
            return SUBIR_PESO;
        }
        return BAJAR_PESO;
    }

}



