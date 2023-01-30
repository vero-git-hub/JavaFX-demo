package com.example.javafxdemo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.*;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
            Scene scene = new Scene( fxmlLoader.load(), 700, 520);
            stage.setTitle( "NIKOPTIK" );
            stage.getIcons().add(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/images/icon.png"))));
            stage.setScene( scene );
            stage.setOnCloseRequest(event -> System.exit(0));
            stage.show();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}