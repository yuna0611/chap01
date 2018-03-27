package com_yuna_ex1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable {
	@FXML private Button btnAdd;
	@FXML private Button btnBarChart;
	@FXML private TableView<Student> tableView;
	
	private Stage primaryStage;
	private ObservableList<Student> list;	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//list = FXCollections.observableArrayList();
		list = FXCollections.observableArrayList(
			new Student("홍길동A", 40, 60, 80),	
			new Student("홍길동B", 60, 80, 40),	
			new Student("홍길동C", 80, 40, 60)	
		);
		
		TableColumn tc = tableView.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory("name"));
		tc.setStyle("-fx-alignment:CENTER;");

		tc = tableView.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory("kor"));
		tc.setStyle("-fx-alignment:CENTER;");
		
		tc = tableView.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory("math"));
		tc.setStyle("-fx-alignment:CENTER;");
		
		tc = tableView.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory("eng"));
		tc.setStyle("-fx-alignment:CENTER;");
		
		tableView.setItems(list);
		tableView.setOnMouseClicked(event->handleTableViewMouseClicked(event));
		btnAdd.setOnAction(event->handleBtnAddAction(event));
		btnBarChart.setOnAction(event->handlebtnBarChartAction(event));
	}
	
/*	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage=primaryStage;
	}*/
	
	
	public void handleBtnAddAction(ActionEvent event){
		try {
			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(btnAdd.getScene().getWindow());
			dialog.setTitle("추가");
			
			Parent parent = FXMLLoader.load(getClass().getResource("form.fxml"));
			
			Button btnReg = (Button)parent.lookup("#btnReg");
			btnReg.setOnAction(e->{
				TextField txtName = (TextField) parent.lookup("#txtName");
				TextField txtKor = (TextField) parent.lookup("#txtKor");
				TextField txtMath = (TextField) parent.lookup("#txtMath");
				TextField txtEng = (TextField) parent.lookup("#txtEng");
				list.add(new Student(
						txtName.getText(), 
						Integer.parseInt(txtKor.getText()), 
						Integer.parseInt(txtMath.getText()), 
						Integer.parseInt(txtEng.getText())
					));
			//	dialog.close;
			});
			
			Button btnCancel = (Button)parent.lookup("#btnCancel");
			btnCancel.setOnAction(e->dialog.close());
			
			Scene scene = new Scene(parent);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
		}catch(IOException e) {}
	}
	
	public void handlebtnBarChartAction(ActionEvent event) {
		try {	
			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(btnAdd.getScene().getWindow());
			dialog.setTitle("막대그래프");
			
			Parent parent = FXMLLoader.load(getClass().getResource("barchart.fxml"));
			
			BarChart barChart = (BarChart)parent.lookup("#barChart");
			
			XYChart.Series seriesKorean = new XYChart.Series();
			seriesKorean.setName("국어");
			ObservableList koreanList = FXCollections.observableArrayList();
			for (int i = 0; i < list.size(); i++) {
				koreanList.add(new XYChart.Data(list.get(i).getName(), list.get(i).getKor()));
			}
			seriesKorean.setData(koreanList);
			barChart.getData().add(seriesKorean);
			
			
			XYChart.Series seriesMath = new XYChart.Series();
			seriesMath.setName("수학");
			ObservableList mathList = FXCollections.observableArrayList();
			for (int i = 0; i < list.size(); i++) {
				mathList.add(new XYChart.Data(list.get(i).getName(), list.get(i).getMath()));
			}
			seriesMath.setData(mathList);
			barChart.getData().add(seriesMath);
			
			XYChart.Series seriesEng = new XYChart.Series();
			seriesEng.setName("영어");
			ObservableList engList = FXCollections.observableArrayList();
			for (int i = 0; i < list.size(); i++) {
				engList.add(new XYChart.Data(list.get(i).getName(), list.get(i).getEng()));
			}
			seriesEng.setData(engList);
			barChart.getData().add(seriesEng);
			
			Button btnClose = (Button)parent.lookup("#btnClose");
			btnClose.setOnAction(e->dialog.close());
			
			Scene scene = new Scene(parent);
			dialog.setScene(scene);
			dialog.show();
		}
	
		catch (IOException e) {};
	}
	
	private void handleTableViewMouseClicked(MouseEvent event) {
		if(event.getClickCount()!=2)
			return;
		try {
			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(btnAdd.getScene().getWindow());
			dialog.setTitle("파이 그래프");
			
			Parent parent = FXMLLoader.load(getClass().getResource("piechart.fxml"));
			
			PieChart pieChart = (PieChart)parent.lookup("#pieChart");
			Student student = tableView.getSelectionModel().getSelectedItem();
			pieChart.setData(FXCollections.observableArrayList(
					new PieChart.Data("국어",student.getKor()),
					new PieChart.Data("수학",student.getMath()),
					new PieChart.Data("영어",student.getEng())
				));
			
			Button btnClose = (Button)parent.lookup("#btnClose");
			btnClose.setOnAction(e->dialog.close());
			
			Scene scene = new Scene(parent);
			dialog.setScene(scene);
			dialog.show();
		} catch (IOException e) {
			System.out.println("예외처리");
		}
	}
}
