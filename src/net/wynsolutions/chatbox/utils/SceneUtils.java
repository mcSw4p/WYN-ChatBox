package net.wynsolutions.chatbox.utils;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import net.wynsolutions.chatbox.Main;
import net.wynsolutions.chatbox.MainUtils;

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
public class SceneUtils {

	public static String username = "Not Signed In";

	public static void showChatBox(Stage stage, String parUsername){
		username = parUsername;

		stage.setTitle("ChatBox - " + username);
		stage.getIcons().add(new Image("file:resources/assets/app_icon.png"));
		stage.setResizable(false);

		// Create Initial Grid
		BorderPane border = new BorderPane();
		// Create Scene
		Scene scene = new Scene(border, 400, 600);

		border.setId("mainGrid");

		// Create Banner Grid
		GridPane bannerGrid = new GridPane();
		bannerGrid.setId("banner");
		bannerGrid.setPadding(new Insets(5));
		bannerGrid.setPrefWidth(400.0);

		// Populate Banner Grid
		bannerGrid.add(MainUtils.getUserAvatarImage(), 0, 0);
		bannerGrid.add(MainUtils.getUserMainText(username), 1, 0);
		border.setTop(bannerGrid);

		// Create Tab Pane for chat and app settings

		TabPane tabPane = new TabPane();
		tabPane.setPrefWidth(410.0);
		tabPane.setPrefHeight(500.0);
		border.setCenter(tabPane);

		MainUtils.addTabs(tabPane);

		// Create Footer Grid
		GridPane footerGrid = new GridPane();
		footerGrid.setId("footer");
		footerGrid.setPadding(new Insets(5));
		footerGrid.setPrefWidth(400.0);
		footerGrid.setPrefHeight(64.0);

		MainUtils.addFooter(footerGrid);
		border.setBottom(footerGrid);

		scene.getStylesheets().add(Main.class.getResource("stylesheet.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}

}
