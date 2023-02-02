/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cifrado.Cifrado;
import entities.Dietista;
import entities.Tipo;
import entities.Usuario;
import exceptions.ContraseniaDesigualException;
import exceptions.CrearUsuarioException;
import exceptions.ExisteEmailException;
import exceptions.ExisteIdException;
import exceptions.ExisteNombreException;
import exceptions.UsuarioInterfaceException;
import factoria.DietistaFactoria;
import factoria.UsuarioFactoria;
import java.io.IOException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logic.UsuarioInterface;

/**
 *
 * @author josue
 */
public class ControladorDatosDietista {

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
    @FXML
    private Button crearBoton;
    @FXML
    private Label fechNacLabel;
    @FXML
    private Label fechAltaLabel;

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
        modificarPanel.setVisible(false);
        crearPanel.setVisible(true);
        fechNacPick.setVisible(true);
        fechAltaPick.setVisible(false);
        fechAltaLabel.setVisible(false);
        stage1.show();
        crearBoton.setOnAction(this::hadleCrearUsuario);
        volverBoton.setOnAction(this::hadleVolverBoton);

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
        }
    }

    public void hadleCrearUsuario(ActionEvent event) {

        try {
            Usuario dietista = new Usuario();
            List<Usuario> dietistas = new ArrayList<>();
            UsuarioInterface usuarioInterface;
            usuarioInterface = UsuarioFactoria.createUsuarioManager(UsuarioFactoria.REST_WEB_CLIENT_TYPE);
            dietistas = FXCollections.observableArrayList(usuarioInterface.getUsuarioTodos());
            for (int i = 0; i < dietistas.size(); i++) {

                if (dietistas.get(i).getDni().equalsIgnoreCase(dniText.getText())) {
                    throw new ExisteIdException("Existe Dni");
                }
                if (dietistas.get(i).getNombreAcceso().equalsIgnoreCase(nombreAcessoText.getText())) {
                    throw new ExisteNombreException("Existe Nombre de Acceso");
                }
                if (dietistas.get(i).getEmail().equalsIgnoreCase(emailText.getText())) {
                    throw new ExisteEmailException("Existe Correo");
                }

            }

            if (dniText.getText().equalsIgnoreCase("") || nombreAcessoText.getText().equalsIgnoreCase("") || contraseñaText.getText().equalsIgnoreCase("") || confContraseñaText.getText().equalsIgnoreCase("")
                    || nombreText.getText().equalsIgnoreCase("") || apellidoText.getText().equalsIgnoreCase("") || emailText.getText().equalsIgnoreCase("")) {
                throw new CrearUsuarioException("Llena todos los campos");
            }
            if (contraseñaText.getText().equalsIgnoreCase(confContraseñaText.getText())) {
                dietista = crearDietista();

            } else {
                throw new ContraseniaDesigualException("Contraseña diferente");

            }
            //Interface dietistaInterface;
            usuarioInterface = UsuarioFactoria.createUsuarioManager(DietistaFactoria.REST_WEB_CLIENT_TYPE);

            usuarioInterface.crearUsuario(dietista);
            Node source = (Node) event.getSource();
            Stage stage1 = (Stage) source.getScene().getWindow();
            stage1.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InicioSesion.fxml"));
            Parent root = loader.load();
            ControladorInicioSesion controlador = loader.getController();
            controlador.setStage(stage);
            controlador.initStage(root);

        } catch (UsuarioInterfaceException ex) {
            Logger.getLogger(ControladorDatosDietista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExisteIdException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "El dni ya Existe", ButtonType.OK);
            alert.show();
        } catch (ExisteNombreException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Nombre de Acceso ya Existe", ButtonType.OK);
            alert.show();
        } catch (CrearUsuarioException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Llena todos los campos con sus Valores Correspondientes", ButtonType.OK);
            alert.show();
        } catch (ContraseniaDesigualException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Contraseña y Confimar Contrasena es diferente", ButtonType.OK);
            alert.show();
        } catch (ExisteEmailException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Email ya Existe", ButtonType.OK);
            alert.show();
        } catch (IOException ex) {
            Logger.getLogger(ControladorDatosDietista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Usuario crearDietista() {
        Usuario dietista = new Usuario();
        Cifrado cifrado = new Cifrado();
        dietista.setDni(dniText.getText());
        dietista.setNombreAcceso(nombreAcessoText.getText());
        dietista.setContraseña(cifrado.cifrarTexto1(contraseñaText.getText()));
        dietista.setNombre(nombreText.getText());
        dietista.setApellido(apellidoText.getText());
        dietista.setEmail(emailText.getText());
        dietista.setTipo(Tipo.DIETISTA);
        Date fechaAhora = Date.from(Instant.now());
        dietista.setFechaNac(fechaAhora);
        return dietista;

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

}
