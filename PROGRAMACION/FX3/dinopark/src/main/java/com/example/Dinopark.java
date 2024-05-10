package com.example;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
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

    private static Connection con ;

    @FXML
    void listarDinosaurios(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setWidth(925);
        stage.setHeight(550);

        App.setRoot("listaDinosaurio");
       

    }

    @FXML
    void crearAtraccion(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setWidth(800);
        stage.setHeight(500);

        App.setRoot("crearZona");
       

    }

    @FXML
    void salir(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void initialize() {
    
       con = crearConexion("33006", "JurassicPark", "root", "dbrootpass");
        //crearConexion("33006", "JurassicPark", "root", "123");
    }

     public static Connection crearConexion(String puerto, String baseDatos, String usuario, String passwd) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:33006/JurassicPark","root", "dbrootpass");
            return con;
        } catch (Exception e) {
            return null;
        }
    }

    public static Connection getCon() {
        return con;
    }

}
