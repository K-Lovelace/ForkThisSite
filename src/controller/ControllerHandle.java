package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.jar.JarEntry;

import javaFxAppli.ForkThisSite;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Database;
import model.WebPage;

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
    
    @FXML
    private TreeView<File> filesTree;
    
    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
    
        printFiles();
        
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Delete page
            }
        });
        
        seeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //View page
            }
        });
        
        openButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Open page in browser
            }
        });
        
    }
    
    private void printFiles() {
        for(Map.Entry<String, String> entry : Database.getWebPages()) {
            WebPage wp = new WebPage(entry.getKey(), entry.getValue());
            printFiles(new File(wp.getLocationFolder()), null);
        }
    }
    
    private void printFiles(File dir, TreeItem<File> parent) {
        TreeItem<File> root = new TreeItem<>(dir);
        root.setExpanded(true);
        try {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("directory:" + file.getCanonicalPath());
                    printFiles(file,root);
                } else {
                    System.out.println("    file:" + file.getCanonicalPath());
                    root.getChildren().add(new TreeItem<>(file));
                }
                
            }
            if(parent==null){
                filesTree.setRoot(root);
            } else {
                parent.getChildren().add(root);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
