/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
 
import java.util.Collection;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gonzalo
 */


@XmlRootElement
public class Administrador extends Usuario {

    /**
     *
     */
    public Administrador() {
        super();
    }
    /**
     * associates {g2.Dietista}
     */

    private Collection<Dietista> listaDietistas;

    /**
     * associates {g2.Cliente}
     */

    private Collection<Cliente> listaClientes;

    /**
     *
     * @return Collection
     */
    public Collection<Dietista> getListaDietistas() {
        return listaDietistas;
    }

    /**
     *
     * @param listaDietistas Collection
     */
    public void setListaDietistas(Collection<Dietista> listaDietistas) {
        this.listaDietistas = listaDietistas;
    }

    /**
     *
     * @return Collection
     */
    @XmlTransient
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
    
}
