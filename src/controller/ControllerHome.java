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
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControllerHome
	 implements Initializable {

		    @FXML 
		    private Button docButton; 
		    @FXML 
		    private Button downloadButton; 
		    @FXML 
		    private Button manageButton; 
		    @FXML
		    private Text infoText;
		    @FXML 
		    private ToggleButton frLanguage; 
		    @FXML 
		    private ToggleButton engLanguage; 
		    @FXML 
		    private ToggleButton rusLanguage; 

		    @Override // This method is called by the FXMLLoader when initialization is complete
		    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		    	switch(ForkThisSite.getMyLanguage()){
		    	case "fr":  frLanguage.setSelected(true);
		    				docButton.setText("Documentation");
		    				manageButton.setText("Gestion des pages téléchargées");
		    				downloadButton.setText("Télécharger une page Web");
		    				infoText.setText("ForkThisSite, développé par Quentin Castillo et Gael Cuminal, pour l'UCE Prototypage et interfaces.");
                			break;
		    	case "eng": engLanguage.setSelected(true);
							docButton.setText("Documentation");
							manageButton.setText("Management");
							downloadButton.setText("Download Web Page");
							infoText.setText("ForkThisSite, designed by Quentin Castillo & Gael Cuminal");
		    				break;
		    	case "rus": rusLanguage.setSelected(true);
		    				docButton.setText("документация");
		    				manageButton.setText("Управление загруженных страниц");
		    				downloadButton.setText("Загрузить веб-страницы");
		    				infoText.setText("ForkThisSite, разработанный Quentin Castillo и Gael Cuminal");
		    				break;
		    	}
		    	
		    	
		    	
		       docButton.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		            	Node node=(Node) event.getSource();
		            	Stage stage=(Stage) node.getScene().getWindow();
		            	BorderPane layout = null;
						try {
							layout = (BorderPane)FXMLLoader.load(getClass().getClassLoader().getResource("view/layout.fxml"));
							AnchorPane page = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("view/doc.fxml"));
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
		        
		        downloadButton.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {            	            	
		            	Node node=(Node) event.getSource();
		            	Stage stage=(Stage) node.getScene().getWindow();
		            	BorderPane layout = null;
						try {
							layout = (BorderPane)FXMLLoader.load(getClass().getClassLoader().getResource("view/layout.fxml"));
							AnchorPane page = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("view/download.fxml"));
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
		        
		        manageButton.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		            	Node node=(Node) event.getSource();
		            	Stage stage=(Stage) node.getScene().getWindow();
		            	BorderPane layout = null;
						try {
							layout = (BorderPane)FXMLLoader.load(getClass().getClassLoader().getResource("view/layout.fxml"));
							AnchorPane page = (AnchorPane)FXMLLoader.load(getClass().getClassLoader().getResource("view/handle.fxml"));
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
		        
		        frLanguage.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		            	if(frLanguage.isSelected()){
		            		ForkThisSite.setMyLanguage("fr");
		            		engLanguage.setSelected(false);
		            		rusLanguage.setSelected(false);
		            		
		            		// rafraichir
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
		            	else{
		            		frLanguage.setSelected(true);
		            	}
		            }
		        });
		        
		        engLanguage.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		            	if(engLanguage.isSelected()){
		            		ForkThisSite.setMyLanguage("eng");
		            		frLanguage.setSelected(false);
		            		rusLanguage.setSelected(false);
		            		
		            		// rafraichir
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
		            	else{
		            		engLanguage.setSelected(true);
		            	}
		            }
		        });
		        
		        rusLanguage.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		            	if(rusLanguage.isSelected()){
		            		ForkThisSite.setMyLanguage("rus");
		            		engLanguage.setSelected(false);
		            		frLanguage.setSelected(false);
		            	}
		            	else{
		            		rusLanguage.setSelected(true);
		            	}
		            	
		            	
		            	
	            		// rafraichir
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
