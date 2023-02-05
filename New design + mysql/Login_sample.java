package application;

import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.FontWeight;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 
public class Login_sample extends Application{
	String checku,checkp;
	boolean flag = false;
	public static void main(String[] args) {
	    launch(args);
	}

	@Override
	public void start(Stage p) throws Exception {
		// TODO Auto-generated method stub
		p.setTitle("Select Page");
		
        Button btn1 = new Button("Sign In");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn1);
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(hbBtn, 1, 3);
        
        Label user = new Label("Username:");
        Label pswd = new Label("Password:");
        grid.add(user, 0, 1);
        grid.add(pswd, 0, 2);
        
        Text head = new Text("Welcome To The Admin Login Page");
        head.setFont(Font.font("verdana", FontWeight.BOLD, 20));
        TextField usertxt = new TextField();
        PasswordField pwd = new PasswordField();
        final Label lblMessage = new Label();
        grid.add(head,0,0,2,1);
        grid.add(usertxt, 1, 1);
        grid.add(pwd, 1, 2);
        grid.add(lblMessage, 1, 4);
        
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
        					}
        				}
        			}
        			con.close();  
        		}
        		catch(Exception e){
        			System.out.println(e);
        		}
                if(flag) {
                	lblMessage.setText("Congratulations!");
                	lblMessage.setTextFill(Color.GREEN);
                }
                else {
                	lblMessage.setText("Incorrect Credentials");
                	lblMessage.setTextFill(Color.RED);
                }
                pwd.setText("");
            }
        });
        
        Scene s1 = new Scene(grid, 500,500);
        p.setScene(s1);
        p.show();
		
	}
    
}
