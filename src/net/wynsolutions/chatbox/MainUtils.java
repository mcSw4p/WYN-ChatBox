package net.wynsolutions.chatbox;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import net.wynsolutions.chatbox.app.ChatBox;
import net.wynsolutions.chatbox.utils.SceneUtils;
import net.wynsolutions.chatbox.utils.TabUtils;

/**
 * Copyright (C) 2017  Sw4p
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
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
public class MainUtils {

	public static ChatBox currentChat;
	public static Label userChater;
	public static TextArea chatArea;
	
	public static SceneUtils scene;
	public static TabUtils tabs;
	
	public MainUtils() {
		scene = new SceneUtils();
		tabs = new TabUtils();
	}
	
	/**
	 * Create a HBox instance containing the users avatar.
	 * @return HBox with image
	 */
	public static HBox getUserAvatarImage(){
		HBox imageBox = new HBox(1);
		Image userAvatar = new Image("file:resources/user/user_avatar.png");
		ImageView userAvatarView = new ImageView();

		userAvatarView.setFitWidth(30);
		userAvatarView.setFitHeight(30);
		userAvatarView.setImage(userAvatar);
		imageBox.setPadding(new Insets(2, 10, 2, 2));

		imageBox.getChildren().add(userAvatarView);
		return imageBox;
	}

	/**
	 * Create a HBox instance containing the User Main Text.
	 * "Welcome, User"
	 * @param username
	 * @return HBox with text.
	 */
	public static HBox getUserMainText(String username){
		HBox userBox = new HBox(1);
		TextFlow flow = new TextFlow();
		flow.setTextAlignment(TextAlignment.CENTER);
		userBox.setPadding(new Insets(10, 2, 2, 2));

		Label userLabel = new Label("Welcome, ");
		Label userName = new Label(username);
		userName.setStyle("-fx-font-weight: bold;");
		Label userEnd = new Label(".");
		flow.getChildren().add(userLabel);
		flow.getChildren().add(userName);
		flow.getChildren().add(userEnd);

		userBox.setAlignment(Pos.CENTER);
		userBox.getChildren().add(flow);
		return userBox;
	}

	public static void addFooter(GridPane grid){
		grid.setVgap(1.0);
		grid.setHgap(2.0);

		final TextArea field = new TextArea();
		field.setPrefWidth(290.0);
		field.setWrapText(true);
		Button send = new Button("Send");

		HBox credit = new HBox(1);
		Label foot = new Label("Created by: Sw4p");
		foot.setTextAlignment(TextAlignment.RIGHT);
		credit.setAlignment(Pos.BOTTOM_RIGHT);
		foot.setId("createdCredits1");
		foot.setPrefWidth(70.0);
		credit.getChildren().add(foot);

		HBox imageBox = new HBox(1);
		Image icon = new Image("file:resources/assets/app_icon(med).png");
		ImageView iconView = new ImageView();

		iconView.setFitWidth(50);
		iconView.setFitHeight(50);
		iconView.setImage(icon);

		imageBox.setAlignment(Pos.CENTER);
		imageBox.getChildren().add(iconView);

		grid.add(send, 3, 0);
		grid.add(field, 0, 0, 2, 4);
		grid.add(credit, 4, 3);
		grid.add(imageBox, 4, 1, 1, 2);
		
		field.setOnKeyPressed(new EventHandler<KeyEvent>() {
		    public void handle(KeyEvent keyEvent) {
		        if (keyEvent.getCode() == KeyCode.ENTER)  {
		            String text = field.getText();
		            if(!text.equals("") && !text.equals("\n")){
		            	MainUtils.currentChat.addMessage(scene.username, text);
		            }
		            field.setText("");
		            keyEvent.consume();
		        }
		    }
		});
		
		send.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				String text = field.getText();
	            if(!text.equals("") && !text.equals("\n")){
	            	MainUtils.currentChat.addMessage(scene.username, text);
	            }
	            field.setText("");
	            arg0.consume();
			}
		});

	}

	@SuppressWarnings("static-access")
	public static void addTabs(TabPane pane){
		pane.getTabs().add(tabs.createChatTab());
		pane.getTabs().add(tabs.createContactsTab());
		pane.getTabs().add(tabs.createSavedTab());
		pane.getTabs().add(tabs.createAccountTab());
		pane.getTabs().add(tabs.createSettingsTab());
		pane.getTabs().add(tabs.createAboutTab());
	}

	@SuppressWarnings("static-access")
	public static void refreshChatBox(){
		chatArea.setText("");
		if(currentChat != null){

		
		}else{
			currentChat = new ChatBox(scene.username);
		}
	}

	public static void addChatMessage(String user, String message){
		if(currentChat != null)
			currentChat.addMessage(user, message.trim());
	}

}
