/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author Gonzalo
 */
public class ClienteDieta implements Serializable {
    private CltDietID idClienteDieta;

    private Dieta dieta;

    private Cliente cliente;

    private Date fechaInicio;

    private Date fechaFinal;
    
    
    public ClienteDieta() {
        super();
    }

    public CltDietID getIdClienteDieta() {
        return idClienteDieta;
    }

    public void setIdClienteDieta(CltDietID idClienteDieta) {
        this.idClienteDieta = idClienteDieta;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }   
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClienteDieta != null ? idClienteDieta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteDieta)) {
            return false;
        }
        ClienteDieta other = (ClienteDieta) object;
        if ((this.idClienteDieta == null && other.idClienteDieta != null) || (this.idClienteDieta != null && !this.idClienteDieta.equals(other.idClienteDieta))) {
            return false;
        }
        return true;
    }
    
}
