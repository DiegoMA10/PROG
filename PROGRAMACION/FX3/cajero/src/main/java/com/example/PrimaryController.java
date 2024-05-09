package com.example;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
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

   
    

    @FXML
    void iniciarSesion(ActionEvent event) throws IOException {
        
       if (App.listaClientes.containsKey(nif.getText()) && App.listaClientes.get(nif.getText()).getClave().equals(clave.getText())) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
            Parent root = loader.load();
            SecondaryController controlador2 = loader.getController();
            controlador2.setCliente(nif.getText());
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            
            
            stage.setScene(new Scene(root));
          
           
       }else{
         Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("ERROR DE ACCESO");
        alerta.setHeaderText("ERROR"); 
        alerta.setContentText("NIF O Clave incorrecta");
        alerta.showAndWait();
        nif.clear();
        clave.clear();
       }
    }

    @FXML
    void initialize() {
   
    }


     
}
