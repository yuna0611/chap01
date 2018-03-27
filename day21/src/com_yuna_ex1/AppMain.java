package com_yuna_ex1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
	@Override
	   public void start(Stage primaryStage) throws Exception {
		/*	FXMLLoader loader = new FXMLLoader(getClass().getResource("root5.fxml"));
			Parent root = loader.load();
			RootController controller = loader.getController();
			controller.setPrimaryStage(primaryStage);*/
			
			Parent root = (Parent)FXMLLoader.load(getClass().getResource("root5.fxml"));
			Scene scene = new Scene(root);
			
			primaryStage.setTitle("AppMain");
			primaryStage.setScene(scene);
			primaryStage.show();
	   }

	   public static void main(String[] args) {
	      launch(args);
	   }
}

