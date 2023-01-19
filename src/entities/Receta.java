/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Jon
 */
public class Receta implements Serializable {

    private String idReceta;
    private String nombre;
    private String preparacion;
    private Date fechaCreacion;
    private TipoDieta TIPO;

    /**
     * @associates <{g2.AlimentoReceta}>
     */
    private Collection<AlimentoReceta> listaAlimentoReceta;

    /**
     * @associates <{g2.Dieta}>
     */
    private Collection<Dieta> listaDieta;

    /**
     * @associates <{uml.Dietista}>
     */
    private Dietista dietista;

    public Receta() {
        super();
    }

    public String getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(String idReceta) {
        this.idReceta = idReceta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Collection<AlimentoReceta> getListaAlimentoReceta() {
        return listaAlimentoReceta;
    }

    public void setListaAlimento(Collection<AlimentoReceta> listaAlimentoReceta) {
        this.listaAlimentoReceta = listaAlimentoReceta;
    }

    public TipoDieta getTIPO() {
        return TIPO;
    }

    public void setTIPO(TipoDieta TIPO) {
        this.TIPO = TIPO;
    }

    public Collection<Dieta> getListaDieta() {
        return listaDieta;
    }

    public void setListaDieta(Collection<Dieta> listaDieta) {
        this.listaDieta = listaDieta;
    }

    public Dietista getDietista() {
        return dietista;
    }

    public void setDietista(Dietista dietista) {
        this.dietista = dietista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReceta != null ? idReceta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receta)) {
            return false;
        }
        Receta other = (Receta) object;
        if ((this.idReceta == null && other.idReceta != null) || (this.idReceta != null && !this.idReceta.equals(other.idReceta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.NewEntity[ id=" + idReceta + " ]";
    }
}
