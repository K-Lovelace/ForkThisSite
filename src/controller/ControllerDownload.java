package controller;


import javaFxAppli.ForkThisSite;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Database;
import model.Parser;
import model.WebPage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;


public class ControllerDownload implements Initializable {
    
    @FXML
    private Button startButton;
    @FXML
    private TextArea urlText;
    @FXML
    private Text URLText;
    @FXML
    private Label folderLabel;
    @FXML
    private Text folderText;
    @FXML
    private ProgressBar progress = new ProgressBar(0.0);
    @FXML
    private Button folderButton;
    @FXML
    private Toggle imagesToggle;
    @FXML
    private Text imagesText;
    @FXML
    private Toggle videosToggle;
    @FXML
    private Text videosText;
    @FXML
    private ChoiceBox<String> recChoice;
    @FXML
    private Text recText;
    
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
                videosText.setText("Télecharger les vidéos ?");
                imagesText.setText("Télecharger les images ?");
                folderText.setText("Répertoir de sauvegarde :");
                URLText.setText("URL de la page Web :");
                recText.setText("Niveau de récursivité : ");
                break;
            
            case "eng":
                startButton.setText("Launch");
                folderButton.setText("Browse");
                if (imagesToggle.isSelected()) ((Labeled) imagesToggle).setText("Yes");
                else ((Labeled) imagesToggle).setText("No");
                if (videosToggle.isSelected()) ((Labeled) videosToggle).setText("Yes");
                else ((Labeled) videosToggle).setText("No");
                videosText.setText("Download videos?");
                imagesText.setText("Download images?");
                folderText.setText("Backup directory:");
                URLText.setText("Web page URL:");
                recText.setText("Level of recursion:");
                break;
            
            case "rus":
                startButton.setText("старт");
                folderButton.setText("путешествие");
                if (imagesToggle.isSelected()) ((Labeled) imagesToggle).setText("да");
                else ((Labeled) imagesToggle).setText("не");
                if (videosToggle.isSelected()) ((Labeled) videosToggle).setText("да");
                else ((Labeled) videosToggle).setText("не");
                videosText.setText("Загрузить видео?");
                imagesText.setText("Загрузка изображений?");
                folderText.setText("Резервное копирование каталога:");
                URLText.setText("URL веб-страницы:");
                recText.setText("Уровень рекурсии:");
                break;
        }
        
        
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
                // affichage popup
                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                Pane layout = null;
                try {
                    layout = (Pane) FXMLLoader.load(getClass().getClassLoader().getResource("view/popupSuccess.fxml"));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Scene dialogScene = new Scene(layout);
                dialog.setScene(dialogScene);
                dialog.show();
            }
        });
        
        // On ajoute les choix pour la récursivité
        for (int i = 1; i <= 10; i++) {
            recChoice.getItems().addAll(String.valueOf(i));
        }
        // par défaut on met 1
        recChoice.getSelectionModel().selectFirst();
        
        
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
    
    
    @FXML // gestion choiceBox
    private void changeValue() {
        recursivity = Integer.parseInt(recChoice.getValue());
    }
    
}

    

    
