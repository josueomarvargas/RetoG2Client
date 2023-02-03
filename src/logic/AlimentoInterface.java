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
 *Interface Alimento
 * @author josue
 */
public interface AlimentoInterface {

    /**
     * Busca todos los Alimentos y los guarda en una lista
     * @return Collection
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAllAlimento() throws AlimentoInterfaceException;

    /**
     * Crea Un Alimento
     * @param alimento Alimento
     * @throws AlimentoInterfaceException
     */
    public void crearAlimento(Alimento alimento) throws AlimentoInterfaceException;

    /**
     * Actualiza un Alimento
     * @param alimento Alimento
     * @throws AlimentoInterfaceException
     */
    public void actualizarAlimento(Alimento alimento) throws AlimentoInterfaceException;

    /**
     * Elimina un alimento por su IdAlimento
     * @param idAlimento String
     * @throws AlimentoInterfaceException
     */
    public void eliminarAlimento(String idAlimento) throws AlimentoInterfaceException;

    /**
     * Busca un Alimento por su IdAlimento
     * @param idAlimento String
     * @return Alimento
     * @throws AlimentoInterfaceException
     */
    public Alimento getAlimentoPorId(String idAlimento) throws AlimentoInterfaceException;

    /**
     * Busca un Alimento por su nombre
     * @param nombreAlimento String
     * @return Alimento 
     * @throws AlimentoInterfaceException
     */
    public Alimento getAlimentoPorNombre(String nombreAlimento) throws AlimentoInterfaceException;

    /**
     * Busca Alimentos por su tipo
     * @param tipo String
     * @return Collection
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorTipo(String tipo) throws AlimentoInterfaceException;

    /**
     * Busca Alimentos que sean superior
     * @param superior String
     * @return Collection
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorCarbohidratosSuperior(String superior) throws AlimentoInterfaceException;

    /**
     * Busca Alimentos que sean superior
     * @param superior String
     * @return Collection
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorCaloriasSuperior(String superior) throws AlimentoInterfaceException;

    /**
     * Busca Alimentos que sean superior
     * @param superior String
     * @return Collection
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorProteinasSuperior(String superior) throws AlimentoInterfaceException;

    /**
     * Busca Alimentos que sean superior
     * @param superior String
     * @return Collection
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorGrasasSuperior(String superior) throws AlimentoInterfaceException;

    /**
     * Busca Alimentos que sean menor
     * @param menor String
     * @return Collection
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorCarbohidratosMinimo(String menor) throws AlimentoInterfaceException;

    /**
     * Busca Alimentos que sean menor
     * @param menor String
     * @return Collection
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorCaloriasMinimo(String menor) throws AlimentoInterfaceException;

    /**
     * Busca Alimentos que sean menor
     * @param menor String
     * @return Collection
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorProteinasMinimo(String menor) throws AlimentoInterfaceException;

    /**
     * Busca Alimentos que sean menor
     * @param menor String
     * @return Collection
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorGrasasMinimo(String menor) throws AlimentoInterfaceException;

    /**
     * Busca Alimentos que esten entre el minimo y maximo puesto
     * @param min String
     * @param max String
     * @return Collection
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorCaloriasEntre(String min, String max) throws AlimentoInterfaceException;

    /**
     * Busca Alimentos que esten entre el minimo y maximo puesto
     * @param min String
     * @param max String
     * @return Collection
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorProteinasEntre(String min, String max) throws AlimentoInterfaceException;

    /**
     * Busca Alimentos que esten entre el minimo y maximo puesto
     * @param min String
     * @param max String
     * @return Collection
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorGrasasEntre(String min, String max) throws AlimentoInterfaceException;

    /**
     * Busca Alimentos que esten entre el minimo y maximo puesto
     * @param min String
     * @param max String
     * @return Collection
     * @throws AlimentoInterfaceException
     */
    public Collection<Alimento> getAlimentoPorCarbohidratosEntre(String min, String max) throws AlimentoInterfaceException;

}
