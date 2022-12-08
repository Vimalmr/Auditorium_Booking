package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Details extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	 public void start(Stage primaryStage) {
		 Text t1 = new Text("Hall details");
		 t1.setFont(Font.font("verdana", FontWeight.BOLD, 14));
		 
		 Label l1 = new Label("Name of the hall : "); 
		 Label l2 = new Label("Location : "); 
		 Label l3 = new Label("Do you want extra chairs : "); 
		 Label l4 = new Label("If yes how many chairs : "); 
		 Label l5 = new Label("Do you want AC : "); 
		 Label l6 = new Label("Sir C V Raman Seminar Hall"); 
		 Label l7 = new Label("Science and Humanities"); 
		 
		 RadioButton button1 = new RadioButton("Yes");
	     RadioButton button2 = new RadioButton("No");
	     
	     HBox hb1 = new HBox(10);
	     hb1.getChildren().addAll(button1,button2);
	     TextField tb1 = new TextField();
	     
	     HBox hb2 = new HBox(10);
	     
	     RadioButton button3 = new RadioButton("Yes");
	     RadioButton button4 = new RadioButton("No");
	     
	     hb2.getChildren().addAll(button3,button4);
	     ToggleGroup group1 = new ToggleGroup();
	      button1.setToggleGroup(group1);
	      button2.setToggleGroup(group1);
	      
	      ToggleGroup group2 = new ToggleGroup();
	      button3.setToggleGroup(group2);
	      button4.setToggleGroup(group2);
	     
	      Button b1=new Button("Book");
	      Button b2=new Button("Back");
	      
	      HBox hb3 = new HBox(10);
	      hb3.getChildren().addAll(b2,b1);
		  GridPane grid = new GridPane();
		  grid.add(t1, 0, 0);
		  grid.add(l1, 0, 1);
		  grid.add(l2, 0, 2);
		  grid.add(l3, 0, 3);
		  grid.add(l4, 0, 4);
		  grid.add(l5, 0, 5);
		  grid.add(l6, 1, 1);
		  grid.add(l7, 1, 2);
		  grid.add(hb1, 1, 3);
		  grid.add(tb1, 1, 4);
		  grid.add(hb2, 1, 5);
		  grid.add(hb3, 1, 6);
		  grid.setVgap(10);
		  grid.setHgap(10);
	        
	        Scene scene = new Scene(grid,300,300);
	        primaryStage.setScene(scene);  
	        primaryStage.show();
	 }
}
