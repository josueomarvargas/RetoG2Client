/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 *
 * @author Gonzalo-
 */
public class Controller_MenuAdmin {

    @FXML
    private Stage stage;
    @FXML
    private MenuBar menubar;
    @FXML
    private MenuItem mnITusDatosAdmin;
    @FXML
    private MenuItem mnICerrarSesionAdmin;
    @FXML
    private MenuItem mnIVerDietistasAdmin;
    @FXML
    private MenuItem mnICrearDietistasAdmin;
    @FXML
    private MenuItem mnIVerClientesAdmin;
    @FXML
    private MenuItem mnICrearClientesAdmin;
    @FXML
    private MenuItem mnIVerRecetasAdmin;
    @FXML
    private MenuItem mnIVerAlimentos;
    @FXML
    private MenuItem mnIVerDietasAdmin;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initStage(Parent root) {

        Scene scene = new Scene(root);
        Stage stage1 = new Stage();
        stage1.setScene(scene);
        stage1.setResizable(false);
        mnITusDatosAdmin.setOnAction(this::handleButtonDatosAdmin);
        mnICerrarSesionAdmin.setOnAction(this::handleButtonSingIn);
        mnIVerDietistasAdmin.setOnAction(this::handleButtonDietistasVer);
        mnICrearDietistasAdmin.setOnAction(this::handleButtonDietistasCrear);
        mnIVerClientesAdmin.setOnAction(this::handleButtonClientesVer);
        mnICrearClientesAdmin.setOnAction(this::handleButtonClientesCrear);
        mnIVerRecetasAdmin.setOnAction(this::handleButtonDatosReceta);
        mnIVerAlimentos.setOnAction(this::handleButtonDatosAlimento);
        mnIVerDietasAdmin.setOnAction(this::handleButtonDatosDieta);
        stage1.setTitle("Inicio");
        stage1.show();
    }

    private void handleButtonDatosAdmin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DatosAdmin.fxml"));
            Parent root = loader.load();
            Controller_DatosAdmin controlador = new Controller_DatosAdmin();
            controlador.setStage(stage);
            controlador.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(Controller_MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleButtonDatosDieta(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TablaDietas.fxml"));
            Parent root = loader.load();
            Controler_TablaDietas controlador = new Controler_TablaDietas();
            controlador.setStage(stage);
            controlador.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(Controller_MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleButtonSingIn(ActionEvent event){
        /*try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TablaDietas.fxml"));
            Parent root = loader.load();
            Controlador_SingIn controlador = new Controlador_SingIn();
            controlador.setStage(stage);
            controlador.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(Controller_MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    private void handleButtonDietistasVer(ActionEvent event){
        /*try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TablaDietista.fxml"));
            Parent root = loader.load();
            Controlador_TablaDietista controlador = new Controlador_TablaDietista();
            controlador.setStage(stage);
            controlador.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(Controller_MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    private void handleButtonDietistasCrear(ActionEvent event){
        /*try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DatosDietista.fxml"));
            Parent root = loader.load();
            Controlador_DatosDietista controlador = new Controlador_DatosDietista();
            controlador.setStage(stage);
            controlador.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(Controller_MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    private void handleButtonClientesVer(ActionEvent event){
        /*try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DatosDietista.fxml"));
            Parent root = loader.load();
            Controller_VCliente controlador = new Controller_VCliente();
            controlador.setStage(stage);
            controlador.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(Controller_MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    private void handleButtonClientesCrear(ActionEvent event){
        /*try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DatosDietista.fxml"));
            Parent root = loader.load();
            Controller_CrearCliente controlador = new Controller_CrearCliente();
            controlador.setStage(stage);
            controlador.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(Controller_MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    private void handleButtonDatosAlimento(ActionEvent event){
        /*try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DatosDietista.fxml"));
            Parent root = loader.load();
            Controlador_DatosAlimento controlador = new Controlador_DatosAlimento();
            controlador.setStage(stage);
            controlador.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(Controller_MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    private void handleButtonDatosReceta(ActionEvent event){
        /*try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DatosDietista.fxml"));
            Parent root = loader.load();
            Controller_VReceta controlador = new Controller_VReceta();
            controlador.setStage(stage);
            controlador.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(Controller_MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}
