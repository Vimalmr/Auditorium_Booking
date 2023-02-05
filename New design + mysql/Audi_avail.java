package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Audi_avail {
	 private DatePicker checkInDatePicker;
	 
	 private Stage p;
	 
	 public void goback() {
			Admin_selection_page ci = new Admin_selection_page();
	        Scene scene = ci.getScene(p);

	        // set new title
	        p.setTitle("Selection Page");

	        // change the scene on the stage
	        p.setScene(scene);
	}
	 
public Scene getScene(Stage p) {
		 
		 this.p=p;
		 
	    	Text t = new Text("Hall availability");
	    	t.setFill(Color.BLACK);
	        t.setStroke(Color.GREEN);
	        t.setStrokeWidth(1);
	        t.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
	    
	        Label l1 = new Label("Date of the event :");
	        Label l2 = new Label("Start Period :");
	        Label l3 = new Label("End Period :");
	        Label l4 = new Label("Choose hall :");
	        
			final Label lblMessage = new Label();
	        
			 TextField tf1=new TextField();
			 TextField tf2=new TextField();
			 TextField tf3=new TextField();
		    	tf1.setPromptText("Start period");
		    	tf2.setPromptText("End period");
		    	tf3.setPromptText("DD/MM/YYYY");
			
	        Button btn1 = new Button("Check");
	        btn1.setTextFill(Color.WHITE);
	        btn1.setStyle("-fx-background-color: #47AB11");
	        
	        Button btn2 = new Button("Back");
	        btn2.setTextFill(Color.WHITE);
	        btn2.setStyle("-fx-background-color: GREY");
	        
	        btn2.setOnAction(new EventHandler<ActionEvent>(){
	            public void handle(ActionEvent event) {
	            	goback();
	            }
	        });
	        
	        GridPane grid=new GridPane();
	        
	        String hall[] = {"Convention center","Maharaja Auditorium","Sir C V Raman Hall"};
	    	ComboBox<String> cb1 = new ComboBox<String>(FXCollections.observableArrayList(hall));
	    	cb1.setPromptText("Select");
	        
	        btn1.setOnAction(new EventHandler<ActionEvent>(){
	            public void handle(ActionEvent event) {
	            	try {
	            		int srt = Integer.parseInt(tf1.getText());
	                	int end = Integer.parseInt(tf2.getText());
	                	String audi=cb1.getValue();
	                	String date=tf3.getText().toString();
	            	
	                    	Class.forName("com.mysql.jdbc.Driver");
	            			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx-project","root","root");
	            			ResultSet rs = null;
	            			
	            			Statement stmt = con.createStatement();
	            			int flag=0;
	            			if(audi.equals("Convention center")) {
	            				rs= stmt.executeQuery("select * from convention_req");
	            			}
	            			else if(audi.equals("Maharaja Auditorium")) {
	            				rs= stmt.executeQuery("select * from maharaja_req");
	            			}
	            			else if(audi.equals("Sir C V Raman Hall")) {
	            				rs= stmt.executeQuery("select * from cvhall_req");
	            			}
	            				
	            			 while(rs.next()) {
	            				 if( date.equals(rs.getString(2))) {
	            					 	if((srt>=rs.getInt(3) && srt<= rs.getInt(4)) || (end>=rs.getInt(3) && end<= rs.getInt(4))) {
	            					 		flag=1;
	            					 		break;
	            					 	}
	            				 }
	            			 }
	            			if(flag==0) {
	                 	    	lblMessage.setText("Available!!!");
	                       	 lblMessage.setTextFill(Color.GREEN);
	                       	 grid.add(lblMessage, 1, 8);
	            			}
	            			else if(flag==1) {
	            				lblMessage.setText("Unavailable!!!");
	            	           	 lblMessage.setTextFill(Color.RED);
	            	           	 grid.add(lblMessage, 1, 8);
	            			}
	            			
	            	}
	            	catch(Exception e) {
	            		System.out.println(e);
	            	}
	            }
	        });
	        
	        
	        BorderPane bp = new BorderPane();
	        
	        grid.add(t, 0, 0);
	        grid.add(l1, 0, 1);
	        grid.add(l2, 0, 2);
	        grid.add(l3, 0, 3);
	        grid.add(l4, 0, 4);
	        grid.add(tf3, 1, 1);
	        grid.add(cb1, 1, 4);
	        grid.add(tf1, 1, 2);
	        grid.add(tf2, 1, 3);
	        grid.add(lblMessage, 1, 8);
	        grid.setAlignment(Pos.CENTER);
	        
	        HBox hb1 = new HBox(10);
	        hb1.getChildren().addAll(btn2,btn1);
	        grid.add(hb1, 1, 6);
	        grid.setVgap(10);
	        grid.setHgap(10);
	        
	        VBox vb = new VBox();
	        vb.getChildren().addAll(t, grid);
	        vb.setAlignment(Pos.CENTER);
	        vb.setSpacing(10);
	        
	        bp.setCenter(vb);
	        bp.setAlignment(vb, Pos.TOP_CENTER);
	        
	        Scene s1 = new Scene(bp,500,500);
	        
	        return s1;
	    }
}
