/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Usuario;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 *
 * @author josue
 */
public class ControladorMenuDietista {

    Usuario usuario;
    @FXML
    private Stage stage;
    @FXML
    private MenuBar mnBAdmin;
    @FXML
    private MenuItem mnITusDatos;
    @FXML
    private MenuItem mnICerrarSesion;
    @FXML
    private MenuItem mnIVerClientes;
    @FXML
    private MenuItem mnIVerRecetas;
    @FXML
    private MenuItem mnBCrearRecetas;
    @FXML
    private MenuItem mnIVerAlimentos;
    @FXML
    private MenuItem mnBCrearAlimentos;
    @FXML
    private MenuItem mnIVerDietas;
    @FXML
    private MenuItem mnBCrearDietas;
    @FXML
    private Menu mnAlimentos;

    /**
     * Getter
     *
     * @return
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * Setter
     *
     * @param stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Inicializa los datos a mostrar en la ventana
     *
     * @param root
     */
    public void initStage(Parent root) {
        Stage stage1 = new Stage();
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.setResizable(false);
        stage1.show();

    }

    /**
     * Inicializa los datos a mostrar en la ventana
     *
     * @param root
     * @param usuario
     */
    public void initStage(Parent root, Usuario usuario) {
        Stage stage1 = new Stage();
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.setResizable(false);
        stage1.show();
        mnITusDatos.setOnAction((event) -> {
            misDatos(usuario);
        });
        mnIVerAlimentos.setOnAction((event) -> {
            verAlimentos(usuario);
        });
        mnBCrearAlimentos.setOnAction((event) -> {
            crearAlimentos(usuario);
        });

        mnIVerDietas.setOnAction((event) -> {
            verDietas(usuario, event);
        });
        mnBCrearDietas.setOnAction((event) -> {
            crearDietas(usuario, event);
        });
        mnICerrarSesion.setOnAction(this::hadleMenuCerrarSesion);

    }
//Muestra los datos del usuario conectado y te lleva a la ventana Datos dietista

    @FXML
    private void hadleMenuTusDatos(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DatosDietista.fxml"));
            ControladorDatosDietista controlador = new ControladorDatosDietista();
            Parent root = loader.load();
            controlador.setStage(stage);
            controlador.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(ControladorMenuDietista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Cierra sesión y te lleva a la ventana de inicion Sesión
    @FXML
    private void hadleMenuCerrarSesion(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Salir");
        alert.setHeaderText(null);
        alert.setContentText("¿Estas Seguro?");
        Optional opc = alert.showAndWait();
        if (opc.isPresent()) {
            if (opc.get() == ButtonType.OK) {
                try {

                    Stage stage1 = (Stage) mnBAdmin.getScene().getWindow();
                    stage1.close();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InicioSesion.fxml"));
                    Parent root = loader.load();
                    ControladorInicioSesion controlador = loader.getController();
                    controlador.setStage(stage);
                    controlador.initStage(root);
                } catch (IOException ex) {
                    Logger.getLogger(ControladorMenuDietista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    // muestra los Datos del Usuario en la ventana Datos Dietista
    private void misDatos(Usuario usuario) {
        try {
            // lambda expression
            Stage stage1 = (Stage) mnBAdmin.getScene().getWindow();
            stage1.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DatosDietista.fxml"));
            Parent root = loader.load();
            ControladorDatosDietista controlador = loader.getController();
            controlador.setStage(stage);
            controlador.initStage(root, usuario);
        } catch (IOException ex) {
            Logger.getLogger(ControladorMenuDietista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//Muestra la tabla de alimento 

    private void verAlimentos(Usuario usuario) {
        try {
            Stage stage1 = (Stage) mnBAdmin.getScene().getWindow();
            stage1.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AlimentoTabla.fxml"));
            Parent root = loader.load();
            ControladorAlimentoTabla controlador = loader.getController();
            controlador.setStage(stage);
            controlador.initStage(root, usuario);
        } catch (IOException ex) {
            Logger.getLogger(ControladorMenuDietista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//Muestra la ventana de Datos Alimento

    private void crearAlimentos(Usuario usuario) {
        try {

            Stage stage1 = (Stage) mnBAdmin.getScene().getWindow();
            stage1.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DatosAlimento.fxml"));
            Parent root = loader.load();
            ControladorDatosAlimento controlador = loader.getController();
            controlador.setStage(stage);
            controlador.initStage(root, usuario);
        } catch (IOException ex) {
            Logger.getLogger(ControladorMenuDietista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//Muestra la ventana de Datos Dietista

    private void verDietas(Usuario usuario, ActionEvent event) {
        try {
            Stage stage1 = (Stage) mnBAdmin.getScene().getWindow();
            stage1.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TablaDietas.fxml"));
            Parent root = loader.load();
            Controler_TablaDietas controlador = loader.getController();
            controlador.setStage(stage);
            controlador.initStage(root, usuario);
        } catch (IOException ex) {
            Logger.getLogger(Controller_MenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//Muestra la Ventana de Datos Dieta

    private void crearDietas(Usuario usuario, ActionEvent event) {
        try {
            Stage stage1 = (Stage) mnBAdmin.getScene().getWindow();
            stage1.close();
            Stage mainstage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CrearModificarDieta.fxml"));
            Parent root = loader.load();
            Controller_CrearModificarDieta controlador = loader.getController();
            controlador.setStage(mainstage);
            controlador.initStage(root, usuario);

        } catch (IOException ex) {
            Logger.getLogger(Controler_TablaDietas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
