package com.example.javafxdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.*;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene( fxmlLoader.load(), 700, 450);
            stage.setTitle( "NIKOPTIK" );
            stage.getIcons().add(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/images/icon.png"))));
            stage.setScene( scene );
            stage.show();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}