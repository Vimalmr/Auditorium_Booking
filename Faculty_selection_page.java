package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class Faculty_selection_page{
	
	public Scene getScene() {
		
		Button btn1 = new Button("Event Registration");
		Button btn2 = new Button("Auditorium Details");
		Button btn3 = new Button("Auditorium Availability");
		
		TilePane tile = new TilePane();
        
        VBox v = new VBox(10);
        v.setAlignment(Pos.CENTER);
        v.getChildren().addAll(btn1,btn2,btn3);
        tile.getChildren().add(v);
        
        StackPane root = new StackPane();
        root.getChildren().add(v);
        
        Scene s1 = new Scene(root,400,350);
        
        return s1;

	}
}
