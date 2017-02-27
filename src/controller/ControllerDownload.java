package controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;


public class ControllerDownload
    implements Initializable {

    @FXML //  fx:id="testButton"
    private Button testButton; // Value injected by FXMLLoader
    
    @FXML // fx:id="urlTest"
    private Label urlTest;
    
    @FXML
    private ProgressBar progress = new ProgressBar(0.0);
    int cpt = 0;

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert testButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected

        testButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	urlTest.setText("test");
            }
        });
    }

}