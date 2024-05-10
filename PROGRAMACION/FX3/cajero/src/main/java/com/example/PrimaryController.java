package com.example;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Node;


public class PrimaryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField clave;

    @FXML
    private Button iniciarSesion;

    @FXML
    private  TextField nif;

   

    private Connection con;
    

    @FXML
    void iniciarSesion(ActionEvent event) throws IOException {
      String sql = "SELECT * FROM Cliente WHERE NIF = ? AND clave = ?";
      System.out.println("hola");
      try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nif.getText());
        ps.setString(2, clave.getText());
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

          App.cliente = new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
          App.setRoot("secondary");
        }else{
          Alert alerta = new Alert(AlertType.ERROR);
          alerta.setTitle("ERROR DE ACCESO");
          alerta.setHeaderText("ERROR"); 
          alerta.setContentText("NIF O Clave incorrecta");
          alerta.showAndWait();
          nif.clear();
          clave.clear();
        }

      } catch (SQLException e) {
        Alert alerta = new Alert(AlertType.ERROR);
          alerta.setTitle("ERROR DE EN LA BASE DE DATOS");
          alerta.setHeaderText("ERROR"); 
          alerta.setContentText("ACCESO A LOS DATOS");
          alerta.showAndWait();
      }
     


      
        
       
    }

    @FXML
    void initialize() {
      con = App.getCon();
    }


     
}
