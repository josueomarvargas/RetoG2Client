/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package aplicacion;

import controller.ControladorAlimentoTabla;
import controller.ControladorDatosAlimento;
import controller.ControladorInicioSesion;
import controller.ControladorMenuDietista;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 *
 * @author josue
 */
public class Principal extends Application {

//Creation of the Main window
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Link the fxml file to the loader and upload it to root 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InicioSesion.fxml"));
        Parent root = loader.load();
        //Initialize the SignIn Controller to send the primaryStage and root.
        ControladorInicioSesion controlador = loader.getController();
        controlador.setStage(primaryStage);
        controlador.initStage(root);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
