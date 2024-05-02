package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ListaDinosaurios {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button menu;

    @FXML
    private URL location;

    @FXML
    private ImageView buscar;

    @FXML
    void buscar(MouseEvent event) throws IOException {
      
        
        
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
        

    }

}
