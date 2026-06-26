package com.example.snakegame;
import java.util.List;

public interface IDrawable {
    List<int[]> getSnake();
    int getFoodRow();
    int getFoodCol();
}