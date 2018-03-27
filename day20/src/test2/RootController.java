package test2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class RootController implements Initializable {
	@FXML private MediaView mediaView;  
	@FXML private ImageView imageView;  
	@FXML private Button btnPlay;  
	@FXML private Button btnPause;  
	@FXML private Button btnStop;
	@FXML private Label labelTime;
	@FXML private Slider sliderVolume;
	@FXML private ProgressBar progressBar;
	@FXML private ProgressIndicator progressIndicator;
	
	private boolean endOfMedia;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Media media = new Media(getClass().getResource("../media/audio.wav").toString());
		
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		
		mediaPlayer.setOnReady(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				
				mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {

					@Override
					public void changed(ObservableValue<? extends Duration> observable, Duration oldValue,
							Duration newValue) {
						// TODO Auto-generated method stub
						double progress = mediaPlayer.getCurrentTime().toSeconds()/mediaPlayer.getTotalDuration().toSeconds();
						progressBar.setProgress(progress);
						progressIndicator.setProgress(progress);
						labelTime.setText((int)mediaPlayer.getCurrentTime().toSeconds()+"/"+(int)mediaPlayer.getTotalDuration().toSeconds()+" sec");
					}
					
				});
				
				btnPlay.setDisable(false);
				btnPause.setDisable(true);
				btnStop.setDisable(true);
			}
		});
		
		mediaPlayer.setOnPlaying(()->{
			btnPlay.setDisable(true);
			btnPause.setDisable(false);
			btnStop.setDisable(false);
		});
		mediaPlayer.setOnPaused(()->{
			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(false);
		});
		mediaPlayer.setOnEndOfMedia(()->{
			progressBar.setProgress(1.0);
			progressIndicator.setProgress(1.0);
			endOfMedia=true;
			
			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(true);
		});
		mediaPlayer.setOnStopped(()->{
			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(true);
		});
		
		btnPlay.setOnAction(event->{
			if(endOfMedia) {
				mediaPlayer.stop();
				mediaPlayer.seek(mediaPlayer.getStartTime());
			}
			mediaPlayer.play();
			endOfMedia=false;
		});
		
		sliderVolume.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				mediaPlayer.setVolume(sliderVolume.getValue()/100.0);
			}
		});
		
		sliderVolume.setValue(50.0);
		btnPause.setOnAction(event->mediaPlayer.pause());
		btnStop.setOnAction(event->mediaPlayer.stop());
	}  
}
	
