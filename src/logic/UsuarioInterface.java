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
public interface UsuarioInterface {

    /**
     *
     * @param usuario
     * @throws UsuarioInterfaceException
     */
    public void crearUsuario(Usuario usuario) throws UsuarioInterfaceException;

    /**
     *
     * @param usuario
     * @throws exceptions.UsuarioInterfaceException
     */
    public void eliminarUsuario(Usuario usuario) throws UsuarioInterfaceException ;

    /**
     *
     * @param usuario
     * @throws exceptions.UsuarioInterfaceException
     * @throws UpdateException
     */
    public void modificarUsuario(Usuario usuario) throws UsuarioInterfaceException ;

    /**
     *
     * @return
     * @throws UsuarioInterfaceException
     */
    public Collection<Usuario> getUsuarioTodos() throws UsuarioInterfaceException;

    /**
     *
     * @param nombreAcceso
     * @param contrasenia
     * @return
     * @throws UsuarioInterfaceException
     */
    public Collection<Usuario> getInicioSesion(String nombreAcceso, String contrasenia) throws UsuarioInterfaceException;

    /**
     *
     * @param correo
     * @throws UsuarioInterfaceException
     */
    public void getUsuarioPorEmail(String correo) throws UsuarioInterfaceException;

    /**
     *
     * @param dni
     * @return
     * @throws UsuarioInterfaceException
     */
    public Usuario getUsuarioPorDni(String dni)throws UsuarioInterfaceException;
    

}
