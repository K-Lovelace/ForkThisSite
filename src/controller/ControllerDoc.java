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

public class ControllerDoc
	 implements Initializable {

		@FXML
		private Text text;


		    @Override // This method is called by the FXMLLoader when initialization is complete
		    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		    	switch(ForkThisSite.getMyLanguage()){
		    	case "fr":  text.setText("Cette application a été développé par Quentin Castillo"
		    			+ "et Gael Cuminal. Elle permet à l'utilisateur de récupérer une page"
		    			+ "web avec des paramètres définis. Ainsi, il peut choisir de récupérer"
		    			+ "l'ensemble des données de la page, mais il peut aussi exclure les "
		    			+ "images et/ou les vidéos. Il doit etre également possible de "
		    			+ "récupérer les pages que pointe la page principal, avec une"
		    			+ "récursivité choisie par l'utilisateur");
                			break;
		    	case "eng": text.setText("This application was developed by Quentin Castillo"
		    			+ " and Gael Cuminal. It allows the user to retrieve a pageweb with"
		    			+ " defined parameters. Thus, it can choose to retrieve all the data"
		    			+ " from the page, but it can also exclude images and / or videos."
		    			+ " It should also be possible to retrieve the pages that the main"
		    			+ " page points to, with a recursion chosen by the user");
    						break;
		    	case "rus": text.setText("Это приложение было разработано Квентина Кастильо"
		    			+ " и Гаэль Cuminal. Это позволяет пользователю получить веб-страницы"
		    			+ " с заданными параметрами. Таким образом, он может выбрать, чтобы "
		    			+ "восстановить все данные на странице, но он также может исключить"
		    			+ " изображения и / или видео. Следует также можно восстановить "
		    			+ "страницы, которые указывают на главную страницу, с возможностью "
		    			+ "выбора пользователем рекурсии");
    						break;
		    	}
		    }

}
