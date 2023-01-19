/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


import java.util.Collection;
import java.util.Date;



/**
 *
 * @author Gonzalo
 */

public class Dietista extends Usuario {

    // atributos

    private Date fechaAlta;

    /**
     * @associates <{g2.Cliente}>
     */
    private Collection<Cliente> listaClientes;

    /**
     * @associates <{g2.Dieta}>
     */
    private Collection<Dieta> listaDietas;

    /**
     * @associates <{g2.Receta}>
     */
    private Collection<Receta> listaRecetas;

    /**
     * @associates <{g2.Alimento}>
     */
    private Collection<Alimento> listaAlimentos;
    
    private Administrador administrador;
//Getters and Setters 

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Collection<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(Collection<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Collection<Dieta> getListaDietas() {
        return listaDietas;
    }

    public void setListaDietas(Collection<Dieta> listaDietas) {
        this.listaDietas = listaDietas;
    }

    public Collection<Receta> getListaRecetas() {
        return listaRecetas;
    }

    public void setListaRecetas(Collection<Receta> listaRecetas) {
        this.listaRecetas = listaRecetas;
    }

    public Collection<Alimento> getListaAlimentos() {
        return listaAlimentos;
    }

    public void setListaAlimentos(Collection<Alimento> listaAlimentos) {
        this.listaAlimentos = listaAlimentos;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Dietista() {
        super();
    }
}
