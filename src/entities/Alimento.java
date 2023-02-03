/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.DatePicker;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gonzalo
 */
@XmlRootElement(name = "alimento")
public class Alimento implements Serializable {
//Atributos

    private String idAlimento;
    private TipoAlimento TIPO;
    private String nombre;
    private Float calorias;
    private Float grasasTotales;
    private Float proteinas;
    private Float carbohidratos;
    private Date fechaInsert;

    /**
     * associates {uml.Dietista}
     */
    private SimpleObjectProperty<Dietista> dietista;

    /**
     * associates {g2.AlimentoReceta}
     */
    private Collection<AlimentoReceta> listaAlimentoReceta;
//Constructor

    /**
     *
     */
    public Alimento() {
        super();

    }

    /**
     *
     * @param idAlimento String
     * @param TIPO TipoAlimento
     * @param nombre String
     * @param calorias Float
     * @param grasasTotales Float
     * @param proteinas Float
     * @param carbohidratos Float
     * @param fechaInsert Date
     * @param dietista SimpleObjectProperty
     * @param listaAlimentoReceta Collection
     */
    public Alimento(String idAlimento, TipoAlimento TIPO, String nombre, Float calorias, Float grasasTotales, Float proteinas, Float carbohidratos, Date fechaInsert, SimpleObjectProperty<Dietista> dietista, Collection<AlimentoReceta> listaAlimentoReceta) {
        this.idAlimento = idAlimento;
        this.TIPO = TIPO;
        this.nombre = nombre;
        this.calorias = calorias;
        this.grasasTotales = grasasTotales;
        this.proteinas = proteinas;
        this.carbohidratos = carbohidratos;
        this.fechaInsert = fechaInsert;
        this.dietista = dietista;
        this.listaAlimentoReceta = listaAlimentoReceta;
    }

//Getters y Setters

    /**
     *
     * @return String
     */
    @XmlElement(name = "idAlimento")
    public String getIdAlimento() {
        return idAlimento;
    }

    /**
     *
     * @param idAlimento String
     */
    public void setIdAlimento(String idAlimento) {
        this.idAlimento = idAlimento;
    }

    /**
     *
     * @return TipoAlimento
     */
    @XmlElement(name = "TIPO")

    public TipoAlimento getTIPO() {
        return TIPO;
    }

    /**
     *
     * @param TIPO TipoAlimento
     */
    public void setTIPO(TipoAlimento TIPO) {
        this.TIPO = TIPO;
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
     * @return Float
     */
    @XmlElement(name = "calorias")

    public Float getCalorias() {
        return calorias;
    }

    /**
     *
     * @param calorias Float
     */
    public void setCalorias(Float calorias) {
        this.calorias = calorias;
    }

    /**
     *
     * @return Float
     */
    @XmlElement(name = "grasasTotales")

    public Float getGrasasTotales() {
        return grasasTotales;
    }

    /**
     *
     * @param grasasTotales Float
     */
    public void setGrasasTotales(Float grasasTotales) {
        this.grasasTotales = grasasTotales;
    }

    /**
     *
     * @return Float
     */
    @XmlElement(name = "proteinas")

    public Float getProteinas() {
        return proteinas;
    }

    /**
     *
     * @param proteinas Float
     */
    public void setProteinas(Float proteinas) {
        this.proteinas = proteinas;
    }

    /**
     *
     * @return Float
     */
    @XmlElement(name = "carbohidratos")

    public Float getCarbohidratos() {
        return carbohidratos;
    }

    /**
     *
     * @param carbohidratos Float
     */
    public void setCarbohidratos(Float carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    /**
     *
     * @return Date
     */
    @XmlElement(name = "FechaInsert")
    public Date getFechaInsert() {
        return fechaInsert;
    }

    /**
     *
     * @param fechaInsert Date
     */
    public void setFechaInsert(Date fechaInsert) {
        this.fechaInsert = fechaInsert;
    }

    /**
     *
     * @return SimpleObjectProperty
     */
    @XmlElement(name = "dietista")

    public SimpleObjectProperty<Dietista> getDietista() {
        return dietista;
    }

    /**
     *
     * @param dietista SimpleObjectProperty
     */
    public void setDietista(SimpleObjectProperty<Dietista> dietista) {
        this.dietista = dietista;
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
    public void setListaAlimentoReceta(Collection<AlimentoReceta> listaAlimentoReceta) {
        this.listaAlimentoReceta = listaAlimentoReceta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlimento != null ? idAlimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alimento)) {
            return false;
        }
        Alimento other = (Alimento) object;
        if ((this.idAlimento == null && other.idAlimento != null) || (this.idAlimento != null && !this.idAlimento.equals(other.idAlimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.NewEntity[ id=" + idAlimento + " ]";
    }

}
