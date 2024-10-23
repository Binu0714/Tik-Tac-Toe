package com.assignment.tictactoe.service;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/BoardView.fxml"));
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(load));
        primaryStage.show();

        Image image = new Image(getClass().getResourceAsStream("/image/tic-tac-toe (1).png"));
        primaryStage.getIcons().add(image);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
