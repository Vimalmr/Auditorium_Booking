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

public class Faculty_selection_page{
	
	private Stage p;
    
    public void changeScenes()
    {
    	event_register ci = new event_register();
        Scene scene = ci.getScene(p);

        // set new title
        p.setTitle("Register Page");

        // change the scene on the stage
        p.setScene(scene);
    }
    
    public void avail()
    {
		Audi_avail2 ci = new Audi_avail2();
        Scene scene = ci.getScene(p);

        // set new title
        p.setTitle("Availability Page");

        // change the scene on the stage
        p.setScene(scene);
    }
	
	
	public Scene getScene(Stage p) {
		
		this.p = p;
    	p.setTitle("Select Page");
		
		Button btn1 = new Button("Event Registration");
		Button btn3 = new Button("Auditorium Availability");
		
		TilePane tile = new TilePane();
		
		btn1.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
                	changeScenes();
            }
        });
		
		btn3.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
                	avail();
            }
        });
        
        VBox v = new VBox(10);
        v.setAlignment(Pos.CENTER);
        v.getChildren().addAll(btn1,btn3);
        tile.getChildren().add(v);
        
        StackPane root = new StackPane();
        root.getChildren().add(v);
        
        Scene s1 = new Scene(root,500,500);
        
        return s1;
	}
}
