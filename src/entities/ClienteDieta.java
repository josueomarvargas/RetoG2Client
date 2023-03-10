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
    
    /**
     *
     */
    public ClienteDieta() {
        super();
    }

    /**
     *
     * @return CltDietID
     */
    public CltDietID getIdClienteDieta() {
        return idClienteDieta;
    }

    /**
     *
     * @param idClienteDieta CltDietID
     */
    public void setIdClienteDieta(CltDietID idClienteDieta) {
        this.idClienteDieta = idClienteDieta;
    }

    /**
     *
     * @return Dieta
     */
    public Dieta getDieta() {
        return dieta;
    }

    /**
     *
     * @param dieta Dieta
     */
    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    /**
     *
     * @return Cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     *
     * @param cliente Cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     *
     * @return Date
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     *
     * @param fechaInicio Date
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     *
     * @return Date
     */
    public Date getFechaFinal() {
        return fechaFinal;
    }

    /**
     *
     * @param fechaFinal Date
     */
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
