/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retog2client;

import controller.Controler_TablaDietas;
import controller.Controller_MenuAdmin;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author josue
 */
public class RetoG2Client extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TablaDietas.fxml"));
        Parent root = loader.load();
        //Initialize the SignIn Controller to send the primaryStage and root.
        Controler_TablaDietas controlador = loader.getController();
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
