/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import aplicacion.Principal;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

/**
 *
 * @author josue
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ControladorDatosAlimentoIT extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        new Principal().start(stage);

//   FieldLogin   = (TextField) lookup("#txtFieldLogin");
    }/*
         @Test
    public void test1_BotonesHabilitados() {
         clickOn("#nombreAccesoText");
        write("JON987");
        clickOn("#passText");
        write("abcd*1234");
        clickOn("#entrarBoton");
        clickOn("ALIMENTOS");
        clickOn("CREAR ALIMENTOS");
        verifyThat("#crearBoton", isEnabled());
        verifyThat("#volverBoton", isEnabled());

    }
    @Test
    public void test2_ErrorCampoVacio() {
                 clickOn("#nombreAccesoText");
        write("JON987");
        clickOn("#passText");
        write("abcd*1234");
        clickOn("#entrarBoton");
        clickOn("ALIMENTOS");
        clickOn("CREAR ALIMENTOS");
        clickOn("#idText");
        write("A-008");
        clickOn("#nombreText");
        write("platano");
        clickOn("#caloriasText");
        write("100");
        clickOn("#grasasText");
        write("5");
        clickOn("#proteinasText");
        write("4");
        clickOn("#carbohidratosText");
        write("");
        clickOn("#tipoComboBox");
        clickOn("FRUTA");
        clickOn("#crearBoton");
        verifyThat("Llena todos los campos con sus Valores Correspondientes",isVisible());
        clickOn("Aceptar");


    }
    
        @Test
    public void test3_ErrorIdExiste() {
        clickOn("#nombreAccesoText");
        write("JON987");
        clickOn("#passText");
        write("abcd*1234");
        clickOn("#entrarBoton");
        clickOn("ALIMENTOS");
        clickOn("CREAR ALIMENTOS");
        clickOn("#idText");
        write("A-001");
        clickOn("#nombreText");
        write("platano");
        clickOn("#caloriasText");
        write("100");
        clickOn("#grasasText");
        write("5");
        clickOn("#proteinasText");
        write("4");
        clickOn("#carbohidratosText");
        write("5");
        clickOn("#tipoComboBox");
        clickOn("FRUTA");
        clickOn("#crearBoton");
        verifyThat("Id Alimento ya Existe",isVisible());
        clickOn("Aceptar");


    }
            @Test
    public void test4_ErrorNombreExiste() {
        clickOn("#nombreAccesoText");
        write("JON987");
        clickOn("#passText");
        write("abcd*1234");
        clickOn("#entrarBoton");
        clickOn("ALIMENTOS");
        clickOn("CREAR ALIMENTOS");
        clickOn("#idText");
        write("A-015");
        clickOn("#nombreText");
        write("bollo");
        clickOn("#caloriasText");
        write("100");
        clickOn("#grasasText");
        write("5");
        clickOn("#proteinasText");
        write("4");
        clickOn("#carbohidratosText");
        write("5");
        clickOn("#tipoComboBox");
        clickOn("CEREAL");
        clickOn("#crearBoton");
        verifyThat("Nombre Alimento ya Existe",isVisible());
        clickOn("Aceptar");
    }
    */
            @Test
    public void test4_ErrorNombreExiste() {
        clickOn("#nombreAccesoText");
        write("JON987");
        clickOn("#passText");
        write("abcd*1234");
        clickOn("#entrarBoton");
        clickOn("ALIMENTOS");
        clickOn("CREAR ALIMENTOS");
        clickOn("#idText");
        write("A-015");
        clickOn("#nombreText");
        write("melocoton");
        clickOn("#caloriasText");
        write("100");
        clickOn("#grasasText");
        write("5");
        clickOn("#proteinasText");
        write("4");
        clickOn("#carbohidratosText");
        write("5");
        clickOn("#tipoComboBox");
        clickOn("FRUTA");
        clickOn("#crearBoton");

    }
}
