package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.image.*;

public class lobbyController {
	//Dummy list of rooms and players
	ObservableList<String> roomList = FXCollections.observableArrayList("Room1", "Room2", "Room3");
	ObservableList<String> playerList = FXCollections.observableArrayList("Michael", "Edward", "Juno", "Huda", "Sam", "Dan", "Mike", "Jessica", "Andrew");
	ObservableList<String> roomListNew = FXCollections.observableArrayList("Room1", "Room2", "Room3", "NewRoom", "MikeRoom");
	ObservableList<String> playerListNew = FXCollections.observableArrayList("Michael", "Edward", "Juno", "Huda");
	//User and game are the values taken from the login (account name & game chosen)
	String user, game;
	
	@FXML
	private Button backButton;
	
	@FXML
	private Button joinButton;
	
	@FXML
	private Button createButton;
	
	@FXML
	private Button saveProfileButton;
	
	@FXML
	private TextArea textArea;
	
	@FXML
	private TextArea UserName;
	
	@FXML
	private Text name;
	
	@FXML
	private Text gameName;
	
	@FXML
	private TextField profile;
	
	@FXML
	private ListView<String> player;
	
	@FXML
	private ListView<String> room;
	
	@FXML
	private void initialize() {
		//Initializing lobby. Request specific lobby (ie checkers lobby, tictactoe lobby, etc) here
		//Code here
		//Fill room and player list with dummy lists
		room.setItems(roomList);
		player.setItems(playerList);
	}
	
	public void backButtonClicked() {
		//Closes the lobby
		System.out.println("closing lobby");
		Stage stage = (Stage) backButton.getScene().getWindow();
		stage.close();
	}
	
	public void saveProfileButtonClicked() {
		//Retrieve user's profile and saves it into string
		String playerprofile = profile.getText();
		//Save user's profile into player class
		//Code here
		textArea.setText("Profile saved!");
	}

	public void joinButtonClicked() {
		//Gets the string value of the game and player highlighted
		String currentGameHighlighted = room.getSelectionModel().getSelectedItem();
		String currentPlayerHighlighted = player.getSelectionModel().getSelectedItem();
		//Join game
		//Code here
		textArea.setText("Joining "+currentPlayerHighlighted+"'s game of "+currentGameHighlighted);
		System.out.println("Joining "+currentPlayerHighlighted+"'s game of "+currentGameHighlighted);
	}
	
	public void roomTitleClicked() {
		//Gets the string value of the game highlighted
		String currentGameHighlighted = room.getSelectionModel().getSelectedItem();
		System.out.println("Highlighted game "+currentGameHighlighted);
		//Retrieve list of players current waiting playing that particular game
		//Code here
		//Update lobby with list of players currently playing highlighted game
		//player.setItems(playerListNew);
	}
	
	public void playerTitleClicked() {
		//Gets the string value of the player highlighted
		String currentPlayerHighlighted = player.getSelectionModel().getSelectedItem();
		System.out.println("Highlighted player "+currentPlayerHighlighted);
		//Retrieve profile of highlighted player
		//Code here
		//Update text area with profile of highlighted player
		//Code here
	}
	
	public void createGameClicked() {
		//Gets the string value of the game highlighted
		String currentGameHighlighted = room.getSelectionModel().getSelectedItem();
		System.out.println("Creating game of "+currentGameHighlighted);
		textArea.setText("Creating game of "+currentGameHighlighted+". Waiting for opponent...");
	}
	
	public void addPlayer(String player) {
		playerList.add(player);
	}
	
	public void addRoom(String room) {
		roomList.add(room);
	}
	
	public void removePlayer(String player) {
		playerList.remove(player);
	}
	
	public void removeRoom(String room) {
		roomList.remove(room);
	}
	
	public void setUserGame(String currentUser, String currentGame) {
		//Takes in the values from the login GUI (username and game chosen)
		this.user = currentUser;
		this.game = currentGame;
		name.setText(currentUser);
		gameName.setText(currentGame);
		System.out.println("Lobby initialized with "+currentUser+" and "+currentGame);
	}
}
