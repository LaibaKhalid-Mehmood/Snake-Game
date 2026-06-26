package com.example.snakegame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.scene.text.Font;

import java.io.IOException.*;

public class ForgotPassword extends Application {

    Button button;
    Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage forgotstage) {

        forgotstage.setTitle("Forgot Password");


        Label label=new Label("Enter your new Password:");
        label.setFont(new Font("Times New Roman",20));
        label.setStyle("-fx-text-fill:white");

        PasswordField input=new PasswordField();
        input.setFont(new Font("Times New Roman",17));

        button=new Button("Back");
        button.setFont(new Font("Times New Roman",20));
        button.setStyle("-fx-text-fill:white; -fx-background-color:red");
        button.setOnAction(e-> {

            String newPassword=input.getText();

            if(!newPassword.isEmpty()){
                UserSession.registeredPassword=newPassword;
            }
            System.out.println("Back button is pressed.");
            LoginPage a=new LoginPage();
            a.start(forgotstage);
        });


        GridPane layout=new GridPane();
        layout.add(label,1,2);
        layout.add(input,2,2);
        layout.add(button,3,5);
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);

        layout.setStyle("-fx-background-color:black");


        scene=new Scene(layout,600,300);
        forgotstage.setScene(scene);
        forgotstage.show();

    }




















}