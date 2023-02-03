/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.Alimento;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

/**
 * Jersey REST client generated for REST resource:AlimentoFacadeREST
 * [entities.alimento]<br>
 * USAGE:
 * <pre>
 *        AlimentoResfullClient client = new AlimentoResfullClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author josue
 */
public class AlimentoResfullClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RetoG2Serv/webresources";

    /**
     *Constructor
     */
    public AlimentoResfullClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("entities.alimento");
    }

    /**
     *Resfull Cliente Busca Por su minimo
     * @param <T> class
     * @param responseType GenericType
     * @param carbohidratos String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorCarbohidratosMinimo_XML(GenericType<T> responseType, String carbohidratos) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCarbohidratosMinimo/{0}", new Object[]{carbohidratos}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     *Resfull Cliente Busca Por su minimo
     * @param <T> class
     * @param responseType GenericType
     * @param carbohidratos String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorCarbohidratosMinimo_JSON(Class<T> responseType, String carbohidratos) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCarbohidratosMinimo/{0}", new Object[]{carbohidratos}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     *Resfull Cliente Busca Por su superior
     * @param <T> class
     * @param responseType GenericType
     * @param calorias String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorCaloriasSuperior_XML(GenericType<T> responseType, String calorias) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCaloriasSuperior/{0}", new Object[]{calorias}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     *Resfull Cliente Busca Por su superior
     * @param <T> class
     * @param responseType GenericType
     * @param calorias String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorCaloriasSuperior_JSON(Class<T> responseType, String calorias) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCaloriasSuperior/{0}", new Object[]{calorias}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     *Resfull Cliente Crea Alimento
     * @param requestEntity Object
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public void crearAlimento_XML(Object requestEntity) throws WebApplicationException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    /**
     *Resfull Cliente Crea Alimento
     * @param requestEntity Object
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public void crearAlimento_JSON(Object requestEntity) throws WebApplicationException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    /**
     *Resfull Cliente Elimina Alimento por su id 
     * @param id String
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public void eliminarAlimento(String id) throws WebApplicationException {
        webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request().delete();
    }

    /**
     *Resfull Cliente Busca entre dos valores
     * @param <T> Class 
     * @param responseType GenericType
     * @param grasasMax String
     * @param grasasMin String 
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorGrasasEntre_XML(GenericType<T> responseType, String grasasMax, String grasasMin) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoGrasasEntre/{0}/{1}", new Object[]{grasasMax, grasasMin}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     *Resfull Cliente Busca entre dos valores
     * @param <T> Class 
     * @param responseType GenericType
     * @param grasasMax String
     * @param grasasMin String 
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorGrasasEntre_JSON(Class<T> responseType, String grasasMax, String grasasMin) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoGrasasEntre/{0}/{1}", new Object[]{grasasMax, grasasMin}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     *Resfull Cliente Busca Por su superior
     * @param <T> Class
     * @param responseType GenericType
     * @param carbohidratos String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorCarbohidratosSuperior_XML(GenericType<T> responseType, String carbohidratos) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCarbohidratosSuperior/{0}", new Object[]{carbohidratos}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     *Resfull Cliente Busca Por su superior
     * @param <T> Class
     * @param responseType GenericType
     * @param carbohidratos String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorCarbohidratosSuperior_JSON(Class<T> responseType, String carbohidratos) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCarbohidratosSuperior/{0}", new Object[]{carbohidratos}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     *Busca Alimento por su id
     * @param <T> Class
     * @param responseType GenericType
     * @param id String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorId_XML(Class<T> responseType, String id) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     *Busca Alimento por su id
     * @param <T> Class
     * @param responseType GenericType
     * @param id String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorId_JSON(Class<T> responseType, String id) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     *Resfull Cliente Busca entre dos valores
     * @param <T> Class
     * @param responseType GenericType
     * @param proteinasMax String
     * @param proteinasMin String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorProteinasEntre_XML(GenericType<T> responseType, String proteinasMax, String proteinasMin) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoProteinasEntre/{0}/{1}", new Object[]{proteinasMax, proteinasMin}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     *Resfull Cliente Busca entre dos valores
     * @param <T> Class
     * @param responseType GenericType
     * @param proteinasMax String
     * @param proteinasMin String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorProteinasEntre_JSON(Class<T> responseType, String proteinasMax, String proteinasMin) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoProteinasEntre/{0}/{1}", new Object[]{proteinasMax, proteinasMin}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     *Busca Alimento por su nombre
     * @param <T> Class
     * @param responseType GenericType
     * @param nombre String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorNombre_XML(GenericType<T> responseType, String nombre) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoNombre/{0}", new Object[]{nombre}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     *Busca Alimento por su nombre
     * @param <T> Class
     * @param responseType GenericType
     * @param nombre String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorNombre_JSON(Class<T> responseType, String nombre) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoNombre/{0}", new Object[]{nombre}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     *Resfull Cliente Busca Por su minimo
     * @param <T> Class
     * @param responseType GenericType
     * @param grasas String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorGrasasMinimo_XML(GenericType<T> responseType, String grasas) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoGrasasMinimo/{0}", new Object[]{grasas}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     *Resfull Cliente Busca Por su minimo
     * @param <T> Class
     * @param responseType GenericType
     * @param grasas String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorGrasasMinimo_JSON(Class<T> responseType, String grasas) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoGrasasMinimo/{0}", new Object[]{grasas}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     *Resfull Cliente Busca Alimento Por su tipo
     * @param <T> Class
     * @param responseType GenericType
     * @param tipo String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorTipo_XML(GenericType<T> responseType, String tipo) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoTIPO/{0}", new Object[]{tipo}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     *Resfull Cliente Busca Alimento Por su tipo
     * @param <T> Class
     * @param responseType GenericType
     * @param tipo String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorTipo_JSON(Class<T> responseType, String tipo) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoTIPO/{0}", new Object[]{tipo}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     *Resfull Cliente Busca Alimento Por su minimo
     * @param <T> Class
     * @param responseType GenericType
     * @param proteinas String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorProteinasMinimo_XML(GenericType<T> responseType, String proteinas) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoProteinasMinimo/{0}", new Object[]{proteinas}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     *Resfull Cliente Busca Alimento Por su minimo
     * @param <T> Class
     * @param responseType GenericType
     * @param proteinas String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorProteinasMinimo_JSON(Class<T> responseType, String proteinas) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoProteinasMinimo/{0}", new Object[]{proteinas}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     *Resfull Cliente Busca Por su superior
     * @param <T> Class
     * @param responseType GenericType
     * @param grasas String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorGrasasSuperior_XML(GenericType<T> responseType, String grasas) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoGrasasSuperior/{0}", new Object[]{grasas}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     *Resfull Cliente Busca Por su superior
     * @param <T> Class
     * @param responseType GenericType
     * @param grasas String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorGrasasSuperior_JSON(Class<T> responseType, String grasas) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoGrasasSuperior/{0}", new Object[]{grasas}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     *Resfull Cliente Busca entre dos valores
     * @param <T> Class
     * @param responseType GenericType
     * @param carbohidratosMax String
     * @param carbohidratosMin String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorCarbohidratosEntre_XML(GenericType<T> responseType, String carbohidratosMax, String carbohidratosMin) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCarbohidratosEntre/{0}/{1}", new Object[]{carbohidratosMax, carbohidratosMin}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     *Resfull Cliente Busca entre dos valores
     * @param <T> Class
     * @param responseType GenericType
     * @param carbohidratosMax String
     * @param carbohidratosMin String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorCarbohidratosEntre_JSON(Class<T> responseType, String carbohidratosMax, String carbohidratosMin) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCarbohidratosEntre/{0}/{1}", new Object[]{carbohidratosMax, carbohidratosMin}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     *Resfull Cliente Busca Alimento Por su minimo
     * @param <T> Class
     * @param responseType GenericType
     * @param calorias String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorCaloriasMinimo_XML(GenericType<T> responseType, String calorias) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCaloriasMinimo/{0}", new Object[]{calorias}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     *Resfull Cliente Busca Alimento Por su minimo
     * @param <T> Class
     * @param responseType GenericType
     * @param calorias String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorCaloriasMinimo_JSON(Class<T> responseType, String calorias) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCaloriasMinimo/{0}", new Object[]{calorias}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     *Resfull Cliente Busca Por su superior
     * @param <T> Class
     * @param responseType GenericType
     * @param proteinas String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorProteinasSuperior_XML(GenericType<T> responseType, String proteinas) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoProteinasSuperior/{0}", new Object[]{proteinas}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     *Resfull Cliente Busca Por su superior
     * @param <T> Class
     * @param responseType GenericType
     * @param proteinas String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorProteinasSuperior_JSON(Class<T> responseType, String proteinas) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoProteinasSuperior/{0}", new Object[]{proteinas}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     *Resfull Cliente actualiza Alimento
     * @param requestEntity Object
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public void actualizarAlimento_XML(Object requestEntity) throws WebApplicationException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    /**
     *Resfull Cliente actualiza Alimento
     * @param requestEntity Object
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public void actualizarAlimento_JSON(Object requestEntity) throws WebApplicationException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    /**
     *Resfull Cliente Busca todos los  Alimentos
     * @param <T> Class
     * @param responseType GenericType
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoTodos_XML(GenericType<T> responseType) throws WebApplicationException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     * @param <T> Class
     * @param responseType GenericType
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoTodos_JSON(Class<T> responseType) throws WebApplicationException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     *Resfull Cliente Busca entre dos valores
     * @param <T> Class
     * @param responseType GenericType
     * @param caloriasMax String
     * @param caloriasMin String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorCaloriasEntre_XML(GenericType<T> responseType, String caloriasMax, String caloriasMin) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCaloriasEntre/{0}/{1}", new Object[]{caloriasMax, caloriasMin}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    /**
     *Resfull Cliente Busca entre dos valores
     * @param <T> Class
     * @param responseType GenericType
     * @param caloriasMax String
     * @param caloriasMin String
     * @return T
     * @throws WebApplicationException saltara si algo va mal en el metodo
     */
    public <T> T getAlimentoPorCaloriasEntre_JSON(Class<T> responseType, String caloriasMax, String caloriasMin) throws WebApplicationException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("AlimentoCaloriasEntre/{0}/{1}", new Object[]{caloriasMax, caloriasMin}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /**
     *
     */
    public void close() {
        client.close();
    }

}
