/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Dieta;
import entities.Objetivo;
import entities.TipoDieta;
import exceptions.FiltroDietaException;
import exceptions.SoloNumerosException;
import exceptions.Sololetrasexception;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.ws.rs.core.GenericType;
import logic.DietaRestfulCliente;
import logic.FactoryDieta;
import logic.InterfaceDietaClie;
import logic.DietaImplementacion;

/**
 *
 * @author Gonzalo
 */
public class Controler_TablaDietas {

    @FXML
    private Stage stage;
    @FXML
    private Button btnCrear;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnBorrar;
    @FXML
    private Button btnInforme;
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnFiltrar;
    @FXML
    private Button btnResetear;
    @FXML
    private TextField txtFieldNombre;
    @FXML
    private TextField txtFieldTiempoMin;
    @FXML
    private TextField txtFieldTiempoMax;
    @FXML
    private RadioButton rButtonVegetariana;
    @FXML
    private RadioButton rButtonVegana;
    @FXML
    private RadioButton rButtonOmnivora;
    @FXML
    private RadioButton rButtonSubirPeso;
    @FXML
    private RadioButton rButtonBajarPeso;
    @FXML
    private TableView tbViewDieta;
    @FXML
    private TableColumn tbColumnId;
    @FXML
    private TableColumn tbColumnNombre;
    @FXML
    private TableColumn tbColumnObjetivo;
    @FXML
    private TableColumn tbColumnTipo;
    @FXML
    private TableColumn tbColumnTiempo;

    private ObservableList<Dieta> dietaData;
    @FXML
    private ToggleGroup groupTipo = new ToggleGroup();
    @FXML
    private ToggleGroup groupObjetivo = new ToggleGroup();

    private FactoryDieta factory = new FactoryDieta();

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private InterfaceDietaClie interdieta;

    /**
     * Están habilitados todos los campos salvo CREAR (BtnDietCrear), MODIFICAR
     * (BtnDietMod) y BORRAR(BtnDietBorrar) que serán solo visibles para los
     * Dietistas. Además MODIFICAR (BtnDietMod) y BORRAR(BtnDietBorrar) estarán
     * deshabilitados En la tabla se mostrarán los datos de las Dietas
     * existentes.
     *
     * @param root
     */
    public void initStage(Parent root) {

        Scene scene = new Scene(root);
        Stage stage1 = new Stage();
        stage1.setScene(scene);
        stage1.setResizable(false);
        rButtonVegetariana.setToggleGroup(groupTipo);
        rButtonVegana.setToggleGroup(groupTipo);
        rButtonOmnivora.setToggleGroup(groupTipo);

        rButtonBajarPeso.setToggleGroup(groupObjetivo);
        rButtonSubirPeso.setToggleGroup(groupObjetivo);

        btnCrear.setOnAction(this::handleButtonCrear);
        btnModificar.setOnAction(this::handleButtonModificar);
        btnFiltrar.setOnAction(this::handleButtonFiltrar);
        btnResetear.setOnAction(this::handleButtonResetear);
        btnBorrar.setOnAction(this::handleButtonBorrar);
        btnVolver.setOnAction(this::handleButtonVolver);
        
        stage1.setTitle("Tabla de Dietas");
        interdieta = new DietaImplementacion();

        dietaData = FXCollections.observableArrayList(interdieta.getDietaAll());
        cargarTabla(dietaData);

        tbViewDieta.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                btnModificar.setDisable(false);
            } else {
                btnModificar.setDisable(true);
            }

            if (newSelection != null) {
                btnBorrar.setDisable(false);
            } else {
                btnBorrar.setDisable(true);
            }
        });

        stage1.show();
    }

    /**
     * Abre la ventana de MenuAdministrador en caso de que el usuario logueado
     * sea un administrador, la venta MenuCliente en caso de que el usuario
     * logueado sea un cliente o la venta MenuDietista en caso de que el usuario
     * sea dietista Cierra la ventana actua
     *
     * @param event
     */
    @FXML
    public void handleButtonVolver(ActionEvent event) {
        try {
            Stage mainstage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CrearModificarDieta.fxml"));
            Parent root = loader.load();
            Controller_CrearModificarDieta controlador = loader.getController();
            controlador.setStage(mainstage);
            controlador.initStageCrear(root);
            Stage stage = (Stage) btnCrear.getScene().getWindow();
            stage.close();

        } catch (IOException ex) {
            Logger.getLogger(Controler_TablaDietas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Los campos que estén informados serán vaciados en el caso de los
     * TextField y se desmarcara en caso de los RadioButton ademas recargala
     * tabla y habilitara los textfield y radio buttons desabilitadosx
     *
     * @param event
     */
    @FXML
    private void handleButtonResetear(ActionEvent event) {
        txtFieldNombre.setText("");
        txtFieldTiempoMax.setText("");
        txtFieldTiempoMin.setText("");
        rButtonVegetariana.setSelected(false);
        rButtonVegana.setSelected(false);
        rButtonOmnivora.setSelected(false);
        rButtonSubirPeso.setSelected(false);
        rButtonBajarPeso.setSelected(false);
        cargarTabla(dietaData);
    }

    /**
     * Validar la longitud y formato de NOMBRE(TxtFFiltroNombre) cuya longitud
     * mínima ha de ser 5 y contener solo letras y números Si es más corta que
     * dicha longitud o contiene caracteres no permitidos se enseñara un mensaje
     * de error se le pedirá que lo introduzca correctamente y sale del método
     * Sololetrasexception se notificará al usuario mediante un mensaje de error
     * y se cancela el método.
     *
     * Validar el formato de MINIMO (TxtFTiempoMin) que solo sean numeros Si
     * tiene caracteres que no sean números se informará con un mensaje de error
     * se le pedirá que lo introduzca correctamente y sale del método
     * SoloNumerosExceptionse notificará al usuario mediante un mensaje de error
     * y se cancela el método.
     *
     * Validar el formato de MAXIMO(TxtTiempoMax) que solo sean numeros Si tiene
     * caracteres que no sean números se informará con un mensaje de error se le
     * pedirá que lo introduzca correctamente y sale del método
     * SoloNumerosExceptionse se notificará al usuario mediante un mensaje de
     * error y se cancela el método.
     *
     * Comprueba que esta seleccionado algun radiobutton Vegetariana
     * (RBtnVegetariana), Vegana (RBtnVegana), Omnivora(RBtnOmnivora), Subir
     * Peso (RBtnSubirPeso) y Bajar Peso(RBtnBajarPeso) se notificará al usuario
     * mediante un mensaje de error y se cancela el método.
     *
     * se notificará al usuario mediante un mensaje de error y se cancela el
     * método. Si los campos introducidos están validados correctamente se
     * ejecutará el método filtrarDietas(Dieta) enviando el objeto (Dieta)
     *
     * @param event
     */
    @FXML
    private void handleButtonFiltrar(ActionEvent event) {
        try {
            String nombre = txtFieldNombre.getText();
            String min = txtFieldTiempoMin.getText();
            String max = txtFieldTiempoMax.getText();

            RadioButton nuevo;
            TipoDieta tipo = null;
            if (groupTipo.getSelectedToggle() != null) {
                nuevo = (RadioButton) groupTipo.getSelectedToggle();
                tipo = TipoDieta.parse(nuevo.getText().toUpperCase());
                System.err.println("tipo");
            }
            Objetivo objetivo = null;
            if (groupObjetivo.getSelectedToggle() != null) {
                nuevo = (RadioButton) groupObjetivo.getSelectedToggle();
                objetivo = Objetivo.parse(nuevo.getText().toUpperCase());
            }

            ObservableList<Dieta> filtro = FXCollections.observableArrayList();

            if (nombre.equals("") && min.equals("") && max.equals("") && tipo == null && objetivo == null) {
                throw new FiltroDietaException("Error");
            }

            if (!nombre.equals("")) {
                boolean p = onlyLetters(nombre);
                if (p == false) {
                    throw new Sololetrasexception("Error");
                }
                for (Integer i = 0; i < dietaData.size(); i++) {
                    if (dietaData.get(i).getNombre().equalsIgnoreCase(nombre)) {
                        filtro.add(dietaData.get(i));
                    }
                }
                cargarTabla(filtro);
                filtrodesabilitar();
            }
            if (!min.equals("")) {
                boolean p = onlyNumbers(min);
                if (p == false) {
                    throw new SoloNumerosException("Error");
                }
                for (Integer i = 0; i < dietaData.size(); i++) {
                    if (dietaData.get(i).getTiempo().toString().equals(min)) {
                        filtro.add(dietaData.get(i));
                    }
                }
                cargarTabla(filtro);
                filtrodesabilitar();
            }
            if (!max.equals("")) {
                boolean p = onlyNumbers(max);
                if (p == false) {
                    throw new SoloNumerosException("Error");
                }
                for (Integer i = 0; i < dietaData.size(); i++) {
                    if (dietaData.get(i).getTiempo().toString().equals(max)) {
                        filtro.add(dietaData.get(i));
                    }
                }
                cargarTabla(filtro);
                filtrodesabilitar();
            }
            if (tipo != null) {
                for (int i = 0; i < dietaData.size(); i++) {
                    if (dietaData.get(i).getTipo().equals(tipo)) {
                        filtro.add(dietaData.get(i));
                    }

                }
                cargarTabla(filtro);
                filtrodesabilitar();
            }
            if (objetivo != null) {
                for (int i = 0; i < dietaData.size(); i++) {
                    if (dietaData.get(i).getObjetivo().equals(objetivo)) {
                        filtro.add(dietaData.get(i));
                    }
                }
                cargarTabla(filtro);
                filtrodesabilitar();
            }
        } catch (FiltroDietaException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor rellene/seleccione algun filtro", ButtonType.OK);
            alert.show();
        } catch (Sololetrasexception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Introduzca solo letras en el campo nombre", ButtonType.OK);
            alert.show();
        } catch (SoloNumerosException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Introduzca solo numeros en los campos minimo y maximo", ButtonType.OK);
            alert.show();
        }

    }

    /**
     * Abre la venta CrearModifcarDietas Cierra la ventana actual
     *
     * @param event
     */
    @FXML
    private void handleButtonCrear(ActionEvent event) {
        try {
            Stage mainstage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CrearModificarDieta.fxml"));
            Parent root = loader.load();
            Controller_CrearModificarDieta controlador = loader.getController();
            controlador.setStage(mainstage);
            controlador.initStageCrear(root);
            Stage stage = (Stage) btnCrear.getScene().getWindow();
            stage.close();

        } catch (IOException ex) {
            Logger.getLogger(Controler_TablaDietas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Abre la ventana CrearModificarDietas y carga en ella los datos de la
     * dieta seleccionada de la tabla Cierra la venta actual
     *
     * @param event
     */
    @FXML
    private void handleButtonModificar(ActionEvent event) {
        try {
            Dieta dieta = new Dieta();
            dieta = (Dieta) tbViewDieta.getSelectionModel().getSelectedItem();
            Stage mainstage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CrearModificarDieta.fxml"));
            Parent root = loader.load();
            Controller_CrearModificarDieta controlador = loader.getController();
            controlador.setStage(mainstage);
            controlador.initStageModificar(root, dieta);
            Stage stage = (Stage) btnModificar.getScene().getWindow();
            stage.close();

        } catch (IOException ex) {
            Logger.getLogger(Controler_TablaDietas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Se eliminará de la base de datos y de la tabla la dieta seleccionada.
     *
     * @param event
     */
    @FXML
    private void handleButtonBorrar(ActionEvent event) {
        Dieta dieta = new Dieta();
        interdieta = new DietaImplementacion();
        dieta = (Dieta) tbViewDieta.getSelectionModel().getSelectedItem();
        interdieta.eliminarDieta(dieta);
        dietaData = FXCollections.observableArrayList(interdieta.getDietaAll());
        cargarTabla(dietaData);
    }

    /**
     * Carga la tabla con todos los datos de la base de datos
     *
     * @param dietaData
     */
    private void cargarTabla(ObservableList<Dieta> dietaData) {
        interdieta = new DietaImplementacion();
        tbColumnNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre"));
        tbColumnTipo.setCellValueFactory(
                new PropertyValueFactory<>("tipo"));
        tbColumnTiempo.setCellValueFactory(
                new PropertyValueFactory<>("tiempo"));
        tbViewDieta.setItems(dietaData);
        txtFieldNombre.setDisable(false);
        txtFieldTiempoMax.setDisable(false);
        txtFieldTiempoMin.setDisable(false);
        rButtonVegana.setDisable(false);
        rButtonVegetariana.setDisable(false);
        rButtonOmnivora.setDisable(false);
        rButtonSubirPeso.setDisable(false);
        rButtonBajarPeso.setDisable(false);
    }

    /**
     * Desabilita los campos no usados para el filtrado
     */
    public void filtrodesabilitar() {
        if (!txtFieldNombre.getText().equals("")) {
            txtFieldTiempoMax.setDisable(true);
            txtFieldTiempoMin.setDisable(true);
            rButtonVegana.setDisable(true);
            rButtonVegetariana.setDisable(true);
            rButtonOmnivora.setDisable(true);
            rButtonSubirPeso.setDisable(true);
            rButtonBajarPeso.setDisable(true);
        } else if (!txtFieldTiempoMax.getText().equals("")) {
            txtFieldNombre.setDisable(true);
            txtFieldTiempoMin.setDisable(true);
            rButtonVegana.setDisable(true);
            rButtonVegetariana.setDisable(true);
            rButtonOmnivora.setDisable(true);
            rButtonSubirPeso.setDisable(true);
            rButtonBajarPeso.setDisable(true);
        } else if (!txtFieldTiempoMin.getText().equals("")) {
            txtFieldNombre.setDisable(true);
            txtFieldTiempoMax.setDisable(true);
            rButtonVegana.setDisable(true);
            rButtonVegetariana.setDisable(true);
            rButtonOmnivora.setDisable(true);
            rButtonSubirPeso.setDisable(true);
            rButtonBajarPeso.setDisable(true);
        } else if (groupTipo.getSelectedToggle() != null) {
            txtFieldNombre.setDisable(true);
            txtFieldTiempoMax.setDisable(true);
            txtFieldTiempoMin.setDisable(true);
            rButtonSubirPeso.setDisable(true);
            rButtonBajarPeso.setDisable(true);
        } else if (groupObjetivo.getSelectedToggle() != null) {
            txtFieldNombre.setDisable(true);
            txtFieldTiempoMax.setDisable(true);
            txtFieldTiempoMin.setDisable(true);
            rButtonVegana.setDisable(true);
            rButtonVegetariana.setDisable(true);
            rButtonOmnivora.setDisable(true);
        }
    }

    /**
     * Comprueba que el parametro que se le pase solo contiene letras
     *
     * @param input
     * @return
     */
    public static boolean onlyLetters(String input) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    /**
     * Comprueba que el parametro que se le pase solo contiene numeros
     *
     * @param input
     * @return
     */
    public static boolean onlyNumbers(String input) {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
