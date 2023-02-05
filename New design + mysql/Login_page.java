package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 
public class Login_page{
	
	String checku,checkp;
	boolean flag = false;
	
    private Stage p;
    
    public void AchangeScenes()
    {
    	Admin_selection_page ci = new Admin_selection_page();
        Scene scene = ci.getScene(p);

        // set new title
        p.setTitle("Selection Page");

        // change the scene on the stage
        p.setScene(scene);
    }
    
    public void FchangeScenes()
    {
    	Faculty_selection_page ci = new Faculty_selection_page();
        Scene scene = ci.getScene(p);

        // set new title
        p.setTitle("Selection Page");

        // change the scene on the stage
        p.setScene(scene);
    }
    
    public Scene getScene(Stage p) {
    	
    	this.p = p;
    	p.setTitle("Select Page");
    	
        Button btn1 = new Button("Sign In");
        btn1.setTextFill(Color.WHITE);
        btn1.setStyle("-fx-background-color: #47AB11");
        
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn1);
        
        Label user = new Label("Username:");
        Label pswd = new Label("Password:");
        
        Text head = new Text("Login");
        head.setFill(Color.BLACK);
        head.setStroke(Color.GREEN);
        head.setStrokeWidth(1);
        head.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
        
        TextField usertxt = new TextField();
        usertxt.setPromptText("Username");
        usertxt.setFont(Font.font("verdana", FontPosture.REGULAR, 13));
        
        PasswordField pwd = new PasswordField();
        pwd.setPromptText("Password");
        pwd.setFont(Font.font("verdana", FontPosture.REGULAR, 13));
        
        final Label lblMessage = new Label();
        
        GridPane grid = new GridPane();
        BorderPane bp = new BorderPane();
        
        VBox v = new VBox(10);
        v.getChildren().addAll(head,grid);
        v.setAlignment(Pos.CENTER);
        
        grid.setHgap(10);
        grid.setVgap(10);
        grid.addRow(1,user,usertxt);
        grid.addRow(2,pswd,pwd);
        grid.add(hbBtn,1,3);
        grid.addRow(5,lblMessage);
        grid.setAlignment(Pos.CENTER);
        
        bp.setCenter(v);
        bp.setAlignment(v, Pos.TOP_CENTER);
        
        btn1.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
                checku = usertxt.getText().toString();
                checkp = pwd.getText().toString();
                try {
        			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/javafx-project","root","root");  
        			Statement stmt=con.createStatement();  
        			ResultSet rs=stmt.executeQuery("select * from user_info");  
        			while(rs.next()) {
        				if(rs.getString(2).equals(checku)) {
        					if(rs.getString(3).equals(checkp)) {
        						flag = true;
        						break;
        					}
        				}
        			}

        			if(flag) {
        				if(rs.getString(5).equals("admin"))
        					AchangeScenes();
        				else
        					FchangeScenes();
        			}
        			else {
        				lblMessage.setText("Incorrect Credentials, Try Again");
        				lblMessage.setTextFill(Color.RED);
        			}
        			con.close(); 
        			pwd.setText("");
                }
                catch(Exception e){
        			System.out.println(e);
        		}
            }
        });
        
        Scene s1 = new Scene(bp, 500,500);
        
        return s1;
        
    }
    
}
