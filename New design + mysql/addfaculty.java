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

public class addfaculty {
	
	private Stage p;
	
	String user,pwd,role,mail,sql;
	
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
    	t1.setFill(Color.BLACK);
        t1.setStroke(Color.GREEN);
        t1.setStrokeWidth(1);
        t1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
    	
    	Label l1 = new Label("Username:");
    	Label l2 = new Label("Password:");
    	Label l3 = new Label("Email Id:");
    	Label l4 = new Label("Role:");
    	
    	TextField tf1 = new TextField();
    	TextField tf2 = new TextField();
    	TextField tf3 = new TextField();
    	
    	String rolename[]= {"admin","faculty"};
    	ComboBox<String> c1 = new ComboBox<String>(FXCollections.observableArrayList(rolename));
    	c1.setPromptText("Select");
    	
    	BorderPane bp = new BorderPane();
    	GridPane grid = new GridPane();
    	grid.add(t1, 0, 0);
    	grid.add(l1, 0, 1);
    	grid.add(l2, 0, 2);
    	grid.add(l3, 0, 3);
    	grid.add(l4, 0, 4);
    	grid.add(tf1, 1, 1);
    	grid.add(tf2, 1, 2);
    	grid.add(tf3, 1, 3);
    	grid.add(c1, 1, 4);
    	grid.setVgap(20);
    	grid.setHgap(20);
    	grid.setAlignment(Pos.CENTER);
    	
    	final Label lblMessage = new Label();
    	
    	Button btn1 = new Button("Back");
    	btn1.setTextFill(Color.WHITE);
        btn1.setStyle("-fx-background-color: GREY");
        
    	Button btn2 = new Button("Register");
    	btn2.setTextFill(Color.WHITE);
        btn2.setStyle("-fx-background-color: #47AB11");
        
        HBox hb1 = new HBox(10);
    	hb1.getChildren().addAll(btn1,btn2);
    	
    	btn1.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
            	goback();
            }
        });
    	
    	btn2.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
            	
            	try {
            		user=tf1.getText().toString();
            		pwd=tf2.getText().toString();
            		mail=tf3.getText().toString();
            		role=c1.getValue();
            		
            		sql = "INSERT INTO user_info(username, password, email, user_role) VALUES (?,?,?,?)";
       
            		
        			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/javafx-project","root","root");  
        			PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS); 
        			
                    pstmt.setString(1, user);
                    pstmt.setString(2, pwd);
                    pstmt.setString(3, mail);
                    pstmt.setString(4, role);
                    
                    int rowAffected = pstmt.executeUpdate();
                    if(rowAffected > 0)
                    {
                    	lblMessage.setText("SUCCESSFULLY SUBMITTED:)");
                   	 	lblMessage.setTextFill(Color.GREEN);

                    }
        			con.close();
                }
                catch(Exception e){
        			System.out.println(e);
        		}
            }
        });
    	
    	grid.add(hb1,1, 5);
    	grid.add(lblMessage, 1, 7);
    	
    	VBox vb = new VBox();
        vb.getChildren().addAll(t1, grid);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(10);
        
        bp.setCenter(vb);
        bp.setAlignment(vb, Pos.TOP_CENTER);
    	
    	Scene s1 = new Scene(bp,500,500);
	     
    	return s1;
    	
    }
}
