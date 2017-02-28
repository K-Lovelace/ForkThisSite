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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControllerLayout 
	 implements Initializable {

		    @FXML 
		    private Button returnButton; 


		    @Override // This method is called by the FXMLLoader when initialization is complete
		    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		    	switch(ForkThisSite.getMyLanguage()){
		    	case "fr":  returnButton.setText("Retour");
                			break;
		    	case "eng": returnButton.setText("Back");
    						break;
		    	case "rus": returnButton.setText("возвращение");
    						break;
		    	}
		    	
		    	
		    	
		        returnButton.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		            	Node node=(Node) event.getSource();
		            	Stage stage=(Stage) node.getScene().getWindow();
		            	BorderPane layout = null;
						try {
							layout = (BorderPane)FXMLLoader.load(getClass().getClassLoader().getResource("view/layout.fxml"));
							AnchorPane page = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("view/home.fxml"));
							layout.setCenter(page);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            	Scene scene = new Scene(layout);
		            	stage.setScene(scene);
		            	stage.show();
		            }
		        });
		    }

}
