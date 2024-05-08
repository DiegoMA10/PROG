package com.example;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.stage.Stage;

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
    private Button menu;

    @FXML
    void vueltaMenu(ActionEvent event) throws IOException {
         Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setWidth(800);
        stage.setHeight(500);
        App.setRoot("dinopark");
    }

    @FXML
    void guardarAtraccion(ActionEvent event) throws IOException {
       
          if (nombre.getText().isEmpty()|| menuEdad.getValue() == null || zona.getValue() == null || capacidad.getValue()==0 || dinosaurio.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No ha ingresado valor en todos los campos ");
            alert.setContentText("Por favor ingrese todos los campos");
            alert.showAndWait();
          }else{
            ResultSet rs = null;
            int idDino = 0;
            int idZona = 0;
            int idAtraccion = 0;
            PreparedStatement ps = null;
            Statement st = null;
            try {
                String sql = "SELECT id_dino FROM Dinosaurio WHERE nombre = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, dinosaurio.getValue());
                rs = ps.executeQuery();
                if (rs.next()) {
                    idDino = rs.getInt("id_dino");
                }

                sql = "SELECT id_zona FROM Zona WHERE nombre = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, zona.getValue());
                rs = ps.executeQuery();
                if (rs.next()) {
                    idZona = rs.getInt("id_zona");
                }
                sql = "SELECT count(*) FROM Atraccion";
                st = con.createStatement();
                rs = st.executeQuery(sql);
                if (rs.next()) {
                    idAtraccion = rs.getInt(1)+1;
                }
                
               
                System.out.println("hola");
                sql = "INSERT INTO Atraccion (id_atraccion, id_zona, id_dino, nombre, capacidad, edad_minima) VALUES (?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1, idAtraccion);
                ps.setInt(2, idZona);
                ps.setInt(3, idDino);
                ps.setString(4, nombre.getText());
                ps.setInt(5, (int)capacidad.getValue());
                ps.setInt(6, menuEdad.getValue());
                ps.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Confirmacion");
                alert.setHeaderText("La atraccion");
                alert.setContentText("Se ha agregado la Atraccion");
                alert.showAndWait();

                App.setRoot("dinopark");
          }catch (SQLException e){
                e.printStackTrace();
          }
        }
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
