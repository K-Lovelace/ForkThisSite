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

public class ControllerPopup
	 implements Initializable {

		    @FXML //  fx:id="testButton"
		    private Button againButton; // Value injected by FXMLLoader
		    
		    @FXML
		    private Button seeButton;
		    
		    @Override // This method is called by the FXMLLoader when initialization is complete
		    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		        assert againButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";

		        // initialize your logic here: all @FXML variables will have been injected

		        againButton.setOnAction(new EventHandler<ActionEvent>() {
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
		    }

}
