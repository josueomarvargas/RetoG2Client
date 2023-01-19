/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:AlimentoFacadeREST
 * [entities.alimento]<br>
 * USAGE:
 * <pre>
 *        AlimentoRestfulCliente client = new AlimentoRestfulCliente();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Gonzalo
 */
public class AlimentoRestfulCliente {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RetoG2Serv/webresources";

    public AlimentoRestfulCliente() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("entities.alimento");
    }

    public <T> T getAlimentoPorCarbohidratosMinimo_XML(Class<T> responseType, String carbohidratos) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCarbohidratosMinimo/{0}", new Object[]{carbohidratos}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAlimentoPorCarbohidratosMinimo_JSON(Class<T> responseType, String carbohidratos) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCarbohidratosMinimo/{0}", new Object[]{carbohidratos}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAlimentoPorCaloriasSuperior_XML(Class<T> responseType, String calorias) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCaloriasSuperior/{0}", new Object[]{calorias}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAlimentoPorCaloriasSuperior_JSON(Class<T> responseType, String calorias) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCaloriasSuperior/{0}", new Object[]{calorias}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void crearAlimento_XML(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void crearAlimento_JSON(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void eliminarAlimento(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request().delete();
    }

    public <T> T getAlimentoPorGrasasEntre_XML(Class<T> responseType, String grasasMax, String grasasMin) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoGrasasEntre/{0}/{1}", new Object[]{grasasMax, grasasMin}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAlimentoPorGrasasEntre_JSON(Class<T> responseType, String grasasMax, String grasasMin) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoGrasasEntre/{0}/{1}", new Object[]{grasasMax, grasasMin}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAlimentoPorCarbohidratosSuperior_XML(Class<T> responseType, String carbohidratos) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCarbohidratosSuperior/{0}", new Object[]{carbohidratos}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAlimentoPorCarbohidratosSuperior_JSON(Class<T> responseType, String carbohidratos) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCarbohidratosSuperior/{0}", new Object[]{carbohidratos}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAlimentoPorId_XML(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAlimentoPorId_JSON(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAlimentoPorProteinasEntre_XML(Class<T> responseType, String proteinasMax, String proteinasMin) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoProteinasEntre/{0}/{1}", new Object[]{proteinasMax, proteinasMin}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAlimentoPorProteinasEntre_JSON(Class<T> responseType, String proteinasMax, String proteinasMin) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoProteinasEntre/{0}/{1}", new Object[]{proteinasMax, proteinasMin}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAlimentoPorNombre_XML(Class<T> responseType, String nombre) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoNombre/{0}", new Object[]{nombre}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAlimentoPorNombre_JSON(Class<T> responseType, String nombre) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoNombre/{0}", new Object[]{nombre}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAlimentoPorGrasasMinimo_XML(Class<T> responseType, String grasas) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoGrasasMinimo/{0}", new Object[]{grasas}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAlimentoPorGrasasMinimo_JSON(Class<T> responseType, String grasas) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoGrasasMinimo/{0}", new Object[]{grasas}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAlimentoPorTipo_XML(Class<T> responseType, String tipo) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoTIPO/{0}", new Object[]{tipo}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAlimentoPorTipo_JSON(Class<T> responseType, String tipo) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoTIPO/{0}", new Object[]{tipo}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAlimentoPorProteinasMinimo_XML(Class<T> responseType, String proteinas) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoProteinasMinimo/{0}", new Object[]{proteinas}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAlimentoPorProteinasMinimo_JSON(Class<T> responseType, String proteinas) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoProteinasMinimo/{0}", new Object[]{proteinas}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAlimentoPorGrasasSuperior_XML(Class<T> responseType, String grasas) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoGrasasSuperior/{0}", new Object[]{grasas}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAlimentoPorGrasasSuperior_JSON(Class<T> responseType, String grasas) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoGrasasSuperior/{0}", new Object[]{grasas}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAlimentoPorCarbohidratosEntre_XML(Class<T> responseType, String carbohidratosMax, String carbohidratosMin) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCarbohidratosEntre/{0}/{1}", new Object[]{carbohidratosMax, carbohidratosMin}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAlimentoPorCarbohidratosEntre_JSON(Class<T> responseType, String carbohidratosMax, String carbohidratosMin) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCarbohidratosEntre/{0}/{1}", new Object[]{carbohidratosMax, carbohidratosMin}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAlimentoPorCaloriasMinimo_XML(Class<T> responseType, String calorias) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCaloriasMinimo/{0}", new Object[]{calorias}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAlimentoPorCaloriasMinimo_JSON(Class<T> responseType, String calorias) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCaloriasMinimo/{0}", new Object[]{calorias}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAlimentoPorProteinasSuperior_XML(Class<T> responseType, String proteinas) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoProteinasSuperior/{0}", new Object[]{proteinas}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAlimentoPorProteinasSuperior_JSON(Class<T> responseType, String proteinas) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoProteinasSuperior/{0}", new Object[]{proteinas}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void actualizarAlimento_XML(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void actualizarAlimento_JSON(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getAlimentoTodos_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAlimentoTodos_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAlimentoPorCaloriasEntre_XML(Class<T> responseType, String caloriasMax, String caloriasMin) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCaloriasEntre/{0}/{1}", new Object[]{caloriasMax, caloriasMin}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAlimentoPorCaloriasEntre_JSON(Class<T> responseType, String caloriasMax, String caloriasMin) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCaloriasEntre/{0}/{1}", new Object[]{caloriasMax, caloriasMin}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
