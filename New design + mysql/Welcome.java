package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class Welcome extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    private Stage primaryStage;
    
    private void calladmin()
    {
    	Login_page ci = new Login_page();
        Scene scene = ci.getScene(primaryStage);

        // set new title
        primaryStage.setTitle("Login Page");

        // change the scene on the stage
        primaryStage.setScene(scene);
    }
    
    @Override
    public void start(Stage primaryStage){
    	
    	this.primaryStage = primaryStage;
    	primaryStage.setTitle("net page");
    	
        primaryStage.setTitle("Welcome!");
        Text t = new Text("Welcome");
        t.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
        //t.setFill(Color.GREY); // setting color of the text to blue
        t.setStroke(Color.GREEN); // setting the stroke for the text
        t.setStrokeWidth(1); // setting stroke width to 2
        
        Button b1 = new Button("LogIn");
        b1.setTextFill(Color.WHITE);
        b1.setStyle("-fx-background-color: #47AB11");
        
        VBox v= new VBox(10);
        v.getChildren().addAll(t,b1);
        v.setAlignment(Pos.CENTER);
        //tile.getChildren().add(v);
        
        StackPane s1 = new StackPane();
        s1.getChildren().add(v);
        
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
