/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;

/**
 *
 * @author Gonzalo
 */
public class CltDietID implements Serializable{
    
    private String idClt;
    private String idDiet;

    /**
     * 
     * @return String
     */
    public String getIdClte() {
        return idClt;
    }

    /**
     *
     * @param idClte String
     */
    public void setIdClte(String idClte) {
        this.idClt = idClte;
    }

    /**
     *
     * @return String
     */
    public String getIdDiet() {
        return idDiet;
    }

    /**
     *
     * @param idDiet String
     */
    public void setIdDiet(String idDiet) {
        this.idDiet = idDiet;
    }
    
}
