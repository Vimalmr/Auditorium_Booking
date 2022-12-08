package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Locale;

public class au_details extends Application {
	private DatePicker checkInDatePicker;
    public static void main(String[] args) {
    	Locale.setDefault(Locale.US);
        launch(args);
    }
    
    public void start(Stage primaryStage) {
    	Text t = new Text("Hall availability");
    	t.setFont(Font.font("verdana", FontWeight.BOLD, 14));
    
        Label l1 = new Label("Date of the event :");
        Label l2 = new Label("Start time :");
        Label l3 = new Label("End time :");
        Label l4 = new Label("Choose hall :");
        
        Button btn1 = new Button("Check");
        Button btn2 = new Button("Back");
        
        TextField tf1=new TextField();
    	TextField tf2=new TextField();
    	tf1.setPromptText("hh:mm");
    	tf2.setPromptText("hh:mm");
    	
        String hall[] = {"Convention center","Maharaja Auditorium","Sir C V Raman Hall","Mahatma Gandhi Hall" };
    	ComboBox<String> cb1 = new ComboBox<String>(FXCollections.observableArrayList(hall));
    	
    	String time[] = {"AM","PM" };
    	ComboBox<String> cb2 = new ComboBox<String>(FXCollections.observableArrayList(time));
    	ComboBox<String> cb3 = new ComboBox<String>(FXCollections.observableArrayList(time));
        checkInDatePicker = new DatePicker();
        
        GridPane grid=new GridPane();
        grid.add(t, 0, 0);
        grid.add(l1, 0, 1);
        grid.add(l2, 0, 2);
        grid.add(l3, 0, 3);
        grid.add(l4, 0, 4);
        grid.add(checkInDatePicker, 1, 1);
        grid.add(cb2, 2, 2);
        grid.add(cb3, 2, 3);
        grid.add(cb1, 1, 4);
        grid.add(tf1, 1, 2);
        grid.add(tf2, 1, 3);
        HBox hb1 = new HBox(10);
        hb1.getChildren().addAll(btn2,btn1);
        grid.add(hb1, 1, 6);
        grid.setVgap(10);
        grid.setHgap(10);
        Scene scene = new Scene(grid,500,400);
        primaryStage.setScene(scene);  
        primaryStage.show();
    }
}
