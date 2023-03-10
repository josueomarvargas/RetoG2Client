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
import exceptions.SoloNumerosException;
import exceptions.UsuarioNullException;
import factoria.AlimentoFactoria;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logic.AlimentoInterface;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author josue
 */
public class ControladorAlimentoTabla {
//Atributos FXML

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
    @FXML
    private Button ayudaBoton;
//Getter 

    /**
     * Getter
     * @return Stage
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
     * Ejecuta todas las condiciones antes de que se habla la ventana
     *
     * @param root Parent
     */
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

        } catch (AlimentoInterfaceException ex) {
            Logger.getLogger(ControladorAlimentoTabla.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Ejecuta todas las condiciones antes de que se habla la ventana
     *
     * @param root Parent
     * @param usuario Usuario
     */
    public void initStage(Parent root, Usuario usuario) {
        try {
            Stage stage1 = new Stage();
            Scene scene = new Scene(root);
            stage1.setScene(scene);
            stage1.setResizable(false);
            //Ejecucion de la factoria
            alimentosInter = AlimentoFactoria.createAlimentoManager(AlimentoFactoria.REST_WEB_CLIENT_TYPE);
            //Creacion de las filas
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
//Botones y mas Menus
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
            ayudaBoton.setOnAction((event) -> {
                ayuda(usuario, event);
            });
            mnIVerDietas.setOnAction((event) -> {
                verDietas(usuario, event);
            });
            mnBCrearDietas.setOnAction((event) -> {
                crearDietas(usuario, event);
            });
            filtrarBoton.setOnAction(this::hadleBotonFiltrar);
            informeBoton.setOnAction(this::hadleBotonInforme);
        } catch (AlimentoInterfaceException ex) {
            Logger.getLogger(ControladorAlimentoTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//Mete Datos a la Combo box

    private void anadirComboBoxTipo() {
        tipoComboBox.getItems().add(TipoAlimento.CEREAL);
        tipoComboBox.getItems().add(TipoAlimento.CARNE);
        tipoComboBox.getItems().add(TipoAlimento.FRUTA);
        tipoComboBox.getItems().add(TipoAlimento.HORTALIZA);
        tipoComboBox.getItems().add(TipoAlimento.LECHE_DEREVADOS);
        tipoComboBox.getItems().add(TipoAlimento.LEGUMBRE);
        tipoComboBox.getItems().add(TipoAlimento.MANTECA_ACEITE);

    }
//Inicia Sesion del Usuario

    private void hadleMenuCerrarSesion(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Salir");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure?");
        Optional opc = alert.showAndWait();
        if (opc.isPresent()) {
            if (opc.get() == ButtonType.OK) {
                try {
//Cierra la ventana actual
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

    /**
     * Vuelve a la ventana Anterior, Ventana Menu Dietista
     *
     * @param event ActionEvent
     */
    public void hadleBotonVolver(ActionEvent event) {
        try {
            //Cierra la ventana actual
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

    /**
     * Abre el Informe de alimento
     *
     * @param event ActionEvent
     */
    public void hadleBotonInforme(ActionEvent event) {

        try {
            JasperReport report
                    = JasperCompileManager.compileReport("src\\informes\\AlimentoReport.jrxml");
            //Data for the report: a collection of UserBean passed as a JRDataSource
            //implementation 

            JRBeanCollectionDataSource dataItems
                    = new JRBeanCollectionDataSource((Collection<Alimento>) this.tablaAlimento.getItems());
//Map of parameter to be passed to the report
            Map<String, Object> parameters = new HashMap<>();
            //Fill report with data
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, dataItems);
            //Create and show the report window. The second parameter false value makes 
            //report window not to close app.
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setVisible(true);
            // jasperViewer.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        } catch (JRException ex) {
            Logger.getLogger(ControladorAlimentoTabla.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Te lleva a la ventana de Datos alimento
     *
     * @param event ActionEvent
     */
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
//Te modifica el Alimento Seleccionado

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

    /**
     * Te filtra los alimentos de la tabla
     *
     * @param event ActionEvent
     */
    public void hadleBotonFiltrar(ActionEvent event) {
        try {
            AlimentoInterface alimentoInterface;
            //ejecuta una factoria
            alimentoInterface = AlimentoFactoria.createAlimentoManager(AlimentoFactoria.REST_WEB_CLIENT_TYPE);
            //Muestra todos los datos de la tabla
            if (nombreText.getText().equalsIgnoreCase("") && menorText.getText().equalsIgnoreCase("") && mayorText.getText().equalsIgnoreCase("") && minText.getText().equalsIgnoreCase("") && maxText.getText().equalsIgnoreCase("") && tipoComboBox.getValue() == null) {
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
                //Elige el tipo de caracteristica para filtrar y el atributo que quieres filtrar
                if (filtrarCBox.getValue().toString().equalsIgnoreCase("Proteinas")) {
                    if (!nombreText.getText().equalsIgnoreCase("")) {
                        alimento = alimentoInterface.getAlimentoPorNombre(nombreText.getText());
                        alimentos.add(alimento);
                        datosAlimento = FXCollections.observableArrayList(alimentos);
                    } else if (!menorText.getText().equalsIgnoreCase("")) {
                        if (!onlyNumbers(menorText.getText())) {
                            throw new SoloNumerosException("Error");
                        }
                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorProteinasMinimo(menorText.getText()));
                    } else if (!mayorText.getText().equalsIgnoreCase("")) {
                        if (!onlyNumbers(mayorText.getText())) {
                            throw new SoloNumerosException("Error");
                        }
                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorProteinasSuperior(mayorText.getText()));
                    } else if (!minText.getText().equalsIgnoreCase("") && !maxText.getText().equalsIgnoreCase("")) {
                        if (!onlyNumbers(minText.getText()) && !onlyNumbers(maxText.getText())) {
                            throw new SoloNumerosException("Error");
                        }
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
                        if (!onlyNumbers(menorText.getText())) {
                            throw new SoloNumerosException("Error");
                        }
                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorCaloriasMinimo(menorText.getText()));
                    } else if (!mayorText.getText().equalsIgnoreCase("")) {
                        if (!onlyNumbers(mayorText.getText())) {
                            throw new SoloNumerosException("Error");
                        }
                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorCaloriasSuperior(mayorText.getText()));
                    } else if (!minText.getText().equalsIgnoreCase("") && !maxText.getText().equalsIgnoreCase("")) {
                        if (!onlyNumbers(minText.getText()) && !onlyNumbers(maxText.getText())) {
                            throw new SoloNumerosException("Error");
                        }
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
                        if (!onlyNumbers(menorText.getText())) {
                            throw new SoloNumerosException("Error");
                        }
                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorGrasasMinimo(menorText.getText()));
                    } else if (!mayorText.getText().equalsIgnoreCase("")) {
                        if (!onlyNumbers(mayorText.getText())) {
                            throw new SoloNumerosException("Error");
                        }
                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorGrasasSuperior(mayorText.getText()));
                    } else if (!minText.getText().equalsIgnoreCase("") && !maxText.getText().equalsIgnoreCase("")) {
                        if (!onlyNumbers(minText.getText()) && !onlyNumbers(maxText.getText())) {
                            throw new SoloNumerosException("Error");
                        }
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
                        if (!onlyNumbers(menorText.getText())) {
                            throw new SoloNumerosException("Error");
                        }
                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorCarbohidratosMinimo(menorText.getText()));
                    } else if (!mayorText.getText().equalsIgnoreCase("")) {
                        if (!onlyNumbers(mayorText.getText())) {
                            throw new SoloNumerosException("Error");
                        }
                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorCarbohidratosSuperior(mayorText.getText()));
                    } else if (!minText.getText().equalsIgnoreCase("") && !maxText.getText().equalsIgnoreCase("")) {
                        if (!onlyNumbers(minText.getText()) && !onlyNumbers(maxText.getText())) {
                            throw new SoloNumerosException("Error");
                        }
                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorCarbohidratosEntre(maxText.getText(), minText.getText()));
                    } else {
                        datosAlimento = FXCollections.observableArrayList(alimentoInterface.getAlimentoPorTipo(tipoComboBox.getValue().toString()));

                    }
                }
//Muestra los datos en la tabla
                tablaAlimento.setItems(datosAlimento);
            }
            //Actualiza la tabla
            tablaAlimento.refresh();

        } catch (AlimentoInterfaceException ex) {
            Logger.getLogger(ControladorAlimentoTabla.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SoloNumerosException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Mayor, menor y entre valores numericos", ButtonType.OK);
            alert.show();
        }
    }
// a??ade los tipos de caracteristica en el combo box

    private void anadirComboBoxTipo2() {
        filtrarCBox.getItems().add("Proteinas");
        filtrarCBox.getItems().add("Calorias");
        filtrarCBox.getItems().add("Grasas Totales");
        filtrarCBox.getItems().add("Carbohidratos");
        filtrarCBox.getSelectionModel().select("Proteinas");
    }
//vuelve a la Ventana anterior

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
//Crear un Alimento

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
// te lleva a los datos de Usuario

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
//Te lleva a la ventana de Crear Alimento

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
//Te muestra un guia de Ayuda de como funciona la tabla y los datos alimento

    private void ayuda(Usuario usuario, ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Ayuda.fxml"));
            Parent root = loader.load();
            ControladorAyuda controlador = loader.getController();
            controlador.setStage(stage);
            controlador.initStage(root);

        } catch (IOException ex) {
            Logger.getLogger(ControladorAlimentoTabla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//muestra la tabla de dietas

    private void verDietas(Usuario usuario, ActionEvent event) {
        try {
            Stage stage1 = (Stage) MnBAdmin.getScene().getWindow();
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
//Te lleva a la ventana datos Dieta para crear la Dieta 

    private void crearDietas(Usuario usuario, ActionEvent event) {
        try {
            Stage stage1 = (Stage) MnBAdmin.getScene().getWindow();
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

    /**
     * Controla que solo sea numero
     *
     * @param input String
     * @return boolean
     */
    public static boolean onlyNumbers(String input) {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

}
