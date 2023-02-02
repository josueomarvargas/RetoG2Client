/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.Alimento;
import exceptions.AlimentoInterfaceException;
import java.util.Collection;

/**
 *
 * @author josue
 */
public interface AlimentoInterface {

    /**
     *
     * @return
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAllAlimento() throws AlimentoInterfaceException;

    /**
     *
     * @param alimento
     * @throws AlimentoInterfaceException
     */
    public void crearAlimento(Alimento alimento) throws AlimentoInterfaceException;

    /**
     *
     * @param alimento
     * @throws AlimentoInterfaceException
     */
    public void actualizarAlimento(Alimento alimento) throws AlimentoInterfaceException;

    /**
     *
     * @param idAlimento
     * @throws AlimentoInterfaceException
     */
    public void eliminarAlimento(String idAlimento) throws AlimentoInterfaceException;

    /**
     *
     * @param idAlimento
     * @return
     * @throws AlimentoInterfaceException
     */
    public Alimento getAlimentoPorId(String idAlimento) throws AlimentoInterfaceException;

    /**
     *
     * @param nombreAlimento
     * @return
     * @throws AlimentoInterfaceException
     */
    public Alimento getAlimentoPorNombre(String nombreAlimento) throws AlimentoInterfaceException;

    /**
     *
     * @param tipo
     * @return
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorTipo(String tipo) throws AlimentoInterfaceException;

    /**
     *
     * @param superior
     * @return
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorCarbohidratosSuperior(String superior) throws AlimentoInterfaceException;

    /**
     *
     * @param superior
     * @return
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorCaloriasSuperior(String superior) throws AlimentoInterfaceException;

    /**
     *
     * @param superior
     * @return
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorProteinasSuperior(String superior) throws AlimentoInterfaceException;

    /**
     *
     * @param superior
     * @return
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorGrasasSuperior(String superior) throws AlimentoInterfaceException;

    /**
     *
     * @param menor
     * @return
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorCarbohidratosMinimo(String menor) throws AlimentoInterfaceException;

    /**
     *
     * @param menor
     * @return
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorCaloriasMinimo(String menor) throws AlimentoInterfaceException;

    /**
     *
     * @param menor
     * @return
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorProteinasMinimo(String menor) throws AlimentoInterfaceException;

    /**
     *
     * @param menor
     * @return
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorGrasasMinimo(String menor) throws AlimentoInterfaceException;

    /**
     *
     * @param min
     * @param max
     * @return
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorCaloriasEntre(String min, String max) throws AlimentoInterfaceException;

    /**
     *
     * @param min
     * @param max
     * @return
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorProteinasEntre(String min, String max) throws AlimentoInterfaceException;

    /**
     *
     * @param min
     * @param max
     * @return
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorGrasasEntre(String min, String max) throws AlimentoInterfaceException;

    /**
     *
     * @param min
     * @param max
     * @return
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorCarbohidratosEntre(String min, String max) throws AlimentoInterfaceException;

}
