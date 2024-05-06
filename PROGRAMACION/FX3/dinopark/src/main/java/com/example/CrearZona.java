package com.example;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;

public class CrearZona {

     private Connection con;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Slider capacidad;

    @FXML
    private ChoiceBox<String> dinosaurio;

    @FXML
    private ChoiceBox<Integer> menuEdad;

    @FXML
    private TextField nombre;

    @FXML
    private Label numCapacidad;

    @FXML
    private ChoiceBox<String> zona;

     @FXML
    private Button guardar;

    @FXML
    void guardarAtraccion(ActionEvent event) {
        String sql = "INSERT INTO Atraccion (id_zona, id_dino, nombre, capacidad, edad_minima) VALUES (?,?,?,?,?)";
        String sqlDino = "SELECT id_dino FROM Dinosaurio WHERE nombre LIKE ?";
        String sqlZona = "SELECT id_zona FROM Zona WHERE nombre LIKE ?";
     
    }

   
    @FXML
    void initialize() {
        con = Dinopark.getCon();

       numCapacidad.textProperty().bind(Bindings.format("%.0f", capacidad.valueProperty()));
       Integer[]edad = {6,10,14,18};
       menuEdad.setItems(FXCollections.observableArrayList(edad));
       String sql = "SELECT nombre FROM Dinosaurio";
       ArrayList<String>nombreDinosaurio= new ArrayList<>();
       ArrayList<String>nombreZona= new ArrayList<>();
      try  {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

         while (rs.next()) {
          
            nombreDinosaurio.add(rs.getString(1));
        } 

        dinosaurio.setItems(FXCollections.observableArrayList(nombreDinosaurio));
        sql = "SELECT nombre FROM Zona";
        rs = st.executeQuery(sql);

        while (rs.next()) {
            
            nombreZona.add(rs.getString(1));

        }
        zona.setItems(FXCollections.observableArrayList(nombreZona));

    } catch (Exception e) {
        
        e.printStackTrace();
    } 
       
    }

}
