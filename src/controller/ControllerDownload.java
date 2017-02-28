package controller;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javaFxAppli.ForkThisSite;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import model.Database;
import model.Parser;
import model.WebPage;


public class ControllerDownload
        implements Initializable {
    
    @FXML
    private Button startButton;
    @FXML
    private TextArea urlText;
    @FXML
    private Label folderLabel;
    @FXML
    private ProgressBar progress = new ProgressBar(0.0);
    @FXML
    private Button folderButton;
    @FXML
    private Toggle imagesToggle;
    @FXML
    private Toggle videosToggle;
    @FXML
    private ChoiceBox<String> recChoice;
    
    
    // Variables de download
    
    // urlText.getText()
    private boolean images = true;
    private boolean videos = true;
    private int recursivity = 1;
    private File directory;
    
    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        //Gestion langue
        switch (ForkThisSite.getMyLanguage()) {
            case "fr":
                startButton.setText("Démarrer");
                folderButton.setText("Parcourir");
                if (imagesToggle.isSelected()) ((Labeled) imagesToggle).setText("Oui");
                else ((Labeled) imagesToggle).setText("Non");
                if (videosToggle.isSelected()) ((Labeled) videosToggle).setText("Oui");
                else ((Labeled) videosToggle).setText("Non");
                
                
                break;
            
            case "eng":
                startButton.setText("Launch");
                folderButton.setText("Browse");
                if (imagesToggle.isSelected()) ((Labeled) imagesToggle).setText("Yes");
                else ((Labeled) imagesToggle).setText("No");
                if (videosToggle.isSelected()) ((Labeled) videosToggle).setText("Yes");
                else ((Labeled) videosToggle).setText("No");
                break;
            
            case "rus":
                startButton.setText("старт");
                folderButton.setText("путешествие");
                if (imagesToggle.isSelected()) ((Labeled) imagesToggle).setText("да");
                else ((Labeled) imagesToggle).setText("не");
                if (videosToggle.isSelected()) ((Labeled) videosToggle).setText("да");
                else ((Labeled) videosToggle).setText("не");
                break;
        }
        
        
        // On ajoute les choix pour la récursivité
        for (int i = 1; i <= 10; i++) {
            recChoice.getItems().addAll(String.valueOf(i));
        }
        // par défaut on met 1
        recChoice.getSelectionModel().selectFirst();
        
        // Lancer le téléchargement
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Initalize parser
                Parser parser = new Parser(urlText.getText(), recursivity, directory.toString(), images, videos);
                //add webpage in database
                Database.add(new WebPage(urlText.getText(), directory.toString(), new Date()));
                //start parsing
                (new Thread(parser::parse)).start();
                //user feedback
            }
        });
        
        folderButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DirectoryChooser directoryChooser = new DirectoryChooser();
                directoryChooser.setTitle("Dossier de sauvegarde");
                File selectedDirectory = directoryChooser.showDialog(null);
                if (selectedDirectory != null) {
                    folderLabel.setText(selectedDirectory.toString());
                    directory = selectedDirectory;
                }
            }
        });
        
        
        ((ButtonBase) imagesToggle).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!imagesToggle.isSelected()) {
                    ((Labeled) imagesToggle).setText("Non");
                    images = false;
                } else {
                    ((Labeled) imagesToggle).setText("Oui");
                    images = true;
                }
            }
        });
        
        
        ((ButtonBase) videosToggle).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!videosToggle.isSelected()) {
                    ((Labeled) videosToggle).setText("Non");
                    videos = false;
                } else {
                    ((Labeled) videosToggle).setText("Oui");
                    videos = true;
                }
            }
        });
    }
    
}