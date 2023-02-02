/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Usuario;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author josue
 */
public class ControladorAlimentoTablaTest {
    
    public ControladorAlimentoTablaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getStage method, of class ControladorAlimentoTabla.
     */
    @Test
    public void testGetStage() {
        System.out.println("getStage");
        ControladorAlimentoTabla instance = new ControladorAlimentoTabla();
        Stage expResult = null;
        Stage result = instance.getStage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStage method, of class ControladorAlimentoTabla.
     */
    @Test
    public void testSetStage() {
        System.out.println("setStage");
        Stage stage = null;
        ControladorAlimentoTabla instance = new ControladorAlimentoTabla();
        instance.setStage(stage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initStage method, of class ControladorAlimentoTabla.
     */
    @Test
    public void testInitStage_Parent() {
        System.out.println("initStage");
        Parent root = null;
        ControladorAlimentoTabla instance = new ControladorAlimentoTabla();
        instance.initStage(root);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initStage method, of class ControladorAlimentoTabla.
     */
    @Test
    public void testInitStage_Parent_Usuario() {
        System.out.println("initStage");
        Parent root = null;
        Usuario usuario = null;
        ControladorAlimentoTabla instance = new ControladorAlimentoTabla();
        instance.initStage(root, usuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hadleBotonVolver method, of class ControladorAlimentoTabla.
     */
    @Test
    public void testHadleBotonVolver() {
        System.out.println("hadleBotonVolver");
        ActionEvent event = null;
        ControladorAlimentoTabla instance = new ControladorAlimentoTabla();
        instance.hadleBotonVolver(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hadleBotonInforme method, of class ControladorAlimentoTabla.
     */
    @Test
    public void testHadleBotonInforme() {
        System.out.println("hadleBotonInforme");
        ActionEvent event = null;
        ControladorAlimentoTabla instance = new ControladorAlimentoTabla();
        instance.hadleBotonInforme(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hadleBotonAnadir method, of class ControladorAlimentoTabla.
     */
    @Test
    public void testHadleBotonAnadir() {
        System.out.println("hadleBotonAnadir");
        ActionEvent event = null;
        ControladorAlimentoTabla instance = new ControladorAlimentoTabla();
        instance.hadleBotonAnadir(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hadleBotonFiltrar method, of class ControladorAlimentoTabla.
     */
    @Test
    public void testHadleBotonFiltrar() {
        System.out.println("hadleBotonFiltrar");
        ActionEvent event = null;
        ControladorAlimentoTabla instance = new ControladorAlimentoTabla();
        instance.hadleBotonFiltrar(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onlyNumbers method, of class ControladorAlimentoTabla.
     */
    @Test
    public void testOnlyNumbers() {
        System.out.println("onlyNumbers");
        String input = "";
        boolean expResult = false;
        boolean result = ControladorAlimentoTabla.onlyNumbers(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
