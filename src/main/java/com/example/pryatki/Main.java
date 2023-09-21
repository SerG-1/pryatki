package com.example.pryatki;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("pryatki.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1192, 810);
        primaryStage.setTitle("Hello!");
        primaryStage.setScene(scene);
        primaryStage.show();

        Stage secondaryStage = new Stage();
        FXMLLoader fxmlLoader1 = new FXMLLoader(Main.class.getResource("pryatki1.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load(), 1192, 810);
        secondaryStage.setTitle("Hello!");
        secondaryStage.setScene(scene1);
        secondaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
