/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.lowagie.text.pdf.AcroFields.Item;
import entities.Alimento;
import entities.TipoAlimento;
import entities.Usuario;
import exceptions.AlimentoInterfaceException;
import exceptions.UsuarioNullException;
import factoria.AlimentoFactoria;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logic.AlimentoImplementacion;
import logic.AlimentoInterface;

/**
 *
 * @author josue
 */
public class ControladorAlimentoTabla {

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
    private AnchorPane filtroPanel;
    @FXML
    private AnchorPane filtroPanel2;
    @FXML
    private TableColumn colum1;
    @FXML
    private TableColumn colum2;
    @FXML
    private TableColumn colum3;
    @FXML
    private TableColumn colum4;
    @FXML
    private TableColumn colum5;
    @FXML
    private TableView tablaAlimento;
    @FXML
    private Button filtrarBoton;
    @FXML
    private Button modificarBoton;
    @FXML
    private Button anadirBoton;
    @FXML
    private Button volverBoton;
    @FXML
    private Button informeBoton;
    @FXML
    private ComboBox tipoComboBox;
    @FXML
    private TextField menorText;
    @FXML
    private TextField mayorText;
    @FXML
    private TextField minText;
    @FXML
    private TextField maxText;
    @FXML
    private TextField nombreText;
    @FXML

    private ComboBox filtrarCBox;
    private ObservableList<Alimento> datosAlimento;
    private AlimentoInterface alimentosInter;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initStage(Parent root) {
        try {
            Stage stage1 = new Stage();
            Scene scene = new Scene(root);
            stage1.setScene(scene);
            stage1.setResizable(false);
            //
            alimentosInter = AlimentoFactoria.createAlimentoManager(AlimentoFactoria.REST_WEB_CLIENT_TYPE);
            colum1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            colum2.setCellValueFactory(new PropertyValueFactory<>("calorias"));
            colum3.setCellValueFactory(new PropertyValueFactory<>("grasasTotales"));
            colum4.setCellValueFactory(new PropertyValueFactory<>("proteinas"));
            colum5.setCellValueFactory(new PropertyValueFactory<>("carbohidratos"));
            datosAlimento = FXCollections.observableArrayList(alimentosInter.getAllAlimento());
            tablaAlimento.setItems(datosAlimento);
            anadirComboBoxTipo();
            anadirComboBoxTipo2();

            stage1.show();
            // volverBoton.setOnAction(this::hadleBotonVolver);
            //anadirBoton.setOnAction(this::hadleBotonAnadir);
            //modificarBoton.setOnAction(this::hadleBotonModificar);
            //filtrarBoton.setOnAction(this::hadleBotonFiltrar);

        } catch (AlimentoInterfaceException ex) {
            Logger.getLogger(ControladorAlimentoTabla.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void initStage(Parent root, Usuario usuario) {
        try {
            Stage stage1 = new Stage();
            Scene scene = new Scene(root);
            stage1.setScene(scene);
            stage1.setResizable(false);
            //
            alimentosInter = AlimentoFactoria.createAlimentoManager(AlimentoFactoria.REST_WEB_CLIENT_TYPE);
            colum1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            colum2.setCellValueFactory(new PropertyValueFactory<>("calorias"));
            colum3.setCellValueFactory(new PropertyValueFactory<>("grasasTotales"));
            colum4.setCellValueFactory(new PropertyValueFactory<>("proteinas"));
            colum5.setCellValueFactory(new PropertyValueFactory<>("carbohidratos"));
            datosAlimento = FXCollections.observableArrayList(alimentosInter.getAllAlimento());
            tablaAlimento.setItems(datosAlimento);
            anadirComboBoxTipo();
            anadirComboBoxTipo2();

            stage1.show();
            mnITusDatos.setOnAction((event) -> {
                misDatos(usuario);
            });

            mnBCrearAlimentos.setOnAction((event) -> {
                crearAlimentos(usuario);
            });
            mnICerrarSesion.setOnAction(this::hadleMenuCerrarSesion);

            volverBoton.setOnAction((event) -> {
                volver(usuario, event);
            });
            anadirBoton.setOnAction((event) -> {
                anadir(usuario, event);
            });
            modificarBoton.setOnAction((event) -> {
                botonModificar(usuario, event);
            });
            filtrarBoton.setOnAction(this::hadleBotonFiltrar);

        } catch (AlimentoInterfaceException ex) {
            Logger.getLogger(ControladorAlimentoTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    @FXML
    public void hadleBotonVolver(ActionEvent event) {
        try {
            Node source = (Node) event.getSource();
            Stage stage1 = (Stage) source.getScene().getWindow();
            stage1.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MenuDietista.fxml"));
            ControladorDatosDietista controlador = new ControladorDatosDietista();
            Parent root = loader.load();
            controlador.setStage(stage);
            controlador.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(ControladorAlimentoTabla.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void hadleBotonAnadir(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DatosAlimento.fxml"));
            Parent root = loader.load();
            ControladorDatosAlimento controlador = loader.getController();
            controlador.setStage(stage);
            controlador.initStage(root);
        } catch (IOException ex) {
            Logger.getLogger(ControladorAlimentoTabla.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void botonModificar(Usuario usuario, ActionEvent event) {
        try {
            Alimento alimento = new Alimento();

            alimento = (Alimento) tablaAlimento.getSelectionModel().getSelectedItem();
            if (alimento != null) {
                Node source = (Node) event.getSource();
                Stage stage1 = (Stage) source.getScene().getWindow();
                stage1.close();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DatosAlimento.fxml"));
                Parent root = loader.load();
                ControladorDatosAlimento controlador = loader.getController();
                controlador.setStage(stage);
                controlador.initStage(root, alimento, usuario);
            } else {
                throw new UsuarioNullException("Alimento null");
            }

        } catch (IOException ex) {
            Logger.getLogger(ControladorAlimentoTabla.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UsuarioNullException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Selecciona un Alimento de la tabla", ButtonType.OK);
            alert.show();
        }

    }

    @FXML
    public void hadleBotonFiltrar(ActionEvent event) {
        try {
            AlimentoInterface alimentoInterface;

            alimentoInterface = AlimentoFactoria.createAlimentoManager(AlimentoFactoria.REST_WEB_CLIENT_TYPE);

            if (nombreText.getText().equalsIgnoreCase("") && menorText.getText().equalsIgnoreCase("") && mayorText.getText().equalsIgnoreCase("") && minText.getText().equalsIgnoreCase("") && maxText.getText().equalsIgnoreCase("") && tipoComboBox.getValue().toString().equalsIgnoreCase("")) {
                colum1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                colum2.setCellValueFactory(new PropertyValueFactory<>("calorias"));
                colum3.setCellValueFactory(new PropertyValueFactory<>("grasasTotales"));
                colum4.setCellValueFactory(new PropertyValueFactory<>("proteinas"));
                colum5.setCellValueFactory(new PropertyValueFactory<>("carbohidratos"));
                datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAllAlimento());
                tablaAlimento.setItems(datosAlimento);
            } else {

                List<Alimento> alimentos = new ArrayList<>();
                Alimento alimento = new Alimento();
                colum1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                colum2.setCellValueFactory(new PropertyValueFactory<>("calorias"));
                colum3.setCellValueFactory(new PropertyValueFactory<>("grasasTotales"));
                colum4.setCellValueFactory(new PropertyValueFactory<>("proteinas"));
                colum5.setCellValueFactory(new PropertyValueFactory<>("carbohidratos"));

                if (filtrarCBox.getValue().toString().equalsIgnoreCase("Proteinas")) {
                    if (!nombreText.getText().equalsIgnoreCase("")) {
                        alimento = alimentoInterface.getAlimentoPorNombre(nombreText.getText());
                        alimentos.add(alimento);
                        datosAlimento = FXCollections.observableArrayList(alimentos);
                    } else if (!menorText.getText().equalsIgnoreCase("")) {

                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorProteinasMinimo(menorText.getText()));
                    } else if (!mayorText.getText().equalsIgnoreCase("")) {
                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorProteinasSuperior(mayorText.getText()));
                    } else if (!minText.getText().equalsIgnoreCase("") && !maxText.getText().equalsIgnoreCase("")) {
                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorProteinasEntre(maxText.getText(), minText.getText()));
                    } else {
                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorTipo(tipoComboBox.getValue().toString()));

                    }
                } else if (filtrarCBox.getValue().toString().equalsIgnoreCase("Calorias")) {
                    if (!nombreText.getText().equalsIgnoreCase("")) {
                        alimento = alimentoInterface.getAlimentoPorNombre(nombreText.getText());
                        alimentos.add(alimento);
                        datosAlimento = FXCollections.observableArrayList(alimentos);
                    } else if (!menorText.getText().equalsIgnoreCase("")) {

                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorCaloriasMinimo(menorText.getText()));
                    } else if (!mayorText.getText().equalsIgnoreCase("")) {
                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorCaloriasSuperior(mayorText.getText()));
                    } else if (!minText.getText().equalsIgnoreCase("") && !maxText.getText().equalsIgnoreCase("")) {
                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorCaloriasEntre(maxText.getText(), minText.getText()));
                    } else {
                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorTipo(tipoComboBox.getValue().toString()));

                    }
                } else if (filtrarCBox.getValue().toString().equalsIgnoreCase("Grasas Totales")) {
                    if (!nombreText.getText().equalsIgnoreCase("")) {
                        alimento = alimentoInterface.getAlimentoPorNombre(nombreText.getText());
                        alimentos.add(alimento);
                        datosAlimento = FXCollections.observableArrayList(alimentos);
                    } else if (!menorText.getText().equalsIgnoreCase("")) {

                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorGrasasMinimo(menorText.getText()));
                    } else if (!mayorText.getText().equalsIgnoreCase("")) {
                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorGrasasSuperior(mayorText.getText()));
                    } else if (!minText.getText().equalsIgnoreCase("") && !maxText.getText().equalsIgnoreCase("")) {
                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorGrasasEntre(maxText.getText(), minText.getText()));
                    } else {
                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorTipo(tipoComboBox.getValue().toString()));

                    }
                } else if (filtrarCBox.getValue().toString().equalsIgnoreCase("Carbohidratos")) {
                    if (!nombreText.getText().equalsIgnoreCase("")) {
                        alimento = alimentoInterface.getAlimentoPorNombre(nombreText.getText());
                        alimentos.add(alimento);
                        datosAlimento = FXCollections.observableArrayList(alimentos);
                    } else if (!menorText.getText().equalsIgnoreCase("")) {

                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorCarbohidratosMinimo(menorText.getText()));
                    } else if (!mayorText.getText().equalsIgnoreCase("")) {
                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorCarbohidratosSuperior(mayorText.getText()));
                    } else if (!minText.getText().equalsIgnoreCase("") && !maxText.getText().equalsIgnoreCase("")) {
                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorCarbohidratosEntre(maxText.getText(), minText.getText()));
                    } else {
                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorTipo(tipoComboBox.getValue().toString()));

                    }
                }

                tablaAlimento.setItems(datosAlimento);
            }
            tablaAlimento.refresh();

        } catch (AlimentoInterfaceException ex) {
            Logger.getLogger(ControladorAlimentoTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void anadirComboBoxTipo2() {
        filtrarCBox.getItems().add("Proteinas");
        filtrarCBox.getItems().add("Calorias");
        filtrarCBox.getItems().add("Grasas Totales");
        filtrarCBox.getItems().add("Carbohidratos");
        filtrarCBox.getSelectionModel().select("Proteinas");
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

    private void anadir(Usuario usuario, ActionEvent event) {
        try {
            Node source = (Node) event.getSource();
            Stage stage1 = (Stage) source.getScene().getWindow();
            stage1.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DatosAlimento.fxml"));
            Parent root = loader.load();
            ControladorDatosAlimento controlador = loader.getController();
            controlador.setStage(stage);
            controlador.initStage(root, usuario);
        } catch (IOException ex) {
            Logger.getLogger(ControladorAlimentoTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void misDatos(Usuario usuario) {
        try {
            // lambda expression
            Stage stage1 = (Stage) MnBAdmin.getScene().getWindow();
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

}
