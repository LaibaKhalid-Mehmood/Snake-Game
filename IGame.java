package com.example.snakegame;
import javafx.scene.input.KeyCode;

public interface IGame {
    void init();
    void update();
    void handleKey(KeyCode key);
    int getScore();
    boolean isOver();
}