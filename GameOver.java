package com.example.snakegame;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GameOver {

    private static int finalScore=0;
    private static Stage gameStageRef;

    public static void setScore(int score)    { finalScore=score; }
    public static void setGameStage(Stage s)  { gameStageRef= s;   }


    public static void show(){
        Stage finalStage = new Stage();
        finalStage.setTitle("Snake Game");

        Label gameOverLabel = new Label("Game Over!");
        gameOverLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 48));
        gameOverLabel.setStyle("-fx-text-fill: red;");

        Label thanksLabel = new Label("Thanks for Playing!");
        thanksLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 28));
        thanksLabel.setStyle("-fx-text-fill: green;");

        Label scoreLabel = new Label("Your Score: " + finalScore);
        scoreLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));
        scoreLabel.setStyle("-fx-text-fill: black;");

        Button resumeBtn = new Button("Resume");
        resumeBtn.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));
        resumeBtn.setStyle("-fx-background-color: green; -fx-text-fill: white;");

        resumeBtn.setOnAction(e -> {
            finalStage.close();
            if (gameStageRef != null) {
                SnakeGame newGame = new SnakeGame();
                try { newGame.start(gameStageRef); }
                catch (Exception ex) { ex.printStackTrace(); }
            }
        });

        Button logoutButton=new Button("Log out");
        resumeBtn.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));

        logoutButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        logoutButton.setOnAction(e-> {
            CreateAccount c=new CreateAccount();
            c.start(gameStageRef);
        });

        VBox layout = new VBox(20, gameOverLabel, thanksLabel, scoreLabel, resumeBtn,logoutButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(40));
        layout.setStyle("-fx-background-color: lightblue;");


        finalStage.setScene(new Scene(layout, 700, 380));
        finalStage.setResizable(false);
        finalStage.show();
    }
}