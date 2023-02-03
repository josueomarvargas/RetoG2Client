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
import exceptions.CrearAlimentoException;
import exceptions.ExisteIdException;
import exceptions.ExisteNombreException;
import exceptions.SoloNumerosException;
import factoria.AlimentoFactoria;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import javafx.stage.Stage;
import logic.AlimentoInterface;

/**
 * Controla los datos de Alimento tanto como crear y modificar
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

    /**
     * Getter
     *
     * @return stage
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
     * Inicializa los datos a mostrar en la ventana
     *
     * @param root Parent
     */
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
    }

    /**
     * Inicializa los datos a mostrar en la ventana
     *
     * @param root Parent
     * @param usuario Usuario
     */
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
        //Acciones de los botones
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
        mnIVerDietas.setOnAction((event) -> {
            verDietas(usuario, event);
        });
        mnBCrearDietas.setOnAction((event) -> {
            crearDietas(usuario, event);
        });
    }

    /**
     * Inicializa los datos a mostrar en la ventana
     *
     * @param root Parent
     * @param alimento Objeto Alimento
     * @param usuario Objeto Usuario
     */
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
        //Acciones de los botones

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
        mnIVerDietas.setOnAction((event) -> {
            verDietas(usuario, event);
        });
        mnBCrearDietas.setOnAction((event) -> {
            crearDietas(usuario, event);
        });

    }
//Añade Datos al ComboBox

    private void anadirComboBoxTipo() {
        tipoComboBox.getItems().add(TipoAlimento.CEREAL);
        tipoComboBox.getItems().add(TipoAlimento.CARNE);
        tipoComboBox.getItems().add(TipoAlimento.FRUTA);
        tipoComboBox.getItems().add(TipoAlimento.HORTALIZA);
        tipoComboBox.getItems().add(TipoAlimento.LECHE_DEREVADOS);
        tipoComboBox.getItems().add(TipoAlimento.LEGUMBRE);
        tipoComboBox.getItems().add(TipoAlimento.MANTECA_ACEITE);

    }
//Cierra Sesion del usuario vuelve a la ventana de Inicio de Sesión 

    @FXML
    private void hadleMenuCerrarSesion(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Salir");
        alert.setHeaderText(null);
        alert.setContentText("¿Estas Seguro?");
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

    /**
     * Crea un nuevo alimento y vuelve a la ventana de tabla alimento
     *
     * @param usuario Usuario
     * @param event ActionEvent
     */
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
            //Controla que alimento no sea null
            if (alimento != null) {
                throw new ExisteNombreException("Error");
            }
            //controla que no haya campos vacios
            if (idText.getText().equalsIgnoreCase("") || nombreText.getText().equalsIgnoreCase("") || caloriasText.getText().equalsIgnoreCase("") || grasasText.getText().equalsIgnoreCase("")
                    || proteinasText.getText().equalsIgnoreCase("") || carbohidratosText.getText().equalsIgnoreCase("") || tipoComboBox.getValue() == null) {
                throw new CrearAlimentoException("Llena todos los campos");
            } else if (!onlyNumbers(caloriasText.getText()) || !onlyNumbers(grasasText.getText()) || !onlyNumbers(proteinasText.getText()) || !onlyNumbers(carbohidratosText.getText())) {
                throw new SoloNumerosException("Error");
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
        } catch (CrearAlimentoException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Llena todos los campos con sus Valores Correspondientes", ButtonType.OK);
            alert.show();
        } catch (SoloNumerosException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Calorias, Proteinas, Grasas Totales y Carbohidratos son valores numericos", ButtonType.OK);
            alert.show();
        }

    }
    // Crea el Alimento Objeto 

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

    /**
     * Vuelve a ventana Alimento Tabla
     *
     * @param usuario Usuario
     * @param event ActionEvent
     */
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

    /**
     * Elimina Alimento que ha sido seleccionado
     *
     * @param usuario Usuario
     * @param event ActionEvent
     */
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

    /**
     * Modifica el Alimento que ha sido seleccionado
     *
     * @param usuario Usuario
     * @param event ActionEvent
     */
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
        } catch (SoloNumerosException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Calorias, Proteinas, Grasas Totales y Carbohidratos son valores numericos", ButtonType.OK);
            alert.show();
        }

    }

    //Modifica los Datos alimento que ha sido seleccionado
    private Alimento modificarAlimento(Alimento alimento) throws SoloNumerosException {
        if (!onlyNumbers(caloriasText.getText()) || !onlyNumbers(grasasText.getText()) || !onlyNumbers(proteinasText.getText()) || !onlyNumbers(carbohidratosText.getText())) {
            throw new SoloNumerosException("Error");
        } else {
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
    }
//Muestra los Datos del usuario conectado en la ventana Datos Dietista

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
// Crea alimento y tella a la otra ventana (Datos Alimento)

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
//Ve los alimentos de la Tabla

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

    /**
     * Controla que sea Float los numeros
     *
     * @param input String
     * @return boolean
     */
    public static boolean onlyNumbers(String input) {
        Pattern pattern = Pattern.compile("[+-]?([0-9]*[.])?[0-9]+");
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }
//Muestra la Ventana de la tabla dietas

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
//Muestra la ventana de crear dietas

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
}
