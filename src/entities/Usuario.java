/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gonzalo
 */
@XmlRootElement(name = "usuario")
public class Usuario implements Serializable {

    private String dni;

    private String nombreAcceso;

    private String contraseña;

    private String nombre;

    private String apellido;

    private String email;
    private Date fechaNac;
    private Tipo tipo;

    /**
     *
     */
    public Usuario() {
        super();
    }

    /**
     *
     * @param dni
     * @param nombreAcceso
     * @param contraseña
     * @param nombre
     * @param apellido
     * @param email
     * @param fechaNac
     * @param tipo
     */
    public Usuario(String dni, String nombreAcceso, String contraseña, String nombre, String apellido, String email, Date fechaNac, Tipo tipo) {
        this.dni = dni;
        this.nombreAcceso = nombreAcceso;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNac = fechaNac;
        this.tipo = tipo;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "dni")
    public String getDni() {
        return dni;
    }

    /**
     *
     * @param dni
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "nombreAcceso")
    public String getNombreAcceso() {
        return nombreAcceso;
    }

    /**
     *
     * @param nombreAcceso
     */
    public void setNombreAcceso(String nombreAcceso) {
        this.nombreAcceso = nombreAcceso;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "contrasenia")
    public String getContraseña() {
        return contraseña;
    }

    /**
     *
     * @param contraseña
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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
    @XmlElement(name = "apellido")

    public String getApellido() {
        return apellido;
    }

    /**
     *
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "email")
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "fechaNac")
    public Date getFechaNac() {
        return fechaNac;
    }

    /**
     *
     * @param fechaNac
     */
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    /**
     *
     * @return
     */
    @XmlElement(name = "tipo")

    public Tipo getTipo() {
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.NewEntity[ id=" + dni + " ]";
    }

}
