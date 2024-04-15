import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PulsaBoton {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Pulsar;

    @FXML
    void Pulsar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert Pulsar != null : "fx:id=\"Pulsar\" was not injected: check your FXML file 'ventana.fxml'.";

    }

}
