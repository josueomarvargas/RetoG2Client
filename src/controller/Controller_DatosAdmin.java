/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Gonzalo
 */
public class Controller_DatosAdmin {

    @FXML
    private Stage stage;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnSalir;
    @FXML
    private Button btnAplicar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtFieldAcceso;
    @FXML
    private TextField txtFieldContraseña;
    @FXML
    private TextField txtFieldEmail;
    @FXML
    private TextField txtFieldNombre;
    @FXML
    private TextField txtFieldApellido;

    /**
     *
     * @return Stage
     */
    public Stage getStage() {
        return stage;
    }

    /**
     *
     * @param stage Stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     *
     * @param root Parent
     */
    public void initStage(Parent root) {

        Scene scene = new Scene(root);
        Stage stage1 = new Stage();
        stage1.setScene(scene);
        stage1.setResizable(false);
        stage1.setTitle("Tus de Datos");
        stage1.show();
    }
}
