package com.yuna.fxex01;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppMain2 extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(10);
		
		TextField textField = new TextField();
		textField.setPrefWidth(200);
		
		Button button = new Button();
		button.setText("»Æ¿Œ");
		
		ObservableList list = hbox.getChildren();
		list.add(textField);
		list.add(button);
		
		Scene scene = new Scene(hbox);
		
		arg0.setTitle("AppMain");
		arg0.setScene(scene);
		arg0.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
