package controller;

import entities.Alimento;
import entities.Dietista;
import entities.Tipo;
import entities.TipoAlimento;
import entities.Usuario;
import exceptions.InicionSesionNAcessoYContraseñaException;
import exceptions.UsuarioInterfaceException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.AlimentoInterface;
import logic.UsuarioImplementacion;
import logic.UsuarioInterface;

/**
 *
 * @author josue
 */
public class ControladorInicioSesion {
    //Variables Creadas para el uso de la ventanas

    @FXML
    private Stage stage;
    @FXML
    private Button entrarBoton;
    @FXML
    private Button registrarBoton;
    @FXML
    private Hyperlink recuContrasenia;
    @FXML
    private TextField nombreAccesoText;
    @FXML
    private PasswordField passText;
    private ObservableList<Usuario> datosUsuario;
    private UsuarioInterface usuariosInter;
    private Usuario usuario;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initStage(Parent root) {
        /**
         * La ventana al iniciarse ● Título de ventana: Nutrivago. ● La ventana
         * no se podrá redimensionar. ● Todo está habilitado. * ● El focus
         * estará en el nombreAccesoText(Primer recuadro dentro del inicio de
         * sesión,nombreAcessoText) TextField. * ● En el campo
         * (nombreAcessoText)tendra 2 a 15 characters como máximo”. * ● En el
         * campo (ContraseñaText) tendra 4 a 10 characters como máximo”. * ● En
         * el campo (nombreAcessoText) mediante un PrompText contendrá el
         * mensaje “nombre Acceso”. ● En el campo (ContraseñaText) mediante un
         * PrompText contendrá el mensaje “contraseña”. * ● En el HyperLink
         * (recuContraseña)
         *
         */
        Stage stage1 = new Stage();
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.setResizable(false);
        stage1.setTitle("Nutrivago");
        //nombreAccesoText.setText("gola");
        stage1.show();
        entrarBoton.setOnAction(this::hadleButtonEntrar);
        registrarBoton.setOnAction(this::hadleButtonRegistrar);
        recuContrasenia.setOnAction(this::hadleButtonRecuContrasenia);
        limitPasswordUser();

    }

    @FXML
    private void hadleButtonEntrar(ActionEvent event) {

        try {
            try {

                usuariosInter = new UsuarioImplementacion();
                datosUsuario = FXCollections.observableArrayList(usuariosInter.getInicioSesion(nombreAccesoText.getText(), passText.getText()));
                if (!datosUsuario.isEmpty()) {

                    if (datosUsuario.get(0).getTipo().equals(Tipo.ADMIN)) {
                    } else if (datosUsuario.get(0).getTipo().equals(Tipo.DIETISTA)) {
                        Node source = (Node) event.getSource();
                        Stage stage1 = (Stage) source.getScene().getWindow();
                        stage1.close();
                        datosUsuario.get(0).setNombreAcceso(nombreAccesoText.getText());
                        datosUsuario.get(0).setContraseña(passText.getText());

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MenuDietista.fxml"));
                        Parent root = loader.load();
                        ControladorMenuDietista controlador = loader.getController();
                        controlador.setStage(stage);
                        controlador.initStage(root, datosUsuario.get(0));

                    } else if (datosUsuario.get(0).getTipo().equals(Tipo.CLIENTE)) {
                        System.out.println(datosUsuario.get(0).getTipo());

                    }
                } else {

                    throw new InicionSesionNAcessoYContraseñaException("Error");

                }
            } catch (UsuarioInterfaceException | IOException ex) {
                Logger.getLogger(ControladorInicioSesion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (InicionSesionNAcessoYContraseñaException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Nombre de Acceso o Contraseña erroneos", ButtonType.OK);
            alert.show();
        }
    }

    @FXML
    private void hadleButtonRegistrar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DatosDietista.fxml"));
            ControladorDatosDietista controlador = new ControladorDatosDietista();
            Parent root = loader.load();
            controlador.setStage(stage);
            controlador.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(ControladorInicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void hadleButtonRecuContrasenia(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/RecupContrasenia.fxml"));
            Parent root = loader.load();

            ControladorRecupContrasenia controlador = loader.getController();
            controlador.setStage(stage);
            controlador.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(ControladorInicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void limitPasswordUser() {
        nombreAccesoText.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number valorAnterior, Number valorActual) {
                if (nombreAccesoText.getText().length() > 15) {
                    nombreAccesoText.setText(nombreAccesoText.getText().substring(0, 15));
                }
            }
        });
        passText.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number valorAnterior, Number valorActual) {
                if (passText.getText().length() > 10) {
                    passText.setText(passText.getText().substring(0, 10));
                }
            }
        });

    }

    void initStage(Parent root1, Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
