package com.example.pryatki;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private FXMLLoader fxmlLoader1;
    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("pryatki.fxml"));
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("pryatki1.fxml"));
        Parent root1 = loader1.load();
        Parent root2 = loader2.load();

        // Получение контроллеров для первого и второго окна
        Controller controller1 = loader1.getController();
        TCPClient tcpClient = new TCPClient(controller1);
        tcpClient.start();
        Controller1 controller2 = loader2.getController();

        // Назначение обработчика события кнопки в первом окне

        controller1.setController2(controller2);
        // Создание сцены и установка ее для первого окна
        Scene scene1 = new Scene(root1);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Окно 1");
        primaryStage.show();

        // Создание нового окна для второго окна
        Stage stage2 = new Stage();
        Scene scene2 = new Scene(root2);
        stage2.setScene(scene2);
        stage2.setTitle("Окно 2");
        stage2.show();

    }

    public static void main(String[] args) {


        launch();
    }
}
