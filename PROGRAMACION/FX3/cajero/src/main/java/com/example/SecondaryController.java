package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.TouchEvent;
import javafx.stage.Stage;

public class SecondaryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> cuentas;

    @FXML
    private Label nombreCliente;

    @FXML
    private Button pagar;

    @FXML
    private Button sacar;

    @FXML
    void SacarDinero(ActionEvent event) {

    }

    @FXML
    void nose(TouchEvent event) {
        System.out.println("hola");
    }

    @FXML
    void cerrarSesion(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    void pagarFactura(ActionEvent event) {

    }

    public void setCliente(String nif) {
        String nombre = App.listaClientes.get(nif).getNombre();
        String apellidos = App.listaClientes.get(nif).getApellidos();
        nombreCliente.setText(nombre + " " + apellidos);
        String[] nose = { "hola", "que", "tal" };
        cuentas.setItems(FXCollections.observableArrayList(nose));

    }

    @FXML
    void initialize() {
        sacar.setDisable(true);
        pagar.setDisable(true);
    }

}
