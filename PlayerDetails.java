
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
import javafx.scene.control.TextField;

import java.io.IOException.*;

public class PlayerDetails extends Application {

     Button button;
     Scene scene;

     public static void main(String[] args){
         launch(args);
     }

     public void start(Stage playerStage){

         playerStage.setTitle("Player Details");


         Label label1=new Label("Player Details");
         label1.setFont(Font.font("Times New Roman",FontWeight.BOLD,35));


         Label label2=new Label("Enter your name:");
         label2.setFont(Font.font("Times New Roman",22));

         TextField input1=new TextField();
         input1.setFont(Font.font("Times New Roman",18));


         Label label3=new Label("Enter your age:");
         label3.setFont(Font.font("Times New Roman",22));

         TextField input2=new TextField();
         input2.setFont(Font.font("Times New Roman",18));


         Label label4=new Label("Enter your ID (like PI26-101):");
         label4.setFont(Font.font("Times New Roman",22));


         TextField input3=new TextField();
         input3.setFont(Font.font("Times New Roman",18));

         button=new Button("Next");
         button.setFont(Font.font("Times New Roman",18));
         button.setStyle("-fx-text-fill:white;-fx-background-color:green");
         button.setOnAction(e-> {
             System.out.println("Next button is pressed.");
             GameInstructions s=new GameInstructions();
             s.start(playerStage);
         });

         GridPane layout=new GridPane();
         layout.add(label1,1,1);
         layout.add(label2,1,3);
         layout.add(input1,2,3);
         layout.add(label3,1,5);
         layout.add(input2,2,5);
         layout.add(label4,1,7);
         layout.add(input3,2,7);
         layout.add(button,3,9);
         layout.setPadding(new Insets(20,20,20,50));
         layout.setStyle("-fx-background-color:lavender");
         layout.setHgap(10);
         layout.setVgap(20);

         Scene scene=new Scene(layout,700,500);
         playerStage.setScene(scene);
         playerStage.show();








     }


}
