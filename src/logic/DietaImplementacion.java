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
    
    @Override
    public void crearDieta(Dieta dieta) {
        this.webDieta.create_XML(dieta);
        
    }

    @Override
    public void eliminarDieta(Dieta dieta) {
        this.webDieta.remove(dieta.getIdDieta());
    }

    @Override
    public void modificarDieta(Dieta dieta) {
        this.webDieta.edit_XML(dieta);
    }

    @Override
    public Dieta getDietaoPorNombre(String nombreDieta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dieta getDietaoPorId(String idDieta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Dieta> getDietaPorTipo(TipoDieta tipoDieta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Dieta> getDietaPorTiempoMinimo(Integer tiempo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Dieta> getDietaPorTiempoMaximo(Integer tiempo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Dieta> getDietaPorTiempoEntre(Integer tiempoMax, Integer tiempoMin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Dieta> getDietaPorObjetivo(Objetivo OBJETIVO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Dieta> getDietaAll() {
        Collection<Dieta> dietas = null;
        dietas = this.webDieta.findAll_XML(new GenericType<List<Dieta>>() {});
        return dietas;
    }
    
}
