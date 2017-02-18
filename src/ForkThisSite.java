/**
 * Created by lovelacez on 2/8/17.
 */

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

import java.io.IOException;

public class ForkThisSite extends Application {
    private Stage primaryStage;
    private BorderPane layout;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");
    
        initLayout();
    
        showHome();
    }
    
    /**
     * Initializes the root layout.
     */
    private void initLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ForkThisSite.class.getResource("view/layout.fxml"));
            layout = loader.load();
            
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
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ForkThisSite.class.getResource("view/download.fxml"));
            AnchorPane home = loader.load();
            
            // Set person overview into the center of root layout.
            layout.setCenter(home);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        // Button was clicked, do something...
        
    }
}
