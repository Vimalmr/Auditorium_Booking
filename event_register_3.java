package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class event_register_3 {
	
	private Stage p;
	
	public void goback() {
		event_register_2 ci = new event_register_2();
        Scene scene = ci.getScene(p);

        // set new title
        p.setTitle("Register Page");

        // change the scene on the stage
        p.setScene(scene);
	}
	
	public Scene getScene(Stage p) {
		this.p=p;
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
	     
	      Button b1=new Button("Register");
	      Button b2=new Button("Back");
	      final Label lblMessage = new Label();
	      
	      b2.setOnAction(new EventHandler<ActionEvent>() {

	             @Override
	             public void handle(ActionEvent event) {
	                 goback();
	             }
	         });
	      
	      b1.setOnAction(new EventHandler<ActionEvent>() {

	             @Override
	             public void handle(ActionEvent event) {
	            	 lblMessage.setText("Registered!!!");
	            	 lblMessage.setTextFill(Color.GREEN);
	             }
	         });
	      
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
		  grid.add(lblMessage, 1, 8);
		  grid.setVgap(10);
		  grid.setHgap(10);
	        
	        Scene s1 = new Scene(grid,500,500);
	        return s1;
	 }
}
