package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerPopup
	 implements Initializable {

		    @FXML 
		    private Button againButton; 
		    
		    @FXML
		    private Button seeButton;
		    
		    @Override 
		    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		        againButton.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		            	Stage stage = (Stage) againButton.getScene().getWindow();
		                stage.close();
		            }
		        });
		        
		        seeButton.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		            	Stage stage = (Stage) againButton.getScene().getWindow();
		                stage.close();
		            }
		        });
		    }

}
