package com.example;

import java.io.File;
import java.net.URL;
import javafx.util.Duration;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Track;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MP3controller implements Initializable {

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
    private ImageView menu;

    @FXML
    private Label tiempo;

    @FXML
    private Slider volumen;

    private File file;

    private FileChooser chooser = new FileChooser();

    private MediaPlayer player;

    private Cancion cancion;

    private Media media;
    private static Timeline timeline;

    private Image loopImage = new Image(getClass().getResourceAsStream("/com/example/images/loop.png"));
    private Image loop1Image = new Image(getClass().getResourceAsStream("/com/example/images/loop1.png"));

    private Image playImage = new Image(getClass().getResourceAsStream("/com/example/images/play.png"));
    private Image stopImage = new Image(getClass().getResourceAsStream("/com/example/images/stop.png"));

    private Image soundImage = new Image(getClass().getResourceAsStream("/com/example/images/sound.png"));
    private Image soundOffImage = new Image(getClass().getResourceAsStream("/com/example/images/soundoff.png"));

    @FXML
    void choiceMusic(ActionEvent event) {

        chooser.setInitialDirectory(new File("./src/main/resources/com/example/musica/"));

        chooser.setTitle("Selecciona un Archivo de sonido");
        chooser.getExtensionFilters().addAll(new ExtensionFilter("Audio", "*.mp3"), new ExtensionFilter("Todo", "*"));

        file = chooser.showOpenDialog(null);

        if (file != null) {
            try {
                if (player!=null) {
                    player.stop();
                }
                media = new Media(file.toURI().toString());

                player = new MediaPlayer(media);
                loopstate=true;
                playState=false;
                playMusic(event);
                loopActive(event);
                player.setVolume(volumen.getValue() * 0.01);

            } catch (MediaException e) {
                e.printStackTrace();
            }
            player.setAutoPlay(true);
            player.totalDurationProperty().addListener(ob -> setPropertys());

            player.setOnEndOfMedia(() -> finCancion());

        }
    }

    private void finCancion() {
        if (loopstate) {
            player.seek(player.getStartTime());
            player.play();
        }else{
            play.setImage(playImage);
        }
    }

    private void setPropertys() {

        metadatos.setText(file.getName().substring(0, file.getName().length() - 4));
        duracion.setText(formatTime(player.getTotalDuration().toSeconds()));
        sliderCancion.setMax(player.getTotalDuration().toSeconds());

        timeline = new Timeline(new KeyFrame(Duration.millis(150), event -> {
            update();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }

    private String formatTime(double timeInSeconds) {
        long minutes = (long) timeInSeconds / 60;
        long seconds = (long) timeInSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    private boolean loopstate=false;
    @FXML
    void loopActive(ActionEvent event) {
        if (player!=null) {

            if (loopstate) {
                loop.setImage(loopImage);
                loopstate = false;
              
            }else{
                loop.setImage(loop1Image);
               
                loopstate = true;
                
            }
            
            }
    }

    private boolean playState=false;

    @FXML
    void playMusic(ActionEvent event) {

        if (player!=null) {
        if (playState) {
            play.setImage(playImage);
            playState = false;
            player.pause();
        }else{
            
            play.setImage(stopImage);
            playState = true;
            player.play();
        }
        
        }
       
    }

    @FXML
    void toEnd(ActionEvent event) {
        if (player != null) {
            if (loopstate) {
            play.setImage(stopImage);
            playState=true;
            }else{
            play.setImage(playImage);
            playState = false;
            }
           
            player.seek(player.getStopTime());
        }
    }

    @FXML
    void toStart(ActionEvent event) {
        if (player != null) {
            play.setImage(stopImage);
            playState=true;
            player.seek(player.getStartTime());
        }
    }

    private Boolean volumenState = true;
    @FXML
    void volumenTransicion(ActionEvent event) {
        if (player != null) {
            if (volumenState) {
                player.setMute(true);
                sound.setImage(soundOffImage);
                volumenState = false;
            }else{
                player.setMute(false);
                sound.setImage(soundImage);
                volumenState = true;
            }

        }
    
    }

    private void update() {
        tiempo.setText(formatTime(player.getCurrentTime().toSeconds()));
        sliderCancion.setValue(player.getCurrentTime().toSeconds());

    }

    public void MoverPosicion() {

        if (player != null) {
            timeline.stop();
            player.seek(Duration.seconds(sliderCancion.getValue()));
        }

    }

    public void endMoverPosicion() {
        if (player != null) {
            timeline.play();
        }
    }

    public void volumenMusica() {

        player.setVolume(volumen.getValue() * 0.01);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        volumen.setValue(10);
        sliderCancion.setOnMousePressed(event -> {
            MoverPosicion();
        });

        sliderCancion.setOnMouseDragged(event -> {

            MoverPosicion();
        });

        sliderCancion.setOnMouseReleased(event -> {
            endMoverPosicion();
        });

        volumen.valueProperty().addListener(ob -> volumenMusica());

    }

}
