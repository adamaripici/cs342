import javafx.application.Application;

//import javafx.event.EventHandler;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
//import javafx.scene.control.Button;
import javafx.scene.control.TextField;
//import javafx.scene.control.EventHandler;
import java.awt.event.ActionEvent;

public class JavaFXTemplate extends Application {
//
	private Button b1;
	private Button b2;
	private TextField t1;
	private TextField t2;
//	private EventHandler<ActionEvent> myHandler;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Ada Pici Homework 3");
		//creating two buttons and 2 text fields
		b1 = new Button("Button one");
		b2 = new Button("Button two");
		t1 = new TextField("enter text here then press button 1");
		//this string should not be a prompt but display message
		t2 = new TextField();
		t2.setText("final string goes here");
		t2.setEditable(false);
		VBox root = new VBox(b1,b2);

		//set one textfield to the center using BorderPane
		// the textfield should display prompt letting the user know what to do with it; "enter text here then press button 1"
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(t1);
		//other textfield to the right in the borderpane

		borderPane.setRight(t2);

		// styling
		t1.setMaxSize(200, 100);
		t1.setStyle("-fx-background-color: #E62FA3;");
		t2.setMaxSize(400, 100);
		t2.setStyle("-fx-background-color: #A67AD1;");

		b1.setMaxSize(100,50);
		b2.setMaxSize(100,50);
		b1.setStyle("-fx-background-color: #83C996;");
		b2.setStyle("-fx-background-color: #F68725;");
		//set the buttons in an vbox to the left inside the borderpane
		borderPane.setLeft(root);
		// create and attach an EventHandler to "button1" utilizing an anonymous class. When clicked:
		// you will get the text from the text field in the center
		//  concatenate that text with the string "from the center text field"
		// set the text field to the right with the new string
		// disable button1 so it can not be pressed
		// change the string displayed on button one to "pressed" (instead of "button1")

		EventHandler<MouseEvent> actionbtn1 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				//get text from t1
				String text = t1.getText();
				// concatenate text
				text = text + " : from the center text field!";
				//set t2 with the new string
				t2.setText(text);
				//disable b1
				b1.setDisable(true);
				//change the string displayed on b1 to pressed
				b1.setText("pressed");
			}
		};
		b1.addEventFilter(MouseEvent.MOUSE_CLICKED, actionbtn1);

		//create and attach an event handle to button 2 utilizing a lambda expression
		// when clicked:
		// you will clear the text from both text fields
		// replace the string "final string goes here" in the t2
		// enable the first button so it can be pressed again
		// replace the string displayed on that button with "button one"
		b2.setOnAction((event) -> {
			t2.clear();
			t1.clear();
			t2.setText("final string goes here");
			//enable b1
			b1.setDisable(false);
			//replace string w button 1
			b1.setText("button one");
		});




		//set the scene
		Scene scene = new Scene(borderPane, 700,700);
		scene.setFill(Color.PINK);


		scene.getRoot().setStyle("-fx-font-family: 'serif'");
		primaryStage.setScene(scene);

		primaryStage.show();


	}

}
