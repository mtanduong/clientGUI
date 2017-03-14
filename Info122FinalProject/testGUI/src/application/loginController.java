package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class loginController {
	//Initial list of games for the drop down menu
	ObservableList<String> gameList = FXCollections.observableArrayList("Checkers", "Tic-Tac-Toe", "Othello");
	
	@FXML
	private TextField username;
	
	@FXML
	private ChoiceBox<String> game;
	
	@FXML
	private void initialize() {
		game.setValue("Checkers");
		game.setItems(gameList);
	}
	
	//Enters the lobby with game chosen if Login button is clicked
	public void loginButtonClicked() {
		String user = username.getText();
		String pickedGame = game.getValue();
		System.out.println("Logging in as "+user+" for game of "+pickedGame);
		
		try {	
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("lobbyGUI.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            
            lobbyController lobby = fxmlLoader.<lobbyController>getController();
            //Sends username and chosen game as string parameters into lobby so lobby can request that game type
            lobby.setUserGame(user, pickedGame);
            Scene scene = new Scene(root1);
            stage.setScene(scene);
            
            stage.setTitle("UCI Steam Lobby");
            stage.getIcons().add(new Image("file:src/applications/favicon.png"));
            //stage.setScene(new Scene(root1, 720, 480));  
            stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	//Exits the program if Cancel button is clicked
	public void cancelButtonClicked() {
		System.out.println("cancel clicked");
		System.exit(0);
	}
}
