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

public class ControllerLayout 
	 implements Initializable {

		    @FXML //  fx:id="testButton"
		    private Button returnButton; // Value injected by FXMLLoader
		    

		    @Override // This method is called by the FXMLLoader when initialization is complete
		    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		        assert returnButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";

		        // initialize your logic here: all @FXML variables will have been injected

		        returnButton.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		            	Stage stage = null; 
		                Parent root = null;
		                try {
							root = FXMLLoader.load(getClass().getClassLoader().getResource("view/doc.fxml"));
							stage=(Stage) returnButton.getScene().getWindow();
		                } catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		                Scene scene = new Scene(root);
		                stage.setScene(scene);
		                stage.show();
		            }
		        });
		    }

}
