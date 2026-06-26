
package com.example.snakegame;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.util.Duration;

public class WelcomePage  extends Application{

    Scene welcomescene;

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage welcomestage){
        welcomestage.setTitle("Welcome Page");

        Label label1=new Label("Welcome to the Snake Game!");
        label1.setFont(Font.font("Times New Roman",FontWeight.BOLD,35));
        label1.setStyle("-fx-text-fill:white");

        GridPane layout=new GridPane();

        layout.add(label1,5,4);
        layout.setStyle("-fx-background-color:grey");

        layout.setPadding(new Insets(150,100,100,100));

        PauseTransition pause=new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e-> {
            welcomestage.close();
            SnakeGame g=new SnakeGame();
            g.start(welcomestage);

        });

        pause.play();
        welcomescene=new Scene(layout,700,400);
        welcomestage.setScene(welcomescene);
        welcomestage.show();




    }

}
