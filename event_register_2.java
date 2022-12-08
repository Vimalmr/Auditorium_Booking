package application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class event_register_2 {
	private DatePicker checkInDatePicker;
    
	private Stage p;
	
	public void goback() {
		event_register ci = new event_register();
        Scene scene = ci.getScene(p);

        // set new title
        p.setTitle("Register Page");

        // change the scene on the stage
        p.setScene(scene);
	}
	
	public void changeScenes()
    {
		event_register_3 ci = new event_register_3();
        Scene scene = ci.getScene(p);

        // set new title
        p.setTitle("Register Page");

        // change the scene on the stage
        p.setScene(scene);
    }
	
    public Scene getScene(Stage p) {
    	this.p= p ;
    	
    	Text t1 = new Text("Enter the event details");
    	Label l1= new Label("Student capacity:");
    	Label l2= new Label("Date of the event:");
    	Label l3=new Label("No.of.hours:");
    	Label l4=new Label("Starting time:");
    	Label l5=new Label("Ending time:");
    	
    	TextField tf1=new TextField();
    	TextField tf2=new TextField();
    	TextField tf3=new TextField();
    	TextField tf4=new TextField();
    	tf3.setPromptText("hh:mm");
    	tf4.setPromptText("hh:mm");
    	
    	String time[] = {"AM","PM" };
    	ComboBox<String> cb1 = new ComboBox<String>(FXCollections.observableArrayList(time));
    	ComboBox<String> cb2 = new ComboBox<String>(FXCollections.observableArrayList(time));
    	checkInDatePicker = new DatePicker();
    	
    	t1.setFont(Font.font("verdana", FontWeight.BOLD, 14));
    	
    	String audi_name[]= {"Maharaja Auditorium","Convention Centre","Sir CV Raman Hall","Mahatama Gandhi Hall"};
    	ComboBox<String> c1 = new ComboBox<String>(FXCollections.observableArrayList(audi_name));
    	
    	Button btn1 = new Button("Check");
    	Button btn2 = new Button("Back");
    	Button btn3 = new Button("Next");
    	
    	 btn2.setOnAction(new EventHandler<ActionEvent>() {

             @Override
             public void handle(ActionEvent event) {
                 goback();
             }
         });
    	 
    	 btn3.setOnAction(new EventHandler<ActionEvent>() {

             @Override
             public void handle(ActionEvent event) {
                 changeScenes();
             }
         });
    	
    	GridPane grid = new GridPane();
        grid.add(t1, 0, 0);
        grid.add(l1, 0, 1);
        grid.add(l2, 0, 2);
        grid.add(tf1, 1, 1);
        grid.add(checkInDatePicker, 1, 2);
        grid.add(l3, 0, 3);
        grid.add(tf2, 1, 3);
        grid.add(l4, 0, 4);
        grid.add(tf3, 1, 5);
        grid.add(l5, 0, 5);
        grid.add(tf4, 1, 4);
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                grid.add(c1, 1, 7, 2, 1);
                grid.add(btn3, 1, 8);
            }
        });
       
        HBox hb1 = new HBox(10);
        hb1.getChildren().addAll(btn2,btn1);
        grid.add(cb1, 2, 4);
        grid.add(cb2, 2, 5);
        grid.add(hb1, 1, 6);
        grid.setVgap(20);
        
        Scene s1 = new Scene(grid,500,500);
        return s1;
        
    	}
}
