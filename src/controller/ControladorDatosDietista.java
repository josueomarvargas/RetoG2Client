/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author josue
 */
public class ControladorDatosDietista {

    @FXML
    private Stage stage;
    @FXML
    MenuBar MnBAdmin;
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
    private TextField dniText;
    @FXML
    private TextField nombreAcessoText;
    @FXML
    private PasswordField contraseñaText;
    @FXML
    private PasswordField confContraseñaText;
    @FXML
    private TextField nombreText;
    @FXML
    private TextField apellidoText;
    @FXML
    private TextField emailText;
    @FXML
    private DatePicker fechNacPick;
    @FXML
    private DatePicker fechAltaPick;
    @FXML
    private AnchorPane modificarPanel;
    @FXML
    private AnchorPane crearPanel;
    @FXML
    private Button volverBoton;
    @FXML
    private Button modificarBoton;
    @FXML
    private Button eliminarBoton;
    @FXML
    private Button cambiarContraseniaBoton;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initStage(Parent root) {
        Stage stage1 = new Stage();
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.setResizable(false);
        stage1.show();
    }

    void initStage(Parent root, Usuario usuario) {
        Stage stage1 = new Stage();
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.setResizable(false);
        modificarPanel.setVisible(true);
        crearPanel.setVisible(false);
        dniText.setText(usuario.getDni());
        dniText.setDisable(true);
        nombreAcessoText.setText(usuario.getNombreAcceso());
        nombreAcessoText.setDisable(true);
        contraseñaText.setText(usuario.getContraseña());
        contraseñaText.setDisable(true);
        confContraseñaText.setText(usuario.getContraseña());
        confContraseñaText.setDisable(true);
        nombreText.setText(usuario.getNombre());
        nombreText.setDisable(true);
        apellidoText.setText(usuario.getApellido());
        apellidoText.setDisable(true);
        emailText.setText(usuario.getEmail());
        emailText.setDisable(true);
        fechNacPick.setDisable(true);
        fechAltaPick.setDisable(true);
        modificarBoton.setDisable(true);
        eliminarBoton.setDisable(true);
        stage1.show();
        volverBoton.setOnAction((event) -> {
            volver(usuario, event);
        });
        cambiarContraseniaBoton.setOnAction((event) -> {
            cambiarContrasenia(usuario, event);
        });
    }

    private void volver(Usuario usuario, ActionEvent event) {
        try {
            Node source = (Node) event.getSource();
            Stage stage1 = (Stage) source.getScene().getWindow();
            stage1.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MenuDietista.fxml"));
            Parent root = loader.load();
            ControladorMenuDietista controlador = loader.getController();

            controlador.setStage(stage);
            controlador.initStage(root, usuario);
        } catch (IOException ex) {
            Logger.getLogger(ControladorAlimentoTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cambiarContrasenia(Usuario usuario, ActionEvent event) {
        try {
            // lambda expression
            Node source = (Node) event.getSource();
            Stage stage1 = (Stage) source.getScene().getWindow();
            stage1.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CambiarContrasenia.fxml"));
            Parent root = loader.load();
            ControladorCambiarContrasenia controlador = loader.getController();
            controlador.setStage(stage);
            controlador.initStage(root, usuario);
        } catch (IOException ex) {
            Logger.getLogger(ControladorMenuDietista.class.getName()).log(Level.SEVERE, null, ex);
        }    }

}
