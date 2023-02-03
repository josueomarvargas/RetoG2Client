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
     * associates {g2.AlimentoReceta}
     */
    private Collection<AlimentoReceta> listaAlimentoReceta;

    /**
     * associates {g2.Dieta}
     */
    private Collection<Dieta> listaDieta;

    /**
     * associates {uml.Dietista}
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
     * @return String
     */
    public String getIdReceta() {
        return idReceta;
    }

    /**
     *
     * @param idReceta String
     */
    public void setIdReceta(String idReceta) {
        this.idReceta = idReceta;
    }

    /**
     *
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre String
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return String
     */
    public String getPreparacion() {
        return preparacion;
    }

    /**
     *
     * @param preparacion String
     */
    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    /**
     *
     * @return Date
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     *
     * @param fechaCreacion Date
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     *
     * @return Collection
     */
    public Collection<AlimentoReceta> getListaAlimentoReceta() {
        return listaAlimentoReceta;
    }

    /**
     *
     * @param listaAlimentoReceta Collection
     */
    public void setListaAlimento(Collection<AlimentoReceta> listaAlimentoReceta) {
        this.listaAlimentoReceta = listaAlimentoReceta;
    }

    /**
     *
     * @return TipoDieta
     */
    public TipoDieta getTIPO() {
        return TIPO;
    }

    /**
     *
     * @param TIPO TipoDieta
     */
    public void setTIPO(TipoDieta TIPO) {
        this.TIPO = TIPO;
    }

    /**
     *
     * @return Collection
     */
    public Collection<Dieta> getListaDieta() {
        return listaDieta;
    }

    /**
     *
     * @param listaDieta Collection
     */
    public void setListaDieta(Collection<Dieta> listaDieta) {
        this.listaDieta = listaDieta;
    }

    /**
     *
     * @return Dietista
     */
    public Dietista getDietista() {
        return dietista;
    }

    /**
     *
     * @param dietista Dietista
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
