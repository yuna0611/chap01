package com_yuna_test3;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {

   public void start(Stage primaryStage) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("root2.fxml"));
      Scene scene = new Scene(root);

      primaryStage.setTitle("AppMain");
      primaryStage.setScene(scene);
      primaryStage.show();
   }

   public static void main(String[] args) {
      // TODO Auto-generated method stub

      launch(args);
   }

}

