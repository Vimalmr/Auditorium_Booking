package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.FontWeight;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 
public class Login{
	String u = "1", pw = "1", checku,checkp;
	
    private Stage p;
    
    public void changeScenes()
    {
    	Faculty_selection_page ci = new Faculty_selection_page();
        Scene scene = ci.getScene();

        // set new title
        p.setTitle("Customer Information");

        // change the scene on the stage
        p.setScene(scene);
    }
    
    public Scene getScene(Stage p) {
    	
    	this.p = p;
    	p.setTitle("Flowerstyle Net");
    	
        Button btn1 = new Button("Sign In");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn1);
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(hbBtn, 1, 3);
        
        Label user = new Label("Username:");
        Label pswd = new Label("Password:");
        grid.add(user, 0, 1);
        grid.add(pswd, 0, 2);
        
        Text head = new Text("Welcome To The Login Page");
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
                if(checku.equals(u) && checkp.equals(pw)) {
                	lblMessage.setText("Congratulations!");
                	lblMessage.setTextFill(Color.GREEN);
                	changeScenes();
                }
                else {
                	lblMessage.setText("Incorrect Credentials");
                	lblMessage.setTextFill(Color.RED);
                }
                pwd.setText("");
            }
        });
        
        Scene s1 = new Scene(grid, 400, 350);
        
        return s1;
        
    }
    
}
