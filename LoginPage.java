package com.example.snakegame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException.*;
public class LoginPage extends Application {

    Scene scene,scene2;

    public static void main(String[]args){
        launch(args);
    }

    public void start(Stage loginstage){

        loginstage.setTitle("Login Page");
        loginstage.setResizable(true);

        Label label1=new Label("Username:");
        label1.setFont(Font.font("Times New Roman",20));
        TextField input1=new TextField();
        input1.setFont(Font.font("Times New Roman",17));

        Label label2=new Label("Password:");
        label2.setFont(new Font("Times New Roman",20));
        PasswordField input2=new PasswordField();
        input2.setFont(new Font("Times New Roman",17));

        Label label3=new Label("Login Status:");
        label3.setFont(Font.font("Times New Roman",FontWeight.BOLD,25));

        Label label4=new Label("Welcome to the Login Page");
        label4.setFont(Font.font("Times New Roman",FontWeight.BOLD,22));

        Label label5=new Label("Thanks for logging in!");
        label5.setFont(Font.font("Times New Roman",25));
        label5.setStyle("-fx-text-fill:green");

        Label label8=new Label(" ");
        label8.setFont(Font.font("Times New Roman",19));
        label8.setStyle("-fx-text-fill:red");

        Label label9=new Label(" ");
        label9.setFont(Font.font("Times New Roman",19));
        label9.setStyle("-fx-text-fill:red");

        Label label10=new Label(" ");
        label10.setFont(Font.font("Times New Roman",19));
        label10.setStyle("-fx-text-fill:red");

        Label label11=new Label(" ");
        label11.setFont(Font.font("Times New Roman",19));
        label11.setStyle("-fx-text-fill:red");

        Button button3=new Button("Forgot Password?");
        button3.setFont(Font.font("Times New Roman",15));
        button3.setStyle("-fx-text-fill:white;-fx-background-color:red");

        button3.setOnAction(e-> {
            ForgotPassword f=new ForgotPassword();
            f.start(loginstage);

        });

        Button button=new Button("Log In");
        button.setFont(new Font("Times New Roman",35));
        button.setStyle("-fx-text-fill:white; -fx-background-color:green");
        button.setOnAction(e->{
            System.out.println("Login button is pressed");

            String username=input1.getText();
            String password=input2.getText();

            String s1="Login Successful";

            if(username.equals(UserSession.registeredUsername) && password.equals(UserSession.registeredPassword)){
                label3.setText("Login Status: " +s1);
                label5.setText(" ");
                loginstage.setScene(scene2);
            }
            else{
                label11.setText("Couldn't find account with this username and password.");
            }

        });


        Button button2=new Button("Next");
        button2.setFont(Font.font("Times New Roman",18));
        button2.setStyle("-fx-text-fill:white; -fx-background-color:black");
        button2.setOnAction(e->{
            System.out.println("Next button is pressed");
            GameName g=new GameName();
            g.start(loginstage);
            //System.exit(0);
        });

        Image image=new Image("file:C:\\Users\\Adnan\\Desktop\\login.jpeg");
        ImageView imageView=new ImageView(image);
        imageView.setFitWidth(80);
        imageView.setFitHeight(50);
        imageView.setPreserveRatio(true);

        GridPane layout=new GridPane();
        layout.add(label1,1,3);
        layout.add(input1,2,3);
        layout.add(label2,1,4);
        layout.add(input2,2,4);
        layout.add(label4,1,1);
        layout.add(button,2,9);
        layout.add(imageView,0,0);
        layout.add(label11,3,2);
        layout.add(label8,2,8);
        layout.add(label9,2,10);
        layout.add(label10,1,7);
        layout.add(button3,3,4);
        layout.setPadding(new Insets(50,30,30,10)); // Can pass 1 or 4 parameters
        layout.setAlignment(Pos.BASELINE_LEFT); // Can be RIGHT
        layout.setHgap(15);
        layout.setVgap(20);
        layout.setStyle("-fx-background-color:lightblue");

        GridPane layout2=new GridPane();
        layout2.add(label5,2,3);
        layout2.add(button2,5,5);
        layout2.add(label3,2,1);
        layout2.setHgap(10);
        layout2.setVgap(10);
        layout2.setPadding(new Insets(10,30,30,50));
        layout2.setStyle("-fx-background-color:lightblue");
        layout2.setAlignment(Pos.CENTER);

        scene=new Scene(layout,1100,600);
        scene2=new Scene(layout2,600,350);
        loginstage.setScene(scene);
        loginstage.show();

    }




}


