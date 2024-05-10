package com.example;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private TableView<Dinosaurio> tablaDinosaurio;

    @FXML
    private ChoiceBox<String> tamanyo;

    @FXML
    private ChoiceBox<String> tipo;

    private Connection con ;

    private ObservableList<Dinosaurio>listaDinosaurios = FXCollections.observableArrayList();

    private ObservableList<Dinosaurio>listaFiltrada = FXCollections.observableArrayList();
    

    @FXML
    void buscar(MouseEvent event) {
        listaFiltrada.clear();
        for (Dinosaurio dinosaurio : listaDinosaurios) {
            if ((tipo.getValue()==null || tipo.getValue().equals(dinosaurio.getTipo())) &&
                (tamanyo.getValue()==null || tamanyo.getValue().equals(dinosaurio.getTamanyo())) &&
                (alimentacion.getValue()==null || alimentacion.getValue().equals(dinosaurio.getAlimentacion()))) {
                listaFiltrada.add(dinosaurio);
            }
        }
        
        tablaDinosaurio.setItems(listaFiltrada);
       
        
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
       String[]tamanyo= {null,"grande" ,"mediano" , "peque"};
       String[]alimentacion= {null,"carnivoro" ,"omnivoro" , "herbivoro"};
       String[]tipo= {null,"tierra" ,"aire" , "agua"};
       
       this.tamanyo.setItems(FXCollections.observableArrayList(tamanyo));
       this.alimentacion.setItems(FXCollections.observableArrayList(alimentacion));
       this.tipo.setItems(FXCollections.observableArrayList(tipo));

       try {
        String sql = "SELECT nombre,tamanyo,alimentacion,tipo FROM Dinosaurio";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            listaDinosaurios.add(new Dinosaurio(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }
       } catch (SQLException e) {
        e.printStackTrace();
       }

      
        tablaDinosaurio.setItems(listaDinosaurios);
        colNombre.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("nombre"));
        colTamanyo.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("tamanyo"));
        colAlimentacion.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("alimentacion"));
        colTipo.setCellValueFactory(new PropertyValueFactory<Dinosaurio, String>("tipo"));

    }

}
