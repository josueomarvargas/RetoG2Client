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
     * @associates <{uml.Dietista}>
     */
    private Dietista dietista;

    /**
     * @associates <{uml.Receta}>
     */
    private Collection<Receta> listaReceta;
    private TipoDieta tipo;

    /**
     * @associates <{uml.ClienteDieta}>
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
     * @param idDieta
     * @param nombre
     * @param tiempo
     * @param OBJETIVO
     * @param dietista
     * @param listaReceta
     * @param tipo
     * @param listaCliente
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
     * @return
     */
    @XmlElement(name = "idDieta")
    public String getIdDieta() {
        return idDieta;
    }

    /**
     *
     * @param idDieta
     */
    public void setIdDieta(String idDieta) {
        this.idDieta = idDieta;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "nombre")
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
    @XmlElement(name = "tiempo")
    public Integer getTiempo() {
        return tiempo;
    }

    /**
     *
     * @param tiempo
     */
    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "objetivo")
    public Objetivo getObjetivo() {
        return OBJETIVO;
    }

    /**
     *
     * @param OBJETIVO
     */
    public void setOBJETIVO(Objetivo OBJETIVO) {
        this.OBJETIVO = OBJETIVO;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "listaReceta")
    public Collection<Receta> getListaReceta() {
        return listaReceta;
    }

    /**
     *
     * @param listaReceta
     */
    public void setListaReceta(Collection<Receta> listaReceta) {
        this.listaReceta = listaReceta;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "tipo")
    public TipoDieta getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(TipoDieta tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "listaCliente")
    public Collection<ClienteDieta> getListaCliente() {
        return listaCliente;
    }

    /**
     *
     * @param listaCliente
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
     *
     * @param id
     * @return
     */
    public String id(String id) {
        String[] separarid = id.split("-");
        Integer id2 = Integer.parseInt(separarid[1]);
        id2++;
        id = separarid[0] + "-" + id2.toString();
        return id;
    }

}