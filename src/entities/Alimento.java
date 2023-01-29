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
     * @associates <{uml.Dietista}>
     */
    private SimpleObjectProperty<Dietista> dietista;

    /**
     * @associates <{g2.AlimentoReceta}>
     */
    private Collection<AlimentoReceta> listaAlimentoReceta;
//Constructor

    /**
     *
     */
    public Alimento() {
        super();

    }

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
    @XmlElement(name = "idAlimento")
    public String getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(String idAlimento) {
        this.idAlimento = idAlimento;
    }


    @XmlElement(name = "TIPO")

    public TipoAlimento getTIPO() {
        return TIPO;
    }



    public void setTIPO(TipoAlimento TIPO) {
        this.TIPO = TIPO;
    }

    @XmlElement(name = "nombre")

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement(name = "calorias")

    public Float getCalorias() {
        return calorias;
    }

    public void setCalorias(Float calorias) {
        this.calorias = calorias;
    }

    @XmlElement(name = "grasasTotales")

    public Float getGrasasTotales() {
        return grasasTotales;
    }

    public void setGrasasTotales(Float grasasTotales) {
        this.grasasTotales = grasasTotales;
    }

    @XmlElement(name = "proteinas")

    public Float getProteinas() {
        return proteinas;
    }

    public void setProteinas(Float proteinas) {
        this.proteinas = proteinas;
    }

    @XmlElement(name = "carbohidratos")

    public Float getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(Float carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    @XmlElement(name = "FechaInsert")
    public Date getFechaInsert() {
        return fechaInsert;
    }

    public void setFechaInsert(Date fechaInsert) {
        this.fechaInsert = fechaInsert;
    }

    @XmlElement(name = "dietista")

    public SimpleObjectProperty<Dietista> getDietista() {
        return dietista;
    }

    public void setDietista(SimpleObjectProperty<Dietista> dietista) {
        this.dietista = dietista;
    }

    public Collection<AlimentoReceta> getListaAlimentoReceta() {
        return listaAlimentoReceta;
    }

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
