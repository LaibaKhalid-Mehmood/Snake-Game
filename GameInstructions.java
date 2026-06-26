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

import java.io.IOException.*;

public class GameInstructions extends Application {

    Button button;
    Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage InstructionsStage){

        InstructionsStage.setTitle("Game Instructions");

        Label label1=new Label("Instructions");
        label1.setFont(Font.font("Times New Roman",FontWeight.BOLD,45));

        Label label2=new Label("Controls:");
        label2.setFont(Font.font("Times New Roman",FontWeight.BOLD,25));

        Label label3=new Label("Arrow Keys to move the snake (Up, Down, Left, Right).");
        label3.setFont(Font.font("Times New Roman",22));

        Label label4=new Label("Rules:");
        label4.setFont(Font.font("Times New Roman",FontWeight.BOLD,25));

        Label label5=new Label("1) Eat the white food to grow and earn 10 points.");
        label5.setFont(Font.font("Times New Roman",22));

        Label label6=new Label("2) Do not hit the walls.");
        label6.setFont(Font.font("Times New Roman",22));

        Label label7=new Label("3) Do not touch your own body.");
        label7.setFont(Font.font("Times New Roman",22));

        Label label8=new Label("4) Game stops if you hit a wall or yourself.");
        label8.setFont(Font.font("Times New Roman",22));

        Label label9=new Label("Goal:");
        label9.setFont(Font.font("Times New Roman",FontWeight.BOLD,25));

        Label label10=new Label("Eat as much food as possible and get the highest score.");
        label10.setFont(Font.font("Times New Roman",22));

        button=new Button("Next");
        button.setFont(Font.font("Times New Roman",20));
        button.setStyle("-fx-text-fill:white;-fx-background-color:green");
        button.setOnAction(e-> {
            System.out.println("Next button is pressed.");
            Start s=new Start();
            s.start(InstructionsStage);
        });

        GridPane layout=new GridPane();
        layout.add(label1,1,1);
        layout.add(label2,1,2);
        layout.add(label3,1,3);
        layout.add(label4,1,4);
        layout.add(label5,1,5);
        layout.add(label6,1,6);
        layout.add(label7,1,7);
        layout.add(label8,1,8);
        layout.add(label9,1,9);
        layout.add(label10,1,10);
        layout.add(button,3,12);

        layout.setStyle("-fx-background-color:lightgray");
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(30,30,30,50));

        Scene scene=new Scene(layout,900,500);
        InstructionsStage.setScene(scene);
        InstructionsStage.show();





    }


}