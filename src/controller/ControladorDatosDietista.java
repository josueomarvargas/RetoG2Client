/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cifrado.Cifrado;
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
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * Controla los datos de Dietista, tanto modificar como crear 
 * @author josue
 */
public class ControladorDatosDietista {

    private Stage stage;
    @FXML
    MenuBar mnBAdmin;
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
    private PasswordField contrase??aText;
    @FXML
    private PasswordField confContrase??aText;
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

    /**
     *Getter
     * @return Stage
     */
    public Stage getStage() {
        return stage;
    }

    /**
     *Setter
     * @param stage Stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Inicializa los datos a mostrar en la ventana
     * @param root Parent
     */
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
                mnBAdmin.setDisable(true);

        stage1.show();
        crearBoton.setOnAction(this::hadleCrearUsuario);
        volverBoton.setOnAction(this::hadleVolverBoton);

    }

    /**
     * Inicializa los datos a mostrar en la ventana
     * @param root Parent
     * @param usuario Usuario
     */
    public void initStage(Parent root, Usuario usuario) {
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
        contrase??aText.setText(usuario.getContrase??a());
        contrase??aText.setDisable(true);
        confContrase??aText.setText(usuario.getContrase??a());
        confContrase??aText.setDisable(true);
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
   
    //Cierra Sesion del Usuaurio y vuelve a la ventana de inicio de sesi??n
    @FXML
    private void hadleMenuCerrarSesion(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Salir");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure?");
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
    //Vuelve a la ventana Anterior
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
//Te lleva  a la ventana para modificar la contrase??a
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

    /**
     *Ventana para Crear Alimento
     * @param event ActionEvent
     */
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

            if (dniText.getText().equalsIgnoreCase("") || nombreAcessoText.getText().equalsIgnoreCase("") || contrase??aText.getText().equalsIgnoreCase("") || confContrase??aText.getText().equalsIgnoreCase("")
                    || nombreText.getText().equalsIgnoreCase("") || apellidoText.getText().equalsIgnoreCase("") || emailText.getText().equalsIgnoreCase("")) {
                throw new CrearUsuarioException("Llena todos los campos");
            }
            if (contrase??aText.getText().equalsIgnoreCase(confContrase??aText.getText())) {
                dietista = crearDietista();

            } else {
                throw new ContraseniaDesigualException("Contrase??a diferente");

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

        } catch (UsuarioInterfaceException | IOException ex) {
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
            Alert alert = new Alert(Alert.AlertType.ERROR, "Contrase??a y Confimar Contrasena es diferente", ButtonType.OK);
            alert.show();
        } catch (ExisteEmailException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Email ya Existe", ButtonType.OK);
            alert.show();
        }

    }
//Crea Dietista
    private Usuario crearDietista() {
        Usuario dietista = new Usuario();
        Cifrado cifrado = new Cifrado();
        dietista.setDni(dniText.getText());
        dietista.setNombreAcceso(nombreAcessoText.getText());
        dietista.setContrase??a(cifrado.cifrarTexto1(contrase??aText.getText()));
        dietista.setNombre(nombreText.getText());
        dietista.setApellido(apellidoText.getText());
        dietista.setEmail(emailText.getText());
        dietista.setTipo(Tipo.DIETISTA);
        Date fechaAhora = Date.from(Instant.now());
        dietista.setFechaNac(fechaAhora);
        return dietista;

    }
//Vuelve a la ventana Anterior 
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
    //te lleva a la ventana tabla alimento
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
//Te lleva a la ventana crear alimento
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
//Te lleva a la tabla De dieta
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
//Te lleva a la ventana donde creas dieta
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
