module com.ejemplo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens com.ejemplo to javafx.fxml;
    exports com.ejemplo;
}
