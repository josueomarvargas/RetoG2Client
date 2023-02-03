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
import java.util.List;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Gonzalo
 */
public class DietaImplementacion implements InterfaceDietaClie{

    private final DietaRestfulCliente webDieta;
    
    
    public DietaImplementacion(){
        webDieta = new DietaRestfulCliente();
    }
    
    /**
     * El metodo creara las dietas que seran guardadas en la base de datos
     * @param dieta Es un Objeto de la entidad de Dieta que contiene datos
     */
    @Override
    public void crearDieta(Dieta dieta) {
        this.webDieta.create_XML(dieta);
        
    }

    /**
     * Este metodo elimina las dietas que existen la base de datos
     * @param dieta Es un Objecto de la entidad Dieta que contiene los datos
     * para eliminar de la base de Datos
     */
    @Override
    public void eliminarDieta(Dieta dieta) {
        this.webDieta.remove(dieta.getIdDieta());
    }

    /**
     * Este metodo Actualiza o cambia los datos de alimentos creados en la base de datos
     * @param dieta es un Objeto de la entidad alimento que contiene los datos
     * para actualizarlo  de la base de datos 
     */
    @Override
    public void modificarDieta(Dieta dieta) {
        this.webDieta.edit_XML(dieta);
    }

    /**
     * Este metodo busca el alimento por su nombre y lo guarda en un objeto de la Entidad alimento
     * @param nombreDieta Un String de Alimento
     * @return Devuelve un Objecto de la Entidad alimento
     */
    @Override
    public Dieta getDietaoPorNombre(String nombreDieta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Este metodo busca el alimento por su nombre y lo guarda en un objeto de la Entidad alimento
     * @param idDieta Un String de Alimento
     * @return Devuelve un Objecto de la Entidad alimento
     */
    @Override
    public Dieta getDietaoPorId(String idDieta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Este metodo busca por su tipo de Alimento y guarda en una lista todos
     * los alimentos encontrados
     * @param tipoDieta Es una Enumacion
     * @return Devuelve una lista de la entidad Alimento
     */
    @Override
    public Collection<Dieta> getDietaPorTipo(TipoDieta tipoDieta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Este metodo busca por el tiempo de la Dieta, en este caso en funcion a un minimo
     * @param tiempo es un Integer
     * @return Devuelve una lista de Dietas
     */
    @Override
    public Collection<Dieta> getDietaPorTiempoMinimo(Integer tiempo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Este metodo busca por el tiempo de la Dieta, en este caso en funcion de un maximo
     * @param tiempo es un Integer
     * @return Decuelve una lista de dietas
     */
    @Override
    public Collection<Dieta> getDietaPorTiempoMaximo(Integer tiempo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Este metodo busca por el tiempo de la Dieta, en este caso entre un minimo y un maximo
     * @param tiempoMax es un Integer
     * @param tiempoMin es un Integer
     * @return Decuelve una lista de dietas
     */
    @Override
    public Collection<Dieta> getDietaPorTiempoEntre(Integer tiempoMax, Integer tiempoMin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Este metodo busca por el Objetivo de la Dieta
     * @param OBJETIVO es una Enumeation
     * @return Decuelve una lista de dietas
     */
    @Override
    public Collection<Dieta> getDietaPorObjetivo(Objetivo OBJETIVO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Este metodo muestra todas las Dietas existentes
     * @return Decuelve una lista de dietas
     */
    @Override
    public Collection<Dieta> getDietaAll() {
        Collection<Dieta> dietas = null;
        dietas = this.webDieta.findAll_XML(new GenericType<List<Dieta>>() {});
        return dietas;
    }
    
}
