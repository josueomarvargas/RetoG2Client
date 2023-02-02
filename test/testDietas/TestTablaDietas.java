/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testDietas;

import entities.Dieta;
import java.util.concurrent.TimeoutException;
import javafx.scene.control.TableView;
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
import static org.testfx.matcher.control.LabeledMatchers.hasText;
import retog2client.RetoG2Client;

/**
 *
 * @author Gonzalo
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestTablaDietas extends ApplicationTest {

    private TableView table = table = lookup("#tbViewDieta").query();
    private Dieta dieta = new Dieta();

    @BeforeClass
    public static void setUpClass() throws TimeoutException {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(RetoG2Client.class);
    }

    @Test
    public void test01_AbrirVentana() {
        verifyThat("#TablaDietas", isVisible());
    }

    @Test
    public void test02_EstadoVentana() {
        verifyThat("#txtFieldNombre", isEnabled());
        verifyThat("#txtFieldTiempoMin", isEnabled());
        verifyThat("#txtFieldTiempoMax", isEnabled());
        verifyThat("#rButtonVegetariana", isEnabled());
        verifyThat("#rButtonVegana", isEnabled());
        verifyThat("#rButtonOmnivora", isEnabled());
        verifyThat("#rButtonSubirPeso", isEnabled());
        verifyThat("#rButtonBajarPeso", isEnabled());
    }

    @Test
    public void test03_BotonCrear() {
        clickOn("#BtnDietCrear");
        verifyThat("#crearModificarDieta", isVisible());
        clickOn("#BtnCancelarMod");
    }

    @Test
    public void test04_BotonModificarEnable() {
        table.getSelectionModel().select(0);
        verifyThat("#BtnDietMod", isEnabled());
    }

    @Test
    public void test05_BotonModificar() {
        clickOn("#BtnDietMod");
        verifyThat("#crearModificarDieta", isVisible());
        clickOn("#BtnCancelarMod");
    }

    @Test
    public void test06_BotonFiltroNombre() {
        clickOn("#txtFieldNombre");
        write("no");
        clickOn("#BtnDietFilt");
        verifyThat("#txtFieldTiempoMin", isDisabled());
        verifyThat("#txtFieldTiempoMax", isDisabled());
        verifyThat("#rButtonVegetariana", isDisabled());
        verifyThat("#rButtonVegana", isDisabled());
        verifyThat("#rButtonOmnivora", isDisabled());
        verifyThat("#rButtonSubirPeso", isDisabled());
        verifyThat("#rButtonBajarPeso", isDisabled());
        table.getSelectionModel().select(0);
        dieta = (Dieta) table.getSelectionModel().getSelectedItem();
        assertEquals(dieta.getNombre(), "no");
        clickOn("#BtnResetearFiltro");

    }

    @Test
    public void test07_BotonFiltroTiempoMin() {
        clickOn("#txtFieldTiempoMin");
        write("54");
        clickOn("#BtnDietFilt");
        verifyThat("#txtFieldNombre", isDisabled());
        verifyThat("#txtFieldTiempoMax", isDisabled());
        verifyThat("#rButtonVegetariana", isDisabled());
        verifyThat("#rButtonVegana", isDisabled());
        verifyThat("#rButtonOmnivora", isDisabled());
        verifyThat("#rButtonSubirPeso", isDisabled());
        verifyThat("#rButtonBajarPeso", isDisabled());
        table.getSelectionModel().select(0);
        dieta = (Dieta) table.getSelectionModel().getSelectedItem();
        assertEquals(dieta.getTiempo().toString(), "54");
        clickOn("#BtnResetearFiltro");

    }

    @Test
    public void test08_BotonFiltroTiempoMax() {
        clickOn("#txtFieldTiempoMax");
        write("54");
        clickOn("#BtnDietFilt");
        verifyThat("#txtFieldNombre", isDisabled());
        verifyThat("#txtFieldTiempoMin", isDisabled());
        verifyThat("#rButtonVegetariana", isDisabled());
        verifyThat("#rButtonVegana", isDisabled());
        verifyThat("#rButtonOmnivora", isDisabled());
        verifyThat("#rButtonSubirPeso", isDisabled());
        verifyThat("#rButtonBajarPeso", isDisabled());
        table.getSelectionModel().select(0);
        dieta = (Dieta) table.getSelectionModel().getSelectedItem();
        assertEquals(dieta.getTiempo().toString(), "54");
        clickOn("#BtnResetearFiltro");

    }

    @Test
    public void test09_BotonFiltroVegetariana() {
        clickOn("#rButtonVegetariana");
        clickOn("#BtnDietFilt");
        verifyThat("#txtFieldNombre", isDisabled());
        verifyThat("#txtFieldTiempoMin", isDisabled());
        verifyThat("#rButtonSubirPeso", isDisabled());
        verifyThat("#rButtonBajarPeso", isDisabled());
        table.getSelectionModel().select(0);
        dieta = (Dieta) table.getSelectionModel().getSelectedItem();
        assertEquals(dieta.getTipo().toString(), "VEGETARIANA");
        
        clickOn("#rButtonVegana");
        clickOn("#BtnDietFilt");
        table.getSelectionModel().select(0);
        dieta = (Dieta) table.getSelectionModel().getSelectedItem();
        assertEquals(dieta.getTipo().toString(), "VEGANA");
        
        clickOn("#rButtonOmnivora");
        clickOn("#BtnDietFilt");
        table.getSelectionModel().select(0);
        dieta = (Dieta) table.getSelectionModel().getSelectedItem();
        assertEquals(dieta.getTipo().toString(), "OMNIVORO");
        
        clickOn("#BtnResetearFiltro");

    }

}
