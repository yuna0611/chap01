package application;
import java.util.ResourceBundle;

import java.net.URL;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.text.Font;

public class RootController implements Initializable {
   @FXML
   private Slider slider;
   @FXML
   private Label label;

   @Override
   public void initialize(URL location, ResourceBundle resources) {
      // TODO Auto-generated method stub
      slider.valueProperty().addListener(new ChangeListener<Number>() {
         @Override
         public void changed(ObservableValue<? extends Number> observable, Number oldaValue, Number newValue) {
            label.setFont(new Font(newValue.doubleValue()));
         }
      });
   }
}