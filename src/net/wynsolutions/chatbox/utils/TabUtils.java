package net.wynsolutions.chatbox.utils;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import net.wynsolutions.chatbox.MainUtils;
import net.wynsolutions.chatbox.app.ChatBox;

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
public class TabUtils {
	
	public static Tab createChatTab(){
		Tab chatTab = new Tab("Chat");
		chatTab.setClosable(false);

		GridPane grid = new GridPane();
		grid.setHgap(15.0);
		grid.setVgap(10.0);

		HBox areaBox = new HBox(2);
		MainUtils.chatArea = new TextArea();
		MainUtils.chatArea.setPrefSize(380.0, 410.0);
		MainUtils.chatArea.setId("chatBox");
		MainUtils.chatArea.setEditable(false);
		MainUtils.chatArea.setWrapText(true);
		


		areaBox.getChildren().add(new ChatBox(MainUtils.scene.username));
		MainUtils.refreshChatBox();
		areaBox.setAlignment(Pos.CENTER);

		grid.add(areaBox, 1, 1);
		
		MainUtils.userChater = new Label("");
		
		MainUtils.userChater.setText(MainUtils.currentChat.getContact());
		MainUtils.userChater.setAlignment(Pos.BOTTOM_CENTER);
		MainUtils.userChater.setStyle("-fx-font: 15px Tahoma;-fx-fill: white;-fx-stroke: black;-fx-stroke-width: 2px;-fx-stroke-type: outside;");
		MainUtils.userChater.setPadding(new Insets(7, 0, 0, 15));
		MainUtils.userChater.getStyleClass().add("user");
		
		grid.add(MainUtils.userChater, 1, 0);
		
		chatTab.setContent(grid);

		return chatTab;
	}

	public static Tab createSavedTab(){
		Tab sTab = new Tab("Saved");
		sTab.setClosable(false);
		return sTab;
	}

	public static Tab createAccountTab(){
		Tab aTab = new Tab("Account");
		aTab.setClosable(false);
		return aTab;
	}

	public static Tab createContactsTab(){
		Tab cTab = new Tab("Contacts");
		cTab.setClosable(false);
		return cTab;
	}

	public static Tab createSettingsTab(){
		Tab sTab = new Tab("Settings");
		sTab.setClosable(false);
		return sTab;
	}

	public static Tab createAboutTab(){
		Tab aTab = new Tab("About");
		aTab.setClosable(false);
		
		BorderPane pane = new BorderPane();
		
		HBox imageBox = new HBox();
		imageBox.setPadding(new Insets(10, 2, 2, 2));
		Image icon = new Image("file:resources/assets/app_icon(large).png");
		ImageView iconView = new ImageView();

		iconView.setFitWidth(100);
		iconView.setFitHeight(100);
		iconView.setImage(icon);
		
		imageBox.getChildren().add(iconView);
		imageBox.setAlignment(Pos.CENTER);
		pane.setTop(imageBox);
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		
		Label title = new Label("WYN ChatBox"),
			create = new Label("Created by: Sw4p");
		
		Text paraText = new Text("WYN Chatbox was created to provide a secure way to chat with people with minimal effort. "
				+ "This software is part of the Free Software licencing under GNU GPLv3, you should have recieved a copy of"
				+ " this licence along with this software. If not you can find it here, "),
			paraText2 = new Text(". \n\n This application and more can be found here, "),
			paraText3 = new Text(". All applications were created by Sw4p and are to be used for personal use.");
		
		Hyperlink licenceLink = new Hyperlink("http://www.gnu.org/licenses/"),
				appLink = new Hyperlink("App Link Here");

		TextFlow para = new TextFlow();
		
		title.setTextAlignment(TextAlignment.CENTER);title.setStyle("-fx-font-size: 14px;-fx-font-weight: bold;-fx-text-fill: black;");
		create.setTextAlignment(TextAlignment.CENTER);create.setStyle("-fx-font-size: 11px;-fx-text-fill: black;");
		para.setTextAlignment(TextAlignment.CENTER);para.setStyle("-fx-font-family: Tahoma;-fx-font-size: 13px;");
		
		title.setAlignment(Pos.TOP_CENTER);
		create.setAlignment(Pos.TOP_CENTER);
		
		para.setPadding(new Insets(10, 30, 30, 30));
		title.setPadding(new Insets(0, 0, 0, 153));
		create.setPadding(new Insets(0, 0, 0, 157));
		licenceLink.setPadding(new Insets(0));
		
		para.getChildren().addAll(paraText, licenceLink, paraText2, appLink, paraText3);
		
		grid.add(title, 1, 0);
		grid.add(create, 1, 1);
		grid.add(para, 1, 3);
		
		pane.setCenter(grid);
		
		aTab.setContent(pane);
		return aTab;
	}
	
}
