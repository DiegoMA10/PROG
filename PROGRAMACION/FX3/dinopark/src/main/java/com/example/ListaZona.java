package com.example;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;

public class ListaZona {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cerrar;

    @FXML
    private Button este;

    @FXML
    private Button norte;

    @FXML
    private Button oeste;

    @FXML
    private Button sud;

    private Connection con;

    @FXML
    void listarZona(ActionEvent event) {
        Button buton = (Button) event.getSource();
        System.out.println("hola" + " " + buton.getId());

        String sql = "SELECT a.nombre, a.capacidad, a.edad_minima,z.nombre,d.nombre FROM atraccion a join zona z on a.id_zona=z.id_zona join dinosaurio d on a.id_dino=d.id_dino where z.ubicacion=?";
        String nombreZona = "";
        String atraccion = "";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, buton.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                nombreZona = rs.getString("z.nombre");
                atraccion += "Atracción: " + rs.getString("a.nombre") +
                        ", Capacidad: " + rs.getInt("a.capacidad") +
                        ", Edad mínima: " + rs.getInt("a.edad_minima") +
                        ", Dinosaurio: " + rs.getString("d.nombre") + "\n";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Alert alert = new Alert(AlertType.INFORMATION);

        alert.setTitle("Informacion de la Zona");
        alert.setHeaderText(nombreZona);
        alert.setContentText(atraccion);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setPrefWidth(600);
        alert.showAndWait();
    }

    @FXML
    void vueltaMenu(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setWidth(800);
        stage.setHeight(500);
        App.setRoot("dinopark");
    }

    @FXML
    void initialize() {
        con = Dinopark.getCon();

    }

}
