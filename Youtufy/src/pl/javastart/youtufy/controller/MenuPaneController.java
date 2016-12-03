package pl.javastart.youtufy.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MenuPaneController implements Initializable {

    @FXML
    private MenuBar mainMenu;
    
    @FXML
    private MenuItem aboutMenuItem;

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private MenuItem deleteMenuItem;
    
    public MenuItem getDeleteMenuItem() {
		return deleteMenuItem;
	}
    
	public MenuBar getMainMenu() {
		return mainMenu;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Initialize");
		configureMenu();
	}
	
	private void configureMenu() {
		closeMenuItem.setOnAction(x -> Platform.exit());
		
		aboutMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
                Parent parent = null;
                try {
                    parent = FXMLLoader.load(getClass().getResource("/pl/javastart/youtufy/view/AboutPane.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setTitle("Youtufy - about");
                stage.setScene(scene);
                stage.show();
            }
			
		});
	}
}