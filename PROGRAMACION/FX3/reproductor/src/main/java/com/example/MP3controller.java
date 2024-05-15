package com.example;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Track;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MP3controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Slider sliderCancion;

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

    private File file;

    private FileChooser chooser = new FileChooser();

    private MediaPlayer player;

    private Cancion cancion;

    private Media media;

    private Image loopImage = new Image(getClass().getResourceAsStream("com/example/images/loop.png"));
    private Image loop1Image = new Image(getClass().getResourceAsStream("com/example/images/loop1.png"));

    private Image playImage = new Image(getClass().getResourceAsStream("com/example/images/play.png"));
    private Image stopImage = new Image(getClass().getResourceAsStream("com/example/images/stop.png"));


    private Image soundImage = new Image(getClass().getResourceAsStream("com/example/images/sound.png"));
    private Image soundOffImage = new Image(getClass().getResourceAsStream("com/example/images/soundoff.png"));



    @FXML
    void choiceMusic(ActionEvent event) {

        chooser.setInitialDirectory(new File("."));

        chooser.setTitle("Selecciona un Archivo de sonido");
        chooser.getExtensionFilters().addAll(new ExtensionFilter("Audio", "*.mp3"), new ExtensionFilter("Todo", "*"));

        file = chooser.showOpenDialog(null);
        if (file != null) {
            try {
                media = new Media(file.toURI().toString());

                if (player != null) {
                    player.stop();
                }
                player = new MediaPlayer(media);
                player.setVolume(.8);
                
            } catch (MediaException e) {
                e.printStackTrace();
            }
            player.setAutoPlay(true);
            player.totalDurationProperty().addListener(ob -> setPropertys());
            player.setOnEndOfMedia(() -> finCancion());
         
        }
    }

    private void finCancion() {
        
    }

    private void setPropertys() {
        cancion = new Cancion(media.getMetadata(), player.getTotalDuration().toMinutes());
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
