/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gonzalo
 */
@XmlRootElement(name = "dieta")
public class Dieta implements Serializable {

    private String idDieta;
    private String nombre;
    private Integer tiempo;
    private Objetivo OBJETIVO;

    /**
     * associates {uml.Dietista}
     */
    private Dietista dietista;

    /**
     * associates {uml.Receta}
     */
    private Collection<Receta> listaReceta;
    private TipoDieta tipo;

    /**
     * associates {uml.ClienteDieta}
     */
    private Collection<ClienteDieta> listaCliente;

    /**
     *
     */
    public Dieta() {
        super();
    }

    /**
     *
     * @param idDieta String
     * @param nombre String
     * @param tiempo Integer
     * @param OBJETIVO Objetivo
     * @param dietista Dietista
     * @param listaReceta Collection
     * @param tipo TipoDieta
     * @param listaCliente Collection
     */
    public Dieta(String idDieta, String nombre, Integer tiempo, Objetivo OBJETIVO, Dietista dietista, Collection<Receta> listaReceta, TipoDieta tipo, Collection<ClienteDieta> listaCliente) {
        this.idDieta = idDieta;
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.OBJETIVO = OBJETIVO;
        this.dietista = dietista;
        this.listaReceta = listaReceta;
        this.tipo = tipo;
        this.listaCliente = listaCliente;
    }

    /**
     *
     * @return String
     */
    @XmlElement(name = "idDieta")
    public String getIdDieta() {
        return idDieta;
    }

    /**
     *
     * @param idDieta String
     */
    public void setIdDieta(String idDieta) {
        this.idDieta = idDieta;
    }

    /**
     *
     * @return String
     */
    @XmlElement(name = "nombre")
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
     * @return Integer
     */
    @XmlElement(name = "tiempo")
    public Integer getTiempo() {
        return tiempo;
    }

    /**
     *
     * @param tiempo Integer
     */
    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    /**
     *
     * @return Objetivo
     */
    @XmlElement(name = "objetivo")
    public Objetivo getObjetivo() {
        return OBJETIVO;
    }

    /**
     *
     * @param OBJETIVO Objetivo
     */
    public void setOBJETIVO(Objetivo OBJETIVO) {
        this.OBJETIVO = OBJETIVO;
    }

    /**
     *
     * @return Collection
     */
    @XmlElement(name = "listaReceta")
    public Collection<Receta> getListaReceta() {
        return listaReceta;
    }

    /**
     *
     * @param listaReceta Collection
     */
    public void setListaReceta(Collection<Receta> listaReceta) {
        this.listaReceta = listaReceta;
    }

    /**
     *
     * @return TipoDieta
     */
    @XmlElement(name = "tipo")
    public TipoDieta getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo TipoDieta
     */
    public void setTipo(TipoDieta tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return Collection
     */
    @XmlElement(name = "listaCliente")
    public Collection<ClienteDieta> getListaCliente() {
        return listaCliente;
    }

    /**
     *
     * @param listaCliente Collection
     */
    public void setListaCliente(Collection<ClienteDieta> listaCliente) {
        this.listaCliente = listaCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDieta != null ? idDieta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dieta)) {
            return false;
        }
        Dieta other = (Dieta) object;
        if ((this.idDieta == null && other.idDieta != null) || (this.idDieta != null && !this.idDieta.equals(other.idDieta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.NewEntity[ id=" + idDieta + " ]";
    }

    /**
     * Genera la id  en funcion de la enviada
     * @param id id de la Dieta
     * @return String
     */
    public String id(String id) {
        String[] separarid = id.split("-");
        Integer id2 = Integer.parseInt(separarid[1]);
        id2++;
        id = separarid[0] + "-" + id2.toString();
        return id;
    }

}