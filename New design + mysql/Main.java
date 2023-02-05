package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application {
    Stage stage;
    @Override
    public void start(Stage primarystage) throws IOException {
        stage = primarystage;
        Scene scene = LoginScene();
        stage.setTitle("Hello!");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
        System.out.printf(stage.widthProperty()+" "+stage.heightProperty());

    }
    Scene LoginScene(){
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();

        //label
        Label ln1 = new Label("WELCOME TO CSD BANK");
        ln1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        Label lna = new Label("UserName:");
        lna.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Label lpass = new Label("Password:");
        lpass.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        //Label llas = new Label("Login As:");
        //llas.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Label lpass2 = new Label("Password:");
        lpass2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Label Lo = new Label("Login");
        Lo.setTextFill(Color.WHITE);
        Lo.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));

        Button b1 = new Button("Login");
        b1.setAlignment(Pos.CENTER);
        b1.setMinSize(200,50);
        b1.setTextFill(Color.WHITE);
        b1.setStyle("-fx-background-color: #47AB11");

        Text t1 = new Text("No account- click here to register");
        t1.setStyle("-fx-text-fill: white");

        //textfields
        TextField tna = new TextField();
        tna.setFont(Font.font("verdana", FontPosture.REGULAR, 20));
        tna.setPromptText("Name");

        //passwordfield
        PasswordField pf = new PasswordField();
        pf.setPromptText("Password");
        pf.setFont(Font.font("verdana", FontPosture.REGULAR, 20));

        //ComboBox cb = new ComboBox();
        //cb.getItems().addAll("Admin","student");
        //cb.setStyle("-fx-font-size: 20");
        //cb.setMinWidth(260);
        PasswordField cb = new PasswordField();
        cb.setPromptText("Password");
        cb.setFont(Font.font("verdana", FontPosture.REGULAR, 20));

        VBox vb = new VBox();
        vb.getChildren().addAll(Lo, gp,b1,t1);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20);

        gp.setHgap(20);
        gp.setVgap(20);
        gp.addRow(0,ln1);
        gp.addRow(3,lna, tna);
        //gp.addRow(3,lpass2,cb);
        gp.addRow(4,lpass, pf);
        gp.setAlignment(Pos.TOP_CENTER);

        bp.setCenter(vb);
        BorderPane.setAlignment(vb, Pos.TOP_CENTER);
        Image image = null;
        try {
            FileInputStream file = new FileInputStream("C://Users//HOME//Downloads//atmbg.webp");
            image = new Image(file);
        }catch (Exception e){
           
        }
        Background background = new Background(new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT));
        bp.setBackground(background);


        b1.setOnMouseClicked(e->switchScenes(homeScene()));
        t1.setOnMouseClicked(e->switchScenes(registerScene()));
        Scene scene = new Scene(bp, 960, 540);
        return scene;
       
        //t1.setOnMouseClicked(e->switchScenes(registerScene()));
        //Scene scene1 = new Scene(bp, 960, 540);
        //return scene1;
    }

    Scene registerScene(){
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();

        Label lna = new Label("UserName:");
        lna.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Label lpass = new Label("Password:");
        lpass.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Label lemail = new Label("Email:");
        lemail.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Label llas = new Label("Conform Password:");
        llas.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Label Lo = new Label("Register");
        Lo.setTextFill(Color.WHITE);
        Lo.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
       
        Label lna1 = new Label("Account No:");
        lna1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));


        Button b1 = new Button("Sign In");
        b1.setAlignment(Pos.CENTER);
        b1.setMinSize(200,50);
        b1.setTextFill(Color.WHITE);
        b1.setStyle("-fx-background-color: #47AB11");

        Text t1 = new Text("Already Registered - click to Login");
        t1.setStyle("-fx-text-fill: white");

        //textfields
        TextField tna = new TextField();
        tna.setFont(Font.font("verdana", FontPosture.REGULAR, 20));
        tna.setPromptText("Name");
       
        TextField tna1 = new TextField();
        tna1.setFont(Font.font("verdana", FontPosture.REGULAR, 20));
        tna1.setPromptText("XXXX XXXX XXXX XXXX");
       
        TextField tn2 = new TextField();
        tn2.setFont(Font.font("verdana", FontPosture.REGULAR, 20));
        tn2.setPromptText("example@gmail.com");

        //passwordfield
        PasswordField pf = new PasswordField();
        pf.setPromptText("re-Enter Password");
        pf.setFont(Font.font("verdana", FontPosture.REGULAR, 20));

        PasswordField cb = new PasswordField();
        cb.setPromptText("Password");
        cb.setFont(Font.font("verdana", FontPosture.REGULAR, 20));

        VBox vb = new VBox();
        vb.getChildren().addAll(Lo, gp,b1,t1);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20);

        gp.setHgap(20);
        gp.setVgap(20);
        gp.addRow(0,lna1,tna1);
        gp.addRow(1,lna, tna);
        gp.addRow(2,lemail,tn2);
        gp.addRow(3,lpass,cb );
        gp.addRow(4,llas, pf);
        gp.setAlignment(Pos.TOP_CENTER);

        bp.setCenter(vb);
        bp.setAlignment(vb, Pos.TOP_CENTER);
        Image image = null;
        try {
            FileInputStream file = new FileInputStream("C://Users//HOME//Downloads//atmbg.webp");
            image = new Image(file);
        }catch (Exception e){

        }
        Background background = new Background(new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT));
        bp.setBackground(background);
        //Scene scene1 = new Scene(bp, 1550.4000244140625, 830.4000244140625);
        //return scene1;
        t1.setOnMouseClicked(e->switchScenes(LoginScene()));
        b1.setOnMouseClicked(e->switchScenes(homeScene()));
        Scene scene = new Scene(bp, 960, 540);
        return scene;
    }
    public void switchScenes1(Scene scene1){
        stage.setMaximized(true);
        stage.setScene(scene1);
    }
    Scene homeScene(){
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();

        //label
        Label lna = new Label("Cash Withdraw ->");
        lna.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Label lpass = new Label("Cash Deposit    ->");
        lpass.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Label lemail = new Label("Check balance  ->");
        lemail.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        //Label ll = new Label(" ");
        //ll.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Label L1 = new Label("HOME");
        //Lo.setTextFill(Color.WHITE);
        L1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));

        Button b1 = new Button("WITHDRAW");
        Button b2 = new Button("DEPOSIT");
        Button b3 = new Button("CHECK BALANCE");
        Button b5 = new Button("LOGOUT");
        Button b4 = new Button("Exit");
        //b1.setAlignment(Pos.CENTER);
        b1.setMinSize(200,50);
        b1.setTextFill(Color.WHITE);
        b1.setStyle("-fx-background-color: #00008B");
       
        b2.setMinSize(200,50);
        b2.setTextFill(Color.WHITE);
        b2.setStyle("-fx-background-color: #00008B");
       
        b3.setMinSize(200,50);
        b3.setTextFill(Color.WHITE);
        b3.setStyle("-fx-background-color: #00008B");
       
        b4.setMinSize(200,50);
        b4.setTextFill(Color.WHITE);
        b4.setStyle("-fx-background-color: #FFA500");
       
        b5.setMinSize(200,50);
        b5.setTextFill(Color.WHITE);
        b5.setStyle("-fx-background-color: #FFA500");


        VBox vb = new VBox();
        vb.getChildren().addAll( gp,b1);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20);

        gp.setHgap(20);
        gp.setVgap(20);
        gp.addRow(0,L1);
        gp.addRow(2,lna, b1);
        gp.addRow(3,lpass,b2);
        gp.addRow(4,lemail,b3);
        gp.addRow(5,b5,b4);
        gp.setAlignment(Pos.TOP_CENTER);

        bp.setCenter(vb);
        bp.setAlignment(vb, Pos.TOP_CENTER);
        Image image = null;
        try {
            FileInputStream file = new FileInputStream("C://Users//HOME//Downloads//atmbg.webp");
            image = new Image(file);
        }catch (Exception e){

        }
        Background background = new Background(new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT));
        bp.setBackground(background);
        //Scene scene1 = new Scene(bp, 1550.4000244140625, 830.4000244140625);
        //return scene;
        b2.setOnMouseClicked(e->switchScenes(depositScene()));
        b1.setOnMouseClicked(e->switchScenes(withdrawScene()));
        b5.setOnMouseClicked(e->switchScenes(LoginScene()));
        b4.setOnMouseClicked(e->switchScenes(exitScene()));
        Scene scene = new Scene(bp, 960, 540);
        return scene;
    }
    public void switchScenes(Scene scene){
        stage.setMaximized(true);
        stage.setScene(scene);
    }
    Scene withdrawScene(){
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();

        //label
        Label lna = new Label("ENTER THE AMOUNT ");
        lna.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
       
        TextField tna = new TextField();
        tna.setFont(Font.font("verdana", FontPosture.REGULAR, 20));
        tna.setPromptText("AMOUNT");

        //Label lpass = new Label("Cash Deposit    ->");
        //lpass.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        //Label lemail = new Label("Check balance  ->");
        //lemail.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        //Label ll = new Label(" ");
        //ll.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Label L1 = new Label("CASH WITHDRAWAL");
        //Lo.setTextFill(Color.WHITE);
        L1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));

        Button b1 = new Button("CONFORM");
        Button b2 = new Button("HOME");
        Button b3 = new Button("EXIT");
        //Button b4 = new Button("Exit");
        //b1.setAlignment(Pos.CENTER);
        b1.setMinSize(200,50);
        b1.setTextFill(Color.WHITE);
        b1.setStyle("-fx-background-color: #00008B");
       
        b2.setMinSize(200,50);
        b2.setTextFill(Color.WHITE);
        b2.setStyle("-fx-background-color: #00008B");
       
        b3.setMinSize(200,50);
        b3.setTextFill(Color.WHITE);
        b3.setStyle("-fx-background-color: #FFA500");
       
        //b4.setMinSize(200,50);
        //b4.setTextFill(Color.WHITE);
       // b4.setStyle("-fx-background-color: #FFA500");


        VBox vb = new VBox();
        vb.getChildren().addAll( gp,b1);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20);

        gp.setHgap(20);
        gp.setVgap(20);
        gp.addRow(0,L1);
        gp.addRow(2,lna,tna);
        gp.addRow(3,b1);
        gp.addRow(4,b2);
        gp.addRow(5,b3);
        gp.setAlignment(Pos.TOP_CENTER);

        bp.setCenter(vb);
        bp.setAlignment(vb, Pos.TOP_CENTER);
        Image image = null;
        try {
            FileInputStream file = new FileInputStream("C://Users//HOME//Downloads//atmbg.webp");
            image = new Image(file);
        }catch (Exception e){

        }
        Background background = new Background(new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT));
        bp.setBackground(background);
        b2.setOnMouseClicked(e->switchScenes(homeScene()));
        b3.setOnMouseClicked(e->switchScenes(exitScene()));
        Scene scene = new Scene(bp, 960, 540);
        return scene;
        //Scene scene = new Scene(bp, 1550.4000244140625, 830.4000244140625);
        //return scene;
    }
    //public void switchScenes(Scene scene){
        //stage.setMaximized(true);
        //stage.setScene(scene);
    //}
    Scene depositScene(){
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();

        //label
        Label lna = new Label("ENTER THE AMOUNT ");
        lna.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
       
        TextField tna = new TextField();
        tna.setFont(Font.font("verdana", FontPosture.REGULAR, 20));
        tna.setPromptText("AMOUNT");

        //Label lpass = new Label("Cash Deposit    ->");
        //lpass.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        //Label lemail = new Label("Check balance  ->");
        //lemail.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        //Label ll = new Label(" ");
        //ll.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        Label L1 = new Label("CASH DEPOSIT");
        //Lo.setTextFill(Color.WHITE);
        L1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));

        Button b1 = new Button("CONFORM");
        Button b2 = new Button("HOME");
        Button b3 = new Button("EXIT");
        //Button b4 = new Button("Exit");
        //b1.setAlignment(Pos.CENTER);
        b1.setMinSize(200,50);
        b1.setTextFill(Color.WHITE);
        b1.setStyle("-fx-background-color: #00008B");
       
        b2.setMinSize(200,50);
        b2.setTextFill(Color.WHITE);
        b2.setStyle("-fx-background-color: #00008B");
       
        b3.setMinSize(200,50);
        b3.setTextFill(Color.WHITE);
        b3.setStyle("-fx-background-color: #FFA500");
       
        //b4.setMinSize(200,50);
        //b4.setTextFill(Color.WHITE);
       // b4.setStyle("-fx-background-color: #FFA500");


        VBox vb = new VBox();
        vb.getChildren().addAll( gp,b1);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20);

        gp.setHgap(20);
        gp.setVgap(20);
        gp.addRow(0,L1);
        gp.addRow(2,lna,tna);
        gp.addRow(3,b1);
        gp.addRow(4,b2);
        gp.addRow(5,b3);
        gp.setAlignment(Pos.TOP_CENTER);

        bp.setCenter(vb);
        bp.setAlignment(vb, Pos.TOP_CENTER);
        Image image = null;
        try {
            FileInputStream file = new FileInputStream("C://Users//HOME//Downloads//atmbg.webp");
            image = new Image(file);
        }catch (Exception e){

        }
        Background background = new Background(new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT));
        bp.setBackground(background);
        b2.setOnMouseClicked(e->switchScenes(homeScene()));
        b3.setOnMouseClicked(e->switchScenes(exitScene()));
        Scene scene = new Scene(bp, 960, 540);
        return scene;
        //Scene scene = new Scene(bp, 1550.4000244140625, 830.4000244140625);
        //return scene;
    }
   
   
    Scene exitScene(){
        BorderPane bp = new BorderPane();
        GridPane gp = new GridPane();

        Label L1 = new Label("THANK YOU");
        //Lo.setTextFill(Color.WHITE);
        L1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));


        VBox vb = new VBox();
        vb.getChildren().addAll( gp);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20);

        gp.setHgap(20);
        gp.setVgap(20);
        gp.addRow(0,L1);
        gp.setAlignment(Pos.TOP_CENTER);

        bp.setCenter(vb);
        bp.setAlignment(vb, Pos.TOP_CENTER);
        Image image = null;
        try {
            FileInputStream file = new FileInputStream("C://Users//HOME//Downloads//atmbg.webp");
            image = new Image(file);
        }catch (Exception e){

        }
        Background background = new Background(new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT));
        Scene scene = new Scene(bp, 960, 540);
        return scene;
        //Scene scene = new Scene(bp, 1550.4000244140625, 830.4000244140625);
        //return scene;
    }




    public static void main(String[] args) {
        launch();
    }
}