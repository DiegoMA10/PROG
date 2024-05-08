package com.example;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class PrimaryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField clave;

    @FXML
    private Button iniciarSesion;

    @FXML
    private TextField nif;

    private static Connection con;

    @FXML
    void iniciarSesion(ActionEvent event) {
        System.out.println("hola");
    }

    @FXML
    void initialize() {
    
       con = crearConexion("33006", "CajeroNOVA", "root", "dbrootpass");
    
    }


     public static Connection crearConexion(String puerto, String baseDatos, String usuario, String pass) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:"+puerto+"/"+baseDatos,usuario, pass);
            return con;
        } catch (Exception e) {
            return null;
        }
    }

    public static Connection getCon() {
        return con;
    }

}
