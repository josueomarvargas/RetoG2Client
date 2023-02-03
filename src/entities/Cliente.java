 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


import java.io.Serializable;
import java.util.Collection;
import java.util.Set;


/**
 *
 * @author Gonzalo
 */

public class Cliente extends Usuario {
    
    private Float altura;
    private String genero;
    private Float imc;
    private EstadoFisico ESTADOFISICO;
    private Float peso;

    /**
     * associates {uml.ClienteDieta}
     */
    private Collection<ClienteDieta> listaDieta;

    private Dietista dietista;

    private Administrador administrador;

    /**
     *
     * @return Float
     */
    public Float getAltura() {
        return altura;
    }

    /**
     *
     * @param altura Float
     */
    public void setAltura(Float altura) {
        this.altura = altura;
    }

    /**
     *
     * @return String
     */
    public String getGenero() {
        return genero;
    }

    /**
     *
     * @param genero String
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     *
     * @return Float
     */
    public Float getImc() {
        return imc;
    }

    /**
     *
     * @param imc Float
     */
    public void setImc(Float imc) {
        this.imc = imc;
    }

    /**
     *
     * @return EstadoFisico
     */
    public EstadoFisico getESTADOFISICO() {
        return ESTADOFISICO;
    }

    /**
     *
     * @param ESTADOFISICO EstadoFisico
     */
    public void setESTADOFISICO(EstadoFisico ESTADOFISICO) {
        this.ESTADOFISICO = ESTADOFISICO;
    }

    /**
     *
     * @return Collection
     */
    public Collection<ClienteDieta> getListaDieta() {
        return listaDieta;
    }

    /**
     *
     * @param listaDieta Collection
     */
    public void setListaDieta(Collection<ClienteDieta> listaDieta) {
        this.listaDieta = listaDieta;
    }

    /**
     *
     * @return Dietista
     */
    public Dietista getDietista() {
        return dietista;
    }

    /**
     *
     * @param dietista Dietista
     */
    public void setDietista(Dietista dietista) {
        this.dietista = dietista;
    }

    /**
     *
     * @return Float 
     */
    public Float getPeso() {
        return peso;
    }

    /**
     *
     * @param peso Float
     */
    public void setPeso(Float peso) {
        this.peso = peso;
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
    public Cliente() {
        super();
    }
}
