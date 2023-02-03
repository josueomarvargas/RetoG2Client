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
     * associates {g2.Cliente}
     */
    private Collection<Cliente> listaClientes;

    /**
     * associates {g2.Dieta}
     */
    private Collection<Dieta> listaDietas;

    /**
     * associates {g2.Receta}
     */
    private Collection<Receta> listaRecetas;

    /**
     * associates {g2.Alimento}
     */
    private Collection<Alimento> listaAlimentos;
    
    private Administrador administrador;
//Getters and Setters 

    /**
     *
     * @return Date
     */ 
    public Date getFechaAlta() {
        return fechaAlta;
    }

    /**
     *
     * @param fechaAlta Date
     */
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    /**
     *
     * @return Collection
     */
    public Collection<Cliente> getListaClientes() {
        return listaClientes;
    }

    /**
     *
     * @param listaClientes Collection
     */
    public void setListaClientes(Collection<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    /**
     *
     * @return Collection
     */
    public Collection<Dieta> getListaDietas() {
        return listaDietas;
    }

    /**
     *
     * @param listaDietas Collection
     */
    public void setListaDietas(Collection<Dieta> listaDietas) {
        this.listaDietas = listaDietas;
    }

    /**
     *
     * @return Collection
     */
    public Collection<Receta> getListaRecetas() {
        return listaRecetas;
    }

    /**
     *
     * @param listaRecetas Collection
     */
    public void setListaRecetas(Collection<Receta> listaRecetas) {
        this.listaRecetas = listaRecetas;
    }

    /**
     *
     * @return Collection
     */
    public Collection<Alimento> getListaAlimentos() {
        return listaAlimentos;
    }

    /**
     *
     * @param listaAlimentos Collection
     */
    public void setListaAlimentos(Collection<Alimento> listaAlimentos) {
        this.listaAlimentos = listaAlimentos;
    }

    /**
     *
     * @return Administrador
     */
    public Administrador getAdministrador() {
        return administrador;
    }

    /**
     *
     * @param administrador Administrador
     */
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    /**
     *
     */
    public Dietista() {
        super();
    }
}
