package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Admin_selection_page{
	private Stage p;
	
	public void changeScenes()
    {
		booking_request ci = new booking_request();
        Scene scene = ci.getScene(p);

        // set new title
        p.setTitle("Booking Requests");

        // change the scene on the stage
        p.setScene(scene);
    }
	
	public void addfac()
    {
		addfaculty ci = new addfaculty();
        Scene scene = ci.getScene(p);

        // set new title
        p.setTitle("Add Faculty");

        // change the scene on the stage
        p.setScene(scene);
    }
	
	public void avail()
    {
		Audi_avail ci = new Audi_avail();
        Scene scene = ci.getScene(p);

        // set new title
        p.setTitle("Availability Page");

        // change the scene on the stage
        p.setScene(scene);
    }
	
	public Scene getScene(Stage p) {
		this.p = p;
		
		Button btn3 = new Button("Auditorium Availability");
		Button btn4 = new Button("Booking Requests");
		Button btn5 = new Button("Add Faculty");
		
		btn4.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
            	changeScenes();
            }
        });
		
		btn5.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
            	addfac();
            }
        });
		
		btn3.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
            	avail();
            }
        });
		
		TilePane tile = new TilePane();
        
        VBox v = new VBox(10);
        v.setAlignment(Pos.CENTER);
        v.getChildren().addAll(btn4,btn3,btn5);
        tile.getChildren().add(v);
        
        StackPane root = new StackPane();
        root.getChildren().add(v);
        
        Scene s1 = new Scene(root,500,500);
        
        return s1;

	}
}
