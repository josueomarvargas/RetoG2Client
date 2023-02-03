/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.Alimento;
import exceptions.AlimentoInterfaceException;
import exceptions.ExisteIdException;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author josue
 */
public class AlimentoImplementacion implements AlimentoInterface {
    //REST Alimento web client

    private final AlimentoResfullClient webClient;
    private static final Logger LOGGER = Logger.getLogger("javafxapplicationud3example");

    /**
     * Constructor
     */
    public AlimentoImplementacion() {
        this.webClient = new AlimentoResfullClient();
    }

    /**
     * Busca todos los Alimentos y los guarda en una lista
     *
     * @return
     * @throws AlimentoInterfaceException
     */
    @Override
    public Collection<Alimento> getAllAlimento() throws AlimentoInterfaceException {
        List<Alimento> alimentos = null;
        try {
            LOGGER.info("AlimentoInterface: Finding all alimentos from REST service (XML).");
            alimentos = webClient.getAlimentoTodos_XML(new GenericType<List<Alimento>>() {
            });
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "Alimento: Exception finding all alimentos, {0}",
                    ex.getMessage());
            throw new AlimentoInterfaceException("Error finding all Alimentos:\n" + ex.getMessage());
        }
        return alimentos;

    }

    /**
     * Crea Un Alimento
     *
     * @param alimento
     * @throws AlimentoInterfaceException
     */
    @Override
    public void crearAlimento(Alimento alimento) throws AlimentoInterfaceException {
        try {
            LOGGER.log(Level.INFO, "AlimentoInterface: Creating alimento {0}.", alimento.getIdAlimento());
            //Send user data to web client for creation. 
            webClient.crearAlimento_XML(alimento);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "Alimento: Exception creating user, {0}",
                    ex.getMessage());
            throw new AlimentoInterfaceException("Error creating user:\n" + ex.getMessage());
        }
    }

    /**
     * Actualiza un Alimento
     *
     * @param alimento
     * @throws AlimentoInterfaceException
     */
    @Override
    public void actualizarAlimento(Alimento alimento) throws AlimentoInterfaceException {
        try {
            LOGGER.log(Level.INFO, "AlimentoInterface: Updating alimento {0}.", alimento.getIdAlimento());
            webClient.actualizarAlimento_XML(alimento);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "AlimentoInterface: Exception updating user, {0}",
                    ex.getMessage());
            throw new AlimentoInterfaceException("Error updating user:\n" + ex.getMessage());
        }
    }

    /**
     * Elimina un alimento por su IdAlimento
     *
     * @param idAlimento
     * @throws AlimentoInterfaceException
     */
    @Override
    public void eliminarAlimento(String idAlimento) throws AlimentoInterfaceException {
        try {
            LOGGER.log(Level.INFO, "AlimentoInterface: Deleting alimento {0}.", idAlimento);
            webClient.eliminarAlimento(idAlimento);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "AlimentoInterface: Exception deleting alimento, {0}",
                    ex.getMessage());
            throw new AlimentoInterfaceException("Error deleting user:\n" + ex.getMessage());
        }
    }

    /**
     * Busca un Alimento por su IdAlimento
     *
     * @param idAlimento
     * @return
     * @throws AlimentoInterfaceException
     */
    @Override
    public Alimento getAlimentoPorId(String idAlimento) throws AlimentoInterfaceException {
        Alimento alimento = null;
        try {
            LOGGER.info("AlimentoInterface: Finding all alimentos from REST service (XML).");
            alimento = webClient.getAlimentoPorId_XML(Alimento.class, idAlimento);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "Alimento: Exception finding all alimentos, {0}",
                    ex.getMessage());
            throw new AlimentoInterfaceException("Error finding all Alimentos:\n" + ex.getMessage());
        }
        return alimento;
    }

    /**
     * Busca un Alimento por su nombre
     *
     * @param nombreAlimento
     * @return
     * @throws AlimentoInterfaceException
     */
    @Override
    public Alimento getAlimentoPorNombre(String nombreAlimento) throws AlimentoInterfaceException {
        List<Alimento> alimento = null;
        try {
            LOGGER.info("AlimentoInterface: Finding all alimentos from REST service (XML).");
            alimento = webClient.getAlimentoPorNombre_XML(new GenericType<List<Alimento>>() {
            }, nombreAlimento);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "Alimento: Exception finding all alimentos, {0}",
                    ex.getMessage());
            throw new AlimentoInterfaceException("Error finding all Alimentos:\n" + ex.getMessage());
        }
        for (int i = 0; i < alimento.size(); i++) {
            return alimento.get(0);
        }
        return null;
    }

    /**
     * Busca Alimentos por su tipo
     * @param tipo
     * @return
     * @throws AlimentoInterfaceException
     */
    @Override
    public Collection<Alimento> getAlimentoPorTipo(String tipo) throws AlimentoInterfaceException {
        List<Alimento> alimentos = null;
        try {
            LOGGER.info("AlimentoInterface: Finding all alimentos from REST service (XML).");
            alimentos = webClient.getAlimentoPorTipo_XML(new GenericType<List<Alimento>>() {
            }, tipo);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "Alimento: Exception finding all alimentos, {0}",
                    ex.getMessage());
            throw new AlimentoInterfaceException("Error finding all Alimentos:\n" + ex.getMessage());
        }
        return alimentos;
    }

    /**
     * Busca Alimentos que sean superior
     * @param superior
     * @return
     * @throws AlimentoInterfaceException
     */
    @Override
    public Collection<Alimento> getAlimentoPorCarbohidratosSuperior(String superior) throws AlimentoInterfaceException {
        List<Alimento> alimentos = null;
        try {
            LOGGER.info("AlimentoInterface: Finding all alimentos from REST service (XML).");
            alimentos = webClient.getAlimentoPorCarbohidratosSuperior_XML(new GenericType<List<Alimento>>() {
            }, superior);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "Alimento: Exception finding all alimentos, {0}",
                    ex.getMessage());
            throw new AlimentoInterfaceException("Error finding all Alimentos:\n" + ex.getMessage());
        }
        return alimentos;
    }

    /**
     * Busca Alimentos que sean superior
     * @param superior
     * @return
     * @throws AlimentoInterfaceException
     */
    @Override
    public Collection<Alimento> getAlimentoPorCaloriasSuperior(String superior) throws AlimentoInterfaceException {
        List<Alimento> alimentos = null;
        try {
            LOGGER.info("AlimentoInterface: Finding all alimentos from REST service (XML).");
            alimentos = webClient.getAlimentoPorCaloriasSuperior_XML(new GenericType<List<Alimento>>() {
            }, superior);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "Alimento: Exception finding all alimentos, {0}",
                    ex.getMessage());
            throw new AlimentoInterfaceException("Error finding all Alimentos:\n" + ex.getMessage());
        }
        return alimentos;
    }

    /**
     * Busca Alimentos que sean superior
     * @param superior
     * @return
     * @throws AlimentoInterfaceException
     */
    @Override
    public Collection<Alimento> getAlimentoPorProteinasSuperior(String superior) throws AlimentoInterfaceException {
        List<Alimento> alimentos = null;
        try {
            LOGGER.info("AlimentoInterface: Finding all alimentos from REST service (XML).");
            alimentos = webClient.getAlimentoPorProteinasSuperior_XML(new GenericType<List<Alimento>>() {
            }, superior);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "Alimento: Exception finding all alimentos, {0}",
                    ex.getMessage());
            throw new AlimentoInterfaceException("Error finding all Alimentos:\n" + ex.getMessage());
        }
        return alimentos;
    }

    /**
     * Busca Alimentos que sean superior
     * @param superior
     * @return
     * @throws AlimentoInterfaceException
     */
    @Override
    public Collection<Alimento> getAlimentoPorGrasasSuperior(String superior) throws AlimentoInterfaceException {
        List<Alimento> alimentos = null;
        try {
            LOGGER.info("AlimentoInterface: Finding all alimentos from REST service (XML).");
            alimentos = webClient.getAlimentoPorGrasasSuperior_XML(new GenericType<List<Alimento>>() {
            }, superior);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "Alimento: Exception finding all alimentos, {0}",
                    ex.getMessage());
            throw new AlimentoInterfaceException("Error finding all Alimentos:\n" + ex.getMessage());
        }
        return alimentos;
    }

    /**
     * Busca Alimentos que sean menor
     * @param menor
     * @return
     * @throws AlimentoInterfaceException
     */
    @Override
    public Collection<Alimento> getAlimentoPorCarbohidratosMinimo(String menor) throws AlimentoInterfaceException {
        List<Alimento> alimentos = null;
        try {
            LOGGER.info("AlimentoInterface: Finding all alimentos from REST service (XML).");
            alimentos = webClient.getAlimentoPorCarbohidratosMinimo_XML(new GenericType<List<Alimento>>() {
            }, menor);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "Alimento: Exception finding all alimentos, {0}",
                    ex.getMessage());
            throw new AlimentoInterfaceException("Error finding all Alimentos:\n" + ex.getMessage());
        }
        return alimentos;
    }

    /**
     * Busca Alimentos que sean menor
     * @param menor
     * @return
     * @throws AlimentoInterfaceException
     */
    @Override
    public Collection<Alimento> getAlimentoPorCaloriasMinimo(String menor) throws AlimentoInterfaceException {
        List<Alimento> alimentos = null;
        try {
            LOGGER.info("AlimentoInterface: Finding all alimentos from REST service (XML).");
            alimentos = webClient.getAlimentoPorCaloriasMinimo_XML(new GenericType<List<Alimento>>() {
            }, menor);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "Alimento: Exception finding all alimentos, {0}",
                    ex.getMessage());
            throw new AlimentoInterfaceException("Error finding all Alimentos:\n" + ex.getMessage());
        }
        return alimentos;
    }

    /**
     * Busca Alimentos que sean menor
     * @param menor
     * @return
     * @throws AlimentoInterfaceException
     */
    @Override
    public Collection<Alimento> getAlimentoPorProteinasMinimo(String menor) throws AlimentoInterfaceException {
        List<Alimento> alimentos = null;
        try {
            LOGGER.info("AlimentoInterface: Finding all alimentos from REST service (XML).");
            alimentos = webClient.getAlimentoPorProteinasMinimo_XML(new GenericType<List<Alimento>>() {
            }, menor);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "Alimento: Exception finding all alimentos, {0}",
                    ex.getMessage());
            throw new AlimentoInterfaceException("Error finding all Alimentos:\n" + ex.getMessage());
        }
        return alimentos;
    }

    /**
     * Busca Alimentos que sean menor
     * @param menor
     * @return
     * @throws AlimentoInterfaceException
     */
    @Override
    public Collection<Alimento> getAlimentoPorGrasasMinimo(String menor) throws AlimentoInterfaceException {
        List<Alimento> alimentos = null;
        try {
            LOGGER.info("AlimentoInterface: Finding all alimentos from REST service (XML).");
            alimentos = webClient.getAlimentoPorGrasasMinimo_XML(new GenericType<List<Alimento>>() {
            }, menor);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "Alimento: Exception finding all alimentos, {0}",
                    ex.getMessage());
            throw new AlimentoInterfaceException("Error finding all Alimentos:\n" + ex.getMessage());
        }
        return alimentos;
    }

    /**
     * Busca Alimentos que esten entre el minimo y maximo puesto
     * @param min
     * @param max
     * @return
     * @throws AlimentoInterfaceException
     */
    @Override
    public Collection<Alimento> getAlimentoPorCaloriasEntre(String min, String max) throws AlimentoInterfaceException {
        List<Alimento> alimentos = null;
        try {
            LOGGER.info("AlimentoInterface: Finding all alimentos from REST service (XML).");
            alimentos = webClient.getAlimentoPorCaloriasEntre_XML(new GenericType<List<Alimento>>() {
            }, min, max);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "Alimento: Exception finding all alimentos, {0}",
                    ex.getMessage());
            throw new AlimentoInterfaceException("Error finding all Alimentos:\n" + ex.getMessage());
        }
        return alimentos;
    }

    /**
     * Busca Alimentos que esten entre el minimo y maximo puesto
     * @param min
     * @param max
     * @return
     * @throws AlimentoInterfaceException
     */
    @Override
    public Collection<Alimento> getAlimentoPorProteinasEntre(String min, String max) throws AlimentoInterfaceException {
        List<Alimento> alimentos = null;
        try {
            LOGGER.info("AlimentoInterface: Finding all alimentos from REST service (XML).");
            alimentos = webClient.getAlimentoPorCaloriasEntre_XML(new GenericType<List<Alimento>>() {
            }, min, max);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "Alimento: Exception finding all alimentos, {0}",
                    ex.getMessage());
            throw new AlimentoInterfaceException("Error finding all Alimentos:\n" + ex.getMessage());
        }
        return alimentos;
    }

    /**
     * Busca Alimentos que esten entre el minimo y maximo puesto
     * @param min
     * @param max
     * @return
     * @throws AlimentoInterfaceException
     */
    @Override
    public Collection<Alimento> getAlimentoPorGrasasEntre(String min, String max) throws AlimentoInterfaceException {
        List<Alimento> alimentos = null;
        try {
            LOGGER.info("AlimentoInterface: Finding all alimentos from REST service (XML).");
            alimentos = webClient.getAlimentoPorGrasasEntre_XML(new GenericType<List<Alimento>>() {
            }, min, max);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "Alimento: Exception finding all alimentos, {0}",
                    ex.getMessage());
            throw new AlimentoInterfaceException("Error finding all Alimentos:\n" + ex.getMessage());
        }
        return alimentos;
    }

    /**
     * Busca Alimentos que esten entre el minimo y maximo puesto
     * @param min
     * @param max
     * @return
     * @throws AlimentoInterfaceException
     */
    @Override
    public Collection<Alimento> getAlimentoPorCarbohidratosEntre(String min, String max) throws AlimentoInterfaceException {
        List<Alimento> alimentos = null;
        try {
            LOGGER.info("AlimentoInterface: Finding all alimentos from REST service (XML).");
            alimentos = webClient.getAlimentoPorCarbohidratosEntre_XML(new GenericType<List<Alimento>>() {
            }, min, max);
        } catch (WebApplicationException ex) {
            LOGGER.log(Level.SEVERE,
                    "Alimento: Exception finding all alimentos, {0}",
                    ex.getMessage());
            throw new AlimentoInterfaceException("Error finding all Alimentos:\n" + ex.getMessage());
        }
        return alimentos;
    }

}
