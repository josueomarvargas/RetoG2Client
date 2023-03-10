/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.Alimento;
import entities.Usuario;
import exceptions.AlimentoInterfaceException;
import exceptions.UsuarioInterfaceException;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author josue
 */
public class UsuarioImplementacion implements UsuarioInterface {

    private final UsuarioResfullClient webClient;

    private static final Logger LOGGER = Logger.getLogger("javafxapplicationud3example");

    /**
     * constructor
     */
    public UsuarioImplementacion() {
        this.webClient = new UsuarioResfullClient();
    }

    /**
     * Crea Un usuario
     * @param usuario
     * @throws UsuarioInterfaceException
     */
    @Override
    public void crearUsuario(Usuario usuario) throws UsuarioInterfaceException {
        try {
            LOGGER.log(Level.INFO, "UsuarioInterface: Creating alimento {0}.", usuario.getDni());
            //Send user data to web client for creation. 
            webClient.crearUsuario_XML(usuario);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "UsersManager: Exception creating user, {0}",
                    ex.getMessage());
            throw new UsuarioInterfaceException("Error creating user:\n" + ex.getMessage());
        } catch (AlimentoInterfaceException ex) {
            Logger.getLogger(UsuarioImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/**
     * Elimina un usuario
     * @throws exceptions.UsuarioInterfaceException
     */
    @Override
    public void eliminarUsuario(Usuario usuario) throws UsuarioInterfaceException {
        try {
            LOGGER.log(Level.INFO, "AlimentoInterface: Deleting alimento {0}.", usuario.getDni());
            webClient.eliminarUsuario(usuario.getDni());
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "AlimentoInterface: Exception deleting alimento, {0}",
                    ex.getMessage());
            throw new UsuarioInterfaceException("Error deleting user:\n" + ex.getMessage());
        } catch (AlimentoInterfaceException ex) {
            Logger.getLogger(UsuarioImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  /**
     * Actualiza un Usuario
     * @param usuario
     */
    @Override
    public void modificarUsuario(Usuario usuario) throws UsuarioInterfaceException {
        try {
            LOGGER.log(Level.INFO, "UsuarioInterface: Updating alimento {0}.", usuario.getDni());
            webClient.actualizarUsuario_XML(usuario);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "AlimentoInterface: Exception updating user, {0}",
                    ex.getMessage());
            throw new UsuarioInterfaceException("Error updating user:\n" + ex.getMessage());
        } catch (AlimentoInterfaceException ex) {
            Logger.getLogger(UsuarioImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *Busca Todos los usuario
     * @return
     * @throws UsuarioInterfaceException
     */
    @Override
    public Collection<Usuario> getUsuarioTodos() throws UsuarioInterfaceException {
        List<Usuario> usuarios = null;
        try {
            LOGGER.info("UsuarioInterface: Finding all usuarios from REST service (XML).");
            usuarios = webClient.getUsuarioTodos_XML(new GenericType<List<Usuario>>() {
            });
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "Usuario: Exception finding all usuarios, {0}",
                    ex.getMessage());
            throw new UsuarioInterfaceException("Error finding all usuarios:\n" + ex.getMessage());
        } catch (AlimentoInterfaceException ex) {
            Logger.getLogger(UsuarioImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    /**
     *Busca Usuarios por nombre de acceso y contrase??a
     * @param nombreAcceso
     * @param contrasenia
     * @return
     * @throws UsuarioInterfaceException
     */
    @Override
    public Collection<Usuario> getInicioSesion(String nombreAcceso, String contrasenia) throws UsuarioInterfaceException {
        List<Usuario> usuarios = null;

            LOGGER.info("UsuarioInterface: Finding all usuarios from REST service (XML).");
        try {
            usuarios = webClient.getInicioSesion_XML(new GenericType<List<Usuario>>() {
            }, nombreAcceso, contrasenia);
        } catch (AlimentoInterfaceException ex) {
            Logger.getLogger(UsuarioImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return usuarios;

    }

    /**
     *Busca Usuario por su correo
     * @param correo
     * @throws UsuarioInterfaceException
     */
    @Override
    public void getUsuarioPorEmail(String correo) throws UsuarioInterfaceException {
        try {
            Usuario usuario = new Usuario();
            webClient.getUsuarioPorEmail_XML(usuario, correo);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "AlimentoInterface: Exception updating user, {0}",
                    ex.getMessage());
            throw new UsuarioInterfaceException("Error updating user:\n" + ex.getMessage());
        } catch (AlimentoInterfaceException ex) {
            Logger.getLogger(UsuarioImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *Busca usuario por su dni
     * @param dni
     * @return
     * @throws UsuarioInterfaceException
     */
    @Override
    public Usuario getUsuarioPorDni(String dni) throws UsuarioInterfaceException {
        Usuario usuario = null;
        try {
            LOGGER.info("AlimentoInterface: Finding all alimentos from REST service (XML).");
            usuario = webClient.getUsuarioPorDni_XML(Usuario.class, dni);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "Alimento: Exception finding all alimentos, {0}",
                    ex.getMessage());
        } catch (AlimentoInterfaceException ex) {
            Logger.getLogger(UsuarioImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

}
