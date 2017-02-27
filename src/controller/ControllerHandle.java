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
import javafx.stage.Stage;

public class ControllerHandle
	 implements Initializable {

		    @FXML 
		    private Button deleteButton;
		    
		    @FXML
		    private Button seeButton;
		    
		    @FXML
		    private Button openButton; 
		    
		    @Override // This method is called by the FXMLLoader when initialization is complete
		    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

		        // initialize your logic here: all @FXML variables will have been injected

		        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		            	// METHODE GAEL
		            }
		        });
		        
		        seeButton.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		            	// METHODE GAEL
		            }
		        });
		        
		        openButton.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		            	// METHODE GAEL
		            }
		        });
		        
		    }

}
