package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
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

public class event_register_2 {
	private Stage p;
	
	String sql,date;
	
	public void goback() {
		event_register ci = new event_register();
        Scene scene = ci.getScene(p);

        // set new title
        p.setTitle("Register Page");

        // change the scene on the stage
        p.setScene(scene);
	}
	
    public Scene getScene(Stage p) {
    	this.p= p ;
    	
    	Text t1 = new Text("Event details");
    	t1.setFill(Color.BLACK);
        t1.setStroke(Color.GREEN);
        t1.setStrokeWidth(1);
        t1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
    	
    	Label l1= new Label("Student capacity:");
    	Label l2= new Label("Date of the event:");
    	Label l4=new Label("Starting Period:");
    	Label l5=new Label("Ending Period:");
    	Label l6=new Label("Auditorium:");
    	
    	TextField tf1=new TextField();
    	TextField tf3=new TextField();
    	TextField tf4=new TextField();
    	TextField tf5=new TextField();
    	tf4.setPromptText("Start Period");
    	tf3.setPromptText("End Period");
    	tf5.setPromptText("DD/MM/YYYY");
    	
    	String audi_name[]= {"Maharaja Auditorium","Convention Centre","Sir CV Raman Hall"};
    	ComboBox<String> c1 = new ComboBox<String>(FXCollections.observableArrayList(audi_name));
    	c1.setPromptText("Select");
    	
    	Button btn1 = new Button("Check");
    	btn1.setTextFill(Color.WHITE);
        btn1.setStyle("-fx-background-color: #47AB11");
        
    	Button btn2 = new Button("Back");
    	btn2.setTextFill(Color.WHITE);
        btn2.setStyle("-fx-background-color: GREY");
        
    	Button btn3 = new Button("Register");
    	btn3.setTextFill(Color.WHITE);
        btn3.setStyle("-fx-background-color: #47AB11");
    	
    	 btn2.setOnAction(new EventHandler<ActionEvent>() {

             @Override
             public void handle(ActionEvent event) {
                 goback();
             }
         });
    	 
    	 GridPane grid = new GridPane();
    	 final Label lblMessage = new Label();
    	 
    	 btn3.setOnAction(new EventHandler<ActionEvent>() {

             @Override
             public void handle(ActionEvent event) {
            	 try {
             		
                	int flag=0;
                	int srt = Integer.parseInt(tf3.getText());
                	int end = Integer.parseInt(tf4.getText());
                	String audi=c1.getValue();
                	date=tf5.getText().toString();
                	
                	ResultSet rs = null;
                	Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/javafx-project","root","root");
                	Statement stmt = con.createStatement();
                	
         			if(audi.equals("Maharaja Auditorium")) {
         				sql = "INSERT INTO maharaja_req(date, start_period, end_period) VALUES (?,?,?)";
         				rs= stmt.executeQuery("select * from maharaja_req");
         			}
         			else if(audi.equals("Convention Centre")) {
         				sql = "INSERT INTO convention_req(date, start_period, end_period) VALUES (?,?,?)";
         				rs= stmt.executeQuery("select * from convention_req");
         			}
         			else if(audi.equals("Sir CV Raman Hall")) {
         				sql = "INSERT INTO cvhall_req(date, start_period, end_period) VALUES (?,?,?)";
         				rs= stmt.executeQuery("select * from cvhall_req");
         			}
         			
         			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS); 
         			
        			while(rs.next()) {
       				 if( date.equals(rs.getString(2))) {
       					 	if((srt>=rs.getInt(3) && srt<= rs.getInt(4)) || (end>=rs.getInt(3) && end<= rs.getInt(4))) {
       					 		flag=1;
       					 		break;
       					 	}
       				 }
       			 }
        			if(flag==0) {
        				pstmt.setString(1, date);
                        pstmt.setInt(3, srt);
                        pstmt.setInt(2, end);
                        int rowAffected = pstmt.executeUpdate();
                        if(rowAffected > 0)
                        {
                        	lblMessage.setText("Successfully Registered:)");
                       	 	lblMessage.setTextFill(Color.GREEN);
                       	 grid.add(lblMessage, 1, 8);

                        }
        			}
        			else if(flag==1) {
        				lblMessage.setText("Unavailable!!!");
        	           	 lblMessage.setTextFill(Color.RED);
        	           	 grid.add(lblMessage, 1, 8);	
        			}
                     
         			con.close();
                 }
                 catch(Exception e){
         			System.out.println(e);
         		}
            	 
             }
         });
    	
    	
        grid.add(t1, 0, 0);
        grid.add(l1, 0, 1);
        grid.add(l2, 0, 2);
        grid.add(tf1, 1, 1);
        grid.add(tf5, 1, 2);
        grid.add(l4, 0, 3);
        grid.add(tf3, 1, 4);
        grid.add(l5, 0, 4);
        grid.add(l6, 0, 5);
        grid.add(tf4, 1, 3);
        grid.add(c1, 1, 5, 2, 1);
        grid.setAlignment(Pos.CENTER);
        
        
       
        HBox hb1 = new HBox(10);
        hb1.getChildren().addAll(btn2,btn3);
        grid.add(hb1, 1, 6);
        grid.setVgap(20);
        
        VBox vb = new VBox();
        vb.getChildren().addAll(t1, grid);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(10);
        
        BorderPane bp = new BorderPane();
        bp.setCenter(vb);
        bp.setAlignment(vb, Pos.TOP_CENTER);
        
        Scene s1 = new Scene(bp,500,500);
        return s1;
        
    	}
}
