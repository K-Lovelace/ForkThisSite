package javaFxAppli;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.*;
import javafx.stage.WindowEvent;
import model.Database;

import java.io.IOException;

public class ForkThisSite extends Application {
    private Stage primaryStage;
    private BorderPane layout;
    private static String langue = "fr";
    
    public static String getMyLanguage() {
        return langue;
    }

    public static void setMyLanguage(String choixLangue) {
        ForkThisSite.langue = choixLangue;
    }

    public static void main(String[] args) {
        launch();
    }
    
    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Fork This Site !");
        Database.initialize();
        this.primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                Database.close();
            }
        });
        initLayout();
    
        showHome();
    }
    

    private void initLayout() {
        try {
            // Load root layout from fxml file.
            layout = (BorderPane)FXMLLoader.load(getClass().getClassLoader().getResource("view/layout.fxml"));
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(layout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void showHome() {
        try {
            AnchorPane page = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("view/home.fxml"));
           
            // Set person overview into the center of root layout.
            layout.setCenter(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

