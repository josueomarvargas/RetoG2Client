/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.Dieta;
import entities.Objetivo;
import entities.TipoDieta;
import java.util.Collection;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Gonzalo
 */
public interface InterfaceDietaClie {

    /**
     * El metodo creara las dietas que seran guardadas en la base de datos
     *
     * @param dieta Es un Objeto de la entidad de Dieta que contiene datos
     */
    public void crearDieta(Dieta dieta);

    /**
     * Este metodo elimina las dietas que existen la base de datos
     *
     * @param dieta Es un Objecto de la entidad Dieta que contiene los datos
     * para eliminar de la base de Datos
     */
    public void eliminarDieta(Dieta dieta);

    /**
     * Este metodo Actualiza o cambia los datos de alimentos creados en la base
     * de datos
     *
     * @param dieta es un Objeto de la entidad alimento que contiene los datos
     * para actualizarlo de la base de datos *      *
     */
    public void modificarDieta(Dieta dieta);

    /**
     * Este metodo busca el alimento por su nombre y lo guarda en un objeto de
     * la Entidad alimento
     *
     * @param nombreDieta Un String de Alimento
     * @return Devuelve un Objecto de la Entidad alimento * @throws
     * excepciones.ReadException se lanza cuando ocurre un error en la busqueda
     * del objeto alimento en la base de datos
     */
    public Dieta getDietaoPorNombre(String nombreDieta);

    /**
     * Este metodo busca el alimento por su nombre y lo guarda en un objeto de
     * la Entidad alimento
     *
     * @param idDieta Un String de Alimento
     * @return Devuelve un Objecto de la Entidad alimento
     *
     */
    public Dieta getDietaoPorId(String idDieta);

    /**
     * Este metodo busca por su tipo de Alimento y guarda en una lista todos los
     * alimentos encontrados
     *
     * @param tipoDieta Es una Enumacion
     * @return Devuelve una lista de la entidad Alimento
     *
     */
    public Collection<Dieta> getDietaPorTipo(TipoDieta tipoDieta);

    /**
     * Este metodo busca por el tiempo de la Dieta, en este caso en funcion a un
     * minimo
     *
     * @param tiempo es un Integer
     * @return Devuelve una lista de Dietas
     */
    public Collection<Dieta> getDietaPorTiempoMinimo(Integer tiempo);

    /**
     * Este metodo busca por el tiempo de la Dieta, en este caso en funcion de
     * un maximo
     *
     * @param tiempo es un Integer
     * @return Decuelve una lista de dietas
     */
    public Collection<Dieta> getDietaPorTiempoMaximo(Integer tiempo);

    /**
     * Este metodo busca por el tiempo de la Dieta, en este caso entre un minimo
     * y un maximo
     *
     * @param tiempoMax es un Integer
     * @param tiempoMin es un Integer
     * @return Decuelve una lista de dietas
     *
     */
    public Collection<Dieta> getDietaPorTiempoEntre(Integer tiempoMax, Integer tiempoMin);

    /**
     * Este metodo busca por el Objetivo de la Dieta
     *
     * @param OBJETIVO es una Enumeation
     * @return
     *
     */
    public Collection<Dieta> getDietaPorObjetivo(Objetivo OBJETIVO);

    /**
     * Este metodo muestra todas las Dietas existentes
     *
     * @return
     *
     */
    public Collection<Dieta> getDietaAll();

}
