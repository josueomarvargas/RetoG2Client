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

    /**
     *
     */
    public Receta() {
        super();
    }

    /**
     *
     * @return
     */
    public String getIdReceta() {
        return idReceta;
    }

    /**
     *
     * @param idReceta
     */
    public void setIdReceta(String idReceta) {
        this.idReceta = idReceta;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getPreparacion() {
        return preparacion;
    }

    /**
     *
     * @param preparacion
     */
    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    /**
     *
     * @return
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     *
     * @param fechaCreacion
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     *
     * @return
     */
    public Collection<AlimentoReceta> getListaAlimentoReceta() {
        return listaAlimentoReceta;
    }

    /**
     *
     * @param listaAlimentoReceta
     */
    public void setListaAlimento(Collection<AlimentoReceta> listaAlimentoReceta) {
        this.listaAlimentoReceta = listaAlimentoReceta;
    }

    /**
     *
     * @return
     */
    public TipoDieta getTIPO() {
        return TIPO;
    }

    /**
     *
     * @param TIPO
     */
    public void setTIPO(TipoDieta TIPO) {
        this.TIPO = TIPO;
    }

    /**
     *
     * @return
     */
    public Collection<Dieta> getListaDieta() {
        return listaDieta;
    }

    /**
     *
     * @param listaDieta
     */
    public void setListaDieta(Collection<Dieta> listaDieta) {
        this.listaDieta = listaDieta;
    }

    /**
     *
     * @return
     */
    public Dietista getDietista() {
        return dietista;
    }

    /**
     *
     * @param dietista
     */
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
