/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.Alimento;
import exceptions.AlimentoInterfaceException;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author josue
 */
public class AlimentoTestDataGenerator implements AlimentoInterface {

    private static final Logger LOGGER = Logger.getLogger("javafxapplicationud3example");
    // List for storing users data.
    private List<Alimento> alimentos;

    @Override
    public Collection<Alimento> getAllAlimento() throws AlimentoInterfaceException {
        LOGGER.info("Getting all fake alimentoss data for UI.");
        return alimentos;
    }

    @Override
    public void crearAlimento(Alimento alimento) throws AlimentoInterfaceException {
        alimentos.add(alimento);
    }

    @Override
    public void actualizarAlimento(Alimento user) throws AlimentoInterfaceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public Alimento getAlimentoPorId(String idAlimento) throws AlimentoInterfaceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Alimento getAlimentoPorNombre(String nombreAlimento) throws AlimentoInterfaceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarAlimento(String idAlimento) throws AlimentoInterfaceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Alimento> getAlimentoPorTipo(String tipo) throws AlimentoInterfaceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Alimento> getAlimentoPorCarbohidratosSuperior(String superior) throws AlimentoInterfaceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Alimento> getAlimentoPorCaloriasSuperior(String superior) throws AlimentoInterfaceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Alimento> getAlimentoPorProteinasSuperior(String superior) throws AlimentoInterfaceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Alimento> getAlimentoPorGrasasSuperior(String superior) throws AlimentoInterfaceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Alimento> getAlimentoPorCarbohidratosMinimo(String menor) throws AlimentoInterfaceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Alimento> getAlimentoPorCaloriasMinimo(String menor) throws AlimentoInterfaceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Alimento> getAlimentoPorProteinasMinimo(String menor) throws AlimentoInterfaceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Alimento> getAlimentoPorGrasasMinimo(String menor) throws AlimentoInterfaceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Alimento> getAlimentoPorCaloriasEntre(String min, String max) throws AlimentoInterfaceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Alimento> getAlimentoPorProteinasEntre(String min, String max) throws AlimentoInterfaceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Alimento> getAlimentoPorGrasasEntre(String min, String max) throws AlimentoInterfaceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Alimento> getAlimentoPorCarbohidratosEntre(String min, String max) throws AlimentoInterfaceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
