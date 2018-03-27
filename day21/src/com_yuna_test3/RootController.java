package com_yuna_test3;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class RootController implements Initializable {
	@FXML private ProgressBar progressBar;
	@FXML private Label lblWorkDone;
	@FXML private Label lblResult;
	@FXML private Button btnStart;
	@FXML private Button btnStop;
	
	private Task<Integer> task;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		btnStart.setOnAction(event->handleBtnStart(event));
		btnStop.setOnAction(event->handleBtnStop(event));
	}
	
	public void handleBtnStart(ActionEvent e) {
		task=new Task<Integer>() {
			
			@Override
			protected Integer call() throws Exception {
				// TODO Auto-generated method stub
				int result=0;
				for (int i = 0; i <=100; i++) {
					if(isCancelled()) {
						break;
					}
					result+=i;
					updateProgress(i, 100);
					updateMessage(String.valueOf(i));
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO: handle exception
						if(isCancelled()) {
							break;
						}
					}
				}
				return result;
			}

			@Override
			protected void succeeded() {
				// TODO Auto-generated method stub
				lblResult.setText(String.valueOf(getValue()));
			}

			
			@Override
			protected void cancelled() {
				// TODO Auto-generated method stub
				super.cancelled();
				lblResult.setText("��ҵ�");
			}

			@Override
			protected void failed() {
				// TODO Auto-generated method stub
				super.failed();
				lblResult.setText("����");
			}
		};
		
		progressBar.progressProperty().bind(task.progressProperty());
		lblWorkDone.textProperty().bind(task.messageProperty());
		lblResult.setText("");
		
		Thread thread = new Thread(task);
		thread.setDaemon(true);
		thread.start();
	}
	
	public void handleBtnStop(ActionEvent e) {
		task.cancel();
	}
}
