package com.wiexon.app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxmls/sample.fxml"));
        fxmlLoader.setController(new Controller());
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("REST LOGGER");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
            Platform.exit();
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
