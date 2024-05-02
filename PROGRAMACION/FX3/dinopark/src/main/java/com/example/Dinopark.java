package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Dinopark {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ListarZonas;

    @FXML
    private Button crearAtraccion;

    @FXML
    private Button listarDinosaurios;

    @FXML
    private Button salir;

    @FXML
    void listarDinosaurios(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setWidth(925);
        stage.setHeight(550);

        App.setRoot("listaDinosaurio");
       

    }

    @FXML
    void salir(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void initialize() {

    }

}
