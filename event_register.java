package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class event_register {
	
	private Stage p;
	
	public void goback() {
		Faculty_selection_page ci = new Faculty_selection_page();
        Scene scene = ci.getScene(p);

        // set new title
        p.setTitle("Selection Page");

        // change the scene on the stage
        p.setScene(scene);
	}
	
	public void changeScenes()
    {
		event_register_2 ci = new event_register_2();
        Scene scene = ci.getScene(p);

        // set new title
        p.setTitle("Register Page");

        // change the scene on the stage
        p.setScene(scene);
    }
	
	public Scene getScene(Stage p) {
		
		this.p = p;
		
		p.setTitle("form");
		Button btn1 = new Button();
		
		btn1.setText("Next");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
	        public void handle(ActionEvent event) {
				changeScenes();
	        }
	    });
		
		Button btn3 = new Button("Back");
		Label label1 = new Label ("Name:");
		Label label2 = new Label ("Department Name:");
		Label label3 = new Label ("Club Name:");
		Label label4 = new Label ("Event Type:");
		Label label5 = new Label ("Faculty Co-ordinator name:");
		Label label6 = new Label ("Email:");
		Label label7 = new Label ("hone:");
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		TextField tf3 = new TextField();
		TextField tf4 = new TextField();
		TextField tf5 = new TextField();
		TextField tf6 = new TextField();
		TextField tf7 = new TextField();
		Button btn2 = new Button("Clear");
		
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                tf1.clear();
                tf2.clear();
                tf3.clear();
                tf4.clear();
                tf5.clear();
                tf6.clear();
                tf7.clear();
            }
        });
        
        btn3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                goback();
            }
        });
        
		GridPane gridPane = new GridPane();
		
		HBox v= new HBox(10);
        v.getChildren().addAll(btn2,btn1);
        v.setAlignment(Pos.CENTER_RIGHT);
		
		gridPane.add(label1, 0, 0);
		gridPane.add(label2, 0, 1);
		gridPane.add(label3, 0, 2);
		gridPane.add(label4, 0, 3);
		gridPane.add(label5, 0, 4);
		gridPane.add(label6, 0, 5);
		gridPane.add(label7, 0, 6);
		gridPane.add(tf1, 1, 0);
		gridPane.add(tf2, 1, 1);
		gridPane.add(tf3, 1, 2);
		gridPane.add(tf4, 1, 3);
		gridPane.add(tf5, 1, 4);
		gridPane.add(tf6, 1, 5);
		gridPane.add(tf7, 1, 6);
        gridPane.add(v,1,7);
        gridPane.add(btn3,0,7);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		
		Scene s1 = new Scene(gridPane, 500, 500);
		
        return s1;
        
	}
}
