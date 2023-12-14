// App.java
package com.example.interpolation;

import com.example.interpolation.controllers.AppController;
import com.example.interpolation.controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Appl extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        loader.load();

        AppController controller = loader.getController();
        Pane chartPane = new Pane(controller.getScatterChart());
        Scene scene = new Scene(chartPane, 900, 900);
        primaryStage.setScene(scene);
        primaryStage.setTitle("График функции");
        primaryStage.show();
    }
}
