package com.example;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Agenda {
    @FXML
    private Button anterior;

    @FXML
    private TextField apellidos;

    @FXML
    private TextField cargo;

    @FXML
    private TextField fechaNacimiento;

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

    private Connection con;
    private List<Empleado> lista = new ArrayList<>();
    private int cont = 0;

    @FXML
    void initialize() {
        assert anterior != null : "fx:id=\"anterior\" was not injected: check your FXML file 'agenda.fxml'.";
        assert apellidos != null : "fx:id=\"apellidos\" was not injected: check your FXML file 'agenda.fxml'.";
        assert cargo != null : "fx:id=\"cargo\" was not injected: check your FXML file 'agenda.fxml'.";
        assert fechaNacimiento != null
                : "fx:id=\"fechaNacimiento\" was not injected: check your FXML file 'agenda.fxml'.";
        assert fin != null : "fx:id=\"fin\" was not injected: check your FXML file 'agenda.fxml'.";
        assert idEmpleado != null : "fx:id=\"idEmpleado\" was not injected: check your FXML file 'agenda.fxml'.";
        assert inicio != null : "fx:id=\"inicio\" was not injected: check your FXML file 'agenda.fxml'.";
        assert nombre != null : "fx:id=\"nombre\" was not injected: check your FXML file 'agenda.fxml'.";
        assert siguiente != null : "fx:id=\"siguiente\" was not injected: check your FXML file 'agenda.fxml'.";
        assert telefono != null : "fx:id=\"telefono\" was not injected: check your FXML file 'agenda.fxml'.";

        try {
            this.con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:33006/agenda", "root", "dbrootpass");
            // this.con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/agenda",
            // "root", "123");
            Statement st = con.createStatement();
            String sql = "SELECT * FROM empleados";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                lista.add(new Empleado(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getDate(5), rs.getString(6)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        idEmpleado.setText(lista.get(cont).getIdEmpleado());
        nombre.setText(lista.get(cont).getNombre());
        apellidos.setText(lista.get(cont).getApellidos());
        telefono.setText(lista.get(cont).getTelefono());
        fechaNacimiento.setText(String.valueOf(lista.get(cont).getFechaNacimiento()));
        cargo.setText(lista.get(cont).getCargo());
        inicio.setDisable(true);
        anterior.setDisable(true);

    }

    @FXML
    void primerEmpleado(ActionEvent event) {
        inicio.setDisable(true);
        anterior.setDisable(true);
        siguiente.setDisable(false);
        fin.setDisable(false);
        cont = 0;
        idEmpleado.setText(lista.get(cont).getIdEmpleado());
        nombre.setText(lista.get(cont).getNombre());
        apellidos.setText(lista.get(cont).getApellidos());
        telefono.setText(lista.get(cont).getTelefono());
        fechaNacimiento.setText(String.valueOf(lista.get(0).getFechaNacimiento()));
        cargo.setText(lista.get(cont).getCargo());
    }

    @FXML
    void anteriorEmpleado(ActionEvent event) {
        cont--;
        if (cont == 0) {
            inicio.setDisable(true);
            anterior.setDisable(true);

        }
        siguiente.setDisable(false);
        fin.setDisable(false);
      
        idEmpleado.setText(lista.get(cont).getIdEmpleado());
        nombre.setText(lista.get(cont).getNombre());
        apellidos.setText(lista.get(cont).getApellidos());
        telefono.setText(lista.get(cont).getTelefono());
        fechaNacimiento.setText(String.valueOf(lista.get(cont).getFechaNacimiento()));
        cargo.setText(lista.get(cont).getCargo());
       
    }

    @FXML
    void siguienteEmpleado(ActionEvent event) {
        cont++;
        if (cont == lista.size() - 1) {
            siguiente.setDisable(true);
            fin.setDisable(true);

        }
        inicio.setDisable(false);
        anterior.setDisable(false);
        idEmpleado.setText(lista.get(cont).getIdEmpleado());
        nombre.setText(lista.get(cont).getNombre());
        apellidos.setText(lista.get(cont).getApellidos());
        telefono.setText(lista.get(cont).getTelefono());
        fechaNacimiento.setText(String.valueOf(lista.get(cont).getFechaNacimiento()));
        cargo.setText(lista.get(cont).getCargo());

    }

    @FXML
    void ultimoEmpleado(ActionEvent event) {
        siguiente.setDisable(true);
        fin.setDisable(true);
        inicio.setDisable(false);
        anterior.setDisable(false);

        cont = lista.size() - 1;
        idEmpleado.setText(lista.get(cont).getIdEmpleado());
        nombre.setText(lista.get(cont).getNombre());
        apellidos.setText(lista.get(cont).getApellidos());
        telefono.setText(lista.get(cont).getTelefono());
        fechaNacimiento.setText(String.valueOf(lista.get(cont).getFechaNacimiento()));
        cargo.setText(lista.get(cont).getCargo());
    }

}
