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
public class AlimRecID implements Serializable{
    
    private String idAlim;
    private String idRec;

    /**
     *
     * @return String
     */
    public String getIdAlim() {
        return idAlim;
    }

    /**
     *
     * @param idAlim String
     */
    public void setIdAlim(String idAlim) {
        this.idAlim = idAlim;
    }

    /**
     *
     * @return String
     */
    public String getIdRec() {
        return idRec;
    }

    /**
     *
     * @param idRec String
     */
    public void setIdRec(String idRec) {
        this.idRec = idRec;
    }

    
}
