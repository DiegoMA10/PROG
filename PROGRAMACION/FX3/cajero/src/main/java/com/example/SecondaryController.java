package com.example;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.TouchEvent;
import javafx.stage.Stage;

public class SecondaryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> selectCuentas;

    @FXML
    private Label nombreCliente;

    @FXML
    private Button pagar;

    @FXML
    private Button sacar;

    private Cliente cliente;

    private Connection con;

    private ArrayList<Cuenta> listaCuentas = new ArrayList<>();

    private ArrayList<String> numcuentas = new ArrayList<>();

    private ArrayList<Factura> listaFacturas = new ArrayList<>();

    private ArrayList<Integer> numFactura = new ArrayList<>();

    private Cuenta currentCuenta = null;

    @FXML
    void SacarDinero(ActionEvent event) {

        TextInputDialog dialog = new TextInputDialog(); // Por defecto
        dialog.setTitle("Sacar dinero");
        dialog.setHeaderText("Saldo disponible: " + String.format("%.2f", currentCuenta.getSaldo()));
        dialog.setContentText("Introduce el dinero:");
        Optional<String> result = dialog.showAndWait(); // Obteniendo el resultado
        if (result.isPresent()) {
            String resultado = result.get();
            try {
                double saldo = Double.parseDouble(resultado);

                if (saldo > 1000) {
                    Alert alerta = new Alert(AlertType.WARNING);
                    alerta.setTitle("Sacar dinero");
                    alerta.setHeaderText("Advertencia");
                    alerta.setContentText("Excede la cantidad máxima permitada: 1000€");
                    alerta.showAndWait();
                } else if (saldo <= currentCuenta.getSaldo()) {
                    currentCuenta.setSaldo(currentCuenta.getSaldo() - saldo);
                    String sql = "UPDATE Cuenta SET saldo = ? WHERE num_cta = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setDouble(1, currentCuenta.getSaldo());
                    ps.setString(2, currentCuenta.getNumCuenta());
                    ps.executeUpdate();

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Sacar dinero");
                    alert.setHeaderText("Mensaje");
                    alert.setContentText("OPERACION REALIZADA \n Su nuevo saldo es: "
                            + String.format("%.2f", currentCuenta.getSaldo()));
                    alert.showAndWait();
                } else if (saldo > currentCuenta.getSaldo()) {
                    Alert alerta = new Alert(AlertType.WARNING);
                    alerta.setTitle("Sacar dinero");
                    alerta.setHeaderText("Advertencia");
                    alerta.setContentText("No tienes suficiente saldo\nSu saldo actual es de: "
                            + String.format("%.2f", currentCuenta.getSaldo()));
                    alerta.showAndWait();
                }

            } catch (SQLException e) {
                Alert alerta = new Alert(AlertType.ERROR);
                alerta.setTitle("ERROR DE EN LA BASE DE DATOS");
                alerta.setHeaderText("ERROR");
                alerta.setContentText("ACCESO A LOS DATOS");
                alerta.showAndWait();
            } catch (NumberFormatException e) {
                Alert alerta = new Alert(AlertType.ERROR);
                alerta.setTitle("ERROR EN LA INTRODUCION DE LOS DATOS");
                alerta.setHeaderText("ERROR");
                alerta.setContentText("Por favor ingrese un numero");
                alerta.showAndWait();
            }

        }
    }

    @FXML
    void cerrarSesion(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

    @FXML
    void pagarFactura(ActionEvent event) {

        ChoiceDialog<Integer> dialog = new ChoiceDialog<>(numFactura.get(0), numFactura);
        dialog.setTitle("Pagar Factura");
        dialog.setHeaderText("Saldo disponible:" + String.format("%.2f", currentCuenta.getSaldo()));
        dialog.setContentText("Elija la factura:");
        Optional<Integer> result = dialog.showAndWait();
        if (result.isPresent()) {
            Integer numFactura = result.get();
            Factura currentFactura = null;

            for (Factura factura : listaFacturas) {
                if (factura.getNumFactura() == numFactura) {
                    currentFactura = factura;
                    break;
                }
            }

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Pagar Factura");
            alert.setHeaderText("Saldo disponible: " + String.format("%.2f", currentCuenta.getSaldo())
                    + "\nLa factura num:" + currentFactura.getNumFactura() + "\n Tiene un importe de "
                    + String.format("%.2f", currentFactura.getImporte()));
            alert.setContentText("¿Desea Pagar la factura?");
            ButtonType buttonTypePagar = new ButtonType("PAGAR");
            ButtonType buttonTypeCancelar = new ButtonType("CANCELAR", ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(buttonTypePagar, buttonTypeCancelar);
            Optional<ButtonType> result2 = alert.showAndWait();

            if (result2.isPresent() && result2.get().getText().equals("PAGAR")) {

                if (currentCuenta.getSaldo() >= currentFactura.getImporte()) {
                    try {
                        String sql = "DELETE FROM Factura WHERE num_fra = ? ";
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setInt(1, currentFactura.getNumFactura());
                        ps.executeUpdate();

                        sql = "UPDATE Cuenta SET saldo = ? WHERE num_cta = ?";
                        ps = con.prepareStatement(sql);
                        Double saldo = currentCuenta.getSaldo() - currentFactura.getImporte();
                        currentCuenta.setSaldo(saldo);
                        ps.setDouble(1, saldo);
                        ps.setString(2, currentCuenta.getNumCuenta());
                        ps.executeUpdate();
                        listaFacturas.remove(currentFactura);
                        Alert alert2 = new Alert(AlertType.INFORMATION);
                        alert2.setTitle("Pagar factura");
                        alert2.setHeaderText("Mensaje");
                        alert2.setContentText("OPERACION REALIZADA \nSu nuevo saldo es: "
                                + String.format("%.2f", currentCuenta.getSaldo()));
                        alert2.showAndWait();
                        if (listaFacturas.isEmpty()) {
                            pagar.setDisable(true);
                        }

                    } catch (SQLException e) {

                        Alert alerta = new Alert(AlertType.ERROR);
                        alerta.setTitle("ERROR DE EN LA BASE DE DATOS");
                        alerta.setHeaderText("ERROR");
                        alerta.setContentText("ACCESO A LOS DATOS");
                        alerta.showAndWait();
                    }

                } else {
                    Alert alerta = new Alert(AlertType.WARNING);
                    alerta.setTitle("Pagar factura");
                    alerta.setHeaderText("Advertencia");
                    alerta.setContentText("No tienes suficiente saldo para pagar esta factura");
                    alerta.showAndWait();
                }

            }

        }
    }

    @FXML
    void initialize() {
        con = App.getCon();
        cliente = App.cliente;
        nombreCliente.setText(cliente.getNombre() + " " + cliente.getApellidos());
        selectCuentas.setOnAction(event -> elegirCuenta());
        String sql = "SELECT * FROM Cuenta WHERE NIF = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNif());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaCuentas.add(new Cuenta(rs.getString(1), rs.getString(2), rs.getDouble(3)));
                numcuentas.add(rs.getString(1));
            }
            selectCuentas.setItems(FXCollections.observableArrayList(numcuentas));

            sql = "SELECT * FROM Factura WHERE NIF = ?";

            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNif());
            rs = ps.executeQuery();
            while (rs.next()) {
                listaFacturas.add(new Factura(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4)));
                numFactura.add(rs.getInt(1));
            }

        } catch (SQLException e) {
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("ERROR DE EN LA BASE DE DATOS");
            alerta.setHeaderText("ERROR");
            alerta.setContentText("ACCESO A LOS DATOS");
            alerta.showAndWait();
        }

        sacar.setDisable(true);
        pagar.setDisable(true);
    }

    private void elegirCuenta() {
        for (Cuenta cuenta : listaCuentas) {
            if (cuenta.getNumCuenta().equals(selectCuentas.getValue())) {
                currentCuenta = cuenta;
                sacar.setDisable(false);

                break;
            }
        }

        if (!listaFacturas.isEmpty()) {
            pagar.setDisable(false);
        }

    }

}
