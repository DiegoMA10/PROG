package com.example;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class CrearZona {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Slider capacidad;

    @FXML
    private MenuItem diez;

    @FXML
    private MenuButton menuEdad;

    @FXML
    private TextField nombre;

    @FXML
    private Label numCapacidad;

    @FXML
    void diez(ActionEvent event) {
             menuEdad.setText("10");
    }

   
    

    @FXML
    void hola(ActionEvent event) {
       System.out.println("hola");
    }

    @FXML
    void initialize() {
        assert capacidad != null : "fx:id=\"capacidad\" was not injected: check your FXML file 'crearZona.fxml'.";
        assert diez != null : "fx:id=\"diez\" was not injected: check your FXML file 'crearZona.fxml'.";
        assert menuEdad != null : "fx:id=\"menuEdad\" was not injected: check your FXML file 'crearZona.fxml'.";
        assert nombre != null : "fx:id=\"nombre\" was not injected: check your FXML file 'crearZona.fxml'.";
        assert numCapacidad != null : "fx:id=\"numCapacidad\" was not injected: check your FXML file 'crearZona.fxml'.";

    }

}
