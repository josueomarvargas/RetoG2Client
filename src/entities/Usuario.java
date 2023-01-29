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

@XmlRootElement(name="usuario")
public class Usuario implements Serializable{
        
    

    private SimpleStringProperty dni;

    private SimpleStringProperty nombreAcceso;

    private SimpleStringProperty contraseña;

    private SimpleStringProperty nombre;

    private SimpleStringProperty apellido;

    private SimpleStringProperty email;
    private Date fechaNac;
    private SimpleObjectProperty<Tipo> tipo;
    

    public Usuario() {
        this.dni= new SimpleStringProperty();
        this.nombreAcceso= new SimpleStringProperty();
        this.contraseña= new SimpleStringProperty();
        this.nombre= new SimpleStringProperty();
        this.apellido= new SimpleStringProperty();
        this.email= new SimpleStringProperty();
        this.tipo= new SimpleObjectProperty<>();
    }

    public Usuario(String nombreAcceso, String contraseña, String nombre, String apellido, String email, Tipo tipo) {
      this.nombreAcceso= new SimpleStringProperty(nombreAcceso);
        this.contraseña= new SimpleStringProperty(contraseña);
        this.nombre= new SimpleStringProperty(nombre);
        this.apellido= new SimpleStringProperty(apellido);
        this.email= new SimpleStringProperty(email);
        this.tipo= new SimpleObjectProperty<>(tipo);
    }
    

    @XmlElement(name="dni")

    public String getDni() {
        return this.dni.get();
    }

    public void setDni(String dni) {
        this.dni.set(dni);
    }
    @XmlElement(name="nombre acesso")

    public String getNombreAcceso() {
        return this.nombreAcceso.get();
    }

    public void setNombreAcceso(String nombreAcceso) {
        this.nombreAcceso.set(nombreAcceso);
    }
    @XmlElement(name="contraseña")

    public String getContraseña() {
        return this.contraseña.get();
    }

    public void setContraseña(String contraseña) {
        this.contraseña.set(contraseña);
    }
    @XmlElement(name="nombre")

    public String getNombre() {
        return this.nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }
    @XmlElement(name="apellido")

    public String getApellido() {
        return this.apellido.get();
    }

    public void setApellido(String apellido) {
        this.apellido.set(apellido);
    }
    @XmlElement(name="email")

    public String getEmail() {
        return this.email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
    @XmlElement(name="fecha Nacimiento")

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }
    @XmlElement(name="tipo")

    public Tipo getTipo() {
        return this.tipo.get();
    }

    public void setTipo(Tipo tipo) {
        this.tipo.set(tipo);
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
