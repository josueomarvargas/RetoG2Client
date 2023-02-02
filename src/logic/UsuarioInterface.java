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
    public void crearUsuario(Usuario usuario) throws UsuarioInterfaceException;

    /**
     *
     * @param usuario
     * @throws DeleteException
     */
    public void eliminarUsuario(Usuario usuario) throws UsuarioInterfaceException ;

    /**
     *
     * @param usuario
     * @throws UpdateException
     */
    public void modificarUsuario(Usuario usuario) throws UsuarioInterfaceException ;
    public Collection<Usuario> getUsuarioTodos() throws UsuarioInterfaceException;
    public Collection<Usuario> getInicioSesion(String nombreAcceso, String contrasenia) throws UsuarioInterfaceException;
    public void getUsuarioPorEmail(String correo) throws UsuarioInterfaceException;
    public Usuario getUsuarioPorDni(String dni)throws UsuarioInterfaceException;
    

}
