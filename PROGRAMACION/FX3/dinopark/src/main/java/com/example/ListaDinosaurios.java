package com.example;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ListaDinosaurios {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> alimentacion;

    @FXML
    private ImageView buscar;

    @FXML
    private TableColumn<Dinosaurio, String> colAlimentacion;

    @FXML
    private TableColumn<Dinosaurio, String> colNombre;

    @FXML
    private TableColumn<Dinosaurio, String> colTamanyo;

    @FXML
    private TableColumn<Dinosaurio, String> colTipo;

    @FXML
    private Button menu;

    @FXML
    private TableView<?> tablaDinosaurio;

    @FXML
    private ChoiceBox<String> tamanyo;

    @FXML
    private ChoiceBox<String> tipo;

    private Connection con ;

    @FXML
    void buscar(MouseEvent event) {
        System.out.println("hola");
    }

    @FXML
    void vueltaMenu(ActionEvent event) throws IOException{
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setWidth(800);
        stage.setHeight(500);
        App.setRoot("dinopark");
    }

    @FXML
    void initialize() {
        con = Dinopark.getCon();
       String[]tamanyo= {"grande" ,"mediano" , "peque"};
       String[]alimentacion= {"carnivoro" ,"omnivoro" , "herbivoro"};
       String[]tipo= {"tierra" ,"aire" , "agua"};
       
       this.tamanyo.setItems(FXCollections.observableArrayList(tamanyo));
       this.alimentacion.setItems(FXCollections.observableArrayList(alimentacion));
       this.tipo.setItems(FXCollections.observableArrayList(tipo));

         colNombre.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("nombre"));
            colTamanyo.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("tamanyo"));
            colAlimentacion.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("alimentacion"));
            colTipo.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("tipo"));

    }

}
