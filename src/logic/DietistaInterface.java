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

    /**
     * Crea Un dietista
     * @param usuario
     * @throws UsuarioInterfaceException Saltara si ocurre algun error durante el metodo
     */
    public void crearDietista(Usuario usuario) throws UsuarioInterfaceException;

    /**
     * Elimina un Dietista
     * @param usuario
     * @throws UsuarioInterfaceException Saltara si ocurre algun error durante el metodo
     */
    public void eliminarDietista(Usuario usuario) throws UsuarioInterfaceException ;

    /**
     * Actualiza un Usuario
     * @param usuario
     * @throws UsuarioInterfaceException Saltara si ocurre algun error durante el metodo
     */
    public void modificarDietista(Usuario usuario) throws UsuarioInterfaceException ;

    

}
