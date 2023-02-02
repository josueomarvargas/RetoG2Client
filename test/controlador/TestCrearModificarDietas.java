/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testDietas;

import entities.Dieta;
import java.util.concurrent.TimeoutException;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isDisabled;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import retog2client.RetoG2Client;

/**
 *
 * @author Gonzalo
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestCrearModificarDietas extends ApplicationTest {

    private TableView table = table = lookup("#tbViewDieta").query();
    private Dieta dieta;
    private TextField txtNombre ;
    private TextField txtTiempo ;
    private ComboBox comboTipo;

    @BeforeClass
    public static void setUpClass() throws TimeoutException {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(RetoG2Client.class);
    }

    @Test
    public void test01_AbrirVentana() {
        clickOn("#BtnDietCrear");
        verifyThat("#crearModificarDieta", isVisible());
        clickOn("#BtnCancelarMod");
    }

    @Test
    public void test02_DatosModificar() {        
        table.getSelectionModel().select(0);
        clickOn("#BtnDietMod");
        clickOn("#txtNombre");
        txtNombre = lookup("#txtNombre").query();
        txtTiempo = lookup("#txtTiempo").query();
        comboTipo = lookup("#comboTipo").query();
        assertEquals(txtNombre.getText(), "ElCucurucho");
        assertEquals(txtTiempo.getText(), "1");
        assertEquals(comboTipo.getSelectionModel().getSelectedItem().toString(), "VEGETARIANA");
        clickOn("#BtnCancelarMod");
    }
    
    @Test
    public void test03_CrearDieta() {        
        clickOn("#BtnDietCrear");
        clickOn("#txtNombre");
        write("Prueba");
        clickOn("#txtTiempo");
        write("8");
        clickOn("#comboTipo");
        type(KeyCode.DOWN);
        clickOn("#comboObjetivo");
        type(KeyCode.DOWN);
        clickOn("#btnCrear");

        
    }
    
    @Test
    public void test04_ComprobarCreacion(){
        clickOn("#txtFieldNombre");
        write("Prueba");
        clickOn("#BtnDietFilt");
        verifyThat("#txtFieldTiempoMin", isDisabled());
        table.getSelectionModel().select(0);
        dieta = (Dieta) table.getSelectionModel().getSelectedItem();
        assertEquals(dieta.getNombre(), "Prueba");
    }
    
    @Test
    public void test05_ModificarDieta(){
        clickOn("#BtnDietMod");
        doubleClickOn("#txtNombre");
        eraseText(1);
        write("modificada");
        doubleClickOn("#txtTiempo");
        eraseText(1);
        write("2");
        clickOn("#comboTipo");
        type(KeyCode.DOWN);
        clickOn("#comboObjetivo");
        type(KeyCode.DOWN);
        type(KeyCode.DOWN);
        clickOn("#btnModificar");
    }
    
    @Test
    public void test06_ComprobarModificacion(){
        clickOn("#txtFieldNombre");
        write("modificada");
        clickOn("#BtnDietFilt");
        verifyThat("#txtFieldTiempoMin", isDisabled());
        table.getSelectionModel().select(0);
        dieta = (Dieta) table.getSelectionModel().getSelectedItem();
        assertEquals(dieta.getNombre(), "modificada");
    }
}
