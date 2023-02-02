/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Usuario;
import exceptions.UsuarioInterfaceException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.UsuarioImplementacion;
import logic.UsuarioInterface;

/**
 *
 * @author josue
 */
public class ControladorRecupContrasenia {

    private Stage stage;
    @FXML
    private Button enviarBoton;
    @FXML
    private Button volverBoton;
    @FXML
    private TextField introCorreoText;

    /**
     *
     * @return
     */
    public Stage getStage() {
        return stage;
    }

    /**
     *
     * @param stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     *
     * @param root
     */
    public void initStage(Parent root) {
        Stage stage1 = new Stage();
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.setResizable(false);
        stage1.show();

        volverBoton.setOnAction(this::hadleVolverBoton);
        enviarBoton.setOnAction(this::hadleEnviarBoton);

    }

    private void hadleVolverBoton(ActionEvent event) {
        try {
            Node source = (Node) event.getSource();
            Stage stage1 = (Stage) source.getScene().getWindow();
            stage1.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InicioSesion.fxml"));
            Parent root = loader.load();
            ControladorInicioSesion controlador = loader.getController();
            controlador.setStage(stage);
            controlador.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(ControladorAlimentoTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void hadleEnviarBoton(ActionEvent event) {
        try {
            UsuarioInterface inter = new UsuarioImplementacion();
            inter.getUsuarioPorEmail(introCorreoText.getText());
            Node source = (Node) event.getSource();
            Stage stage1 = (Stage) source.getScene().getWindow();
            stage1.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InicioSesion.fxml"));
            Parent root = loader.load();
            ControladorInicioSesion controlador = loader.getController();
            controlador.setStage(stage);
            controlador.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(ControladorAlimentoTabla.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UsuarioInterfaceException ex) {
            Logger.getLogger(ControladorRecupContrasenia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
