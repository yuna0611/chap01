package test;


import java.util.ResourceBundle;

import java.net.URL;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class RootController2 implements Initializable {
	@FXML private TextArea textArea1;
	@FXML private TextArea textArea2;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		Bindings.bindBidirectional(textArea1.textProperty(), textArea2.textProperty());
	}
}
