/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import exceptions.AlimentoInterfaceException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

/**
 * Jersey REST client generated for REST resource:UsuarioFacadeREST
 * [entities.usuario]<br>
 * USAGE:
 * <pre>
 *        UsuarioResfullClient client = new UsuarioResfullClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author josue
 */
public class UsuarioResfullClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RetoG2Serv/webresources";

    /**
     *Constructor
     */
    public UsuarioResfullClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("entities.usuario");
    }

    /**
     *Resfull Cliente Crea Usuario
     * @param requestEntity
     * @throws AlimentoInterfaceException
     */
    public void crearUsuario_XML(Object requestEntity) throws AlimentoInterfaceException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    /**
     *Resfull Cliente Crea Usuario
     * @param requestEntity
     * @throws AlimentoInterfaceException
     */
    public void crearUsuario_JSON(Object requestEntity) throws AlimentoInterfaceException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    /**
     *Resfull Cliente Busca Usuario por su nombre acceso y contraseña
     * @param <T>
     * @param responseType
     * @param nombreAcceso
     * @param contrasenia
     * @return
     * @throws AlimentoInterfaceException
     */
    public <T> T getInicioSesion_XML(GenericType<T> responseType, String nombreAcceso, String contrasenia) throws AlimentoInterfaceException{
        WebTarget resource = webTarget;
        
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{nombreAcceso, contrasenia}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     *Resfull Cliente Busca Usuario por su nombre acceso y contraseña
     * @param <T>
     * @param responseType
     * @param nombreAcceso
     * @param contrasenia
     * @return
     * @throws AlimentoInterfaceException
     */
    public <T> T getInicioSesion_JSON(Class<T> responseType, String nombreAcceso, String contrasenia) throws AlimentoInterfaceException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{nombreAcceso, contrasenia}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     *Resfull Cliente busca todos los  Usuarios  
     * @param <T>
     * @param responseType
     * @return
     * @throws AlimentoInterfaceException
     */
    public <T> T getUsuarioTodos_XML(GenericType<T> responseType) throws AlimentoInterfaceException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     *Resfull Cliente busca todos los  Usuarios  
     * @param <T>
     * @param responseType
     * @return
     * @throws AlimentoInterfaceException
     */
    public <T> T getUsuarioTodos_JSON(Class<T> responseType) throws AlimentoInterfaceException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     *Resfull Cliente busca  Usuario por su correo 
     * @param requestEntity
     * @param correo
     * @throws AlimentoInterfaceException
     */
    public void getUsuarioPorEmail_XML(Object requestEntity, String correo) throws AlimentoInterfaceException {
        webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{correo})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    /**
     *Resfull Cliente busca  Usuario por su correo 
     * @param requestEntity
     * @param correo
     * @throws AlimentoInterfaceException
     */
    public void getUsuarioPorEmail_JSON(Object requestEntity, String correo) throws AlimentoInterfaceException {
        webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{correo})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    /**
     *Resfull Cliente actualiza usuario
     * @param requestEntity
     * @throws AlimentoInterfaceException
     */
    public void actualizarUsuario_XML(Object requestEntity) throws AlimentoInterfaceException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    /**
     *Resfull Cliente actualiza usuario
     * @param requestEntity
     * @throws AlimentoInterfaceException
     */
    public void actualizarUsuario_JSON(Object requestEntity) throws AlimentoInterfaceException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    /**
     *Resfull Cliente Elimina usuario
     * @param dni
     * @throws AlimentoInterfaceException
     */
    public void eliminarUsuario(String dni) throws AlimentoInterfaceException {
        webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{dni})).request().delete();
    }

    /**
     *Resfull Cliente busca  Usuario por su dni 
     * @param <T>
     * @param responseType
     * @param dni
     * @return
     * @throws AlimentoInterfaceException
     */
    public <T> T getUsuarioPorDni_XML(Class<T> responseType, String dni) throws AlimentoInterfaceException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{dni}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     *
     */
    public void close() {
        client.close();
    }
    
}
