/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cifrado.Cifrado;
import entities.Usuario;
import exceptions.ContraseniaDesigualException;
import exceptions.ContraseniaDesigualException1;
import exceptions.UsuarioInterfaceException;
import factoria.DietistaFactoria;
import factoria.UsuarioFactoria;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import logic.UsuarioInterface;

/**
 *
 * @author josue
 */
public class ControladorCambiarContrasenia {

    private Stage stage;
    @FXML
    MenuBar MnBAdmin;
    @FXML

    private MenuItem mnITusDatos;
    @FXML
    private MenuItem mnICerrarSesion;
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
    private PasswordField antiguaContraseñaText;
    @FXML
    private PasswordField nuevaContraseñaText;
    @FXML
    private PasswordField confNuevaContraseñaText;
    @FXML
    private Button cambiarContraseniaBoton;
    @FXML
    private Button volverBoton;

    /**
     * Getter
     *
     * @return stage
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * Setter
     *
     * @param stage Stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Inicializa los datos a mostrar en la ventana
     *
     * @param root Parent
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
     * @param root Parent
     * @param usuario Objeto Usuario
     */
    public void initStage(Parent root, Usuario usuario) {
        Stage stage1 = new Stage();
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.setResizable(false);
        stage1.show();
//Acciones de los botones
        volverBoton.setOnAction((event) -> {
            volver(usuario, event);
        });
        cambiarContraseniaBoton.setOnAction((event) -> {
            try {
                cambiarContrasenia(usuario, event);
            } catch (ContraseniaDesigualException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error, Contraseña antigua incorrecta", ButtonType.OK);
                alert.show();
            } catch (ContraseniaDesigualException1 ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error, Contraseña nueva no coincide", ButtonType.OK);
                alert.show();
            }
        });

    }

    /**
     * Vuelve a la Ventana Anterior(DatosDietista)
     *
     * @param usuario Usuario
     * @param event ActionEvent
     */
    public void volver(Usuario usuario, ActionEvent event) {

        try {
            Node source = (Node) event.getSource();
            Stage stage1 = (Stage) source.getScene().getWindow();
            stage1.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DatosDietista.fxml"));
            Parent root = loader.load();
            ControladorDatosDietista controlador = loader.getController();
            controlador.setStage(stage);
            controlador.initStage(root, usuario);
        } catch (IOException ex) {
            Logger.getLogger(ControladorDatosAlimento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Ejecuta el metodo de cambiar contraseña y vuelve a la ventana de Datos alimento
    private void cambiarContrasenia(Usuario usuario, ActionEvent event) throws ContraseniaDesigualException, ContraseniaDesigualException1 {

        UsuarioInterface usuarioInterface = UsuarioFactoria.createUsuarioManager(DietistaFactoria.REST_WEB_CLIENT_TYPE);
        //Controla que la contraseña del usuario coincida con la puesta
        if (usuario.getContraseña().equalsIgnoreCase(antiguaContraseñaText.getText())) {
            //Controla que sean iguales la contraseña nueva con confirmar
            if (nuevaContraseñaText.getText().equalsIgnoreCase(confNuevaContraseñaText.getText())) {
                try {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Nutrivago");
                    alert.setHeaderText(null);
                    alert.setContentText("¿Estas Seguro que quieres Cambiar la Contraseña?");
                    Optional opc = alert.showAndWait();
                    if (opc.isPresent()) {
                        if (opc.get() == ButtonType.OK) {
                            stage.close();

                            Cifrado cifrado = new Cifrado();
                            usuario.setContraseña(cifrado.cifrarTexto1(nuevaContraseñaText.getText()));
                            usuarioInterface.modificarUsuario(usuario);
                            usuario.setContraseña(nuevaContraseñaText.getText());
                            Node source = (Node) event.getSource();
                            Stage stage1 = (Stage) source.getScene().getWindow();
                            stage1.close();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DatosDietista.fxml"));
                            Parent root = loader.load();
                            ControladorDatosDietista controlador = loader.getController();
                            controlador.setStage(stage);
                            controlador.initStage(root, usuario);
                        }
                    }
                } catch (UsuarioInterfaceException ex) {
                    Logger.getLogger(ControladorCambiarContrasenia.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ControladorCambiarContrasenia.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {

                throw new ContraseniaDesigualException1("Contraseña Diferentes");

            }
        } else {

            throw new ContraseniaDesigualException("Contraseña Diferentes");

        }
    }

}
