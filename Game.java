package com.example.snakegame;

import javafx.scene.input.KeyCode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game implements IGame, IDrawable{

    static final int ROWS=25, COLS=25;

    private final List<int[]> snake=new ArrayList<>();
    private final Random rand=new Random();
    private int foodRow, foodCol, dir, newDir, score;
    private boolean over;

    @Override
    public void init(){
        snake.clear();
        snake.add(new int[]{12, 14});
        snake.add(new int[]{12, 13});
        snake.add(new int[]{12, 12});
        dir=0; newDir=0; score=0; over=false;
        spawnFood();
    }

    @Override
    public void update(){
        if (over) return;
        dir=newDir;

        int r=snake.get(0)[0];
        int c=snake.get(0)[1];

        if(dir==0) c++;
        if(dir==1) r++;
        if(dir==2) c--;
        if(dir==3) r--;

        if(r<0 || r>=ROWS || c<0 || c>=COLS){
            over=true;
            return;
        }

        for(int i=0; i<snake.size() - 1; i++)
            if(snake.get(i)[0] == r && snake.get(i)[1] == c){
                over=true;
                return;
            }

        snake.add(0, new int[]{r, c});
        if(r==foodRow && c==foodCol){
            score+=10;
            spawnFood();
        } else{
            snake.remove(snake.size()-1);
        }
    }

    @Override
    public void handleKey(KeyCode k) {
        if (k==KeyCode.RIGHT && dir!=2) newDir=0;
        if (k==KeyCode.DOWN && dir!=3) newDir=1;
        if (k==KeyCode.LEFT && dir!=0) newDir=2;
        if (k==KeyCode.UP && dir!=1) newDir=3;
    }

    @Override public int getScore(){return score;}
    @Override public boolean isOver(){return over;}
    @Override public List<int[]> getSnake(){return snake;}
    @Override public int getFoodRow(){return foodRow;}
    @Override public int getFoodCol(){return foodCol;}

    private void spawnFood(){
        do{
            foodRow=rand.nextInt(ROWS);
            foodCol=rand.nextInt(COLS);
        }while(onSnake(foodRow, foodCol));
    }

    private boolean onSnake(int r, int c) {
        for(int[] s : snake)
            if(s[0]==r && s[1]==c) return true;
        return false;
    }
}