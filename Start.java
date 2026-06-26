package com.example.snakegame;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Label;
import javafx.geometry.Insets;


public class Start extends Application{

    Button button;
    Scene startscene;

    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage startstage){

        startstage.setTitle("Start Window");

        Label label1=new Label("Click here to start the game....");
        label1.setFont(Font.font("Times New Roman",FontWeight.BOLD,30));


        button=new Button("START");
        button.setFont(Font.font("Times New Roman",FontWeight.BOLD,22));
        button.setStyle("-fx-text-fill:white;-fx-background-color:green");

        button.setOnAction(e->{
            System.out.println("Start button is pressed.");
            WelcomePage wp=new WelcomePage();
            wp.start(startstage);

        });

        GridPane layout=new GridPane();
        layout.add(label1,2,3);
        layout.add(button,6,6);
        layout.setStyle("-fx-background-color:lightyellow");
       // layout.setAlignment(Pos.CENTER);
        layout.setVgap(15);


        layout.setPadding(new Insets(10,50,50,100));


        startscene=new Scene(layout,700,300);
        startstage.setScene(startscene);
        startstage.show();


    }
}
