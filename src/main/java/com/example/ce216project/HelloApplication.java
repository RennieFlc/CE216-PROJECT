package com.example.ce216project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        Dictionary dictionary = new Dictionary();
        stage.setScene(scene);
        dictionary.readDictFile();
        stage.setMinWidth(400);
        stage.setMinHeight(400);
        stage.show();
    }
    public static void main (String[]args){
        launch();
    }
}