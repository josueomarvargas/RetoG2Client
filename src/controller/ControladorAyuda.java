/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *Ejecuta la ventana de Ayuda
 * @author josue
 */
public class ControladorAyuda {

    private Stage stage;
    @FXML
    private WebView webView;

    /**
     *Getter
     * @return stage
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
     *Inicializa  los datos a mostrar en la ventana
     * @param root Parent
     */
    
    public void initStage(Parent root) {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Ayuda para la Gestion de Alimentos");
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setOnShowing(this::handleWindowShowing);
        stage.show();
    }
//Ejecuta la Pagina de ayuda

    private void handleWindowShowing(WindowEvent event) {
        WebEngine webEngine = webView.getEngine();
        //Load help page.
        webEngine.load(getClass().getResource("/view/ayuda.html").toExternalForm());
    }

}
