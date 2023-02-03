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
 * Jersey REST client generated for REST resource:DietaFacadeREST
 * [entities.dieta]<br>
 * USAGE:
 * <pre>
 *        DietaRestfulCliente client = new DietaRestfulCliente();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Gonzalo
 */
public class DietaRestfulCliente {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RetoG2Serv/webresources";

    public DietaRestfulCliente() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("entities.dieta");
    }

    /**
     * Metodo que lee todos los objetos de Dieta por su objetivo y lo representa
     * en un XML
     *
     * @param <T>
     * @param responseType
     * @param objetivo
     * @return
     * @throws ClientErrorException
     */
    public <T> T findObjetivo_XML(Class<T> responseType, String objetivo) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("FindObjetivo/{0}", new Object[]{objetivo}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     * Metodo que lee todos los objetos de Dieta por su objetivo y lo representa
     * en un JSON
     *
     * @param <T>
     * @param responseType
     * @param objetivo
     * @return
     * @throws ClientErrorException
     */
    public <T> T findObjetivo_JSON(Class<T> responseType, String objetivo) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("FindObjetivo/{0}", new Object[]{objetivo}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     * Metodo que modifica un objeto de Dieta de la base de Datos y lo
     * representa en un XML
     *
     * @param requestEntity
     * @throws ClientErrorException
     */
    public void edit_XML(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    /**
     * Metodo que modifica un objeto de Dieta de la base de Datos y lo
     * representa en un JSON
     *
     * @param requestEntity
     * @throws ClientErrorException
     */
    public void edit_JSON(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    /**
     * Metodo que lee un objeto dieta por su Id y lo representa en un XML
     *
     * @param <T>
     * @param responseType
     * @param id
     * @return
     * @throws ClientErrorException
     */
    public <T> T find_XML(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     * Metodo que lee un objeto dieta por su Id y lo representa en un JSON
     *
     * @param <T>
     * @param responseType
     * @param id
     * @return
     * @throws ClientErrorException
     */
    public <T> T find_JSON(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     * Metodo que lee todos los objetos de Dieta si esta entre los tiempos dados
     * y lo representa en un XML
     *
     * @param <T>
     * @param responseType
     * @param from
     * @param to
     * @return
     * @throws ClientErrorException
     */
    public <T> T findRange_XML(Class<T> responseType, String from, String to) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("FindRange/{0}/{1}", new Object[]{from, to}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     * Metodo que lee todos los objetos de Dieta si esta entre los tiempos dados
     * y lo representa en un JSON
     *
     * @param <T>
     * @param responseType
     * @param from
     * @param to
     * @return
     * @throws ClientErrorException
     */
    public <T> T findRange_JSON(Class<T> responseType, String from, String to) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("FindRange/{0}/{1}", new Object[]{from, to}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     * Metodo que crea un objeto de Dieta y lo representa en un XML
     *
     * @param requestEntity
     * @throws ClientErrorException
     */
    public void create_XML(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    /**
     * Metodo que crea un objeto de Dieta y lo representa en un JSON
     *
     * @param requestEntity
     * @throws ClientErrorException
     */
    public void create_JSON(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    /**
     * Metodo que lee todos los objetos de Dieta por su tipo y lo representa en
     * un XML
     *
     * @param <T>
     * @param responseType
     * @param tipo
     * @return
     * @throws ClientErrorException
     */
    public <T> T findTipo_XML(Class<T> responseType, String tipo) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("FindTipo/{0}", new Object[]{tipo}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     * Metodo que lee todos los objetos de Dieta por su tipo y lo representa en
     * un JSON
     *
     * @param <T>
     * @param responseType
     * @param tipo
     * @return
     * @throws ClientErrorException
     */
    public <T> T findTipo_JSON(Class<T> responseType, String tipo) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("FindTipo/{0}", new Object[]{tipo}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     * Metodo que lee todos los objetos de Dieta por su nombre y lo representa
     * en un XML
     *
     * @param <T>
     * @param responseType
     * @param nombre
     * @return
     * @throws ClientErrorException
     */
    public <T> T findNombre_XML(Class<T> responseType, String nombre) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("FindNombre/{0}", new Object[]{nombre}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     * Metodo que lee todos los objetos de Dieta por su nombre y lo representa
     * en un JSON
     *
     * @param <T>
     * @param responseType
     * @param nombre
     * @return
     * @throws ClientErrorException
     */
    public <T> T findNombre_JSON(Class<T> responseType, String nombre) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("FindNombre/{0}", new Object[]{nombre}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     *
     * @param <T>
     * @param responseType
     * @param from
     * @return
     * @throws ClientErrorException
     */
    public <T> T findmin_XML(Class<T> responseType, String from) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("FindMin/{0}", new Object[]{from}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     * Metodo que lee todos los objetos de Dieta si es inferior a el el tiempo
     * dado y lo representa en un XML
     *
     * @param <T>
     * @param responseType
     * @param from
     * @return
     * @throws ClientErrorException
     */
    public <T> T findmin_JSON(Class<T> responseType, String from) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("FindMin/{0}", new Object[]{from}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     * Metodo que lee todos los objetos de Dieta y lo representa en un
     * XML
     *
     * @param <T>
     * @param responseType
     * @return
     * @throws ClientErrorException
     */
    public <T> T findAll_XML(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     * Metodo que lee todos los objetos de Dieta y lo representa en un
     * JSON
     * @param <T>
     * @param responseType
     * @return
     * @throws ClientErrorException
     */
    public <T> T findAll_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     * Metodo que elimina un objeto de la entidad Dieta de la base
     * de Datos y lo representa en un XML
     * @param id
     * @throws ClientErrorException
     */
    public void remove(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request().delete();
    }

    /**
     * Metodo que lee todos los objetos de Dieta si es superior a el
     * tiempo dado y lo representa en un XML
     * @param <T>
     * @param responseType
     * @param to
     * @return
     * @throws ClientErrorException
     */
    public <T> T findMax_XML(Class<T> responseType, String to) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("FindMax/{0}", new Object[]{to}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     * Metodo que lee todos los objetos de Dieta si es superior a el
     * tiempo dado y lo representa en un JSON
     * @param <T>
     * @param responseType
     * @param to
     * @return
     * @throws ClientErrorException
     */
    public <T> T findMax_JSON(Class<T> responseType, String to) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("FindMax/{0}", new Object[]{to}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }

}
