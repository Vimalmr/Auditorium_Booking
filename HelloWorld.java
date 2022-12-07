package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class HelloWorld extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	
        primaryStage.setTitle("Welcome!");
        Text t = new Text("Welcome");
        t.setFont(Font.font("verdana", FontWeight.BOLD, 20));
        
        TilePane tile = new TilePane();
        Button b1 = new Button("Admin");
        Button b2 = new Button("Faculty");
        
        VBox v= new VBox(10);
        v.getChildren().addAll(t,b1,b2);
        v.setAlignment(Pos.CENTER);
        //tile.getChildren().add(v);
        
        StackPane s1 = new StackPane();
        s1.getChildren().add(v);
        
        Scene scene = new Scene(s1,300,300);
        primaryStage.setScene(scene);  
        primaryStage.show();
    }
    
    
}

