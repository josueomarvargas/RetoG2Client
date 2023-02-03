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
     * Crea Un usuario
     * @param usuario
     * @throws UsuarioInterfaceException
     */
    public void crearUsuario(Usuario usuario) throws UsuarioInterfaceException;

    /**
     * Elimina un usuario
     * @param usuario
     * @throws exceptions.UsuarioInterfaceException
     */
    public void eliminarUsuario(Usuario usuario) throws UsuarioInterfaceException ;

    /**
     * Actualiza un Usuario
     * @param usuario
     * @throws exceptions.UsuarioInterfaceException
     */
    public void modificarUsuario(Usuario usuario) throws UsuarioInterfaceException ;

    /**
     *Busca Todos los usuario
     * @return
     * @throws UsuarioInterfaceException
     */
    public Collection<Usuario> getUsuarioTodos() throws UsuarioInterfaceException;

    /**
     *Busca Usuarios por nombre de acceso y contraseña
     * @param nombreAcceso
     * @param contrasenia
     * @return
     * @throws UsuarioInterfaceException
     */
    public Collection<Usuario> getInicioSesion(String nombreAcceso, String contrasenia) throws UsuarioInterfaceException;

    /**
     *Busca Usuario por su correo
     * @param correo
     * @throws UsuarioInterfaceException
     */
    public void getUsuarioPorEmail(String correo) throws UsuarioInterfaceException;

    /**
     *Busca usuario por su dni
     * @param dni
     * @return
     * @throws UsuarioInterfaceException
     */
    public Usuario getUsuarioPorDni(String dni)throws UsuarioInterfaceException;
    

}
