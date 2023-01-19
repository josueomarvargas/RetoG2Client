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

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Float getImc() {
        return imc;
    }

    public void setImc(Float imc) {
        this.imc = imc;
    }

    public EstadoFisico getESTADOFISICO() {
        return ESTADOFISICO;
    }

    public void setESTADOFISICO(EstadoFisico ESTADOFISICO) {
        this.ESTADOFISICO = ESTADOFISICO;
    }

    public Collection<ClienteDieta> getListaDieta() {
        return listaDieta;
    }

    public void setListaDieta(Collection<ClienteDieta> listaDieta) {
        this.listaDieta = listaDieta;
    }

    public Dietista getDietista() {
        return dietista;
    }

    public void setDietista(Dietista dietista) {
        this.dietista = dietista;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }   

    public Cliente() {
        super();
    }
}
