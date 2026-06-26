
package com.example.snakegame;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.util.Duration;
import java.io.IOException.*;


public class GameName extends Application{

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage gameNameStage){

        gameNameStage.setTitle("Game Name");

        Label label1=new Label("Snake Game");
        label1.setFont(Font.font("Times New Roman",FontWeight.BOLD,FontPosture.ITALIC,50));

        PauseTransition pause=new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e-> {
            gameNameStage.close();
            PlayerDetails p=new PlayerDetails();
            p.start(gameNameStage);
        });
        pause.play();

        GridPane layout=new GridPane();
        layout.add(label1,3,1);
        layout.setStyle("-fx-background-color:lightpink");
        layout.setAlignment(Pos.CENTER);

        Scene scene=new Scene(layout,700,350);
        gameNameStage.setScene(scene);
        gameNameStage.show();
    }
}
