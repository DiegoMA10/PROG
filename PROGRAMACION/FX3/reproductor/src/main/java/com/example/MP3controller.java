package com.example;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MP3controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Slider cancion;

    @FXML
    private Label duracion;

    @FXML
    private ImageView loop;

    @FXML
    private Label metadatos;

    @FXML
    private ImageView play;

    @FXML
    private ImageView sound;

    @FXML
    private ImageView start13;

    @FXML
    private Label tiempo;

    @FXML
    private Slider volumen;

    File file;

    FileChooser chooser = new FileChooser();

    MediaPlayer player;

    @FXML
    void choiceMusic(ActionEvent event) {

        chooser.setInitialDirectory(new File("."));

        chooser.setTitle("Selecciona un Archivo de sonido");
        chooser.getExtensionFilters().addAll(new ExtensionFilter("Audio", "*.mp3"), new ExtensionFilter("Todo", "*"));

        file = chooser.showOpenDialog(null);
        if (file != null) {
            try {
                Media media = new Media(file.toURI().toString());

                if (player != null) {
                    player.stop();
                }
                player = new MediaPlayer(media);
                player.setVolume(.8);
                
            } catch (MediaException e) {
                e.printStackTrace();
            }
            player.setAutoPlay(true);
        }
    }

    @FXML
    void loopActive(ActionEvent event) {

    }

    @FXML
    void playMusic(ActionEvent event) {

    }

    @FXML
    void toEnd(ActionEvent event) {

    }

    @FXML
    void toStart(ActionEvent event) {

    }

    @FXML
    void volumenTransicion(ActionEvent event) {
     
    }

    
   

    @FXML
    void initialize() {
        volumen.onDragDetectedProperty().addListener(ob -> System.out.println("hola"));
    }

}
