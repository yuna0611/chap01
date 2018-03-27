package com.yuna.fxex01;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppMain extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		VBox root = new VBox();
		root.setPrefWidth(350);
		root.setPrefHeight(150);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);
		
		Label label = new Label();
		label.setText("Yuna");
		label.setFont(new Font(50));
		
		Button button = new Button();
		button.setText("Ȯ��");
		button.setOnAction(event->Platform.exit());
		
		root.getChildren().add(label);
		root.getChildren().add(button);
		
		Scene scene = new Scene(root);
		
		arg0.setTitle("AppMain");
		arg0.setScene(scene);
		arg0.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
