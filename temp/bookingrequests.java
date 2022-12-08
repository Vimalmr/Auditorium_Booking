
package application;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class bookingrequests extends Application{
	 public static void main(String[] args) {
	        launch(args);
}

	@Override
	public void start(Stage arg0) throws Exception {
		Text t1 = new Text("Booking request details");
		t1.setFont(Font.font("verdana", FontWeight.BOLD, 14));
		Button btn1 = new Button();
		
		btn1.setText("Decline");
		 Button btn3 = new Button("Back");
		 btn3.setText("Back");
		 Button btn2 = new Button("Accept");
		 
		Label label1 = new Label ("Name:");
		Label label2 = new Label ("Department Name:");
		Label label3 = new Label ("Club Name:");
		Label label4 = new Label ("Event Type:");
		Label label5 = new Label ("Faculty Co-ordinator name:");
		Label label6 = new Label ("Email:");
		Label label7 = new Label ("phone:");
	
		GridPane gridPane = new GridPane();
		gridPane.add(t1, 0, 0);
		gridPane.add(label1, 0, 1);
		gridPane.add(label2, 0, 2);
		gridPane.add(label3, 0, 3);
		gridPane.add(label4, 0, 4);
		gridPane.add(label5, 0, 5);
		gridPane.add(label6, 0, 6);
		gridPane.add(label7, 0, 7);
		
		
		HBox hb1 = new HBox(10);
		hb1.getChildren().addAll(btn1,btn2,btn3);
		gridPane.add(hb1,1,8);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		arg0.setScene(new Scene(gridPane, 300, 250));
        arg0.show();
        
	}
}