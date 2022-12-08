package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class Welcome extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    private Stage primaryStage;
    
    private void changeScenes()
    {
    	Faculty_Login ci = new Faculty_Login();
        Scene scene = ci.getScene(primaryStage);

        // set new title
        primaryStage.setTitle("Faculty Login Page");

        // change the scene on the stage
        primaryStage.setScene(scene);
    }
    
    private void calladmin()
    {
    	Admin_Login ci = new Admin_Login();
        Scene scene = ci.getScene(primaryStage);

        // set new title
        primaryStage.setTitle("Admin Login Page");

        // change the scene on the stage
        primaryStage.setScene(scene);
    }
    
    @Override
    public void start(Stage primaryStage){
    	
    	this.primaryStage = primaryStage;
    	primaryStage.setTitle("net page");
    	
        primaryStage.setTitle("Welcome!");
        Text t = new Text("Welcome");
        t.setFont(Font.font("verdana", FontWeight.BOLD, 20));

        Button b1 = new Button("Admin");
        Button b2 = new Button("Faculty");
        
        VBox v= new VBox(10);
        v.getChildren().addAll(t,b1,b2);
        v.setAlignment(Pos.CENTER);
        //tile.getChildren().add(v);
        
        StackPane s1 = new StackPane();
        s1.getChildren().add(v);
        
        b2.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
                	changeScenes();
            }
        });
        
        b1.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
                	calladmin();
            }
        });
        
        Scene scene = new Scene(s1,500,500);
        primaryStage.setScene(scene);  
        primaryStage.show();
    }
    
    
}
