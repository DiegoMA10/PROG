package com.example;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class Agenda {
    @FXML
    private Button anterior;

    @FXML
    private TextField apellidos;

    @FXML
    private TextField cargo;

    @FXML
    private Button fin;

    @FXML
    private TextField idEmpleado;

    @FXML
    private Button inicio;

    @FXML
    private TextField nombre;

    @FXML
    private Button siguiente;

    @FXML
    private TextField telefono;

    @FXML
    private DatePicker fechita;

    @FXML
    private Button insertar;

    @FXML
    private Button modificar;

    @FXML
    private Button borrar;

    private Connection con;
    private List<Empleado> lista = new ArrayList<>();
    private HashMap<String, Empleado> map = new HashMap<>();
    private int cont = 0;

    @FXML
    void initialize() {

        try {
            // this.con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:33006/agenda",
            // "root", "dbrootpass");
            this.con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/agenda", "root", "123");
            Statement st = con.createStatement();
            String sql = "SELECT * FROM empleados";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                lista.add(new Empleado(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getDate(5), rs.getString(6)));
                map.put(rs.getString(1), new Empleado(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDate(5), rs.getString(6)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        cargarTexto();

    }

    @FXML
    void primerEmpleado(ActionEvent event) {
        cont = 0;
        cargarTexto();

    }

    @FXML
    void anteriorEmpleado(ActionEvent event) {
        cont--;
        cargarTexto();
    }

    @FXML
    void siguienteEmpleado(ActionEvent event) {
        cont++;
        cargarTexto();

    }

    @FXML
    void ultimoEmpleado(ActionEvent event) {
        cont = lista.size() - 1;
        cargarTexto();
    }

    @FXML
    void comprobarEmpleado(KeyEvent event) {
        boolean salida = false;
        
        if (!idEmpleado.getText().isEmpty()) {
            
            if (map.containsKey(idEmpleado.getText())) {
                salida = true;

            }
            if (salida) {
                insertar.setDisable(true);
                modificar.setDisable(false);
                borrar.setDisable(false);

            } else {
                insertar.setDisable(false);
                modificar.setDisable(true);
                borrar.setDisable(true);

            }

        } else {
            insertar.setDisable(true);
            modificar.setDisable(true);
            borrar.setDisable(true);
        }

    }

    @FXML
    void borrarEmpleado(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Diálogo de confirmación");
        alert.setHeaderText("Quiere borrar el empleado con la ID: " + idEmpleado.getText());
        alert.setContentText("¿Seguro que quieres continuar?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {

            String sql = "DELETE FROM empleados WHERE idEmpleado = ?";

            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, idEmpleado.getText());
                ps.executeUpdate();
                lista.remove(cont);
                map.remove(idEmpleado.getText());
                if (lista.size() == cont) {
                    cont = lista.size() - 1;
                }

                cargarTexto();
                Alert alerta = new Alert(AlertType.INFORMATION);
                alerta.setTitle("Diálogo de información");
                alerta.setContentText("Usuario borrado exitosamente");
                alerta.showAndWait();

            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
    }

    @FXML
    void insertarEmpleado(ActionEvent event) {
        String sql = "INSERT INTO empleados (`idEmpleado`, `Nombre`, `Apellidos`, `Telefono`, `Fecha_nacimiento`, `Cargo`) VALUES (?, ?, ?, ?, ?, ?)";

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Diálogo de confirmación");
        String listaAlerta = "\nidEmpleado: "+idEmpleado.getText()+"\nNombre: "+nombre.getText()+"\nApellidos: "+apellidos.getText()+"\nTelefono: "+telefono.getText()+"\nFecha Nacimiento: "+ fechita.getValue().toString()+"\nCargo: "+cargo.getText();
        alert.setHeaderText("Quiere añadir este empleado ?:"+listaAlerta);
        alert.setContentText("¿Seguro que quieres continuar?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {

            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, idEmpleado.getText());
                ps.setString(2, nombre.getText());
                ps.setString(3, apellidos.getText());
                ps.setString(4, telefono.getText());
                ps.setDate(5, Date.valueOf(fechita.getValue()));
                ps.setString(6, cargo.getText());
                ps.executeUpdate();
                lista.add(new Empleado(idEmpleado.getText(), nombre.getText(), apellidos.getText(), telefono.getText(),
                        Date.valueOf(fechita.getValue()), cargo.getText()));
                cont = lista.size() - 1;
                cargarTexto();
                Alert alerta = new Alert(AlertType.INFORMATION);
                alerta.setTitle("Diálogo de información");
                alerta.setContentText("Usuario añadido exitosamente");
                alerta.showAndWait();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void modificarEmpleado(ActionEvent event) {
        String sql = "UPDATE empleados SET Nombre = ?, Apellidos = ?, Telefono = ?, Fecha_nacimiento = ?, Cargo = ? WHERE idEmpleado = ?";
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Diálogo de confirmación");
        String listaAlerta = "\nidEmpleado: "+idEmpleado.getText()+"\nNombre: "+nombre.getText()+"\nApellidos: "+apellidos.getText()+"\nTelefono: "+telefono.getText()+"\nFecha Nacimiento: "+ fechita.getValue().toString()+"\nCargo: "+cargo.getText();
        alert.setHeaderText("Quiere modificar el empleado: "+idEmpleado.getText()+"?"+listaAlerta);
        alert.setContentText("¿Quieres aplicar estos cambios?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {

            try {
                PreparedStatement ps = con.prepareStatement(sql);
                
                ps.setString(1, nombre.getText());
                ps.setString(2, apellidos.getText());
                ps.setString(3, telefono.getText());
                ps.setDate(4, Date.valueOf(fechita.getValue()));
                ps.setString(5, cargo.getText());
                ps.setString(6, idEmpleado.getText());
                ps.executeUpdate();
                lista.get(cont).actualizarEmpleado(nombre.getText(),apellidos.getText(),telefono.getText(),Date.valueOf(fechita.getValue()),cargo.getText());
                cargarTexto();
                Alert alerta = new Alert(AlertType.INFORMATION);
                alerta.setTitle("Diálogo de información");
                alerta.setContentText("Usuario modificado exitosamente");
                alerta.showAndWait();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }

    private void cargarTexto() {
        comprobarBotones();
        if (lista.isEmpty()) {
            idEmpleado.setText("");
            nombre.setText("");
            fechita.setValue(null);
            apellidos.setText("");
            telefono.setText("");
            cargo.setText("");
        } else {
            idEmpleado.setText(lista.get(cont).getIdEmpleado());
            nombre.setText(lista.get(cont).getNombre());
            fechita.setValue(lista.get(cont).getFechaNacimiento().toLocalDate());
            apellidos.setText(lista.get(cont).getApellidos());
            telefono.setText(lista.get(cont).getTelefono());
            cargo.setText(lista.get(cont).getCargo());
        }

    }

    private void comprobarBotones() {

        if (lista.isEmpty()) {
            inicio.setDisable(true);
            anterior.setDisable(true);
            insertar.setDisable(false);
            siguiente.setDisable(true);
            modificar.setDisable(true);
            borrar.setDisable(true);
            fin.setDisable(true);

        } else {

            if (lista.size() == 1) {
                inicio.setDisable(true);
                anterior.setDisable(true);
                insertar.setDisable(true);
                modificar.setDisable(false);
                borrar.setDisable(false);
                fin.setDisable(true);
                siguiente.setDisable(true);

            } else {

                if (cont > 0 && cont < lista.size() - 1) {
                    inicio.setDisable(false);
                    anterior.setDisable(false);
                    insertar.setDisable(true);
                    modificar.setDisable(false);
                    borrar.setDisable(false);
                    fin.setDisable(false);
                    siguiente.setDisable(false);
                }

                if (cont == 0) {
                    inicio.setDisable(true);
                    anterior.setDisable(true);
                    insertar.setDisable(true);
                    modificar.setDisable(false);
                    borrar.setDisable(false);
                    fin.setDisable(false);
                    siguiente.setDisable(false);
                }

                if (lista.size() - 1 == cont) {
                    inicio.setDisable(false);
                    anterior.setDisable(false);
                    insertar.setDisable(true);
                    modificar.setDisable(false);
                    borrar.setDisable(false);
                    fin.setDisable(true);
                    siguiente.setDisable(true);
                }

            }

        }
    }

}
