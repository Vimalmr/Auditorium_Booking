package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class addfaculty {
	
	private Stage p;
	
	public void goback() {
		Admin_selection_page ci = new Admin_selection_page();
        Scene scene = ci.getScene(p);

        // set new title
        p.setTitle("Selection Page");

        // change the scene on the stage
        p.setScene(scene);
	}
	
	public Scene getScene(Stage p){
		
		this.p = p;
		
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
    	
    	final Label lblMessage = new Label();
    	
    	Button btn1 = new Button("Back");
    	Button btn2 = new Button("Submit");
        HBox hb1 = new HBox(10);
    	hb1.getChildren().addAll(btn1,btn2);
    	
    	btn1.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
            	goback();
            }
        });
    	
    	btn2.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
            	lblMessage.setText("SUCCESSFULLY SUBMITTED:)");
           	 	lblMessage.setTextFill(Color.GREEN);
            }
        });
    	
    	grid.add(hb1,1, 5);
    	grid.add(lblMessage, 1, 7);
    	
    	Scene s1 = new Scene(grid,500,500);
	     
    	return s1;
    	
    }
}
