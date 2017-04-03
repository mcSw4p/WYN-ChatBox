package net.wynsolutions.chatbox;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Copyright (C) 2017  Sw4p
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either vrsion 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * @author Sw4p
 *
 */
public class Main extends Application{
	
	private Button createButton = new Button("Sign in"), cancelBtn = new Button("Cancel"), registerBtn = new Button("Register");
	private TextField userTextField = new TextField();
	private PasswordField pwBox = new PasswordField();
	
	private Stage stage;
	
	@Override public void start(Stage arg0) throws Exception {

		this.stage = arg0;
		
		// Create Sign in box
		
		arg0.setTitle("ChatBox - Sign in");
		arg0.getIcons().add(new Image("file:resources/assets/app_icon(small).png"));
		arg0.setResizable(false);
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Scene scene = new Scene(grid, 350, 200);
		arg0.setScene(scene);
		
		Text scenetitle = new Text("Welcome");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1);

		grid.add(this.userTextField, 1, 1);

		Label pw = new Label("Password:");
		grid.add(pw, 0, 2);

		grid.add(this.pwBox, 1, 2);
		
		this.createButtonActions();
		
		HBox hbBtn = new HBox(10), cancelHb = new HBox(10), registerHb = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		cancelHb.setAlignment(Pos.BOTTOM_RIGHT);
		registerHb.setAlignment(Pos.BOTTOM_RIGHT);
		
		BorderPane pane = new BorderPane();
		pane.setRight(createButton);
		pane.setCenter(cancelBtn);
		
		registerHb.getChildren().add(registerBtn);
		
		grid.add(pane, 1, 4);
		grid.add(registerHb, 0, 4);
		
		arg0.show();
		
	}
	
	private void createButtonActions(){
		this.cancelBtn.setOnAction(new EventHandler<ActionEvent>(){

			public void handle(ActionEvent arg0) {
				stage.close();
			}
			
		});
		
		this.createButton.setOnAction(new EventHandler<ActionEvent>(){
			
			@SuppressWarnings("static-access")
			public void handle(ActionEvent arg0) {
				
				// if user name exists
				  // Then check password
				//Else flash user name field yellow
				
				MainUtils.scene.showChatBox(stage, userTextField.getText());
				
			}
			
		});
		
		this.registerBtn.setOnAction(new EventHandler<ActionEvent>(){

			public void handle(ActionEvent arg0) {
				
			}
			
		});
	}

	public static void main(String[] args) {
		launch(args);
	}

}
