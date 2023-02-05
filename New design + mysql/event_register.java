package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
		
		Text Lo = new Text("Register");
        Lo.setFill(Color.BLACK);
        Lo.setStroke(Color.GREEN);
        Lo.setStrokeWidth(1);
        Lo.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
		
		btn1.setText("Next");
		btn1.setTextFill(Color.WHITE);
        btn1.setStyle("-fx-background-color: #47AB11");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
	        public void handle(ActionEvent event) {
				changeScenes();
	        }
	    });
		
		Button btn3 = new Button("Back");
		btn3.setTextFill(Color.WHITE);
        btn3.setStyle("-fx-background-color: GREY");
		Label label1 = new Label ("Faculty Member Name:");
		Label label2 = new Label ("Department Name:");
		Label label3 = new Label ("Nature of Function:");
		Label label4 = new Label ("Email:");
		Label label5 = new Label ("Phone No:");
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		TextField tf3 = new TextField();
		TextField tf4 = new TextField();
		TextField tf5 = new TextField();
		
		Button btn2 = new Button("Clear");
		btn2.setTextFill(Color.WHITE);
        btn2.setStyle("-fx-background-color: GREY");
		
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                tf1.clear();
                tf2.clear();
                tf3.clear();
                tf4.clear();
                tf5.clear();
            }
        });
        
        btn3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                goback();
            }
        });
        
		GridPane gridPane = new GridPane();
		BorderPane bp = new BorderPane();
		
		HBox v= new HBox();
        v.getChildren().addAll(btn2,btn1);
        v.setAlignment(Pos.CENTER_RIGHT);
        v.setSpacing(10);
		
		VBox vb = new VBox();
        vb.getChildren().addAll(Lo, gridPane);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(10);
		
		
        gridPane.setHgap(20);
		gridPane.setVgap(20);
		gridPane.addRow(2,label1,tf1);
		gridPane.addRow(3,label2,tf2);
		gridPane.addRow(4,label3,tf3);
		gridPane.addRow(5,label4,tf4);
		gridPane.addRow(6,label5,tf5);
        gridPane.addRow(7,btn3,v);
        gridPane.setAlignment(Pos.CENTER);
		
		bp.setCenter(vb);
        bp.setAlignment(vb, Pos.TOP_CENTER);
		
		Scene s1 = new Scene(bp, 500, 500);
		
        return s1;
        
	}
}
