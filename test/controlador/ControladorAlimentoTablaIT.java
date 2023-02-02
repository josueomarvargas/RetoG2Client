/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import aplicacion.Principal;
import com.sun.management.jmx.Trace;
import entities.Alimento;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logic.AlimentoInterface;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.util.NodeQueryUtils.isVisible;

/**
 *
 * @author josue
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControladorAlimentoTablaIT extends ApplicationTest {

    /**
     * private static final String
     * OVERSIZED_TEXT="XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"+
     * "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"+ "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"+
     * "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"+ "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"+
     * "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"+ "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"+
     * "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
     */
    @Override
    public void start(Stage stage) throws Exception {
        new Principal().start(stage);

//   FieldLogin   = (TextField) lookup("#txtFieldLogin");
    }

    /* @Test
    public void test1_BotonesHabilitados() {
             clickOn("#nombreAccesoText");

        write("JON987");
        clickOn("#passText");
        write("abcd*1234");
        clickOn("#entrarBoton");
        clickOn("ALIMENTOS");
        clickOn("VER ALIMENTOS");
        verifyThat("#filtrarBoton", isEnabled());
        verifyThat("#modificarBoton", isEnabled());
        verifyThat("#anadirBoton", isEnabled());
        verifyThat("#volverBoton", isEnabled());

    }
     
        @Test
    public void test2_ErrorModificarFilaNoSeleccionada() {
                  clickOn("#nombreAccesoText");
       write("JON987");
        clickOn("#passText");
        write("abcd*1234");
        clickOn("#entrarBoton");
        clickOn("ALIMENTOS");
        clickOn("VER ALIMENTOS");
        clickOn("#modificarBoton");
        verifyThat("Selecciona un Alimento de la tabla",isVisible());
        clickOn("Aceptar");
    }
    
     
    @Test
    public void test2_ModificarFilaSeleccionada() {
                 clickOn("#nombreAccesoText");
write("JON987");
        clickOn("#passText");
        write("abcd*1234");
        clickOn("#entrarBoton");
        clickOn("ALIMENTOS");
        clickOn("VER ALIMENTOS");
        clickOn("#filtrarBoton");
        Node row = lookup(".table-row-cell").nth(0).query();
        clickOn(row);
        clickOn("#modificarBoton");
    }
    
        @Test
    public void test3_AnadirAlimento() {
                 clickOn("#nombreAccesoText");
write("JON987");
        clickOn("#passText");
        write("abcd*1234");
        clickOn("#entrarBoton");
        clickOn("ALIMENTOS");
        clickOn("VER ALIMENTOS");
        clickOn("#anadirBoton");
    }
  
            @Test
    public void test4_volverAlimento() {
                 clickOn("#nombreAccesoText");
write("JON987");
        clickOn("#passText");
        write("abcd*1234");
        clickOn("#entrarBoton");
        clickOn("ALIMENTOS");
        clickOn("VER ALIMENTOS");
        clickOn("#volverBoton");
    }
     
    @Test
    public void test5_FiltrarNombre() {
                clickOn("#nombreAccesoText");
 write("JON987");
        clickOn("#passText");
        write("abcd*1234");
        clickOn("#entrarBoton");
        clickOn("ALIMENTOS");
        clickOn("VER ALIMENTOS");
        clickOn("#nombreText");
        write("bollo");
        clickOn("#filtrarBoton");
        Node row = lookup(".table-row-cell").nth(0).query();
        assertNotNull("Row is null: table has not that row. ", row);
        clickOn(row);
    }
    @Test
    public void test6_FiltrarNombreVacio() {
                clickOn("#nombreAccesoText");
 write("JON987");
        clickOn("#passText");
        write("abcd*1234");
        clickOn("#entrarBoton");
        clickOn("ALIMENTOS");
        clickOn("VER ALIMENTOS");
        clickOn("#nombreText");
        write("bollo65");
        clickOn("#filtrarBoton");
        Node row = lookup(".table-row-cell").nth(0).query();
        assertNotNull(row);
        clickOn(row); 
    }
   
        @Test
    public void test6_FiltrarMenor() {
                 clickOn("#nombreAccesoText");
write("JON987");
        clickOn("#passText");
        write("abcd*1234");
        clickOn("#entrarBoton");
        clickOn("ALIMENTOS");
        clickOn("VER ALIMENTOS");
        clickOn("#menorText");
        write("11");
        clickOn("#filtrarBoton");
        Node row = lookup(".table-row-cell").nth(0).query();
        assertNotNull("Row is null: table has not that row. ", row);
        clickOn(row);
    }
            @Test
    public void test7_FiltrarMayor() {
                 clickOn("#nombreAccesoText");
write("JON987");
        clickOn("#passText");
        write("abcd*1234");
        clickOn("#entrarBoton");
        clickOn("ALIMENTOS");
        clickOn("VER ALIMENTOS");
        clickOn("#mayorText");
        write("11");
        clickOn("#filtrarBoton");
        Node row = lookup(".table-row-cell").nth(0).query();
        assertNotNull("Row is null: table has not that row. ", row);
        clickOn(row);
    }
                @Test
    public void test8_FiltrarEntre() {
                 clickOn("#nombreAccesoText");
write("JON987");
        clickOn("#passText");
        write("abcd*1234");
        clickOn("#entrarBoton");
        clickOn("ALIMENTOS");
        clickOn("VER ALIMENTOS");
        clickOn("#minText");
        write("8");
        clickOn("#maxText");
        write("11");
        clickOn("#filtrarBoton");
        Node row = lookup(".table-row-cell").nth(0).query();
        assertNotNull("Row is null: table has not that row. ", row);
        clickOn(row);
    }
                @Test
    public void test9_FiltrarEntreAlReves() {
                 clickOn("#nombreAccesoText");
write("JON987");
        clickOn("#passText");
        write("abcd*1234");
        clickOn("#entrarBoton");
        clickOn("ALIMENTOS");
        clickOn("VER ALIMENTOS");
        clickOn("#minText");
        write("11");
        clickOn("#maxText");
        write("8");
        clickOn("#filtrarBoton");
        Node row = lookup(".table-row-cell").nth(0).query();
        assertNotNull("Row is null: table has not that row. ", row);
        clickOn(row);
    }
                @Test
    public void test11_FiltrarTipo() {
                 clickOn("#nombreAccesoText");
write("JON987");
        clickOn("#passText");
        write("abcd*1234");
        clickOn("#entrarBoton");
        clickOn("ALIMENTOS");
        clickOn("VER ALIMENTOS");
        clickOn("#tipoComboBox");
        clickOn("CEREAL");
        clickOn("#filtrarBoton");
        Node row = lookup(".table-row-cell").nth(0).query();
        assertNotNull("Row is null: table has not that row. ", row);
        clickOn(row);
    }
   
                @Test
    public void test12_FiltrarTipoFitro() {
                 clickOn("#nombreAccesoText");
write("JON987");
        clickOn("#passText");
        write("abcd*1234");
        clickOn("#entrarBoton");
        clickOn("ALIMENTOS");
        clickOn("VER ALIMENTOS");
        clickOn("#filtrarCBox");
        clickOn("Grasas Totales");
        clickOn("#menorText");
         write("12");
        clickOn("#filtrarBoton");

    } */
    @Test
    public void test13_FiltrarSinValores() {
        clickOn("#nombreAccesoText");
        write("JON987");
        clickOn("#passText");
        write("abcd*1234");
        clickOn("#entrarBoton");
        clickOn("ALIMENTOS");
        clickOn("VER ALIMENTOS");
        clickOn("#filtrarBoton");

    }

}
