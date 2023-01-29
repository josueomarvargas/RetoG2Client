/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Alimento;
import entities.TipoAlimento;
import entities.Usuario;
import exceptions.AlimentoInterfaceException;
import exceptions.ExisteIdException;
import exceptions.ExisteNombreException;
import exceptions.InicionSesionNAcessoYContraseñaException;
import factoria.AlimentoFactoria;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.AlimentoImplementacion;
import logic.AlimentoInterface;

/**
 *
 * @author josue
 */
public class ControladorDatosAlimento {

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
    private AnchorPane crearPanel;
    @FXML
    private AnchorPane modificarPanel;
    @FXML
    private Button crearBoton;
    @FXML
    private Button volverBoton;
    @FXML
    private Button modificarBoton;
    @FXML
    private Button eliminarBoton;
    @FXML
    private ComboBox tipoComboBox;
    @FXML
    private TextField idText;
    @FXML
    private TextField nombreText;
    @FXML
    private TextField caloriasText;
    @FXML
    private TextField grasasText;
    @FXML
    private TextField proteinasText;
    @FXML
    private TextField carbohidratosText;
    AlimentoFactoria alimentoFactoria;

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
        //crearPanel.setDisable(flase);
        modificarPanel.setVisible(false);
        crearPanel.setVisible(true);
        anadirComboBoxTipo();
        stage1.show();
        //crearBoton.setOnAction(this::hadleBotonCreacion);
        //volverBoton.setOnAction(this::hadleBotonVolver);

    }

    public void initStage(Parent root, Usuario usuario) {
        Stage stage1 = new Stage();
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.setResizable(false);
        //crearPanel.setDisable(flase);
        modificarPanel.setVisible(false);
        crearPanel.setVisible(true);
        anadirComboBoxTipo();
        stage1.show();
        crearBoton.setOnAction((event) -> {
            creacion(usuario, event);
        });
        volverBoton.setOnAction((event) -> {
            volver(usuario, event);
        });
        mnITusDatos.setOnAction((event) -> {
            misDatos(usuario);
        });
        mnIVerAlimentos.setOnAction((event) -> {
            verAlimentos(usuario);
        });
        mnICerrarSesion.setOnAction(this::hadleMenuCerrarSesion);
    }

    public void initStage(Parent root, Alimento alimento, Usuario usuario) {
        Stage stage1 = new Stage();
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.setResizable(false);
        //crearPanel.setDisable(flase);
        modificarPanel.setVisible(true);
        crearPanel.setVisible(false);
        anadirComboBoxTipo();
        idText.setText(alimento.getIdAlimento());
        idText.setEditable(false);
        nombreText.setText(alimento.getNombre());
        nombreText.setEditable(false);
        caloriasText.setText(alimento.getCalorias().toString());
        grasasText.setText(alimento.getGrasasTotales().toString());
        proteinasText.setText(alimento.getProteinas().toString());
        carbohidratosText.setText(alimento.getCarbohidratos().toString());
        tipoComboBox.getSelectionModel().select(alimento.getTIPO());
        stage1.show();
        volverBoton.setOnAction((event) -> {
            volver(usuario, event);
        });
        eliminarBoton.setOnAction((event) -> {
            eliminar(usuario, event);
        });
        modificarBoton.setOnAction((event) -> {
            modificar(usuario, event);
        });
        mnITusDatos.setOnAction((event) -> {
            misDatos(usuario);
        });
        mnIVerAlimentos.setOnAction((event) -> {
            verAlimentos(usuario);
        });
        mnBCrearAlimentos.setOnAction((event) -> {
            crearAlimentos(usuario);
        });
        mnICerrarSesion.setOnAction(this::hadleMenuCerrarSesion);

    }

    private void anadirComboBoxTipo() {
        tipoComboBox.getItems().add(TipoAlimento.CEREAL);
        tipoComboBox.getItems().add(TipoAlimento.CARNE);
        tipoComboBox.getItems().add(TipoAlimento.FRUTA);
        tipoComboBox.getItems().add(TipoAlimento.HORTALIZA);
        tipoComboBox.getItems().add(TipoAlimento.LECHE_DEREVADOS);
        tipoComboBox.getItems().add(TipoAlimento.LEGUMBRE);
        tipoComboBox.getItems().add(TipoAlimento.MANTECA_ACEITE);

    }

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

                    Stage stage1 = (Stage) MnBAdmin.getScene().getWindow();
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

    public void creacion(Usuario usuario, ActionEvent event) {

        try {
            Alimento alimento = new Alimento();
            AlimentoInterface alimentoInterface;
            alimentoInterface = AlimentoFactoria.createAlimentoManager(AlimentoFactoria.REST_WEB_CLIENT_TYPE);
            alimento = alimentoInterface.getAlimentoPorId(idText.getText());

            if (alimento != null) {
                throw new ExisteIdException("Error");
            }
            alimento = alimentoInterface.getAlimentoPorNombre(nombreText.getText());
            if (alimento != null) {
                throw new ExisteNombreException("Error");
            }

            alimento = crearAlimento1();

            alimentoInterface.crearAlimento(alimento);
            Node source = (Node) event.getSource();
            Stage stage1 = (Stage) source.getScene().getWindow();
            stage1.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AlimentoTabla.fxml"));
            Parent root = loader.load();
            ControladorAlimentoTabla controlador = loader.getController();
            controlador.setStage(stage);
            controlador.initStage(root, usuario);
        } catch (AlimentoInterfaceException ex) {
            Logger.getLogger(ControladorAlimentoTabla.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControladorDatosAlimento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExisteIdException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Id Alimento ya Existe", ButtonType.OK);
            alert.show();
        } catch (ExisteNombreException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Nombre Alimento ya Existe", ButtonType.OK);
            alert.show();
        }

    }

    private Alimento crearAlimento1() throws AlimentoInterfaceException {
        Alimento alimento = new Alimento();
        Date fechaAhora = Date.from(Instant.now());
        alimento.setIdAlimento(idText.getText());
        alimento.setNombre(nombreText.getText());
        alimento.setCalorias(Float.valueOf(caloriasText.getText()));
        alimento.setGrasasTotales(Float.valueOf(grasasText.getText()));
        alimento.setProteinas(Float.valueOf(proteinasText.getText()));
        alimento.setCarbohidratos(Float.valueOf(carbohidratosText.getText()));
        TipoAlimento tipo = (TipoAlimento) tipoComboBox.getValue();
        alimento.setTIPO(tipo);
        alimento.setFechaInsert(fechaAhora);

        // System.out.println(alimento.getFechaInsert());
        return alimento;

    }

    public void volver(Usuario usuario, ActionEvent event) {

        try {
            Node source = (Node) event.getSource();
            Stage stage1 = (Stage) source.getScene().getWindow();
            stage1.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AlimentoTabla.fxml"));
            Parent root = loader.load();
            ControladorAlimentoTabla controlador = loader.getController();
            controlador.setStage(stage);
            controlador.initStage(root, usuario);
        } catch (IOException ex) {
            Logger.getLogger(ControladorDatosAlimento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminar(Usuario usuario, ActionEvent event) {
        try {
            AlimentoInterface alimentoInterface;
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Eliminar");
            alert.setHeaderText(null);
            alert.setContentText("¿Estas seguro que quieres eliminar ese Alimento?");
            Optional opc = alert.showAndWait();
            if (opc.isPresent()) {
                if (opc.get() == ButtonType.OK) {
                    stage.close();
                    alimentoInterface = AlimentoFactoria.createAlimentoManager(AlimentoFactoria.REST_WEB_CLIENT_TYPE);
                    alimentoInterface.eliminarAlimento(idText.getText());
                    Node source = (Node) event.getSource();
                    Stage stage1 = (Stage) source.getScene().getWindow();
                    stage1.close();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AlimentoTabla.fxml"));
                    Parent root = loader.load();
                    ControladorAlimentoTabla controlador = loader.getController();
                    controlador.setStage(stage);
                    controlador.initStage(root, usuario);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(ControladorDatosAlimento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlimentoInterfaceException ex) {
            Logger.getLogger(ControladorDatosAlimento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificar(Usuario usuario, ActionEvent event) {
        try {
            Alimento alimento = new Alimento();
            alimento = modificarAlimento(alimento);

            AlimentoInterface alimentoInterface = AlimentoFactoria.createAlimentoManager(AlimentoFactoria.REST_WEB_CLIENT_TYPE);
            alimentoInterface.actualizarAlimento(alimento);
            Node source = (Node) event.getSource();
            Stage stage1 = (Stage) source.getScene().getWindow();
            stage1.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AlimentoTabla.fxml"));
            Parent root = loader.load();
            ControladorAlimentoTabla controlador = loader.getController();
            controlador.setStage(stage);
            controlador.initStage(root, usuario);
        } catch (IOException ex) {
            Logger.getLogger(ControladorDatosAlimento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AlimentoInterfaceException ex) {
            Logger.getLogger(ControladorDatosAlimento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Alimento modificarAlimento(Alimento alimento) {
        alimento.setIdAlimento(idText.getText());
        alimento.setNombre(nombreText.getText());
        alimento.setCalorias(Float.valueOf(caloriasText.getText()));
        alimento.setGrasasTotales(Float.valueOf(grasasText.getText()));
        alimento.setProteinas(Float.valueOf(proteinasText.getText()));
        alimento.setCarbohidratos(Float.valueOf(carbohidratosText.getText()));
        TipoAlimento tipo = (TipoAlimento) tipoComboBox.getValue();
        alimento.setTIPO(tipo);
        return alimento;
    }

    private void misDatos(Usuario usuario) {
        try {
            // lambda expression
            Stage stage1 = (Stage) MnBAdmin.getScene().getWindow();
            stage1.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DatosDietista.fxml"));
            Parent root1 = loader.load();
            ControladorDatosDietista controlador = loader.getController();
            controlador.setStage(stage);
            controlador.initStage(root1, usuario);
        } catch (IOException ex) {
            Logger.getLogger(ControladorMenuDietista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void crearAlimentos(Usuario usuario) {
        try {

            Stage stage1 = (Stage) MnBAdmin.getScene().getWindow();
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
    private void verAlimentos(Usuario usuario) {
        try {
            Stage stage1 = (Stage) MnBAdmin.getScene().getWindow();
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
}
