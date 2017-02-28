package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javaFxAppli.ForkThisSite;
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

public class ControllerHandle
	 implements Initializable {

		    @FXML 
		    private Button deleteButton;
		    
		    @FXML
		    private Button seeButton;
		    
		    @FXML
		    private Button openButton; 
		    
		    @FXML
		    private AnchorPane detailAnchorPane;
		    
		    @Override
		    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

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
		            	System.out.println(ForkThisSite.getMyLanguage());
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
