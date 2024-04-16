package com.ejemplo;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField password;

    @FXML
    private TextField usuario;

    @FXML
    private Button validar;

    private Connection con;

    @FXML
    void initialize() {
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'login.fxml'.";
        assert usuario != null : "fx:id=\"usuario\" was not injected: check your FXML file 'login.fxml'.";
        assert validar != null : "fx:id=\"validar\" was not injected: check your FXML file 'login.fxml'.";
        try {
            //this.con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:33006/login", "root", "dbrootpass");
            this.con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login", "root", "123");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void validarboton(ActionEvent e) {

        String sql = "SELECT * FROM login.usuarios WHERE usuario= ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getText());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                
                if (!rs.getString(2).equals(password.getText())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setContentText("Contraseña incorrecto");
                    alert.showAndWait();
                }else{
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("ACCESO CONCEDIDO");
                    alert.showAndWait();
                }
                

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("Formato incorrecto");
                alert.showAndWait();

            }

        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }

}
