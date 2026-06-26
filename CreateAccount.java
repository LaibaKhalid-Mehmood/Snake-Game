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
import javafx.animation.PauseTransition;
import javafx.util.Duration;

import java.io.IOException.*;
public class CreateAccount extends Application {

    Button button;
    Scene scene;

    public static void main(String[]args){
        launch(args);
    }

    public void start(Stage accountstage){

        accountstage.setTitle("Create Account");
        accountstage.setResizable(true);

        Label label1=new Label("Username:");
        label1.setFont(Font.font("Times New Roman",20));
        TextField input1=new TextField();
        input1.setFont(Font.font("Times New Roman",17));

        Label label2=new Label("Password:");
        label2.setFont(new Font("Times New Roman",20));
        PasswordField input2=new PasswordField();
        input2.setFont(new Font("Times New Roman",17));

        Label label3=new Label("Create an Account");
        label3.setFont(Font.font("Times New Roman",FontWeight.BOLD,25));

        Label label4=new Label("1) Select gender:");
        label4.setFont(Font.font("Times New Roman",FontWeight.BOLD,19));

        Label label5=new Label("2) Select your DOB:");
        label5.setFont(Font.font("Times New Roman",FontWeight.BOLD,19));

        Label label6=new Label(" ");
        label6.setFont(Font.font("Times New Roman",19));
        label6.setStyle("-fx-text-fill:red");

        Label label7=new Label(" ");
        label7.setFont(Font.font("Times New Roman",19));
        label7.setStyle("-fx-text-fill:red");

        Label label8=new Label(" ");
        label8.setFont(Font.font("Times New Roman",19));
        label8.setStyle("-fx-text-fill:red");

        Label label9=new Label(" ");
        label9.setFont(Font.font("Times New Roman",19));
        label9.setStyle("-fx-text-fill:red");

        Label label10=new Label(" ");
        label10.setFont(Font.font("Times New Roman",21));
        label10.setStyle("-fx-text-fill:black");

        DatePicker dob=new DatePicker();

        RadioButton male=new RadioButton("Male");
        male.setFont(Font.font("Times New Roman",19));
        RadioButton female=new RadioButton("Female");
        female.setFont(Font.font("Times New Roman",19));

        ToggleGroup group=new ToggleGroup();
        male.setToggleGroup(group);
        female.setToggleGroup(group);

        button=new Button("Create");
        button.setFont(new Font("Times New Roman",20));
        button.setStyle("-fx-text-fill:white; -fx-background-color:green");
        button.setOnAction(e->{

            UserSession.registeredUsername=input1.getText();
            UserSession.registeredPassword=input2.getText();

            System.out.println("Create button is pressed");

            if(dob.getValue()==null && group.getSelectedToggle()==null){
                label8.setText("These fields are required.");
                return;
            }

            if(dob.getValue()==null){
                label6.setText("This field is required");
                return;
            }

            if(group.getSelectedToggle()==null){
                label7.setText("This field is required");
                return;
            }



            label10.setText("Your account is successfully created.");

            PauseTransition pause=new PauseTransition(Duration.seconds(3));
            pause.setOnFinished(a-> {
                accountstage.close();
                LoginPage lp=new LoginPage();
                lp.start(accountstage);

            });
            pause.play();

        });



        GridPane layout=new GridPane();
        layout.add(label1,1,3);
        layout.add(input1,2,3);
        layout.add(label2,1,4);
        layout.add(input2,2,4);
        layout.add(label3,1,1);
        layout.add(label5,1,8);
        layout.add(dob,1,9);
        layout.add(label4,1,10);
        layout.add(male,1,11);
        layout.add(female,1,12);
        layout.add(button,6,12);
        layout.add(label9,3,4);
        layout.add(label6,2,8);
        layout.add(label7,2,10);
        layout.add(label8,1,7);
        layout.add(label10,6,13);
        layout.setPadding(new Insets(50,30,30,10)); // Can pass 1 or 4 parameters
        layout.setAlignment(Pos.BASELINE_CENTER); // Can be RIGHT
        layout.setHgap(15);
        layout.setVgap(20);
        layout.setStyle("-fx-background-color:lightblue");

        scene=new Scene(layout,1000,600);
        accountstage.setScene(scene);
        accountstage.show();

    }




}


