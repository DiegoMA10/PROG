package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static HashMap<String,Cliente> listaClientes = new HashMap<>();
    private static Connection con;

    @Override
    public void start(Stage stage) throws IOException {
         setUpClientes();
        scene = new Scene(loadFXML("primary") );
       
        stage.setScene(scene); 
        
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        System.out.println("Cargando escena: " + fxml);
        scene.setRoot(loadFXML(fxml));
    }
    

  

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        //con = crearConexion("33006", "CajeroNOVA", "root", "dbrootpass");
        con = crearConexion("3306", "CajeroNOVA", "root", "123");
        
        launch();
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

    public void setUpClientes(){
        String sql = "SELECT * FROM cliente";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                listaClientes.put(rs.getString(1),new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException e) {
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("ERROR DE ACCESO");
            alerta.setHeaderText("ERROR"); 
            alerta.setContentText("NIF O Clave incorrecta");
            alerta.showAndWait();
        }
       
    }


}