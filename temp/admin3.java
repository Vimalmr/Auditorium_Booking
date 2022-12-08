package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class admin3 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) {
		Button btn1 = new Button("Booking requests");
		Button btn2 = new Button("Auditorium details");
		Button btn3 = new Button("Auditorium availabilty");
		Button btn4 = new Button("Add faculty");
		Button btn5 = new Button("Back");
		
		VBox vb1 = new VBox(20);
		vb1.getChildren().addAll(btn1,btn2,btn3,btn4,btn5);
		vb1.setAlignment(Pos.CENTER);
		
		StackPane s1 = new StackPane();
		 s1.getChildren().add(vb1);
	        
	        Scene scene = new Scene(s1,300,300);
	        primaryStage.setScene(scene);  
	        primaryStage.show();
		
	}
}
