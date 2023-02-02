/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.Usuario;
import exceptions.UsuarioInterfaceException;
import java.util.Collection;

/**
 *
 * @author josue
 */
public interface DietistaInterface {
    public void crearDietista(Usuario usuario) throws UsuarioInterfaceException;

    /**
     *
     * @param usuario
     * @throws DeleteException
     */
    public void eliminarDietista(Usuario usuario) throws UsuarioInterfaceException ;

    /**
     *
     * @param usuario
     * @throws UpdateException
     */
    public void modificarDietista(Usuario usuario) throws UsuarioInterfaceException ;

    

}
