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
import javafx.scene.control.Labeled;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
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
		    private Text detailsText;
		    @FXML
		    private Text titleText;
		    @FXML
		    private Text urlText;
		    @FXML
		    private Text downloadText;
		    @FXML
		    private Text architecText;
		    @FXML
		    private Text gestionText;
		    
		    @Override
		    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		    	switch(ForkThisSite.getMyLanguage()){
		    	case "fr":  deleteButton.setText("Supprimer");
		    				seeButton.setText("Visualiser");
		    				openButton.setText("Ouvrir l'URL");
		    				detailsText.setText("Détails");
		    				titleText.setText("Titre :");
		    				urlText.setText("URL :");
		    				downloadText.setText("Téléchargé le : ");
		    				architecText.setText("Architecture des pages");
		    				gestionText.setText("Gestion de l'URL");
		        			break;
		        			
		    	case "eng": deleteButton.setText("Delete");
							seeButton.setText("Show");
							openButton.setText("Open the URL");
							detailsText.setText("Details");
							titleText.setText("Headline :");
							urlText.setText("URL :");
							downloadText.setText("Uploaded on : ");
							architecText.setText("Architecture of pages");
		    				gestionText.setText("URL management");
							break;
							
		    	case "rus": deleteButton.setText("удалять");
							seeButton.setText("дисплей");
							openButton.setText("Открыть URL");
							detailsText.setText("подробности");
							titleText.setText("Название :");
							urlText.setText("URL :");
							downloadText.setText("скачал : ");
							architecText.setText("архитектура страницы");
		    				gestionText.setText("Управление URL");
							break;
		    	}
		    	
		    	
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
		            	String url_open ="www.google.fr";
		            	try {
							java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }
		        });
		        
		    }

}
