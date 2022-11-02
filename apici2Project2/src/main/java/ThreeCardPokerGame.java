import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.Group;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import java.awt.*;

public class ThreeCardPokerGame extends Application {
	HBox p1Box;
	HBox p2Box;
	HBox dealerBox;
	HBox p1anteBox;
	HBox p2anteBox;
	Button startBtn;

	HBox startBox;

	//player1:
	Player playerOne;
	Text p1Text;
	TextField p1Ante;
	TextField p1Wager;
	TextField p1PairPlus;
	Text p1PairPlusInput;
	Button p1PairPlusBtn;
	HBox p1PairPlusBox;
	Text p1Balance;
	Text p1AnteInput;
	HBox p1AnteInputBox;
	HBox totalP1;
	HBox totalP2;
	Button p1Fold;
	Button p1Play;
	HBox p1Cards;
	VBox player1Pane;

	Player playerTwo;
	Text p2Text;
	TextField p2Ante;
	Text p2AnteInput;
	Button p2AnteBtn;
	HBox p2AnteInputBox;
	TextField p2Wager;
	TextField p2PairPlus;
	Text p2PairPlusInput;
	Button p2PairPlusBtn;
	HBox p2PairPlusBox;
	Text p2Balance;
	Button p2Fold;
	Button p2Play;
	HBox p2Cards;

	Dealer theDealer;
	HBox dealerCards;
	Text dealerText;

	ImageView dealerCard1;
	ImageView dealerCard2;
	ImageView dealerCard3;
	String backCard = ("https://cdn.pixabay.com/photo/2022/02/23/20/25/card-7031432_960_720.png");

	Text instructions;
	HBox instructionsBox;
	Button btnGetText;
	Menu m = new Menu("Menu");
	private VBox menuBox;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
	}

	//create a menu
	void createMenu(BorderPane borderPane, Stage primaryStage) {

		// create a menubar
		Menu mb = new Menu("Options");

		//Creating menu Items
		MenuItem item1 = new MenuItem("Exit");
		MenuItem item2 = new MenuItem("Fresh Start");
		MenuItem item3 = new MenuItem("NewLook");
		//Adding all the menu items to the menu
		mb.getItems().addAll(item1, item2, item3);
		//Creating a menu bar and adding menu to it.
		MenuBar menuBar = new MenuBar(mb);
		menuBox = new VBox(20, menuBar);

	}

	void createElements() {
		instructions = new Text();
		instructions.setText("Press START to begin");
		instructions.setFill(Color.RED);
		instructions.setFont(Font.font("verdana", FontWeight.BOLD,24));
		instructionsBox = new HBox(instructions);
		instructionsBox.setLayoutX(300);
		instructionsBox.setLayoutY(400);


		//player1:
		p1Text = new Text();
		p1Text.setText("Player 1:");
		p1Text.setFill(Color.BROWN);
		p1Text.setFont(Font.font("verdana", FontWeight.BOLD,24));
		p1Text.setTextAlignment(TextAlignment.CENTER);
		p1Box = new HBox(p1Text);
		p1Box.setLayoutX(100);
		p1Box.setLayoutY(300);

		//balance
		p1Balance = new Text();
		p1Balance.setText("Total Winnings: $" + playerOne.getTotalWinnings());
		p1Balance.setFont(Font.font("verdana",24));
		totalP1 = new HBox(p1Balance);



		//player2:
		p2Text = new Text();
		p2Text.setText("Player 2:");
		p2Text.setFill(Color.BROWN);
		p2Text.setFont(Font.font("verdana", FontWeight.BOLD,24));
		p2Text.setTextAlignment(TextAlignment.CENTER);
		p2Box = new HBox(p2Text);
		p2Box.setLayoutX(500);
		p2Box.setLayoutY(300);

		//balance
		p2Balance = new Text();
		p2Balance.setText("Total Winnings: $" + playerTwo.getTotalWinnings());
		p2Balance.setFont(Font.font("verdana",24));
		totalP2 = new HBox(p2Balance);

		//dealer:
		dealerText = new Text();
		dealerText.setText("Dealer:");
		dealerText.setFill(Color.BROWN);

		dealerText.setFont(Font.font("verdana",FontWeight.BOLD ,24));
		dealerText.setTextAlignment(TextAlignment.CENTER);



		dealerBox = new HBox(dealerText);
		dealerBox.setLayoutX(450);
		dealerBox.setLayoutY(30);

		p1PairPlusBtn = new Button("OK");
		p1PairPlusBtn.setVisible(false);

		p2PairPlusBtn = new Button("OK");
		p2PairPlusBtn.setVisible(false);

		//p2 ante wager
		p2AnteBtn = new Button("OK");
		p2AnteBtn.setVisible(false);
	}


	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		Image img = new Image("https://img.freepik.com/premium-vector/poker-table-background-green-color_47243-1068.jpg?w=996");
		BackgroundImage bImg = new BackgroundImage(img,
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		Background bGround = new Background(bImg);

		//start button
		startBtn = new Button("Start");
		startBtn.setStyle("-fx-background-color: #6495ED; -fx-border-width: 2px;-fx-font-size:25");
		startBox = new HBox(startBtn);
		startBtn.setMinSize(100, 60);
		startBox.setLayoutX(400);
		startBox.setLayoutY(480);



		primaryStage.setTitle("Welcome to 3 Card Poker!");

		theDealer = new Dealer();
		playerOne = new Player();
		playerTwo = new Player();

		BorderPane borderPane = new BorderPane();
		borderPane.setStyle("-fx-background-color: rgba(230,230,230,0.7);");

		//Creating menu Items
		createMenu(borderPane, primaryStage);

		createElements();

		//when clicked on start
		startBtn.setOnAction(e->{
			startBtn.setVisible(false);
			// dealers card
			Image dealCardBack = new Image(backCard);
			dealerCard1 = new ImageView();
			dealerCard1.setFitHeight(80);
			dealerCard1.setFitWidth(50);
			dealerCard1.setImage(dealCardBack);

			dealerCard2 = new ImageView();
			dealerCard2.setFitHeight(80);
			dealerCard2.setFitWidth(50);
			dealerCard2.setImage(dealCardBack);

			dealerCard3 = new ImageView();
			dealerCard3.setFitHeight(80);
			dealerCard3.setFitWidth(50);
			dealerCard3.setImage(dealCardBack);

			dealerCards = new HBox(dealerCard1,dealerCard2,dealerCard3);

			dealerCards.setLayoutX(475);
			dealerCards.setLayoutY(100);
			borderPane.getChildren().add(dealerCards);

			instructionsBox.getChildren().clear();

			instructions = new Text();
			instructions.setText("Player 1: Enter ante wager");
			instructions.setFill(Color.RED);
			instructions.setFont(Font.font("verdana", FontWeight.BOLD,24));
			instructionsBox = new HBox(instructions);
			instructionsBox.setLayoutX(300);
			instructionsBox.setLayoutY(400);
			borderPane.getChildren().add(instructionsBox);

			//ante wager
			p1Ante = new TextField();
			p1Ante.setMinSize(50,50);

			btnGetText = new Button("OK");
			btnGetText.setMinSize(50,50);

			p1anteBox = new HBox(p1Ante,btnGetText);
			p1anteBox.setLayoutX(100);
			p1anteBox.setLayoutY(400);




			//button ante
			btnGetText.setOnAction(event -> {
				instructionsBox.getChildren().clear();
				if (Integer.parseInt(p1Ante.getText()) < 5 || Integer.parseInt(p1Ante.getText()) > 25 ) {
					instructions.setText("Ante Bet must be $5 or greater, up to $25");
					instructions.setFill(Color.RED);
					instructions.setFont(Font.font("verdana", FontWeight.BOLD,24));
					instructionsBox = new HBox(instructions);
					instructionsBox.setLayoutX(300);
					instructionsBox.setLayoutY(400);
					borderPane.getChildren().addAll(instructionsBox);
				} else {
					playerOne.setAnteBet(Integer.parseInt(p1Ante.getText()));
					p1AnteInput = new Text();
					p1AnteInput.setText("Play Wager: $" + p1Ante.getText());
					p1AnteInput.setFont(Font.font("verdana", 24));
					p1AnteInputBox = new HBox(p1AnteInput);
					p1AnteInputBox.setLayoutX(300);
					p1AnteInputBox.setLayoutY(400);
					borderPane.getChildren().addAll(p1AnteInputBox);
					p1AnteInputBox.setLayoutX(100);
					p1AnteInputBox.setLayoutY(500);
					btnGetText.setVisible(false);

					//enter optional pair plus wager
					instructionsBox.getChildren().clear();
					instructions.setText("Player 1: Enter Optional Pair Plus Wager");
					instructions.setFill(Color.RED);
					instructions.setFont(Font.font("verdana", FontWeight.BOLD,24));
					instructionsBox = new HBox(instructions);
					instructionsBox.setLayoutX(300);
					instructionsBox.setLayoutY(400);

//					p1PairPlusBtn = new Button("Make Bet");
					p1PairPlusBtn.setVisible(true);
					p1PairPlusBtn.setMinSize(50,50);
					p1PairPlus = new TextField();

					p1PairPlus.setMinSize(50,50);
					p1PairPlusBox = new HBox(p1PairPlus,p1PairPlusBtn);
					p1PairPlusBox.setLayoutX(100);
					p1PairPlusBox.setLayoutY(400);

					p1Ante.setVisible(false);
					borderPane.getChildren().addAll(instructionsBox, p1PairPlusBox);
				}

			});

			p1PairPlusBtn.setOnAction(event2 -> {
				instructionsBox.getChildren().clear();
				if (Integer.parseInt(p1PairPlus.getText()) < 5 || Integer.parseInt(p1PairPlus.getText()) > 25 ) {
					instructions.setText("Pair Plus Bet must be $5 or greater, up to $25");
					instructions.setFill(Color.RED);
					instructions.setFont(Font.font("verdana", FontWeight.BOLD,24));
					instructionsBox = new HBox(instructions);
					instructionsBox.setLayoutX(300);
					instructionsBox.setLayoutY(400);
					borderPane.getChildren().addAll(instructionsBox);
				} else {
					playerOne.setPlayBet(Integer.parseInt(p1PairPlus.getText()));
					p1PairPlusInput = new Text();
					p1PairPlusInput.setText("Pair Plus: $" + p1PairPlus.getText());
					p1PairPlusInput.setFont(Font.font("verdana", 24));
					HBox p1PairPlusBox = new HBox(p1PairPlusInput);
					p1PairPlusBox.setLayoutX(100);
					p1PairPlusBox.setLayoutY(460);
					borderPane.getChildren().addAll(p1PairPlusBox);
					p1PairPlusBtn.setVisible(false);
					p1PairPlus.setVisible(false);

					//enter p2 ante
					instructionsBox.getChildren().clear();
					instructions.setText("Player 2: Enter Ante Wager");
					instructions.setFill(Color.RED);
					instructions.setFont(Font.font("verdana", FontWeight.BOLD,24));
					instructionsBox = new HBox(instructions);
					instructionsBox.setLayoutX(300);
					instructionsBox.setLayoutY(400);

					p2Ante = new TextField();
					p2AnteBtn.setVisible(true);
					p2AnteBtn.setMinSize(50,50);
					p2Ante.setMinSize(50,50);
					p2anteBox = new HBox(p2Ante,p2AnteBtn);
					p2anteBox.setLayoutX(500);
					p2anteBox.setLayoutY(450);
					borderPane.getChildren().addAll(p2anteBox, instructionsBox);
				}
			});

			p2AnteBtn.setOnAction(event2 -> {
				instructionsBox.getChildren().clear();
				if (Integer.parseInt(p2Ante.getText()) < 5 || Integer.parseInt(p2Ante.getText()) > 25 ) {
					instructions.setText("Ante Bet must be $5 or greater, up to $25");
					instructions.setFill(Color.RED);
					instructions.setFont(Font.font("verdana", FontWeight.BOLD,24));
					instructionsBox = new HBox(instructions);
					instructionsBox.setLayoutX(300);
					instructionsBox.setLayoutY(400);
					borderPane.getChildren().addAll(instructionsBox);
				} else {
					playerTwo.setAnteBet(Integer.parseInt(p2Ante.getText()));
					p2AnteInput = new Text();
					p2AnteInput.setText("Play Wager: $" + p2Ante.getText());
					p2AnteInput.setFont(Font.font("verdana", 24));
					p2AnteInputBox = new HBox(p2AnteInput);
					p2AnteInputBox.setLayoutX(650);
					p2AnteInputBox.setLayoutY(400);
					borderPane.getChildren().addAll(p2AnteInputBox);
					p2AnteInputBox.setLayoutX(500);
					p2AnteInputBox.setLayoutY(500);
					p2AnteBtn.setVisible(false);

					//enter optional pair plus wager
					instructionsBox.getChildren().clear();
					instructions.setText("Player 2: Enter Optional Pair Plus Wager");
					instructions.setFill(Color.RED);
					instructions.setFont(Font.font("verdana", FontWeight.BOLD,24));
					instructionsBox = new HBox(instructions);
					instructionsBox.setLayoutX(300);
					instructionsBox.setLayoutY(400);

					p2PairPlusBtn.setVisible(true);
					p2PairPlusBtn.setMinSize(50,50);
					p2PairPlus = new TextField();

					p2PairPlus.setMinSize(50,50);

					p2PairPlusBox = new HBox(p2PairPlus,p2PairPlusBtn);
					p2PairPlusBox.setLayoutX(500);
					p2PairPlusBox.setLayoutY(450);

					p2Ante.setVisible(false);
					borderPane.getChildren().addAll(instructionsBox, p2PairPlusBox);
				}
			});

			p2PairPlusBtn.setOnAction(event3 -> {
				instructionsBox.getChildren().clear();
				if (Integer.parseInt(p2PairPlus.getText()) < 5 || Integer.parseInt(p2PairPlus.getText()) > 25 ) {
					instructions.setText("Pair Plus Bet must be $5 or greater, up to $25");
					instructions.setFill(Color.RED);
					instructions.setFont(Font.font("verdana", FontWeight.BOLD,24));
					instructionsBox = new HBox(instructions);
					instructionsBox.setLayoutX(300);
					instructionsBox.setLayoutY(400);
					borderPane.getChildren().addAll(instructionsBox);
				} else {
					playerTwo.setPlayBet(Integer.parseInt(p2PairPlus.getText()));
					p2PairPlusInput = new Text();
					p2PairPlusInput.setText("Pair Plus: $" + p2PairPlus.getText());
					p2PairPlusInput.setFont(Font.font("verdana", 24));
					p2PairPlusBox = new HBox(p2PairPlusInput);
					p2PairPlusBox.setLayoutX(500);
					p2PairPlusBox.setLayoutY(460);
					borderPane.getChildren().addAll(p2PairPlusBox);
					p2PairPlusBtn.setVisible(false);
					p2PairPlus.setVisible(false);

				}
			});

			borderPane.getChildren().addAll(p1anteBox);
		});




		borderPane.setTop(menuBox);
		borderPane.getChildren().add(instructionsBox);
		totalP1.setLayoutX(100);
		totalP1.setLayoutY(520);

		totalP2.setLayoutX(500);
		totalP2.setLayoutY(520);
		borderPane.getChildren().addAll(dealerBox, startBox, totalP2, totalP1,p1Box,p2Box);


		borderPane.setStyle("-fx-background-color: transparent;");

		Scene scene = new Scene(borderPane,990,580);
		borderPane.setBackground(bGround);
		scene.getRoot().setStyle("-fx-font-family: 'serif'");
		primaryStage.setScene(scene);

		primaryStage.show();
	}

}
