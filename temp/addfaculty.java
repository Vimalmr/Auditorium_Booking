package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class addfaculty extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage primaryStage) {
    	Text t1=new Text("Faculty Details");
    	t1.setFont(Font.font("verdana", FontWeight.BOLD, 14));
    	
    	Label l1 = new Label("Name:");
    	Label l2 = new Label("Department:");
    	Label l3 = new Label("email id:");
    	Label l4 = new Label("Phone no:");
    	
    	TextField tf1 = new TextField();
    	TextField tf2 = new TextField();
    	TextField tf3 = new TextField();
    	TextField tf4 = new TextField();
    	
    	GridPane grid = new GridPane();
    	grid.add(t1, 0, 0);
    	grid.add(l1, 0, 1);
    	grid.add(l2, 0, 2);
    	grid.add(l3, 0, 3);
    	grid.add(l4, 0, 4);
    	grid.add(tf1, 1, 1);
    	grid.add(tf2, 1, 2);
    	grid.add(tf3, 1, 3);
    	grid.add(tf4, 1, 4);
    	grid.setVgap(20);
    	
    	Button btn1 = new Button("Back");
    	Button btn2 = new Button("Submit");
        HBox hb1 = new HBox(10);
    	hb1.getChildren().addAll(btn1,btn2);
    	
    	grid.add(hb1,1, 5);
    	 Scene scene = new Scene(grid,300,300);
	        primaryStage.setScene(scene);  
	        primaryStage.show();
    	
    }
}
