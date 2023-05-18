package com.example.lab4v2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 340, 500);
        stage.setTitle("Metal");
        stage.setScene(scene);
        stage.setMinHeight(530);
        stage.setMinWidth(200);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}