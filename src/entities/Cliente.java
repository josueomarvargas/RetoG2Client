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
     * @associates <{uml.ClienteDieta}>
     */
    private Collection<ClienteDieta> listaDieta;

    private Dietista dietista;

    private Administrador administrador;

    /**
     *
     * @return
     */
    public Float getAltura() {
        return altura;
    }

    /**
     *
     * @param altura
     */
    public void setAltura(Float altura) {
        this.altura = altura;
    }

    /**
     *
     * @return
     */
    public String getGenero() {
        return genero;
    }

    /**
     *
     * @param genero
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     *
     * @return
     */
    public Float getImc() {
        return imc;
    }

    /**
     *
     * @param imc
     */
    public void setImc(Float imc) {
        this.imc = imc;
    }

    /**
     *
     * @return
     */
    public EstadoFisico getESTADOFISICO() {
        return ESTADOFISICO;
    }

    /**
     *
     * @param ESTADOFISICO
     */
    public void setESTADOFISICO(EstadoFisico ESTADOFISICO) {
        this.ESTADOFISICO = ESTADOFISICO;
    }

    /**
     *
     * @return
     */
    public Collection<ClienteDieta> getListaDieta() {
        return listaDieta;
    }

    /**
     *
     * @param listaDieta
     */
    public void setListaDieta(Collection<ClienteDieta> listaDieta) {
        this.listaDieta = listaDieta;
    }

    /**
     *
     * @return
     */
    public Dietista getDietista() {
        return dietista;
    }

    /**
     *
     * @param dietista
     */
    public void setDietista(Dietista dietista) {
        this.dietista = dietista;
    }

    /**
     *
     * @return
     */
    public Float getPeso() {
        return peso;
    }

    /**
     *
     * @param peso
     */
    public void setPeso(Float peso) {
        this.peso = peso;
    }

    /**
     *
     * @return
     */
    public Administrador getAdministrador() {
        return administrador;
    }

    /**
     *
     * @param administrador
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
