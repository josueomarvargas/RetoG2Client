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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericType;

/**
    //REST Dietista web client
 * @author josue
 */
public class DietistaImplementacion implements DietistaInterface {

    private final DietistaResfullClient webClient;

    private static final Logger LOGGER = Logger.getLogger("javafxapplicationud3example");

    /**
     * Constructor
     */
    public DietistaImplementacion() {
        this.webClient = new DietistaResfullClient();
    }

    /**
     * Crea Un dietista
     * @param usuario
     * @throws UsuarioInterfaceException
     */
    @Override
    public void crearDietista(Usuario usuario) throws UsuarioInterfaceException {
        try {
            LOGGER.log(Level.INFO, "UsuarioInterface: Creating alimento {0}.", usuario.getDni());
            //Send user data to web client for creation. 
            webClient.crearDietista_XML(usuario);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "UsersManager: Exception creating user, {0}",
                    ex.getMessage());
            throw new UsuarioInterfaceException("Error creating user:\n" + ex.getMessage());
        }
    }
    /**
     * Elimina un Dietista
     * @throws exceptions.UsuarioInterfaceException
     */
    @Override
    public void eliminarDietista(Usuario usuario) throws UsuarioInterfaceException {
        try {
            LOGGER.log(Level.INFO, "AlimentoInterface: Deleting alimento {0}.", usuario.getDni());
            webClient.eliminarDietista(usuario.getDni());
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "AlimentoInterface: Exception deleting alimento, {0}",
                    ex.getMessage());
            throw new UsuarioInterfaceException("Error deleting user:\n" + ex.getMessage());
        }
    }
    /**
     * Actualiza un Usuario
     * @param usuario
     */
    @Override
    public void modificarDietista(Usuario usuario) throws UsuarioInterfaceException {
        try {
            LOGGER.log(Level.INFO, "UsuarioInterface: Updating alimento {0}.", usuario.getDni());
            webClient.actualizarDietista_XML(usuario);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "AlimentoInterface: Exception updating user, {0}",
                    ex.getMessage());
            throw new UsuarioInterfaceException("Error updating user:\n" + ex.getMessage());
        }
    }

    /**
     *Busca Todos los dietista
     * @return
     * @throws UsuarioInterfaceException
     */
    public Collection<Usuario> getDietistaTodos() throws UsuarioInterfaceException {
        List<Usuario> usuarios = null;
        try {
            LOGGER.info("UsuarioInterface: Finding all usuarios from REST service (XML).");
            usuarios = webClient.getDietistaTodos_XML(new GenericType<List<Usuario>>() {
            });
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "Usuario: Exception finding all usuarios, {0}",
                    ex.getMessage());
            throw new UsuarioInterfaceException("Error finding all usuarios:\n" + ex.getMessage());
        }
        return usuarios;
    }
}

   