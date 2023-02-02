/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Dieta;
import entities.Objetivo;
import entities.TipoDieta;
import entities.Usuario;
import exceptions.CrearDietaNoNombreException;
import exceptions.CrearDietaNoObjetivoException;
import exceptions.CrearDietaNoTiempoException;
import exceptions.CrearDietaNoTipoException;
import exceptions.SoloNumerosException;
import exceptions.Sololetrasexception;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.DietaImplementacion;
import logic.InterfaceDietaClie;

/**
 *
 * @author Gonzalo
 */
public class Controller_CrearModificarDieta {

    @FXML
    private Stage stage;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnCrear;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtTiempo;
    @FXML
    private ComboBox comboObjetivo;
    @FXML
    private ComboBox comboTipo;

    private InterfaceDietaClie interdieta;

    private ObservableList<String> tipo = FXCollections.observableArrayList(TipoDieta.VEGETARIANA.toString(), TipoDieta.VEGANA.toString(), TipoDieta.OMNIVORO.toString());

    private ObservableList<String> objetivo = FXCollections.observableArrayList(Objetivo.SUBIR_PESO.toString(), Objetivo.BAJAR_PESO.toString());

    private String idModificado;

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
     * Inicializa la ventana entrando por el boton de crear de la ventana
     * TablaDietas y hace visible y habilita el boton crear
     *
     * @param root
     * @param usuario
     */
    public void initStage(Parent root, Usuario usuario) {

        Scene scene = new Scene(root);
        Stage stage1 = new Stage();
        stage1.setScene(scene);
        stage1.setResizable(false);
        btnCrear.setVisible(true);
        btnCrear.setDisable(false);
        btnModificar.setVisible(false);
        comboObjetivo.setItems(objetivo);
        comboTipo.setItems(tipo);
        btnCancelar.setOnAction((event) -> {
            handleButtonCancelar(usuario);
        });
        btnCrear.setOnAction((event) -> {
            handleButtonCrear(usuario, event);
        });
        stage1.setTitle("Dieta");
        stage1.show();
    }

    /**
     * Inicializa la ventana entrando por el boton de crear de la ventana
     * TablaDietas y hace visible y habilita el boton modificar y carga los
     * datos del objeto que se le pasa de la ventana anterior en los TextField y
     * las ComboBox
     *
     * @param root
     * @param dieta
     * @param usuario
     */
    public void initStage(Parent root, Dieta dieta, Usuario usuario) {

        Scene scene = new Scene(root);
        Stage stage1 = new Stage();
        stage1.setScene(scene);
        stage1.setResizable(false);
        txtNombre.setText(dieta.getNombre());
        txtTiempo.setText(Integer.toString(dieta.getTiempo()));
        comboObjetivo.setItems(objetivo);
        //comboObjetivo.getSelectionModel().select(dieta.getObjetivo().toString());
        comboTipo.setItems(tipo);
        comboTipo.getSelectionModel().select(dieta.getTipo().toString());
        idModificado = dieta.getIdDieta();
        btnCrear.setVisible(false);
        btnCancelar.setOnAction((event) -> {
            handleButtonCancelar(usuario);
        });
        btnModificar.setVisible(true);
        btnModificar.setOnAction((event) -> {
            handleButtonModificar(dieta, usuario);
        });
        stage1.setTitle("Dieta");
        stage1.show();
    }

    /**
     * Inicializa la venta TablaDietas al pulsar el boton Cancelar y cierra la
     * actual
     *
     * @param usuario
     * @param event
     */
    public void handleButtonCancelar(Usuario usuario) {
        try {
            Stage mainstage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TablaDietas.fxml"));
            Parent root = loader.load();
            Controler_TablaDietas controlador = loader.getController();
            controlador.setStage(mainstage);
            controlador.initStage(root, usuario);
            Stage stage = (Stage) btnCancelar.getScene().getWindow();
            stage.close();
        } catch (IOException ex) {
            Logger.getLogger(Controller_CrearModificarDieta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Comprueba que los campos NOMBRE(TxtFNombreDieta), TIEMPO(TxtFTiempo),
     * OBJETIVO(ComboObjetivo) y TIPO(ComboTiipoDiet) estan informados Si no
     * están informados muestra un mensaje de error informando al usuario y
     * cancela el método.
     *
     * Validar el formato y longitud de NOMBRE(TxtFNombreDieta) que no contenga
     * caracteres especiales y tenga como mínimo 5 caracteres Si no tiene menos
     * de 5 caracteres o contiene caracteres especiales se avisara con un
     * mensaje de error, se pedirá que introduzca correctamente los datos y se
     * cancelara el método CrearDietaNoNombreException se notificará al usuario
     * mediante un mensaje de error y se cancela el método.
     *
     * Sololetrasexception se notificará al usuario mediante un mensaje de error
     * y se cancela el método.
     *
     * Validar el formato de TIEMPO(TxtFTiempo) que solo contenga números Si no
     * contiene números se notificará con un mensaje de error, se pedirá que se
     * introduzca correctamente y se cancelara el metodo
     * CrearDietaNoTiempoException se notificará al usuario mediante un mensaje
     * de error y se cancela el método
     *
     * SoloNumerosException se notificará al usuario mediante un mensaje de
     * error y se cancela el método
     *
     * Validar que haya algo seleccionado en OBJETIVO(ComboObjetivo) Si no hay
     * nada seleccionado se notificará con un mensaje de error, se pedirá que se
     * seleccione algo y se cancelara el método CrearDietaNoObjetivoException se
     * notificará al usuario mediante un mensaje de error y se cancela el método
     * *
     *
     * Validar que haya algo seleccionado en TIPO(ComboTiipoDiet) Si no hay nada
     * seleccionado se notificará con un mensaje de error, se pedirá que se
     * seleccione un dato y se cancelara el método CrearDietaNoTipoException se
     * notificará al usuario mediante un mensaje de error y se cancela el método
     *
     * Si todos los datos se han validado correctamente se recogen los datos se
     * crea un objeto (Dieta), se llamará al método crearDieta(Dieta) enviando
     * el objeto (Dieta).
     *
     * Si no salta ninguna excepción se notificará de la creación de la dieta al
     * usuario mediante un mensaje de confirmación y se volverá a la venta de
     * TablaDietas
     *
     * @param usuario
     * @param event
     */
    @FXML
    public void handleButtonCrear(Usuario usuario, ActionEvent event) {
        try {
            Dieta dieta = new Dieta();
            interdieta = new DietaImplementacion();

            String idmax;
            ObservableList<Dieta> dietaData = FXCollections.observableArrayList(interdieta.getDietaAll());
            dieta = dietaData.get(dietaData.size() - 1);
            idmax = dieta.getIdDieta();
            String idlast = dieta.id(idmax);

            dieta.setIdDieta(idlast);
            boolean p = onlyLetters(txtNombre.getText());
            if (txtNombre.getText().equals("")) {
                throw new CrearDietaNoNombreException("Error");
            } else if (p == false) {
                throw new Sololetrasexception("Error");
            }
            dieta.setNombre(txtNombre.getText());

            boolean b = onlyNumbers(txtTiempo.getText());
            if (txtTiempo.getText().equals("")) {
                throw new CrearDietaNoTiempoException("Error");
            } else if (b == false) {
                throw new SoloNumerosException("Error");
            }
            dieta.setTiempo(Integer.parseInt(txtTiempo.getText()));

            if (comboTipo.getSelectionModel().getSelectedIndex() == -1) {
                throw new CrearDietaNoTipoException("Error");
            }
            TipoDieta tip = TipoDieta.parse((String) comboTipo.getSelectionModel().getSelectedItem());
            dieta.setTipo(tip);

            if (comboObjetivo.getSelectionModel().getSelectedIndex() == -1) {
                throw new CrearDietaNoObjetivoException("Error");
            }
            Objetivo obj = Objetivo.parse((String) comboObjetivo.getSelectionModel().getSelectedItem());
            dieta.setOBJETIVO(obj);

            interdieta.crearDieta(dieta);

            Stage mainstage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TablaDietas.fxml"));
            Parent root = loader.load();
            Controler_TablaDietas controlador = loader.getController();
            controlador.setStage(mainstage);
            controlador.initStage(root, usuario);
            Stage stage = (Stage) btnCancelar.getScene().getWindow();
            stage.close();
        } catch (IOException ex) {
            Logger.getLogger(Controller_CrearModificarDieta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Sololetrasexception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Introduzca solo letras en el campo nombre", ButtonType.OK);
            alert.show();
        } catch (CrearDietaNoNombreException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Introduzca datos en el campo nombre", ButtonType.OK);
            alert.show();
        } catch (SoloNumerosException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Introduzca solo numeros en el campo tiempo", ButtonType.OK);
            alert.show();
        } catch (CrearDietaNoTiempoException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Introduzca datos en el campo tiempo", ButtonType.OK);
            alert.show();
        } catch (CrearDietaNoTipoException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Seleccione un dato del la combobox tipo", ButtonType.OK);
            alert.show();
        } catch (CrearDietaNoObjetivoException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Seleccione un dato del la combobox objetivo", ButtonType.OK);
            alert.show();
        }
    }

    /**
     * Comprueba que los campos NOMBRE(TxtFNombreDieta), TIEMPO(TxtFTiempo),
     * OBJETIVO(ComboObjetivo) y TIPO(ComboTiipoDiet) estan informados Si no
     * están informados muestra un mensaje de error informando al usuario y
     * cancela el método.
     *
     * Validar el formato y longitud de NOMBRE(TxtFNombreDieta) que no contenga
     * caracteres especiales y tenga como mínimo 5 caracteres Si no tiene menos
     * de 5 caracteres o contiene caracteres especiales se avisara con un
     * mensaje de error, se pedirá que introduzca correctamente los datos y se
     * cancelara el método CrearDietaNoNombreException se notificará al usuario
     * mediante un mensaje de error y se cancela el método.
     *
     * Sololetrasexception se notificará al usuario mediante un mensaje de error
     * y se cancela el método.
     *
     * Validar el formato de TIEMPO(TxtFTiempo) que solo contenga números Si no
     * contiene números se notificará con un mensaje de error, se pedirá que se
     * introduzca correctamente y se cancelara el metodo
     * CrearDietaNoTiempoException se notificará al usuario mediante un mensaje
     * de error y se cancela el método
     *
     * SoloNumerosException se notificará al usuario mediante un mensaje de
     * error y se cancela el método
     *
     * Validar que haya algo seleccionado en OBJETIVO(ComboObjetivo) Si no hay
     * nada seleccionado se notificará con un mensaje de error, se pedirá que se
     * seleccione algo y se cancelara el método CrearDietaNoObjetivoException se
     * notificará al usuario mediante un mensaje de error y se cancela el método
     * *
     *
     * Validar que haya algo seleccionado en TIPO(ComboTiipoDiet) Si no hay nada
     * seleccionado se notificará con un mensaje de error, se pedirá que se
     * seleccione un dato y se cancelara el método CrearDietaNoTipoException se
     * notificará al usuario mediante un mensaje de error y se cancela el método
     *
     * Si todos los datos se han validado correctamente se recogen los datos se
     * crea un objeto (Dieta), se llamará al método crearDieta(Dieta) enviando
     * el objeto (Dieta).
     *
     * Si no salta ninguna excepción se notificará de la modificacion de la
     * dieta al usuario mediante un mensaje de confirmación y se volverá a la
     * venta de TablaDietas
     *
     * @param dieta1
     * @param usuario
     * @param event
     */
    public void handleButtonModificar(Dieta dieta1, Usuario usuario) {
        try {
            Dieta dieta = null;
            interdieta = new DietaImplementacion();
            ObservableList<Dieta> dietaData = FXCollections.observableArrayList(interdieta.getDietaAll());
            String nombre = txtNombre.getText();
            String tiempo = txtTiempo.getText();
            TipoDieta tipo = TipoDieta.parse((String) comboTipo.getSelectionModel().getSelectedItem());
            Objetivo objetivo = Objetivo.parse((String) comboObjetivo.getSelectionModel().getSelectedItem());
            for (int i = 0; i < dietaData.size(); i++) {
                if (dietaData.get(i).getIdDieta().equalsIgnoreCase(idModificado)) {
                    dieta = dietaData.get(i);
                }
            }

            boolean p = onlyLetters(txtNombre.getText());
            if (txtNombre.getText().equals("")) {
                throw new CrearDietaNoNombreException("Error");
            } else if (p == false) {
                throw new Sololetrasexception("Error");

            }
            dieta.setNombre(nombre);

            boolean b = onlyNumbers(txtTiempo.getText());
            if (txtTiempo.getText().equals("")) {
                throw new CrearDietaNoTiempoException("Error");
            } else if (b == false) {
                throw new SoloNumerosException("Error");
            }
            dieta.setTiempo(Integer.parseInt(tiempo));

            if (comboTipo.getSelectionModel().getSelectedIndex() == -1) {
                throw new CrearDietaNoTipoException("Error");
            }
            dieta.setTipo(tipo);

            if (comboObjetivo.getSelectionModel().getSelectedIndex() == -1) {
                throw new CrearDietaNoObjetivoException("Error");
            }
            dieta.setOBJETIVO(objetivo);
            interdieta.modificarDieta(dieta);

            Stage mainstage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TablaDietas.fxml"));
            Parent root = loader.load();
            Controler_TablaDietas controlador = loader.getController();
            controlador.setStage(mainstage);
            controlador.initStage(root, usuario);
            Stage stage = (Stage) btnCancelar.getScene().getWindow();
            stage.close();
        } catch (IOException ex) {
            Logger.getLogger(Controller_CrearModificarDieta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Sololetrasexception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Introduzca solo letras en el campo nombre", ButtonType.OK);
            alert.show();
        } catch (CrearDietaNoNombreException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Introduzca datos en el campo nombre", ButtonType.OK);
            alert.show();
        } catch (SoloNumerosException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Introduzca solo numeros en el campo tiempo", ButtonType.OK);
            alert.show();
        } catch (CrearDietaNoTiempoException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Introduzca datos en el campo tiempo", ButtonType.OK);
            alert.show();
        } catch (CrearDietaNoTipoException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Seleccione un dato del la combobox tipo", ButtonType.OK);
            alert.show();
        } catch (CrearDietaNoObjetivoException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Seleccione un dato del la combobox objetivo", ButtonType.OK);
            alert.show();
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
