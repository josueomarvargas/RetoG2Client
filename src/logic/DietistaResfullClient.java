/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

/**
 * Jersey REST client generated for REST resource:DietistaFacadeREST
 * [entities.dietista]<br>
 * USAGE:
 * <pre>
 *        DietistaResfullClient client = new DietistaResfullClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author josue
 */
public class DietistaResfullClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RetoG2Serv/webresources";

    /**
     *Constructor
     */
    public DietistaResfullClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("entities.dietista");
    }

    /**
     *Resfull Cliente actualiza Dietista
     * @param requestEntity
     * @throws ClientErrorException
     */
    public void actualizarDietista_XML(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    /**
     *Resfull Cliente actualiza Dietista
     * @param requestEntity
     * @throws ClientErrorException
     */
    public void actualizarDietista_JSON(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    /**
     *Resfull Cliente Elimina Dietista por su dni 
     * @param dni
     * @throws ClientErrorException
     */
    public void eliminarDietista(String dni) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{dni})).request().delete();
    }

    /**
     *Resfull Cliente Crea Dietista
     * @param requestEntity
     * @throws ClientErrorException
     */
    public void crearDietista_XML(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    /**
     *Resfull Cliente Crea Dietista
     * @param requestEntity
     * @throws ClientErrorException
     */
    public void crearDietista_JSON(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    /**
     *Resfull Cliente busca Dietista por su dni 
     * @param <T>
     * @param responseType
     * @param dni
     * @return
     * @throws ClientErrorException
     */
    public <T> T getDietistaPorDni_XML(Class<T> responseType, String dni) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{dni}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     *Resfull Cliente busca Dietista por su dni 
     * @param <T>
     * @param responseType
     * @param dni
     * @return
     * @throws ClientErrorException
     */
    public <T> T getDietistaPorDni_JSON(Class<T> responseType, String dni) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{dni}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     *Resfull Cliente busca todos los  Dietistas  
     * @param <T>
     * @param responseType
     * @return
     * @throws ClientErrorException
     */
    public <T> T getDietistaTodos_XML(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     *Resfull Cliente busca todos los  Dietistas  
     * @param <T>
     * @param responseType
     * @return
     * @throws ClientErrorException
     */
    public <T> T getDietistaTodos_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     *
     */
    public void close() {
        client.close();
    }
    
}
