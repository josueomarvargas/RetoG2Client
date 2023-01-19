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

public class AlimentoReceta implements Serializable{
    //Atributos
    private AlimRecID idAlimentoReceta;

    private Receta receta;
    private Alimento alimento;
    private Integer cantidad;    
//Constructor
    public AlimentoReceta() {
        super();
    }
//Getters y Setters
    public AlimRecID getIdAlimentoReceta() {
        return idAlimentoReceta;
    }

    public void setIdAlimentoReceta(AlimRecID idAlimentoReceta) {
        this.idAlimentoReceta = idAlimentoReceta;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlimentoReceta != null ? idAlimentoReceta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlimentoReceta)) {
            return false;
        }
        AlimentoReceta other = (AlimentoReceta) object;
        if ((this.idAlimentoReceta == null && other.idAlimentoReceta != null) || (this.idAlimentoReceta != null && !this.idAlimentoReceta.equals(other.idAlimentoReceta))) {
            return false;
        }
        return true;
    }
}
