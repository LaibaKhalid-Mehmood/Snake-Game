package com.example.snakegame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SnakeGame extends Application {

    static final int CELL=25;
    static final long TICK=200_000_000L;

    @Override
    public void start(Stage gameStage) {
        Game game=new Game();
        // grid
        Rectangle[][] grid=new Rectangle[Game.ROWS][Game.COLS];
        GridPane gridPane=new GridPane();
        for (int r=0; r<Game.ROWS; r++)
            for (int c=0; c<Game.COLS; c++) {
                grid[r][c] = new Rectangle(CELL, CELL, Color.BLACK);
                gridPane.add(grid[r][c], c, r);
            }

        Label scoreLabel = new Label("Score: 0");
        scoreLabel.setStyle("-fx-text-fill: white; -fx-font-size: 14; -fx-font-family: monospace;");

        VBox root = new VBox(5, scoreLabel, gridPane);
        root.setStyle("-fx-background-color: black; -fx-padding: 10;");

        game.init();

        Scene scene = new Scene(root, CELL * Game.COLS + 20, CELL * Game.ROWS + 50);
        scene.setOnKeyPressed(e -> game.handleKey(e.getCode()));

        gameStage.setTitle("Snake Game");
        gameStage.setScene(scene);
        gameStage.setResizable(false);
        gameStage.show();

        //Game loop
        AnimationTimer[] timerHolder=new AnimationTimer[1];

        timerHolder[0]=new AnimationTimer() {
            long last=0;
            long overAt=-1;

            @Override
            public void handle(long now) {
                if(!game.isOver()) {
                    if (now-last>=TICK) {
                        game.update();
                        scoreLabel.setText("Score: "+game.getScore());
                        last=now;
                    }
                    IDrawable d=game;
                    for (int r=0; r<Game.ROWS; r++)
                        for (int c=0; c<Game.COLS; c++)
                            grid[r][c].setFill(Color.BLACK);
                    grid[d.getFoodRow()][d.getFoodCol()].setFill(Color.WHITE);
                    for (int[] s : d.getSnake()) grid[s[0]][s[1]].setFill(Color.RED);

                }else{
                    if(overAt==-1) overAt=now;

                    if (now - overAt>=2_000_000_000L) {
                        timerHolder[0].stop();
                        gameStage.hide();
                        GameOver.setScore(game.getScore());
                        GameOver.setGameStage(gameStage);
                        GameOver.show();
                    }
                }
            }
        };

        timerHolder[0].start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}